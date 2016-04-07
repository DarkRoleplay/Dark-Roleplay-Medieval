package net.drpmedieval.common.events;

import java.util.Random;

import net.drpmedieval.common.items.DRPMedievalItems;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LivingDrop {

	public static Random random;
	public static int dropped;

	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) {

		if(event.entityLiving instanceof EntityBat){
			random = new Random();
			dropped = random.nextInt(3);
			event.entityLiving.dropItem(DRPMedievalItems.itemBatEar, dropped);
		}

		if(event.entityLiving instanceof EntityWolf){
			dropped = random.nextInt(2);
			event.entityLiving.dropItem(DRPMedievalItems.itemFurWolf, dropped);
			dropped = random.nextInt(2) + 1;
			event.entityLiving.dropItem(DRPMedievalItems.itemWolfMeatRaw, dropped);
		}
	}

}
