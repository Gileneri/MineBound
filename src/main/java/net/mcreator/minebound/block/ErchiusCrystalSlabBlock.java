
package net.mcreator.minebound.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.Collections;

public class ErchiusCrystalSlabBlock extends SlabBlock {
	public ErchiusCrystalSlabBlock() {
		super(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_PINK)
				.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("minebound:footstep_crystals")), () -> new SoundEvent(new ResourceLocation("minebound:footstep_crystals")),
						() -> new SoundEvent(new ResourceLocation("minebound:inventory_putdown1")), () -> new SoundEvent(new ResourceLocation("minebound:footstep_crystals")), () -> new SoundEvent(new ResourceLocation("minebound:silence"))))
				.strength(8f).lightLevel(s -> 8).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).dynamicShape());
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
	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.BLOCK;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, state.getValue(TYPE) == SlabType.DOUBLE ? 2 : 1));
	}
}
