
package net.mcreator.minebound.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.minebound.init.MineboundModFluids;
import net.mcreator.minebound.init.MineboundModFluidTypes;
import net.mcreator.minebound.init.MineboundModBlocks;

public abstract class StickySlimeFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> MineboundModFluidTypes.STICKY_SLIME_TYPE.get(), () -> MineboundModFluids.STICKY_SLIME.get(), () -> MineboundModFluids.FLOWING_STICKY_SLIME.get())
			.explosionResistance(100f).block(() -> (LiquidBlock) MineboundModBlocks.STICKY_SLIME.get());

	private StickySlimeFluid() {
		super(PROPERTIES);
	}

	public static class Source extends StickySlimeFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends StickySlimeFluid {
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
