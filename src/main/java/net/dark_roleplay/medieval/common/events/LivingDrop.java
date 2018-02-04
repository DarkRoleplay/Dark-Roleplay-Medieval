package net.dark_roleplay.medieval.common.events;

import java.util.Random;

import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class LivingDrop {

	public static Random random;
	public static int dropped;

	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) {

		if(event.getEntityLiving() instanceof EntityBat){
			LivingDrop.random = new Random();
			LivingDrop.dropped = LivingDrop.random.nextInt(3);
			event.getEntityLiving().dropItem(DRPMedievalItems.BAT_EAR, LivingDrop.dropped);
		}

		if(event.getEntityLiving() instanceof EntityWolf){
			LivingDrop.random = new Random();
			LivingDrop.dropped = 0;
			if(event.getSource().isProjectile()){
				LivingDrop.dropped = Math.abs(1/(LivingDrop.random.nextInt(5)+1));
			}else{
				LivingDrop.dropped = 1;
			}
			event.getEntityLiving().dropItem(DRPMedievalItems.FUR_WOLF, LivingDrop.dropped);
			LivingDrop.dropped = LivingDrop.random.nextInt(2) + 1;
			event.getEntityLiving().dropItem(DRPMedievalItems.MEAT_RAW_WOLF, LivingDrop.dropped);
		}
	}

}
