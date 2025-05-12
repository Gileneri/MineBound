
package net.mcreator.minebound.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.minebound.procedures.MeltingLavaOnEffectActiveTickProcedure;
import net.mcreator.minebound.procedures.MeltingLavaEffectExpiresProcedure;

public class MeltingLavaMobEffect extends MobEffect {
	public MeltingLavaMobEffect() {
		super(MobEffectCategory.HARMFUL, -65536);
	}

	@Override
	public String getDescriptionId() {
		return "effect.minebound.melting_lava";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		MeltingLavaOnEffectActiveTickProcedure.execute(entity.level, entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		MeltingLavaEffectExpiresProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
