package net.killarexe.dimensional_expansion.client.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class JugerAnimations {
	public static final AnimationDefinition JUGER_WALK = AnimationDefinition.Builder.withLength(1f).looping()
			.addAnimation("left_legs",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -15f, 0f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 15f, 0f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -15f, 0f),
						AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("right_legs",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -15f, 0f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 15f, 0f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -15f, 0f),
						AnimationChannel.Interpolations.CATMULLROM))).build();
	
	public static final AnimationDefinition JUGER_ATTACK = AnimationDefinition.Builder.withLength(0.25f)
			.addAnimation("up",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.125f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("down",
				new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.125f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.LINEAR))).build();
	
	public static final AnimationDefinition JUGER_STAND = AnimationDefinition.Builder.withLength(2f).looping()
			.addAnimation("body",
				new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1f, KeyframeAnimations.posVec(0f, -0.25f, 0f),
						AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
						AnimationChannel.Interpolations.CATMULLROM))).build();
}
