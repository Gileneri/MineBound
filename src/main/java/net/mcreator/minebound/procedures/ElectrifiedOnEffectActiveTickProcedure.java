package net.mcreator.minebound.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.minebound.init.MineboundModMobEffects;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class ElectrifiedOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Thunder_DMG = 0;
		if (!world.isClientSide()) {
			if (entity.isAlive()) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MineboundModMobEffects.ELECTRIFIED.get()) ? _livEnt.getEffect(MineboundModMobEffects.ELECTRIFIED.get()).getDuration() : 0) % 20 == 0) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
								.collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (entityiterator instanceof LivingEntity) {
									Thunder_DMG = 0.05 * (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
									if (Thunder_DMG > 4) {
										Thunder_DMG = 4;
									} else if (Thunder_DMG < 0.4) {
										Thunder_DMG = 0.4;
									}
									if (((entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) || entity instanceof Villager || entity instanceof WanderingTrader || entity instanceof Player || entity instanceof ServerPlayer)
											&& ((entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) || entityiterator instanceof Villager || entityiterator instanceof WanderingTrader || entityiterator instanceof Player
													|| entityiterator instanceof ServerPlayer)) {
										if (entityiterator instanceof LivingEntity _entity)
											_entity.hurt(new DamageSource("was shocked").bypassArmor(), (float) Thunder_DMG);
									} else if (entity instanceof Animal && entityiterator instanceof Animal) {
										if (entityiterator instanceof LivingEntity _entity)
											_entity.hurt(new DamageSource("was shocked").bypassArmor(), (float) Thunder_DMG);
									} else if (!((entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) || entity instanceof Villager || entity instanceof WanderingTrader || entity instanceof Player || entity instanceof ServerPlayer
											|| entity instanceof Animal)
											&& !((entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) || entityiterator instanceof Villager || entityiterator instanceof WanderingTrader || entityiterator instanceof Player
													|| entityiterator instanceof ServerPlayer || entityiterator instanceof Animal)) {
										if (entityiterator instanceof LivingEntity _entity)
											_entity.hurt(new DamageSource("was shocked").bypassArmor(), (float) Thunder_DMG);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
