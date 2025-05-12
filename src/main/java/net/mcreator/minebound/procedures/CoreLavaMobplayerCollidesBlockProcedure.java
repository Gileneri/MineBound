package net.mcreator.minebound.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.minebound.init.MineboundModMobEffects;

public class CoreLavaMobplayerCollidesBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isAlive()) {
			if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MineboundModMobEffects.DEADLY_HEAT.get()) : false)) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MineboundModMobEffects.DEADLY_HEAT.get(), 25, 0, (false), (false)));
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MineboundModMobEffects.DEADLY_HEAT.get()) ? _livEnt.getEffect(MineboundModMobEffects.DEADLY_HEAT.get()).getDuration() : 0) <= 5) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MineboundModMobEffects.DEADLY_HEAT.get(), 25,
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MineboundModMobEffects.DEADLY_HEAT.get()) ? _livEnt.getEffect(MineboundModMobEffects.DEADLY_HEAT.get()).getAmplifier() : 0) + 1), (false), (false)));
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("melted").bypassArmor(),
							(float) (Math.pow(2, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MineboundModMobEffects.DEADLY_HEAT.get()) ? _livEnt.getEffect(MineboundModMobEffects.DEADLY_HEAT.get()).getAmplifier() : 0) + 1) * 3));
			}
		}
	}
}
