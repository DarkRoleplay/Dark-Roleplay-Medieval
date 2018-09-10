package net.dark_roleplay.medieval.mess.common.handler;

import net.dark_roleplay.medieval.mess.common.References;
import net.dark_roleplay.medieval.mess.common.objects.potions.DrunkPotion;
import net.minecraft.block.Block;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(References.MODID)
@Mod.EventBusSubscriber
public class DRPMedievalPotions {

	@SubscribeEvent
	public static final void register(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(new DrunkPotion());
	}
}
