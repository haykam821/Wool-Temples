package io.github.haykam821.wooltemples.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.DesertTempleGenerator;

@Mixin(DesertTempleGenerator.class)
class DesertTempleGeneratorMixin {
	@Redirect(method = "generate", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getDefaultState()Lnet/minecraft/block/BlockState;"))
	public BlockState replaceTerracotta(Block originalBlock) {
		if (originalBlock == Blocks.ORANGE_TERRACOTTA) {
			return Blocks.ORANGE_WOOL.getDefaultState();
		} else if (originalBlock == Blocks.BLUE_TERRACOTTA) {
			return Blocks.BLUE_WOOL.getDefaultState();
		}

		return originalBlock.getDefaultState();
	}
}