
package net.mcreator.minebound.block;

import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

public class BrokentableBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public BrokentableBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD)
				.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("minebound:silence")), () -> new SoundEvent(new ResourceLocation("minebound:silence")),
						() -> new SoundEvent(new ResourceLocation("minebound:inventory_putdown1")), () -> new SoundEvent(new ResourceLocation("minebound:silence")), () -> new SoundEvent(new ResourceLocation("minebound:silence"))))
				.strength(1f, 1.5f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.join(Shapes.or(box(0, 0, 0, 16, 4, 16), box(10, 16, -2, 15, 19, 16), box(6, 13, -2, 10, 16, 16), box(0, 10, -2, 6, 13, 16), box(-5, 8, -2, 0, 10, 16), box(7, 0, 7, 9, 15, 9)),
					Shapes.or(box(9, 0, 9, 16, 4, 16), box(0, 0, 9, 7, 4, 16), box(9, 0, 0, 16, 4, 7), box(0, 0, 0, 7, 4, 7)), BooleanOp.ONLY_FIRST);
			case NORTH -> Shapes.join(Shapes.or(box(0, 0, 0, 16, 4, 16), box(1, 16, 0, 6, 19, 18), box(6, 13, 0, 10, 16, 18), box(10, 10, 0, 16, 13, 18), box(16, 8, 0, 21, 10, 18), box(7, 0, 7, 9, 15, 9)),
					Shapes.or(box(0, 0, 0, 7, 4, 7), box(9, 0, 0, 16, 4, 7), box(0, 0, 9, 7, 4, 16), box(9, 0, 9, 16, 4, 16)), BooleanOp.ONLY_FIRST);
			case EAST -> Shapes.join(Shapes.or(box(0, 0, 0, 16, 4, 16), box(-2, 16, 1, 16, 19, 6), box(-2, 13, 6, 16, 16, 10), box(-2, 10, 10, 16, 13, 16), box(-2, 8, 16, 16, 10, 21), box(7, 0, 7, 9, 15, 9)),
					Shapes.or(box(9, 0, 0, 16, 4, 7), box(9, 0, 9, 16, 4, 16), box(0, 0, 0, 7, 4, 7), box(0, 0, 9, 7, 4, 16)), BooleanOp.ONLY_FIRST);
			case WEST -> Shapes.join(Shapes.or(box(0, 0, 0, 16, 4, 16), box(0, 16, 10, 18, 19, 15), box(0, 13, 6, 18, 16, 10), box(0, 10, 0, 18, 13, 6), box(0, 8, -5, 18, 10, 0), box(7, 0, 7, 9, 15, 9)),
					Shapes.or(box(0, 0, 9, 7, 4, 16), box(0, 0, 0, 7, 4, 7), box(9, 0, 9, 16, 4, 16), box(9, 0, 0, 16, 4, 7)), BooleanOp.ONLY_FIRST);
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}
