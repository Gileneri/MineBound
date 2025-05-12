
package net.mcreator.minebound.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.minebound.procedures.BonusHealthEffectStartedappliedProcedure;
import net.mcreator.minebound.procedures.BonusHealthEffectExpiresProcedure;

public class BonusHealthMobEffect extends MobEffect {
	public BonusHealthMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -52429);
	}

	@Override
	public String getDescriptionId() {
		return "effect.minebound.bonus_health";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		BonusHealthEffectStartedappliedProcedure.execute(entity.level, entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		BonusHealthEffectExpiresProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
