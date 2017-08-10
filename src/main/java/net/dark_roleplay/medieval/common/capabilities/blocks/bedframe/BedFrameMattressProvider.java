package net.dark_roleplay.medieval.common.capabilities.blocks.bedframe;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCapabilities;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class BedFrameMattressProvider implements ICapabilityProvider {

	 private TileEntity te;

	 BedFrameMattressProvider(TileEntity te)
     {
         this.te = te;
     }
	
	 private IBedFrameMattress mattress = null;
		
	public BedFrameMattressProvider(){
		mattress = new DefaultBedFrameMattress();
	}
		
	public BedFrameMattressProvider(IBedFrameMattress mattress){
		this.mattress = mattress;
	}
	 
	@Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        return DRPMedievalCapabilities.MATTRESS != null && capability == DRPMedievalCapabilities.MATTRESS ;
    }
	
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if (DRPMedievalCapabilities.MATTRESS  != null && capability == DRPMedievalCapabilities.MATTRESS ) return (T)mattress;
        return null;
    }

}
