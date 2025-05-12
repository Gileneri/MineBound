package net.mcreator.minebound.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.minebound.init.MineboundModParticleTypes;
import net.mcreator.minebound.init.MineboundModBlocks;

public class WetOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (!(entity instanceof LivingEntity _livEnt ? _livEnt.getMobType() == MobType.WATER : false)) {
				if (!entity.isInWaterOrBubble() && !((world.getFluidState(new BlockPos(x, y, z)).createLegacyBlock()).getBlock() == MineboundModBlocks.HEALING_WATER.get()
						&& (world.getFluidState(new BlockPos(x, y, z)).createLegacyBlock()).getBlock() == MineboundModBlocks.SWAMP_WATER.get())) {
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 0.9), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() * 0.9)));
				}
				if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
						} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity))) {
					if (!entity.isInWaterOrBubble() && !((world.getFluidState(new BlockPos(x, y, z)).createLegacyBlock()).getBlock() == MineboundModBlocks.HEALING_WATER.get()
							|| (world.getFluidState(new BlockPos(x, y, z)).createLegacyBlock()).getBlock() == MineboundModBlocks.SWAMP_WATER.get())) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (MineboundModParticleTypes.DRIPING_WET.get()), x, y, z, 1, 0.2, 0.8, 0.2, 2);
					}
				}
			}
		}
	}
}
