package net.drpmedieval.common.events;

import java.util.Random;

import net.drpmedieval.common.handler.DRPMedievalItems;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LivingDrop {

	public static Random random;
	public static int dropped;

	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) {

		if(event.getEntityLiving() instanceof EntityBat){
			random = new Random();
			dropped = random.nextInt(3);
			event.getEntityLiving().dropItem(DRPMedievalItems.BatEar, dropped);
		}

		if(event.getEntityLiving() instanceof EntityWolf){
			random = new Random();
			dropped = 0;
			if(event.getSource().isProjectile()){
				dropped = Math.abs(1/(random.nextInt(5)+1));
			}else{
				dropped = 1;
			}
			event.getEntityLiving().dropItem(DRPMedievalItems.FurWolf, dropped);
			dropped = random.nextInt(2) + 1;
			event.getEntityLiving().dropItem(DRPMedievalItems.WolfMeatRaw, dropped);
		}
	}

}
