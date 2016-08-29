package net.drpmedieval.common.capabilities.blocks.bedframe;

import net.drpmedieval.common.capabilities.DRPMCapabilities;
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
        return DRPMCapabilities.MATTRESS != null && capability == DRPMCapabilities.MATTRESS ;
    }
	
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if (DRPMCapabilities.MATTRESS  != null && capability == DRPMCapabilities.MATTRESS ) return (T)mattress;
        return null;
    }

}
