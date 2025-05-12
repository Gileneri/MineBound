package net.mcreator.minebound.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.minebound.init.MineboundModMobEffects;

public class HealingWaterMobplayerCollidesBlockProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MineboundModMobEffects.BURNING.get());
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MineboundModMobEffects.REGENERATION_1.get()) : false) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MineboundModMobEffects.REGENERATION_1.get()) ? _livEnt.getEffect(MineboundModMobEffects.REGENERATION_1.get()).getDuration() : 0) < 5) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MineboundModMobEffects.REGENERATION_1.get(), 100, 0, (true), (true)));
				}
			} else {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MineboundModMobEffects.REGENERATION_1.get(), 100, 0, (true), (true)));
			}
			if (!entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("minebound:water_creature")))) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MineboundModMobEffects.WET.get(), 85, 0, (true), (false)));
			}
		}
	}
}
