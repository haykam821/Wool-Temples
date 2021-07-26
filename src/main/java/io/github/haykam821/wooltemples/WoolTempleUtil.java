package io.github.haykam821.wooltemples;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public final class WoolTempleUtil {
	private WoolTempleUtil() {
		return;
	}

	public static BlockState replaceBlock(Block originalBlock) {
		if (originalBlock == Blocks.ORANGE_TERRACOTTA) {
			return Blocks.ORANGE_WOOL.getDefaultState();
		} else if (originalBlock == Blocks.BLUE_TERRACOTTA) {
			return Blocks.BLUE_WOOL.getDefaultState();
		}

		return originalBlock.getDefaultState();
	}
}
