package net.mcreator.minebound.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.minebound.MineboundMod;

public class DebugTestToolLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		MineboundMod.LOGGER.info(sourceentity + "" + entity);
		if (sourceentity instanceof LivingEntity) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("it lives!!"), (false));
		}
		if (sourceentity instanceof Monster) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("you monster!!"), (false));
		}
		if (sourceentity instanceof Animal) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("animal :3"), (false));
		}
		if (entity instanceof LivingEntity) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("it lives!!"), (false));
		}
		if (entity instanceof Monster) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("you monster!!"), (false));
		}
		if (entity instanceof Animal) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("animal :3"), (false));
		}
	}
}
