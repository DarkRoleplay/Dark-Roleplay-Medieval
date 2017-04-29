package net.dark_roleplay.medieval.common.events;

import net.dark_roleplay.medieval.common.blocks.tileentitys.BedFrameTileEntity;
import net.dark_roleplay.medieval.common.capabilities.blocks.bedframe.BedFrameMattressProvider;
import net.dark_roleplay.medieval.common.capabilities.blocks.bedframe.DefaultBedFrameMattress;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCapabilities;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AttachCapabilityTileEntity {

	@SubscribeEvent
	public void AttachCapability(AttachCapabilitiesEvent.TileEntity e){
		if(e.getTileEntity() instanceof BedFrameTileEntity && !e.getTileEntity().hasCapability(DRPMedievalCapabilities.MATTRESS, null) )
			e.addCapability(new ResourceLocation("drpmedieval_mattress"), new BedFrameMattressProvider(new DefaultBedFrameMattress()));
	}
	
}
