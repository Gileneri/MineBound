
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minebound.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.minebound.client.gui.ShipDimensionSelectGUITestScreen;
import net.mcreator.minebound.client.gui.MMUpgradeGUITestScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MineboundModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MineboundModMenus.MM_UPGRADE_GUI_TEST.get(), MMUpgradeGUITestScreen::new);
			MenuScreens.register(MineboundModMenus.SHIP_DIMENSION_SELECT_GUI_TEST.get(), ShipDimensionSelectGUITestScreen::new);
		});
	}
}
