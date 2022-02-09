package net.killarexe.dimensional_expansion.mixin;

import net.minecraft.util.SignType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(SignType.class)
public interface DESignTypeAccessor {

    //@Accessor("VALUES")
    //public static final Set<SignType> getVALUES;
}
