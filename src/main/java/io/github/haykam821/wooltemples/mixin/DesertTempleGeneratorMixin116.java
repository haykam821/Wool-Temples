package io.github.haykam821.wooltemples.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.wooltemples.WoolTempleUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.structure.DesertTempleGenerator;

@Mixin(DesertTempleGenerator.class)
public class DesertTempleGeneratorMixin116 {
	@Redirect(method = "generate", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getDefaultState()Lnet/minecraft/block/BlockState;"))
	private BlockState replaceTerracotta(Block originalBlock) {
		return WoolTempleUtil.replaceBlock(originalBlock);
	}
}