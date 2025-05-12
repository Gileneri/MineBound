
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minebound.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.minebound.world.features.plants.OldpapersFeature;
import net.mcreator.minebound.world.features.ores.WasteFeature;
import net.mcreator.minebound.world.features.ores.UnrefinedAndesiteFeature;
import net.mcreator.minebound.world.features.ores.TarTestFeature;
import net.mcreator.minebound.world.features.ores.SlushFeature;
import net.mcreator.minebound.world.features.ores.RustyBlockFeature;
import net.mcreator.minebound.world.features.ores.RoughsandstoneFeature;
import net.mcreator.minebound.world.features.ores.RawSewageFeature;
import net.mcreator.minebound.world.features.ores.MudFeature;
import net.mcreator.minebound.world.features.ores.MoonstoneFeature;
import net.mcreator.minebound.world.features.ores.MoonrockFeature;
import net.mcreator.minebound.world.features.ores.MoonDustFeature;
import net.mcreator.minebound.world.features.ores.GraniteRockFeature;
import net.mcreator.minebound.world.features.ores.GenerateInDepth6Feature;
import net.mcreator.minebound.world.features.ores.GenerateInDepth5Feature;
import net.mcreator.minebound.world.features.ores.GenerateInDepth4Feature;
import net.mcreator.minebound.world.features.ores.GenerateInDepth3Feature;
import net.mcreator.minebound.world.features.ores.GenerateInDepth2Feature;
import net.mcreator.minebound.world.features.ores.GenerateInDepth1Feature;
import net.mcreator.minebound.world.features.ores.DirtmaterialFeature;
import net.mcreator.minebound.world.features.ores.AshFeature;
import net.mcreator.minebound.world.features.UtilityPoleStructureFeature;
import net.mcreator.minebound.world.features.TelephonePoleFeature;
import net.mcreator.minebound.world.features.ScorchedSkyscraper2Feature;
import net.mcreator.minebound.world.features.ScorchedSkyscraper1Feature;
import net.mcreator.minebound.world.features.RuinedSidewalkFeature;
import net.mcreator.minebound.world.features.RuinedShopFeature;
import net.mcreator.minebound.world.features.RuinedRoadFeature;
import net.mcreator.minebound.world.features.RuinedGasStationFeature;
import net.mcreator.minebound.world.features.RuinedBenchesSidewalkFeature;
import net.mcreator.minebound.world.features.PileOfJunk2Feature;
import net.mcreator.minebound.world.features.PileOfJunk1Feature;
import net.mcreator.minebound.world.features.GlassTopperStructureFeature;
import net.mcreator.minebound.world.features.ErchiusFuelPoolFeature;
import net.mcreator.minebound.world.features.ErchiusCavePoolFeature;
import net.mcreator.minebound.world.features.DumpsterWalkwayFeature;
import net.mcreator.minebound.world.features.AirTopperStructureFeature;
import net.mcreator.minebound.MineboundMod;

@Mod.EventBusSubscriber
public class MineboundModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, MineboundMod.MODID);
	public static final RegistryObject<Feature<?>> ASH = REGISTRY.register("ash", AshFeature::feature);
	public static final RegistryObject<Feature<?>> DIRTMATERIAL = REGISTRY.register("dirtmaterial", DirtmaterialFeature::feature);
	public static final RegistryObject<Feature<?>> MOON_DUST = REGISTRY.register("moon_dust", MoonDustFeature::feature);
	public static final RegistryObject<Feature<?>> MOONROCK = REGISTRY.register("moonrock", MoonrockFeature::feature);
	public static final RegistryObject<Feature<?>> MOONSTONE = REGISTRY.register("moonstone", MoonstoneFeature::feature);
	public static final RegistryObject<Feature<?>> MUD = REGISTRY.register("mud", MudFeature::feature);
	public static final RegistryObject<Feature<?>> ROUGHSANDSTONE = REGISTRY.register("roughsandstone", RoughsandstoneFeature::feature);
	public static final RegistryObject<Feature<?>> SLUSH = REGISTRY.register("slush", SlushFeature::feature);
	public static final RegistryObject<Feature<?>> WASTE = REGISTRY.register("waste", WasteFeature::feature);
	public static final RegistryObject<Feature<?>> UNREFINED_ANDESITE = REGISTRY.register("unrefined_andesite", UnrefinedAndesiteFeature::feature);
	public static final RegistryObject<Feature<?>> GRANITE_ROCK = REGISTRY.register("granite_rock", GraniteRockFeature::feature);
	public static final RegistryObject<Feature<?>> TAR_TEST = REGISTRY.register("tar_test", TarTestFeature::feature);
	public static final RegistryObject<Feature<?>> RUSTY_BLOCK = REGISTRY.register("rusty_block", RustyBlockFeature::feature);
	public static final RegistryObject<Feature<?>> RAW_SEWAGE = REGISTRY.register("raw_sewage", RawSewageFeature::feature);
	public static final RegistryObject<Feature<?>> GLASS_TOPPER_STRUCTURE = REGISTRY.register("glass_topper_structure", GlassTopperStructureFeature::feature);
	public static final RegistryObject<Feature<?>> AIR_TOPPER_STRUCTURE = REGISTRY.register("air_topper_structure", AirTopperStructureFeature::feature);
	public static final RegistryObject<Feature<?>> ERCHIUS_FUEL_POOL = REGISTRY.register("erchius_fuel_pool", ErchiusFuelPoolFeature::new);
	public static final RegistryObject<Feature<?>> ERCHIUS_CAVE_POOL = REGISTRY.register("erchius_cave_pool", ErchiusCavePoolFeature::new);
	public static final RegistryObject<Feature<?>> GENERATE_IN_DEPTH_1 = REGISTRY.register("generate_in_depth_1", GenerateInDepth1Feature::feature);
	public static final RegistryObject<Feature<?>> GENERATE_IN_DEPTH_2 = REGISTRY.register("generate_in_depth_2", GenerateInDepth2Feature::feature);
	public static final RegistryObject<Feature<?>> GENERATE_IN_DEPTH_3 = REGISTRY.register("generate_in_depth_3", GenerateInDepth3Feature::feature);
	public static final RegistryObject<Feature<?>> GENERATE_IN_DEPTH_4 = REGISTRY.register("generate_in_depth_4", GenerateInDepth4Feature::feature);
	public static final RegistryObject<Feature<?>> GENERATE_IN_DEPTH_5 = REGISTRY.register("generate_in_depth_5", GenerateInDepth5Feature::feature);
	public static final RegistryObject<Feature<?>> GENERATE_IN_DEPTH_6 = REGISTRY.register("generate_in_depth_6", GenerateInDepth6Feature::feature);
	public static final RegistryObject<Feature<?>> OLDPAPERS = REGISTRY.register("oldpapers", OldpapersFeature::feature);
	public static final RegistryObject<Feature<?>> SCORCHED_SKYSCRAPER_1 = REGISTRY.register("scorched_skyscraper_1", ScorchedSkyscraper1Feature::feature);
	public static final RegistryObject<Feature<?>> SCORCHED_SKYSCRAPER_2 = REGISTRY.register("scorched_skyscraper_2", ScorchedSkyscraper2Feature::feature);
	public static final RegistryObject<Feature<?>> TELEPHONE_POLE = REGISTRY.register("telephone_pole", TelephonePoleFeature::feature);
	public static final RegistryObject<Feature<?>> UTILITY_POLE_STRUCTURE = REGISTRY.register("utility_pole_structure", UtilityPoleStructureFeature::feature);
	public static final RegistryObject<Feature<?>> RUINED_SIDEWALK = REGISTRY.register("ruined_sidewalk", RuinedSidewalkFeature::feature);
	public static final RegistryObject<Feature<?>> RUINED_GAS_STATION = REGISTRY.register("ruined_gas_station", RuinedGasStationFeature::feature);
	public static final RegistryObject<Feature<?>> RUINED_BENCHES_SIDEWALK = REGISTRY.register("ruined_benches_sidewalk", RuinedBenchesSidewalkFeature::feature);
	public static final RegistryObject<Feature<?>> RUINED_SHOP = REGISTRY.register("ruined_shop", RuinedShopFeature::feature);
	public static final RegistryObject<Feature<?>> DUMPSTER_WALKWAY = REGISTRY.register("dumpster_walkway", DumpsterWalkwayFeature::feature);
	public static final RegistryObject<Feature<?>> RUINED_ROAD = REGISTRY.register("ruined_road", RuinedRoadFeature::feature);
	public static final RegistryObject<Feature<?>> PILE_OF_JUNK_1 = REGISTRY.register("pile_of_junk_1", PileOfJunk1Feature::feature);
	public static final RegistryObject<Feature<?>> PILE_OF_JUNK_2 = REGISTRY.register("pile_of_junk_2", PileOfJunk2Feature::feature);
}
