package net.mcreator.minebound.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.minebound.init.MineboundModMobEffects;
import net.mcreator.minebound.MineboundMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DoomedGlobalProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, double amount) {
		execute(null, world, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, double amount) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MineboundModMobEffects.DOOMED.get()) : false) {
			if (amount >= 2) {
				MineboundMod.queueServerWork(1, () -> {
					if (entity.isAlive()) {
						if (entity instanceof LivingEntity _entity)
							_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - 26));
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MineboundModMobEffects.DOOMED.get());
						if (world instanceof Level _level && !_level.isClientSide())
							_level.explode(null, (entity.getX()), (entity.getY()), (entity.getZ()), 0, Explosion.BlockInteraction.NONE);
					}
				});
			}
		}
	}
}
