package net.mcreator.minebound.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class WhenPlayerEntersShipDimensionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean toggleXorZ = false;
		boolean toggleNorP = false;
		double zPos = 0;
		double yPos = 0;
		double counter2 = 0;
		double counter1 = 0;
		double range = 0;
		double xPos = 0;
		double height = 0;
		double distanceApart = 0;
		double iterationCount = 0;
		if (!world.isClientSide()) {
			iterationCount = 1;
			for (int index0 = 0; index0 < (int) (2); index0++) {
				toggleXorZ = true;
				toggleNorP = false;
				xPos = 0;
				yPos = 128;
				zPos = 0;
				counter1 = 1;
				counter2 = 2;
				range = 97;
				distanceApart = 256;
				for (int index1 = 0; index1 < (int) (range); index1++) {
					for (int index2 = 0; index2 < (int) (counter1); index2++) {
						if (iterationCount > 2) {
							range = 0;
							counter1 = 0;
							break;
						} else if ((world.getBlockState(new BlockPos(xPos, yPos, zPos))).getBlock() == Blocks.CHEST) {
							if (iterationCount == 1) {
								if (!(new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, new BlockPos(xPos, yPos, zPos), "mbPartyLeader")).isEmpty()) {
									if ((new Object() {
										public String getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getString(tag);
											return "";
										}
									}.getValue(world, new BlockPos(xPos, yPos, zPos), "mbPartyLeader")).equals(entity.getPersistentData().getString("mbPartyLeader"))) {
										{
											Entity _ent = entity;
											_ent.teleportTo((xPos + 0.5), (yPos + 1), (zPos + 0.5));
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport((xPos + 0.5), (yPos + 1), (zPos + 0.5), _ent.getYRot(), _ent.getXRot());
										}
										if (entity instanceof Player _player && !_player.level.isClientSide())
											_player.displayClientMessage(Component.literal(("Welcome aboard crewmate. This is your party leader, " + entity.getPersistentData().getString("mbPartyLeader") + "'s, ship.")), (false));
										iterationCount = 3;
									}
								}
							} else if (iterationCount == 2) {
								if ((new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, new BlockPos(xPos, yPos, zPos), "mbShipOwner")).equals(entity.getDisplayName().getString())) {
									{
										Entity _ent = entity;
										_ent.teleportTo((xPos + 0.5), (yPos + 1), (zPos + 0.5));
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport((xPos + 0.5), (yPos + 1), (zPos + 0.5), _ent.getYRot(), _ent.getXRot());
									}
									if (entity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(Component.literal("Welcome aboard, captain."), (false));
									iterationCount = 3;
								}
							}
							break;
						} else if (iterationCount == 2) {
							world.setBlock(new BlockPos(xPos, yPos, zPos), Blocks.CHEST.defaultBlockState(), 3);
							if (!world.isClientSide()) {
								BlockPos _bp = new BlockPos(xPos, yPos, zPos);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putString("mbShipOwner", (entity.getDisplayName().getString()));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							{
								Entity _ent = entity;
								_ent.teleportTo((xPos + 0.5), (yPos + 1), (zPos + 0.5));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((xPos + 0.5), (yPos + 1), (zPos + 0.5), _ent.getYRot(), _ent.getXRot());
							}
							if (entity instanceof Player _player && !_player.level.isClientSide())
								_player.displayClientMessage(Component.literal("Welcome aboard your new ship!"), (false));
							iterationCount = 3;
							break;
						}
						if (!((world.getBlockState(new BlockPos(xPos, yPos, zPos))).getBlock() == Blocks.CHEST)) {
							break;
						} else {
							if (toggleXorZ == true) {
								if (toggleNorP == true) {
									xPos = xPos + distanceApart;
								} else if (toggleNorP == false) {
									xPos = xPos - distanceApart;
								}
							} else if (toggleXorZ == false) {
								if (toggleNorP == true) {
									zPos = zPos + distanceApart;
								} else if (toggleNorP == false) {
									zPos = zPos - distanceApart;
								}
							}
						}
					}
					if (!((world.getBlockState(new BlockPos(xPos, yPos, zPos))).getBlock() == Blocks.CHEST)) {
						break;
					} else {
						if (toggleXorZ == true) {
							toggleXorZ = false;
						} else if (toggleXorZ == false) {
							toggleXorZ = true;
						}
						counter2 = counter2 - 1;
						if (counter2 == 0) {
							if (toggleNorP == true) {
								toggleNorP = false;
							} else if (toggleNorP == false) {
								toggleNorP = true;
							}
							counter1 = counter1 + 1;
							counter2 = 2;
						}
					}
				}
				iterationCount = iterationCount + 1;
			}
		}
	}
}
