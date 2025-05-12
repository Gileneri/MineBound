
package net.mcreator.minebound.block;

import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.minebound.init.MineboundModFluids;

public class CoconutMilkBlock extends LiquidBlock {
	public CoconutMilkBlock() {
		super(() -> MineboundModFluids.COCONUT_MILK.get(), BlockBehaviour.Properties.of(Material.WATER, MaterialColor.WOOL).strength(100f).noCollission().noLootTable());
	}
}
