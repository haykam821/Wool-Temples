package io.github.haykam821.wooltemples.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.wooltemples.WoolTempleUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.structure.DesertTempleGenerator;

@Mixin(value = DesertTempleGenerator.class, remap = false)
public class DesertTempleGeneratorMixin115 {
	@Redirect(method = "method_14931", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_2248;method_9564()Lnet/minecraft/class_2680;"))
	private BlockState replaceTerracotta(Block originalBlock) {
		return WoolTempleUtil.replaceBlock(originalBlock);
	}
}