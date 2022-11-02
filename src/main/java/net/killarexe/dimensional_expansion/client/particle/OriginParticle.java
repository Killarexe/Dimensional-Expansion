package net.killarexe.dimensional_expansion.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OriginParticle extends TextureSheetParticle{
	protected OriginParticle(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed,
			double pZSpeed) {
		super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
	}

	@Override
	public ParticleRenderType getRenderType() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
