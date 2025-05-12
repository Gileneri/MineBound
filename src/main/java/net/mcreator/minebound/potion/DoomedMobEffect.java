
package net.mcreator.minebound.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class DoomedMobEffect extends MobEffect {
	public DoomedMobEffect() {
		super(MobEffectCategory.HARMFUL, -902084);
	}

	@Override
	public String getDescriptionId() {
		return "effect.minebound.doomed";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
