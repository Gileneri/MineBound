
package net.mcreator.minebound.block;

import net.minecraftforge.common.PlantType;

import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class ScorchedgrassBlock extends FlowerBlock {
	public ScorchedgrassBlock() {
		super(MobEffects.WITHER, 70, BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.SAND).sound(SoundType.CHAIN).instabreak().noLootTable().noCollission());
	}

	@Override
	public int getEffectDuration() {
		return 70;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.DESERT;
	}
}
