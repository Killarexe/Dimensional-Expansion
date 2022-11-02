package net.killarexe.dimensional_expansion.client.gui.screen;

import com.google.common.util.concurrent.Runnables;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.LogUtils;
import com.mojang.math.Vector3f;
import com.mojang.realmsclient.RealmsMainScreen;
import com.mojang.realmsclient.gui.screens.RealmsNotificationsScreen;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import javax.annotation.Nullable;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.gui.screen.config.DEConfigScreen;
import net.killarexe.dimensional_expansion.utils.DEUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.MultiLineLabel;
import net.minecraft.client.gui.components.PlainTextButton;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Mth;
import net.minecraft.world.level.levelgen.presets.WorldPresets;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.LevelSummary;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.gui.TitleScreenModUpdateIndicator;
import net.minecraftforge.fml.VersionChecker;
import net.minecraftforge.versions.forge.ForgeVersion;
import org.slf4j.Logger;

import static net.minecraftforge.fml.VersionChecker.Status.BETA;
import static net.minecraftforge.fml.VersionChecker.Status.BETA_OUTDATED;

@OnlyIn(Dist.CLIENT)
public class DETitleScreen extends Screen {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final Component COPYRIGHT_TEXT = Component.literal("Copyright Mojang AB. Do not distribute!");
    public static final CubeMap CUBE_MAP = new CubeMap(new ResourceLocation("textures/gui/title/background/panorama"));
    private static final ResourceLocation PANORAMA_OVERLAY = new ResourceLocation("textures/gui/title/background/panorama_overlay.png");
    private static final ResourceLocation ACCESSIBILITY_TEXTURE = new ResourceLocation("textures/gui/accessibility.png");
    private final ResourceLocation icons = new ResourceLocation(DEMod.MOD_ID, "textures/gui/widgets.png");
    private final boolean minceraftEasterEgg;
    @Nullable
    private String splash;
    private Button resetDemoButton;
    private static final ResourceLocation MINECRAFT_LOGO = new ResourceLocation(DEMod.MOD_ID, "textures/gui/title/minecraft.png");
    private static final ResourceLocation MINECRAFT_EDITION = new ResourceLocation("textures/gui/title/edition.png");
    private Screen realmsNotificationsScreen;
    private final PanoramaRenderer panorama = new PanoramaRenderer(CUBE_MAP);
    public final boolean fading;
    private long fadeInStart;
    @Nullable
    private WarningLabel warningLabel;
    private TitleScreenModUpdateIndicator modUpdateNotification;

    private ImageButton discord, youtube, github, config;

    public DETitleScreen() {
        this(false);
    }

    public DETitleScreen(boolean p_96733_) {
        super(Component.translatable("narrator.screen.title"));
        this.fading = p_96733_;
        this.minceraftEasterEgg = false;
    }

    private boolean realmsNotificationsEnabled() {
        return this.minecraft.options.realmsNotifications().get() && this.realmsNotificationsScreen != null;
    }

    public void tick() {
        if (this.realmsNotificationsEnabled()) {
            this.realmsNotificationsScreen.tick();
        }

        this.minecraft.getRealms32BitWarningStatus().showRealms32BitWarningIfNeeded(this);
    }

    public static CompletableFuture<Void> preloadResources(TextureManager p_96755_, Executor p_96756_) {
        return CompletableFuture.allOf(p_96755_.preload(MINECRAFT_LOGO, p_96756_), p_96755_.preload(MINECRAFT_EDITION, p_96756_), p_96755_.preload(PANORAMA_OVERLAY, p_96756_), CUBE_MAP.preload(p_96755_, p_96756_));
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

        int i = this.font.width(COPYRIGHT_TEXT);
        int j = this.width - i - 2;
        int l = this.height / 4 + 48;
        Button modButton = null;
        if (this.minecraft.isDemo()) {
            this.createDemoMenuOptions(l, 24);
        } else {
            this.createNormalMenuOptions(l, 24);
            modButton = this.addRenderableWidget(new Button(this.width / 2 - 100, l + 24 * 2, 98, 20, Component.translatable("fml.menu.mods"), button -> {
                this.minecraft.setScreen(new net.minecraftforge.client.gui.ModListScreen(this));
            }));
        }
        modUpdateNotification = new TitleScreenModUpdateIndicator(modButton);
        modUpdateNotification.resize(minecraft, width, height);
        modUpdateNotification.init();

        this.addRenderableWidget(new ImageButton(this.width / 2 - 124, l + 72 + 12, 20, 20, 0, 106, 20, Button.WIDGETS_LOCATION, 256, 256, (p_96791_) -> {
            this.minecraft.setScreen(new LanguageSelectScreen(this, this.minecraft.options, this.minecraft.getLanguageManager()));
        }, Component.translatable("narrator.button.language")));
        this.addRenderableWidget(new Button(this.width / 2 - 100, l + 72 + 12, 98, 20, Component.translatable("menu.options"), (p_96788_) -> {
            this.minecraft.setScreen(new OptionsScreen(this, this.minecraft.options));
        }));
        this.addRenderableWidget(new Button(this.width / 2 + 2, l + 72 + 12, 98, 20, Component.translatable("menu.quit"), (p_96786_) -> {
            this.minecraft.stop();
        }));
        this.addRenderableWidget(new ImageButton(this.width / 2 + 104, l + 72 + 12, 20, 20, 0, 0, 20, ACCESSIBILITY_TEXTURE, 32, 64, (p_96784_) -> {
            this.minecraft.setScreen(new AccessibilityOptionsScreen(this, this.minecraft.options));
        }, Component.translatable("narrator.button.accessibility")));
        this.addRenderableWidget(new PlainTextButton(j, this.height - 10, i, 10, COPYRIGHT_TEXT, (p_211790_) -> {
            this.minecraft.setScreen(new WinScreen(false, Runnables.doNothing()));
        }, this.font));
        this.minecraft.setConnectedToRealms(false);
        if (this.minecraft.options.realmsNotifications().get() && this.realmsNotificationsScreen == null) {
            this.realmsNotificationsScreen = new RealmsNotificationsScreen();
        }

        if (this.realmsNotificationsEnabled()) {
            this.realmsNotificationsScreen.init(this.minecraft, this.width, this.height);
        }

        if (!this.minecraft.is64Bit()) {
            this.warningLabel = new WarningLabel(this.font, MultiLineLabel.create(this.font, Component.translatable("title.32bit.deprecation"), 350, 2), this.width / 2, l - 24);
        }

    }

    private void createNormalMenuOptions(int p_96764_, int p_96765_) {

        config =  new ImageButton(width / 2 -200, height / 4 + 48 + 60, 16, 16, 0, 96, icons, (button -> {
            minecraft.setScreen(new DEConfigScreen(this));
        }));
        discord = new ImageButton(width / 2 -200, height / 4 + 48 + 40, 16, 16, 0, 0, icons, (button -> {
            Util.getPlatform().openUri("https://discord.gg/xYytpBTd3r");
        }));
        youtube = new ImageButton(width / 2 -200, height / 4 + 48 + 20, 16, 16, 0, 64, icons, (button -> {
            Util.getPlatform().openUri("https://youtube.com/channel/UC7lHA5pMQMrTTeZg1yk2hXw");
        }));
        github = new ImageButton(width / 2 -200, height / 4 + 48, 16, 16, 0, 32, icons, (button -> {
            Util.getPlatform().openUri("https://github.com/Killarexe/Dimensional-Expansion");
        }));

        addRenderableWidget(config);
        addRenderableWidget(discord);
        addRenderableWidget(youtube);
        addRenderableWidget(github);

        this.addRenderableWidget(new Button(this.width / 2 - 100, p_96764_, 200, 20, Component.translatable("menu.singleplayer"), (p_232779_) -> {
            this.minecraft.setScreen(new SelectWorldScreen(this));
        }));
        boolean flag = this.minecraft.allowsMultiplayer();
        Button.OnTooltip button$ontooltip = flag ? Button.NO_TOOLTIP : new Button.OnTooltip() {
            private final Component text = Component.translatable("title.multiplayer.disabled");

            public void onTooltip(Button p_169458_, PoseStack p_169459_, int p_169460_, int p_169461_) {
                if (!p_169458_.active) {
                    DETitleScreen.this.renderTooltip(p_169459_, DETitleScreen.this.minecraft.font.split(this.text, Math.max(DETitleScreen.this.width / 2 - 43, 170)), p_169460_, p_169461_);
                }

            }

            public void narrateTooltip(Consumer<Component> p_169456_) {
                p_169456_.accept(this.text);
            }
        };
        (this.addRenderableWidget(new Button(this.width / 2 - 100, p_96764_ + p_96765_ * 1, 200, 20, Component.translatable("menu.multiplayer"), (p_96776_) -> {
            Screen screen = (Screen)(this.minecraft.options.skipMultiplayerWarning ? new JoinMultiplayerScreen(this) : new SafetyScreen(this));
            this.minecraft.setScreen(screen);
        }, button$ontooltip))).active = flag;
        (this.addRenderableWidget(new Button(this.width / 2 + 2, p_96764_ + p_96765_ * 2, 98, 20, Component.translatable("menu.online"), (p_96771_) -> {
            this.realmsButtonClicked();
        }, button$ontooltip))).active = flag;
    }

    private void createDemoMenuOptions(int p_96773_, int p_96774_) {
        boolean flag = this.checkDemoWorldPresence();
        this.addRenderableWidget(new Button(this.width / 2 - 100, p_96773_, 200, 20, Component.translatable("menu.playdemo"), (p_232773_) -> {
            if (flag) {
                this.minecraft.createWorldOpenFlows().loadLevel(this, "Demo_World");
            } else {
                RegistryAccess registryaccess = RegistryAccess.builtinCopy().freeze();
                this.minecraft.createWorldOpenFlows().createFreshLevel("Demo_World", MinecraftServer.DEMO_SETTINGS, registryaccess, WorldPresets.demoSettings(registryaccess));
            }

        }));
        this.resetDemoButton = this.addRenderableWidget(new Button(this.width / 2 - 100, p_96773_ + p_96774_ * 1, 200, 20, Component.translatable("menu.resetdemo"), (p_232770_) -> {
            LevelStorageSource levelstoragesource = this.minecraft.getLevelSource();

            try {
                LevelStorageSource.LevelStorageAccess levelstoragesource$levelstorageaccess = levelstoragesource.createAccess("Demo_World");

                try {
                    LevelSummary levelsummary = levelstoragesource$levelstorageaccess.getSummary();
                    if (levelsummary != null) {
                        this.minecraft.setScreen(new ConfirmScreen(this::confirmDemo, Component.translatable("selectWorld.deleteQuestion"), Component.translatable("selectWorld.deleteWarning", levelsummary.getLevelName()), Component.translatable("selectWorld.deleteButton"), CommonComponents.GUI_CANCEL));
                    }
                } catch (Throwable throwable1) {
                    if (levelstoragesource$levelstorageaccess != null) {
                        try {
                            levelstoragesource$levelstorageaccess.close();
                        } catch (Throwable throwable) {
                            throwable1.addSuppressed(throwable);
                        }
                    }

                    throw throwable1;
                }

                if (levelstoragesource$levelstorageaccess != null) {
                    levelstoragesource$levelstorageaccess.close();
                }
            } catch (IOException ioexception) {
                SystemToast.onWorldAccessFailure(this.minecraft, "Demo_World");
                LOGGER.warn("Failed to access demo world", (Throwable)ioexception);
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
            } catch (Throwable throwable1) {
                if (levelstoragesource$levelstorageaccess != null) {
                    try {
                        levelstoragesource$levelstorageaccess.close();
                    } catch (Throwable throwable) {
                        throwable1.addSuppressed(throwable);
                    }
                }

                throw throwable1;
            }

            if (levelstoragesource$levelstorageaccess != null) {
                levelstoragesource$levelstorageaccess.close();
            }

            return flag;
        } catch (IOException ioexception) {
            SystemToast.onWorldAccessFailure(this.minecraft, "Demo_World");
            LOGGER.warn("Failed to read demo world data", (Throwable)ioexception);
            return false;
        }
    }

    private void realmsButtonClicked() {
        this.minecraft.setScreen(new RealmsMainScreen(this));
    }

    public void render(PoseStack poseStack, int mouseX, int mouseY, float p_96742_) {
    	DEUtils.setWindowTitle("Dimensional Expansion v" + DEMod.VERSION + " | Title screen");
        if (this.fadeInStart == 0L && this.fading) {
            this.fadeInStart = Util.getMillis();
        }

        float f = this.fading ? (float)(Util.getMillis() - this.fadeInStart) / 1000.0F : 1.0F;
        this.panorama.render(p_96742_, Mth.clamp(f, 0.0F, 1.0F));
        int j = this.width / 2 - 128;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, PANORAMA_OVERLAY);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.fading ? (float)Mth.ceil(Mth.clamp(f, 0.0F, 1.0F)) : 1.0F);
        blit(poseStack, 0, 0, this.width, this.height, 0.0F, 0.0F, 16, 128, 16, 128);
        float f1 = this.fading ? Mth.clamp(f - 1.0F, 0.0F, 1.0F) : 1.0F;
        int l = Mth.ceil(f1 * 255.0F) << 24;
        if ((l & -67108864) != 0) {
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderTexture(0, MINECRAFT_LOGO);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, f1);
            if (this.minceraftEasterEgg) {
                this.blitOutlineBlack(j, 30, (p_232776_, p_232777_) -> {
                    this.blit(poseStack, p_232776_ + 0, p_232777_, 0, 0, 99, 44);
                    this.blit(poseStack, p_232776_ + 99, p_232777_, 129, 0, 27, 44);
                    this.blit(poseStack, p_232776_ + 99 + 26, p_232777_, 126, 0, 3, 44);
                    this.blit(poseStack, p_232776_ + 99 + 26 + 3, p_232777_, 99, 0, 26, 44);
                    this.blit(poseStack, p_232776_ + 155, p_232777_, 0, 45, 155, 44);
                });
            } else {
                this.blitOutlineBlack(j, 15, (p_210862_, p_210863_) -> {
                    this.blit(poseStack, p_210862_ + 0, p_210863_, 0, 0, 155, 88);
                    this.blit(poseStack, p_210862_ + 155, p_210863_, 155, 0, 102, 88);
                });
            }

            //RenderSystem.setShaderTexture(0, MINECRAFT_EDITION);
            //blit(poseStack, j + 88, 67, 0.0F, 0.0F, 98, 14, 128, 16);
            if (this.warningLabel != null) {
                this.warningLabel.render(poseStack, l);
            }

            VersionChecker.Status status = ForgeVersion.getStatus();
            if (status == BETA || status == BETA_OUTDATED)
            {
                // render a warning at the top of the screen,
                Component line = Component.translatable("forge.update.beta.1", ChatFormatting.RED, ChatFormatting.RESET).withStyle(ChatFormatting.RED);
                GuiComponent.drawCenteredString(poseStack, font, line, width / 2, 4 + (0 * (font.lineHeight + 1)), 0xFFFFFF | 1);
                line = Component.translatable("forge.update.beta.2");
                GuiComponent.drawCenteredString(poseStack, font, line, width / 2, 4 + (1 * (font.lineHeight + 1)), 0xFFFFFF | 1);
            }
            String line = null;
            switch(status)
            {
                case FAILED:        line = "Version check failed"; break;
                case UP_TO_DATE:    line = "Forge up to date"; break;
                case AHEAD:         line = "Using non-recommended Forge build, issues may arise."; break;
                case OUTDATED:
                case BETA_OUTDATED: line = I18n.get("forge.update.newversion", ForgeVersion.getTarget()); break;
                default: break;
            }
            ForgeHooksClient.forgeStatusLine = line;

            if (this.splash != null) {
                poseStack.pushPose();
                poseStack.translate((double)(this.width / 2 + 90), 70.0D, 0.0D);
                poseStack.mulPose(Vector3f.ZP.rotationDegrees(-20.0F));
                float f2 = 1.8F - Mth.abs(Mth.sin((float)(Util.getMillis() % 1000L) / 1000.0F * ((float)Math.PI * 2F)) * 0.1F);
                f2 = f2 * 100.0F / (float)(this.font.width(this.splash) + 32);
                poseStack.scale(f2, f2, f2);
                drawCenteredString(poseStack, this.font, this.splash, 0, 0, 16776960 | l);
                poseStack.popPose();
            }

            String s = "Minecraft " + SharedConstants.getCurrentVersion().getName();
            if (this.minecraft.isDemo()) {
                s = s + " Demo";
            } else {
                s = s + ("release".equalsIgnoreCase(this.minecraft.getVersionType()) ? "" : "/" + this.minecraft.getVersionType());
            }

            if (Minecraft.checkModStatus().shouldReportAsModified()) {
                s = s + I18n.get("menu.modded");
            }

            if(github.isHoveredOrFocused()){
                renderTooltip(poseStack, Component.translatable("dimensional_expansion.button.github"), mouseX, mouseY);
            }
            if(discord.isHoveredOrFocused()){
            	renderTooltip(poseStack, Component.translatable("dimensional_expansion.button.discord"), mouseX, mouseY);
            }
            if(youtube.isHoveredOrFocused()){
            	renderTooltip(poseStack, Component.translatable("dimensional_expansion.button.youtube"), mouseX, mouseY);
            }
            if(config.isHoveredOrFocused()){
            	renderTooltip(poseStack, Component.translatable("dimensional_expansion.button.config"), mouseX, mouseY);
            }

            net.minecraftforge.internal.BrandingControl.forEachLine(true, true, (brdline, brd) ->
                    drawString(poseStack, this.font, brd, 2, this.height - ( 10 + brdline * (this.font.lineHeight + 1)), 16777215 | l)
            );

            net.minecraftforge.internal.BrandingControl.forEachAboveCopyrightLine((brdline, brd) ->
                    drawString(poseStack, this.font, brd, this.width - font.width(brd), this.height - (10 + (brdline + 1) * ( this.font.lineHeight + 1)), 16777215 | l)
            );


            for(GuiEventListener guieventlistener : this.children()) {
                if (guieventlistener instanceof AbstractWidget) {
                    ((AbstractWidget)guieventlistener).setAlpha(f1);
                }
            }

            super.render(poseStack, mouseX, mouseY, p_96742_);
            if (this.realmsNotificationsEnabled() && f1 >= 1.0F) {
                this.realmsNotificationsScreen.render(poseStack, mouseX, mouseY, p_96742_);
            }
            if (f1 >= 1.0f) modUpdateNotification.render(poseStack, mouseX, mouseY, p_96742_);

        }
    }

    public boolean mouseClicked(double p_96735_, double p_96736_, int p_96737_) {
        if (super.mouseClicked(p_96735_, p_96736_, p_96737_)) {
            return true;
        } else {
            return this.realmsNotificationsEnabled() && this.realmsNotificationsScreen.mouseClicked(p_96735_, p_96736_, p_96737_);
        }
    }

    public void removed() {
        if (this.realmsNotificationsScreen != null) {
            this.realmsNotificationsScreen.removed();
        }

    }

    private void confirmDemo(boolean p_96778_) {
        if (p_96778_) {
            try {
                LevelStorageSource.LevelStorageAccess levelstoragesource$levelstorageaccess = this.minecraft.getLevelSource().createAccess("Demo_World");

                try {
                    levelstoragesource$levelstorageaccess.deleteLevel();
                } catch (Throwable throwable1) {
                    if (levelstoragesource$levelstorageaccess != null) {
                        try {
                            levelstoragesource$levelstorageaccess.close();
                        } catch (Throwable throwable) {
                            throwable1.addSuppressed(throwable);
                        }
                    }

                    throw throwable1;
                }

                if (levelstoragesource$levelstorageaccess != null) {
                    levelstoragesource$levelstorageaccess.close();
                }
            } catch (IOException ioexception) {
                SystemToast.onWorldDeleteFailure(this.minecraft, "Demo_World");
                LOGGER.warn("Failed to delete demo world", (Throwable)ioexception);
            }
        }

        this.minecraft.setScreen(this);
    }

    @OnlyIn(Dist.CLIENT)
    static record WarningLabel(Font font, MultiLineLabel label, int x, int y) {
        public void render(PoseStack p_232791_, int p_232792_) {
            this.label.renderBackgroundCentered(p_232791_, this.x, this.y, 9, 2, 1428160512);
            this.label.renderCentered(p_232791_, this.x, this.y, 9, 16777215 | p_232792_);
        }
    }
}