
package net.mcreator.minebound.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.minebound.procedures.LiquidErchiusFuelMobplayerCollidesBlockProcedure;
import net.mcreator.minebound.init.MineboundModFluids;

public class LiquidErchiusFuelBlock extends LiquidBlock {
	public LiquidErchiusFuelBlock() {
		super(() -> MineboundModFluids.LIQUID_ERCHIUS_FUEL.get(),
				BlockBehaviour.Properties.of(Material.WATER, MaterialColor.COLOR_MAGENTA).strength(100f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 3).noCollission().noLootTable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		LiquidErchiusFuelMobplayerCollidesBlockProcedure.execute(world, entity);
	}
}
