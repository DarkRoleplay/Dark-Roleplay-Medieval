package net.drpmedieval.common.events;

import net.drpmedieval.common.blocks.tileentitys.BedFrameTileEntity;
import net.drpmedieval.common.capabilities.blocks.bedframe.BedFrameMattressProvider;
import net.drpmedieval.common.capabilities.blocks.bedframe.DefaultBedFrameMattress;
import net.drpmedieval.common.handler.DRPMedievalCapabilities;
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
