
package net.mcreator.minebound.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.minebound.init.MineboundModParticleTypes;
import net.mcreator.minebound.init.MineboundModFluids;
import net.mcreator.minebound.init.MineboundModFluidTypes;
import net.mcreator.minebound.init.MineboundModBlocks;

public abstract class SwampWaterFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> MineboundModFluidTypes.SWAMP_WATER_TYPE.get(), () -> MineboundModFluids.SWAMP_WATER.get(), () -> MineboundModFluids.FLOWING_SWAMP_WATER.get())
			.explosionResistance(100f).block(() -> (LiquidBlock) MineboundModBlocks.SWAMP_WATER.get());

	private SwampWaterFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (MineboundModParticleTypes.DRIPING_SLIME.get());
	}

	public static class Source extends SwampWaterFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends SwampWaterFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
