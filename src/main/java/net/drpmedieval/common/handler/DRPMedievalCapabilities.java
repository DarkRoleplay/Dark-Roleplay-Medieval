package net.drpmedieval.common.handler;

import net.drpmedieval.common.capabilities.blocks.bedframe.IBedFrameMattress;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class DRPMedievalCapabilities {
	
	@CapabilityInject(IBedFrameMattress.class)
    public static Capability<IBedFrameMattress> MATTRESS;
	
}
