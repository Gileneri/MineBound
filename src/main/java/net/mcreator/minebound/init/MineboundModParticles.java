
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minebound.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.minebound.client.particle.PoisonDripParticle;
import net.mcreator.minebound.client.particle.PoisonBublesParticle;
import net.mcreator.minebound.client.particle.OresparkParticle;
import net.mcreator.minebound.client.particle.DrippingOilParticle;
import net.mcreator.minebound.client.particle.DripingWetParticle;
import net.mcreator.minebound.client.particle.DripingSlimeParticle;
import net.mcreator.minebound.client.particle.BurningParticleParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MineboundModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.register(MineboundModParticleTypes.DRIPING_WET.get(), DripingWetParticle::provider);
		event.register(MineboundModParticleTypes.POISON_BUBLES.get(), PoisonBublesParticle::provider);
		event.register(MineboundModParticleTypes.POISON_DRIP.get(), PoisonDripParticle::provider);
		event.register(MineboundModParticleTypes.BURNING_PARTICLE.get(), BurningParticleParticle::provider);
		event.register(MineboundModParticleTypes.DRIPING_SLIME.get(), DripingSlimeParticle::provider);
		event.register(MineboundModParticleTypes.DRIPPING_OIL.get(), DrippingOilParticle::provider);
		event.register(MineboundModParticleTypes.ORESPARK.get(), OresparkParticle::provider);
	}
}
