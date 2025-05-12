
package net.mcreator.minebound.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.minebound.procedures.BonusEnergyEffectStartedappliedProcedure;
import net.mcreator.minebound.procedures.BonusEnergyEffectExpiresProcedure;

public class BonusEnergyMobEffect extends MobEffect {
	public BonusEnergyMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -6684826);
	}

	@Override
	public String getDescriptionId() {
		return "effect.minebound.bonus_energy";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		BonusEnergyEffectStartedappliedProcedure.execute(entity.level, entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		BonusEnergyEffectExpiresProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
