package net.killarexe.dimensional_expansion.client.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class JugerAnimations {

	public static final AnimationDefinition JUGER_WALK = AnimationDefinition.Builder.withLength(0.5416766f).looping()
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("first_left_part", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
							AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("second_left_part", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
							AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("first_right_part", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
							AnimationChannel.Interpolations.LINEAR)))
			.build();

	public static final AnimationDefinition JUGER_ATTACK = AnimationDefinition.Builder.withLength(0.25f)
			.addAnimation("up", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.125f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
							AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("down", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.125f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
							AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("ass", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.125f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
							AnimationChannel.Interpolations.LINEAR)))
			.build();

	public static final AnimationDefinition JUGER_STAND = AnimationDefinition.Builder.withLength(2f).looping()
			.addAnimation("chest", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1f, KeyframeAnimations.posVec(0f, -0.25f, 0f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
							AnimationChannel.Interpolations.CATMULLROM)))
			.build();
}
