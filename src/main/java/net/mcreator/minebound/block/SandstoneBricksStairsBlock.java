
package net.mcreator.minebound.block;

import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.Collections;

public class SandstoneBricksStairsBlock extends StairBlock {
	public SandstoneBricksStairsBlock() {
		super(() -> Blocks.AIR.defaultBlockState(),
				BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND)
						.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("minebound:footstep_stone3")), () -> new SoundEvent(new ResourceLocation("minebound:footstep_stone3")),
								() -> new SoundEvent(new ResourceLocation("minebound:inventory_putdown1")), () -> new SoundEvent(new ResourceLocation("minebound:footstep_stone3")), () -> new SoundEvent(new ResourceLocation("minebound:silence"))))
						.strength(4f).dynamicShape());
	}

	@Override
	public float getExplosionResistance() {
		return 4f;
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return false;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("a"));
		list.add(Component.literal("a"));
		list.add(Component.literal("a"));
		list.add(Component.literal("a"));
		list.add(Component.literal("a"));
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}
