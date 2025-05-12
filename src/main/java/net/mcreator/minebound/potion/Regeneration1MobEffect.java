
package net.mcreator.minebound.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.minebound.procedures.Regeneration1OnEffectActiveTickProcedure;

public class Regeneration1MobEffect extends MobEffect {
	public Regeneration1MobEffect() {
		super(MobEffectCategory.BENEFICIAL, -52429);
	}

	@Override
	public String getDescriptionId() {
		return "effect.minebound.regeneration_1";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Regeneration1OnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
