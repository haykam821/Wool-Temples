package io.github.haykam821.wooltemples.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.wooltemples.WoolTempleUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.structure.DesertTempleGenerator;

@SuppressWarnings("target")
@Mixin(value = DesertTempleGenerator.class, remap = false)
public class DesertTempleGeneratorMixin116 {
	@Redirect(method = "method_14931(Lnet/minecraft/class_5281;Lnet/minecraft/class_5138;Lnet/minecraft/class_2794;Ljava/util/Random;Lnet/minecraft/class_3341;Lnet/minecraft/class_1923;Lnet/minecraft/class_2338;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_2248;method_9564()Lnet/minecraft/class_2680;"))
	private BlockState replaceTerracotta(Block originalBlock) {
		return WoolTempleUtil.replaceBlock(originalBlock);
	}
}