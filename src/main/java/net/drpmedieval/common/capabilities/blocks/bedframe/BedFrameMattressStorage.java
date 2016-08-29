package net.drpmedieval.common.capabilities.blocks.bedframe;

import net.drpmedieval.common.blocks.helper.EnumMattressType;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class BedFrameMattressStorage implements IStorage<IBedFrameMattress>{

	@Override
	public NBTBase writeNBT(Capability<IBedFrameMattress> capability, IBedFrameMattress instance, EnumFacing side) {
		return new NBTTagString(instance.getMattress().toString());
	}

	@Override
	public void readNBT(Capability<IBedFrameMattress> capability, IBedFrameMattress instance, EnumFacing side,NBTBase nbt) {
	
        if (nbt != null && nbt instanceof NBTTagInt)
            instance.setMattress(EnumMattressType.getType(((NBTTagString) nbt).getString()));
		
	}

}
