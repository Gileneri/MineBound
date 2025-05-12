
package net.mcreator.minebound.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.minebound.procedures.SlimeOnEffectActiveTickProcedure;
import net.mcreator.minebound.procedures.SlimeEffectStartsProcedure;
import net.mcreator.minebound.procedures.SlimeEffectExpiresProcedure;

public class SlimeMobEffect extends MobEffect {
	public SlimeMobEffect() {
		super(MobEffectCategory.HARMFUL, -13369498);
	}

	@Override
	public String getDescriptionId() {
		return "effect.minebound.slime";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		SlimeEffectStartsProcedure.execute(entity.level, entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SlimeOnEffectActiveTickProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		SlimeEffectExpiresProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
