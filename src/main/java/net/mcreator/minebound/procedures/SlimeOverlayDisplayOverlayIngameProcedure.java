package net.mcreator.minebound.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.minebound.init.MineboundModBlocks;

public class SlimeOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return false;
		boolean IsSubmerged_Slime = false;
		IsSubmerged_Slime = false;
		if ((world
				.getFluidState(new BlockPos(x,
						entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0.000001)), ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, entity)).getBlockPos().getY(), z))
				.createLegacyBlock()).getBlock() == MineboundModBlocks.STICKY_SLIME.get()) {
			IsSubmerged_Slime = true;
		}
		return IsSubmerged_Slime;
	}
}
