
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

import net.mcreator.minebound.procedures.LavaMobplayerCollidesBlockProcedure;
import net.mcreator.minebound.init.MineboundModFluids;

public class LavaBlock extends LiquidBlock {
	public LavaBlock() {
		super(() -> MineboundModFluids.LAVA.get(), BlockBehaviour.Properties.of(Material.LAVA, MaterialColor.COLOR_RED).strength(1000f).lightLevel(s -> 15).noCollission().noLootTable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		LavaMobplayerCollidesBlockProcedure.execute(entity);
	}
}
