
package net.mcreator.minebound.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.minebound.procedures.TarEffectStartsProcedure;
import net.mcreator.minebound.procedures.TarEffectOnEffectActiveTickProcedure;
import net.mcreator.minebound.procedures.TarEffectExpiresProcedure;

public class TarEffectMobEffect extends MobEffect {
	public TarEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -14672861);
	}

	@Override
	public String getDescriptionId() {
		return "effect.minebound.tar_effect";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		TarEffectStartsProcedure.execute(entity.level, entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		TarEffectOnEffectActiveTickProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		TarEffectExpiresProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
