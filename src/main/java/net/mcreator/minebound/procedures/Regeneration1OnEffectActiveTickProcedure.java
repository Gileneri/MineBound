package net.mcreator.minebound.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.minebound.init.MineboundModMobEffects;

public class Regeneration1OnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double regeneration1 = 0;
		double howLongToWait = 0;
		if (entity.isAlive()) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MineboundModMobEffects.REGENERATION_1.get()) ? _livEnt.getEffect(MineboundModMobEffects.REGENERATION_1.get()).getAmplifier() : 0) >= 4) {
				howLongToWait = (10 - (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MineboundModMobEffects.REGENERATION_1.get()) ? _livEnt.getEffect(MineboundModMobEffects.REGENERATION_1.get()).getAmplifier() : 0)) * 20;
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MineboundModMobEffects.REGENERATION_1.get()) ? _livEnt.getEffect(MineboundModMobEffects.REGENERATION_1.get()).getAmplifier() : 0) == 3) {
				howLongToWait = 9;
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MineboundModMobEffects.REGENERATION_1.get()) ? _livEnt.getEffect(MineboundModMobEffects.REGENERATION_1.get()).getAmplifier() : 0) == 2) {
				howLongToWait = 12;
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MineboundModMobEffects.REGENERATION_1.get()) ? _livEnt.getEffect(MineboundModMobEffects.REGENERATION_1.get()).getAmplifier() : 0) == 1) {
				howLongToWait = 13.5;
			} else {
				howLongToWait = 18;
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MineboundModMobEffects.REGENERATION_1.get()) ? _livEnt.getEffect(MineboundModMobEffects.REGENERATION_1.get()).getDuration() : 0) % howLongToWait == 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.1));
			}
		}
	}
}
