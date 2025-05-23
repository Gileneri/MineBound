
package net.mcreator.minebound.block;

import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.minebound.procedures.StickySlimeMobplayerCollidesBlockProcedure;
import net.mcreator.minebound.init.MineboundModFluids;

public class StickySlimeBlock extends LiquidBlock {
	public StickySlimeBlock() {
		super(() -> MineboundModFluids.STICKY_SLIME.get(), BlockBehaviour.Properties.of(Material.LAVA, MaterialColor.COLOR_GREEN).strength(100f).noCollission().noLootTable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		StickySlimeMobplayerCollidesBlockProcedure.execute(world, entity);
	}
}
