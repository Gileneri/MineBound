package net.mcreator.minebound.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.minebound.init.MineboundModParticleTypes;
import net.mcreator.minebound.init.MineboundModBlocks;

public class SlimeOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (!((world.getFluidState(new BlockPos(x, y, z)).createLegacyBlock()).getBlock() == MineboundModBlocks.STICKY_SLIME.get())) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (MineboundModParticleTypes.DRIPING_SLIME.get()), x, y, z, 1, 0.2, 0.8, 0.2, 1);
			}
		}
	}
}
