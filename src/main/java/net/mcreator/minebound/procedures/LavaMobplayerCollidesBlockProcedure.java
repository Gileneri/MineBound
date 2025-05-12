package net.mcreator.minebound.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.minebound.init.MineboundModMobEffects;

public class LavaMobplayerCollidesBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("minebound:fire_creature")))) {
			if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MineboundModMobEffects.MELTING_LAVA.get()) : false)) {
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("melt").bypassArmor(), 3);
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MineboundModMobEffects.MELTING_LAVA.get(), 25, 0, (false), (true)));
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MineboundModMobEffects.MELTING_LAVA.get()) ? _livEnt.getEffect(MineboundModMobEffects.MELTING_LAVA.get()).getDuration() : 0) <= 5) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MineboundModMobEffects.MELTING_LAVA.get(), 25,
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MineboundModMobEffects.MELTING_LAVA.get()) ? _livEnt.getEffect(MineboundModMobEffects.MELTING_LAVA.get()).getAmplifier() : 0) + 1), (false), (true)));
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("melted").bypassArmor(),
							(float) (Math.pow(2, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MineboundModMobEffects.MELTING_LAVA.get()) ? _livEnt.getEffect(MineboundModMobEffects.MELTING_LAVA.get()).getAmplifier() : 0) + 1) * 3));
			}
		}
	}
}
