
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

import net.mcreator.minebound.procedures.HealingWaterMobplayerCollidesBlockProcedure;
import net.mcreator.minebound.init.MineboundModFluids;

public class HealingWaterBlock extends LiquidBlock {
	public HealingWaterBlock() {
		super(() -> MineboundModFluids.HEALING_WATER.get(),
				BlockBehaviour.Properties.of(Material.WATER, MaterialColor.COLOR_LIGHT_BLUE).strength(100f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 4).noCollission().noLootTable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		HealingWaterMobplayerCollidesBlockProcedure.execute(world, entity);
	}
}
