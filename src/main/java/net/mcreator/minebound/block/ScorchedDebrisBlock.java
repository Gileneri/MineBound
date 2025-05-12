
package net.mcreator.minebound.block;

import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.common.PlantType;

import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ScorchedDebrisBlock extends FlowerBlock {
	public ScorchedDebrisBlock() {
		super(MobEffects.BLINDNESS, 100,
				BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.SAND)
						.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("minebound:silence")), () -> new SoundEvent(new ResourceLocation("minebound:silence")),
								() -> new SoundEvent(new ResourceLocation("minebound:inventory_putdown1")), () -> new SoundEvent(new ResourceLocation("minebound:silence")), () -> new SoundEvent(new ResourceLocation("minebound:silence"))))
						.instabreak().speedFactor(0.4f).jumpFactor(0.5f).noLootTable().noCollission());
	}

	@Override
	public int getEffectDuration() {
		return 100;
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.DESERT;
	}
}
