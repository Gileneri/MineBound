
package net.mcreator.minebound.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.minebound.procedures.ElectrifiedOnEffectActiveTickProcedure;

public class ElectrifiedMobEffect extends MobEffect {
	public ElectrifiedMobEffect() {
		super(MobEffectCategory.HARMFUL, -2500259);
	}

	@Override
	public String getDescriptionId() {
		return "effect.minebound.electrified";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ElectrifiedOnEffectActiveTickProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
