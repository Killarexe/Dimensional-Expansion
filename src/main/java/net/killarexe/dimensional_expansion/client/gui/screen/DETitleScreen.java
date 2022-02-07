package net.killarexe.dimensional_expansion.client.gui.screen;

import com.google.common.util.concurrent.Runnables;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.mojang.realmsclient.RealmsMainScreen;
import com.mojang.realmsclient.gui.screens.RealmsNotificationsScreen;
import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.screens.*;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.gui.screens.multiplayer.SafetyScreen;
import net.minecraft.client.gui.screens.worldselection.SelectWorldScreen;
import net.minecraft.client.renderer.CubeMap;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.PanoramaRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Mth;
import net.minecraft.world.level.levelgen.WorldGenSettings;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.LevelSummary;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.ModListScreen;
import net.minecraftforge.client.gui.NotificationModUpdateScreen;
import net.minecraftforge.internal.BrandingControl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

@OnlyIn(Dist.CLIENT)
public class DETitleScreen extends Screen {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String DEMO_LEVEL_ID = "Demo_World";
    public static final String COPYRIGHT_TEXT = "Copyright Mojang AB. Do not distribute!";
    public static final CubeMap CUBE_MAP = new CubeMap(new ResourceLocation("textures/gui/title/background/panorama"));
    private static final ResourceLocation PANORAMA_OVERLAY = new ResourceLocation("textures/gui/title/background/panorama_overlay.png");
    private static final ResourceLocation ACCESSIBILITY_TEXTURE = new ResourceLocation("textures/gui/accessibility.png");
    private final boolean minceraftEasterEgg;
    @Nullable
    private String splash;
    private Button resetDemoButton, discordButton, youtubeButton, githubButton, configButton;
    private static final ResourceLocation MINECRAFT_LOGO = new ResourceLocation("textures/gui/title/minecraft.png");
    private static final ResourceLocation MINECRAFT_EDITION = new ResourceLocation("textures/gui/title/edition.png");
    private Screen realmsNotificationsScreen;
    private int copyrightWidth;
    private int copyrightX;
    private final PanoramaRenderer panorama;
    private final boolean fading;
    private long fadeInStart;
    private NotificationModUpdateScreen modUpdateNotification;

    public DETitleScreen() {
        this(false);
    }

    public DETitleScreen(boolean pFading) {
        super(new TranslatableComponent("narrator.screen.title"));
        this.panorama = new PanoramaRenderer(CUBE_MAP);
        this.fading = pFading;
        this.minceraftEasterEgg = (double)(new Random()).nextFloat() < 1.0E-4D;
    }

    private boolean realmsNotificationsEnabled() {
        return this.minecraft.options.realmsNotifications && this.realmsNotificationsScreen != null;
    }

    public void tick() {
        if (this.realmsNotificationsEnabled()) {
            this.realmsNotificationsScreen.tick();
        }

    }

    public static CompletableFuture<Void> preloadResources(TextureManager pTexMngr, Executor pBackgroundExecutor) {
        return CompletableFuture.allOf(pTexMngr.preload(MINECRAFT_LOGO, pBackgroundExecutor), pTexMngr.preload(MINECRAFT_EDITION, pBackgroundExecutor), pTexMngr.preload(PANORAMA_OVERLAY, pBackgroundExecutor), CUBE_MAP.preload(pTexMngr, pBackgroundExecutor));
    }

    public boolean isPauseScreen() {
        return false;
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    protected void init() {
        if (this.splash == null) {
            this.splash = this.minecraft.getSplashManager().getSplash();
        }

        preloadResources(this.minecraft.getTextureManager(), this.minecraft);

        this.copyrightWidth = this.font.width("Copyright Mojang AB. Do not distribute!");
        this.copyrightX = this.width - this.copyrightWidth - 2;
        int i = 24;
        int j = this.height / 4 + 48;
        Button modButton = null;
        if (this.minecraft.isDemo()) {
            this.createDemoMenuOptions(j, 24);
        } else {
            this.createNormalMenuOptions(j, 24);
            modButton = (Button)this.addRenderableWidget(new Button(this.width / 2 - 100, j + 48, 98, 20, new TranslatableComponent("fml.menu.mods"), (p_96791_) -> {
                this.minecraft.setScreen(new ModListScreen(this));
            }));
        }

        this.modUpdateNotification = new NotificationModUpdateScreen(modButton);
        this.addRenderableWidget(new ImageButton(this.width / 2 - 124, j + 72 + 12, 20, 20, 0, 106, 20, Button.WIDGETS_LOCATION, 256, 256, (p_96788_) -> {
            this.minecraft.setScreen(new LanguageSelectScreen(this, this.minecraft.options, this.minecraft.getLanguageManager()));
        }, new TranslatableComponent("narrator.button.language")));
        this.addRenderableWidget(new Button(this.width / 2 - 100, j + 72 + 12, 98, 20, new TranslatableComponent("menu.options"), (p_96786_) -> {
            this.minecraft.setScreen(new OptionsScreen(this, this.minecraft.options));
        }));
        this.addRenderableWidget(new Button(this.width / 2 + 2, j + 72 + 12, 98, 20, new TranslatableComponent("menu.quit"), (p_96784_) -> {
            this.minecraft.stop();
        }));
        this.addRenderableWidget(new ImageButton(this.width / 2 + 104, j + 72 + 12, 20, 20, 0, 0, 20, ACCESSIBILITY_TEXTURE, 32, 64, (p_96784_) -> {
            this.minecraft.setScreen(new AccessibilityOptionsScreen(this, this.minecraft.options));
        }, new TranslatableComponent("narrator.button.accessibility")));
        this.minecraft.setConnectedToRealms(false);
        if (this.minecraft.options.realmsNotifications && this.realmsNotificationsScreen == null) {
            this.realmsNotificationsScreen = new RealmsNotificationsScreen();
        }

        if (this.realmsNotificationsEnabled()) {
            this.realmsNotificationsScreen.init(this.minecraft, this.width, this.height);
        }

    }

    private void createNormalMenuOptions(int pY, int pRowHeight) {
        this.addRenderableWidget(new Button(this.width / 2 - 100, pY, 200, 20, new TranslatableComponent("menu.singleplayer"), (p_169450_) -> {
            this.minecraft.setScreen(new SelectWorldScreen(this));
        }));
        boolean flag = this.minecraft.allowsMultiplayer();
        Button.OnTooltip button$ontooltip = flag ? Button.NO_TOOLTIP : new Button.OnTooltip() {
            private final Component text = new TranslatableComponent("title.multiplayer.disabled");

            public void onTooltip(Button p_169458_, PoseStack p_169459_, int p_169460_, int p_169461_) {
                if (!p_169458_.active) {
                    DETitleScreen.this.renderTooltip(p_169459_, DETitleScreen.this.minecraft.font.split(this.text, Math.max(DETitleScreen.this.width / 2 - 43, 170)), p_169460_, p_169461_);
                }

            }

            public void narrateTooltip(Consumer<Component> p_169456_) {
                p_169456_.accept(this.text);
            }
        };
        ((Button)this.addRenderableWidget(new Button(this.width / 2 - 100, pY + pRowHeight * 1, 200, 20, new TranslatableComponent("menu.multiplayer"), (p_96776_) -> {
            Screen screen = this.minecraft.options.skipMultiplayerWarning ? new JoinMultiplayerScreen(this) : new SafetyScreen(this);
            this.minecraft.setScreen((Screen)screen);
        }, button$ontooltip))).active = flag;
        ((Button)this.addRenderableWidget(new Button(this.width / 2 + 2, pY + pRowHeight * 2, 98, 20, new TranslatableComponent("menu.online"), (p_96771_) -> {
            this.realmsButtonClicked();
        }, button$ontooltip))).active = flag;
        configButton = new ImageButton(this.width / 2 -200, this.height / 4 + 48 + 60, 16, 16, 0, 96, new ResourceLocation(DEMod.MODID, "textures/gui/widgets.png"), (button -> {
            this.getMinecraft().setScreen(new DEConfigScreen(this));
        }));
        discordButton = new ImageButton(this.width / 2 -200, this.height / 4 + 48 + 40, 16, 16, 0, 0, new ResourceLocation(DEMod.MODID, "textures/gui/widgets.png"), (button -> {
            openLink("https://discord.gg/xYytpBTd3r");
        }));
        youtubeButton = new ImageButton(this.width / 2 -200, this.height / 4 + 48 + 20, 16, 16, 0, 64, new ResourceLocation(DEMod.MODID, "textures/gui/widgets.png"), (button -> {
            openLink("https://youtube.com/channel/UC7lHA5pMQMrTTeZg1yk2hXw");
        }));
        githubButton = new ImageButton(this.width / 2 -200, this.height / 4 + 48, 16, 16, 0, 32, new ResourceLocation(DEMod.MODID, "textures/gui/widgets.png"), (button -> {
            openLink("https://github.com/Killarexe/Dimensional-Expansion");
        }));
        this.addRenderableWidget(configButton);
        this.addRenderableWidget(discordButton);
        this.addRenderableWidget(youtubeButton);
        this.addRenderableWidget(githubButton);
    }

    private void createDemoMenuOptions(int pY, int pRowHeight) {
        boolean flag = this.checkDemoWorldPresence();
        this.addRenderableWidget(new Button(this.width / 2 - 100, pY, 200, 20, new TranslatableComponent("menu.playdemo"), (p_169444_) -> {
            if (flag) {
                this.minecraft.loadLevel("Demo_World");
            } else {
                RegistryAccess.RegistryHolder registryaccess$registryholder = RegistryAccess.builtin();
                this.minecraft.createLevel("Demo_World", MinecraftServer.DEMO_SETTINGS, registryaccess$registryholder, WorldGenSettings.demoSettings(registryaccess$registryholder));
            }

        }));
        this.resetDemoButton = (Button)this.addRenderableWidget(new Button(this.width / 2 - 100, pY + pRowHeight * 1, 200, 20, new TranslatableComponent("menu.resetdemo"), (p_169441_) -> {
            LevelStorageSource levelstoragesource = this.minecraft.getLevelSource();

            try {
                LevelStorageSource.LevelStorageAccess levelstoragesource$levelstorageaccess = levelstoragesource.createAccess("Demo_World");

                try {
                    LevelSummary levelsummary = levelstoragesource$levelstorageaccess.getSummary();
                    if (levelsummary != null) {
                        this.minecraft.setScreen(new ConfirmScreen(this::confirmDemo, new TranslatableComponent("selectWorld.deleteQuestion"), new TranslatableComponent("selectWorld.deleteWarning", new Object[]{levelsummary.getLevelName()}), new TranslatableComponent("selectWorld.deleteButton"), CommonComponents.GUI_CANCEL));
                    }
                } catch (Throwable var7) {
                    if (levelstoragesource$levelstorageaccess != null) {
                        try {
                            levelstoragesource$levelstorageaccess.close();
                        } catch (Throwable var6) {
                            var7.addSuppressed(var6);
                        }
                    }

                    throw var7;
                }

                if (levelstoragesource$levelstorageaccess != null) {
                    levelstoragesource$levelstorageaccess.close();
                }
            } catch (IOException var8) {
                SystemToast.onWorldAccessFailure(this.minecraft, "Demo_World");
                LOGGER.warn("Failed to access demo world", var8);
            }

        }));
        this.resetDemoButton.active = flag;
    }

    private boolean checkDemoWorldPresence() {
        try {
            LevelStorageSource.LevelStorageAccess levelstoragesource$levelstorageaccess = this.minecraft.getLevelSource().createAccess("Demo_World");

            boolean flag;
            try {
                flag = levelstoragesource$levelstorageaccess.getSummary() != null;
            } catch (Throwable var6) {
                if (levelstoragesource$levelstorageaccess != null) {
                    try {
                        levelstoragesource$levelstorageaccess.close();
                    } catch (Throwable var5) {
                        var6.addSuppressed(var5);
                    }
                }

                throw var6;
            }

            if (levelstoragesource$levelstorageaccess != null) {
                levelstoragesource$levelstorageaccess.close();
            }

            return flag;
        } catch (IOException var7) {
            SystemToast.onWorldAccessFailure(this.minecraft, "Demo_World");
            LOGGER.warn("Failed to read demo world data", var7);
            return false;
        }
    }

    private void realmsButtonClicked() {
        this.minecraft.setScreen(new RealmsMainScreen(this));
    }

    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        if (this.fadeInStart == 0L && this.fading) {
            this.fadeInStart = Util.getMillis();
        }

        float f = this.fading ? (float)(Util.getMillis() - this.fadeInStart) / 1000.0F : 1.0F;
        this.panorama.render(pPartialTick, Mth.clamp(f, 0.0F, 1.0F));
        int i = 274;
        int j = this.width / 2 - 137;
        int k = 30;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, PANORAMA_OVERLAY);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.fading ? (float)Mth.ceil(Mth.clamp(f, 0.0F, 1.0F)) : 1.0F);
        blit(pPoseStack, 0, 0, this.width, this.height, 0.0F, 0.0F, 16, 128, 16, 128);
        float f1 = this.fading ? Mth.clamp(f - 1.0F, 0.0F, 1.0F) : 1.0F;
        int l = Mth.ceil(f1 * 255.0F) << 24;
        if ((l & -67108864) != 0) {
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderTexture(0, MINECRAFT_LOGO);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, f1);
            if (this.minceraftEasterEgg) {
                this.blitOutlineBlack(j, 30, (p_96768_, p_96769_) -> {
                    this.blit(pPoseStack, p_96768_ + 0, p_96769_, 0, 0, 99, 44);
                    this.blit(pPoseStack, p_96768_ + 99, p_96769_, 129, 0, 27, 44);
                    this.blit(pPoseStack, p_96768_ + 99 + 26, p_96769_, 126, 0, 3, 44);
                    this.blit(pPoseStack, p_96768_ + 99 + 26 + 3, p_96769_, 99, 0, 26, 44);
                    this.blit(pPoseStack, p_96768_ + 155, p_96769_, 0, 45, 155, 44);
                });
            } else {
                this.blitOutlineBlack(j, 30, (p_96768_, p_96769_) -> {
                    this.blit(pPoseStack, p_96768_ + 0, p_96769_, 0, 0, 155, 44);
                    this.blit(pPoseStack, p_96768_ + 155, p_96769_, 0, 45, 155, 44);
                });
            }

            RenderSystem.setShaderTexture(0, MINECRAFT_EDITION);
            blit(pPoseStack, j + 88, 67, 0.0F, 0.0F, 98, 14, 128, 16);
            if (this.splash != null) {
                pPoseStack.pushPose();
                pPoseStack.translate((double)(this.width / 2 + 90), 70.0D, 0.0D);
                pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(-20.0F));
                float f2 = 1.8F - Mth.abs(Mth.sin((float)(Util.getMillis() % 1000L) / 1000.0F * 6.2831855F) * 0.1F);
                f2 = f2 * 100.0F / (float)(this.font.width(this.splash) + 32);
                pPoseStack.scale(f2, f2, f2);
                drawCenteredString(pPoseStack, this.font, this.splash, 0, -8, 16776960 | l);
                pPoseStack.popPose();
            }

            String s = "Minecraft " + SharedConstants.getCurrentVersion().getName();
            if (this.minecraft.isDemo()) {
                s = s + " Demo";
            } else {
                s = s + ("release".equalsIgnoreCase(this.minecraft.getVersionType()) ? "" : "/" + this.minecraft.getVersionType());
            }

            if (Minecraft.checkModStatus().shouldReportAsModified()) {
                s = s + I18n.get("menu.modded", new Object[0]);
            }

            BrandingControl.forEachAboveCopyrightLine((brdline, brd) -> {
                Font var10001 = this.font;
                int var10003 = this.width - this.font.width(brd);
                int var10004 = this.height;
                int var10006 = brdline + 1;
                Objects.requireNonNull(this.font);
                drawString(pPoseStack, var10001, brd, var10003, var10004 - (10 + var10006 * (9 + 1)), 16777215 | l);
            });
            drawString(pPoseStack, this.font, "Copyright Mojang AB. Do not distribute!", this.copyrightX, this.height - 10, 16777215 | l);
            if (pMouseX > this.copyrightX && pMouseX < this.copyrightX + this.copyrightWidth && pMouseY > this.height - 10 && pMouseY < this.height) {
                fill(pPoseStack, this.copyrightX, this.height - 1, this.copyrightX + this.copyrightWidth, this.height, 16777215 | l);
            }

            Iterator var12 = this.children().iterator();

            while(var12.hasNext()) {
                GuiEventListener guieventlistener = (GuiEventListener)var12.next();
                if (guieventlistener instanceof AbstractWidget) {
                    ((AbstractWidget)guieventlistener).setAlpha(f1);
                }
            }

            super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
            if (this.realmsNotificationsEnabled() && f1 >= 1.0F) {
                this.realmsNotificationsScreen.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
            }

            if (f1 >= 1.0F) {
                this.modUpdateNotification.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
            }
        }

        if(githubButton.isHoveredOrFocused()){
            this.drawString(pPoseStack, font, "Github", githubButton.x + 16, githubButton.y, 0xffffff);
        }
        if(discordButton.isHoveredOrFocused()){
            this.drawString(pPoseStack, font, "Discord", discordButton.x + 16, discordButton.y, 0xffffff);
        }
        if(youtubeButton.isHoveredOrFocused()){
            this.drawString(pPoseStack, font, "YouTube", youtubeButton.x + 16, youtubeButton.y, 0xffffff);
        }
        if(configButton.isHoveredOrFocused()){
            this.drawString(pPoseStack, font, "Config", configButton.x + 16, configButton.y, 0xffffff);
        }
        this.drawString(pPoseStack, font, "Dimensional Expansion 2020-2022", 0, this.height - 10, 0xffffff);
        this.drawString(pPoseStack, font, "Dimensional Expansion v" + DEMod.VERSION, 0, this.height - 20, 0xffffff);
        this.drawString(pPoseStack, font, "Minecraft " + SharedConstants.getCurrentVersion().getName(), 0, this.height - 30, 0xffffff);
        this.minecraft.getWindow().setTitle("Dimensional Expansion " + DEMod.VERSION);
    }

    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        if (super.mouseClicked(pMouseX, pMouseY, pButton)) {
            return true;
        } else if (this.realmsNotificationsEnabled() && this.realmsNotificationsScreen.mouseClicked(pMouseX, pMouseY, pButton)) {
            return true;
        } else {
            if (pMouseX > (double)this.copyrightX && pMouseX < (double)(this.copyrightX + this.copyrightWidth) && pMouseY > (double)(this.height - 10) && pMouseY < (double)this.height) {
                this.minecraft.setScreen(new WinScreen(false, Runnables.doNothing()));
            }

            return false;
        }
    }

    public void removed() {
        if (this.realmsNotificationsScreen != null) {
            this.realmsNotificationsScreen.removed();
        }

    }

    private static void openLink(String url){
        Util.getPlatform().openUri(url);
    }

    private void confirmDemo(boolean p_96778_) {
        if (p_96778_) {
            try {
                LevelStorageSource.LevelStorageAccess levelstoragesource$levelstorageaccess = this.minecraft.getLevelSource().createAccess("Demo_World");

                try {
                    levelstoragesource$levelstorageaccess.deleteLevel();
                } catch (Throwable var6) {
                    if (levelstoragesource$levelstorageaccess != null) {
                        try {
                            levelstoragesource$levelstorageaccess.close();
                        } catch (Throwable var5) {
                            var6.addSuppressed(var5);
                        }
                    }

                    throw var6;
                }

                if (levelstoragesource$levelstorageaccess != null) {
                    levelstoragesource$levelstorageaccess.close();
                }
            } catch (IOException var7) {
                SystemToast.onWorldDeleteFailure(this.minecraft, "Demo_World");
                LOGGER.warn("Failed to delete demo world", var7);
            }
        }

        this.minecraft.setScreen(this);
    }
}
