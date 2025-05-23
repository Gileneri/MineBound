
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minebound.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.minebound.MineboundMod;

public class MineboundModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MineboundMod.MODID);
	public static final RegistryObject<SimpleParticleType> DRIPING_WET = REGISTRY.register("driping_wet", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> POISON_BUBLES = REGISTRY.register("poison_bubles", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> POISON_DRIP = REGISTRY.register("poison_drip", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> BURNING_PARTICLE = REGISTRY.register("burning_particle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DRIPING_SLIME = REGISTRY.register("driping_slime", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> DRIPPING_OIL = REGISTRY.register("dripping_oil", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> ORESPARK = REGISTRY.register("orespark", () -> new SimpleParticleType(false));
}
