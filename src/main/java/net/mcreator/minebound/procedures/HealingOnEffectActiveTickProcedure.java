package net.mcreator.minebound.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.minebound.init.MineboundModMobEffects;
import net.mcreator.minebound.MineboundMod;

public class HealingOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double Cure_Power = 0;
		if (!world.isClientSide()) {
			if (entity.isAlive()) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MineboundModMobEffects.HEALING.get()) ? _livEnt.getEffect(MineboundModMobEffects.HEALING.get()).getDuration() : 0) % 4 == 0) {
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
								+ ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MineboundModMobEffects.HEALING.get()) ? _livEnt.getEffect(MineboundModMobEffects.HEALING.get()).getAmplifier() : 0) + 1) * 0.2));
					MineboundMod.LOGGER.info(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
				}
			}
		}
	}
}
