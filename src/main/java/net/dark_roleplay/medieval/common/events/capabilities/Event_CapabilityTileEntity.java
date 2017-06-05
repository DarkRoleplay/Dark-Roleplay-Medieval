package net.dark_roleplay.medieval.common.events.capabilities;

import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Event_CapabilityTileEntity {

	@SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent.TileEntity event){
       // if (!(event.getEntity() instanceof EntityPlayer)) return;

//		event.addCapability(DRPMedievalInfo.MODID + "inventory", CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
		
//        event.addCapability(new ResourceLocation(DRPCoreInfo.MODID, "recipe_controller"), new CapabilityProvider(DRPCoreCapabilities.DRPCORE_RECIPE_CONTROLLER));
//        event.addCapability(new ResourceLocation(DRPCoreInfo.MODID, "skill_controller"), new CapabilityProvider(DRPCoreCapabilities.DRPCORE_SKILL_CONTROLLER));
    }
	
}
