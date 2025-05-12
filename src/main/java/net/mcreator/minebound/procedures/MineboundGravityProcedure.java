package net.mcreator.minebound.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class MineboundGravityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if ((world.getBlockState(new BlockPos(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("minebound:gravity_affected_blocks")))) {
				for (int index0 = 0; index0 < (int) (3); index0++) {
					if (world.isEmptyBlock(new BlockPos(x + 1, y, z)) && Math.random() < 0.25) {
						world.setBlock(new BlockPos(x + 1, y, z), (world.getBlockState(new BlockPos(x, y + 1, z))), 3);
						world.setBlock(new BlockPos(x, y + 1, z), (world.getFluidState(new BlockPos(x, y + 1, z)).createLegacyBlock()), 3);
						break;
					} else if (world.isEmptyBlock(new BlockPos(x - 1, y, z)) && Math.random() < 0.5) {
						world.setBlock(new BlockPos(x - 1, y, z), (world.getBlockState(new BlockPos(x, y + 1, z))), 3);
						world.setBlock(new BlockPos(x, y + 1, z), (world.getFluidState(new BlockPos(x, y + 1, z)).createLegacyBlock()), 3);
						break;
					} else if (world.isEmptyBlock(new BlockPos(x, y, z + 1)) && Math.random() < 0.75) {
						world.setBlock(new BlockPos(x, y, z + 1), (world.getBlockState(new BlockPos(x, y + 1, z))), 3);
						world.setBlock(new BlockPos(x, y + 1, z), (world.getFluidState(new BlockPos(x, y + 1, z)).createLegacyBlock()), 3);
						break;
					} else if (world.isEmptyBlock(new BlockPos(x, y, z - 1))) {
						world.setBlock(new BlockPos(x, y, z - 1), (world.getBlockState(new BlockPos(x, y + 1, z))), 3);
						world.setBlock(new BlockPos(x, y + 1, z), (world.getFluidState(new BlockPos(x, y + 1, z)).createLegacyBlock()), 3);
						break;
					}
				}
			}
		}
	}
}
