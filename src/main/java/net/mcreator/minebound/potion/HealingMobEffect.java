
package net.mcreator.minebound.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.minebound.procedures.HealingOnEffectActiveTickProcedure;

public class HealingMobEffect extends MobEffect {
	public HealingMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -2778727);
	}

	@Override
	public String getDescriptionId() {
		return "effect.minebound.healing";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		HealingOnEffectActiveTickProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
