package net.dark_roleplay.medieval.common.items.equipment.other;

import net.dark_roleplay.drpcore.api.items.DRPItem;
import net.dark_roleplay.medieval.client.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Telescope extends DRPItem{

	public Telescope(String name, String foldername) {
		super(name, foldername, 1);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected){
		if(world.isRemote){
			if(entity.isSneaking()){
				if(ClientProxy.previewsFOV == -1){
					ClientProxy.previewsFOV = Minecraft.getMinecraft().gameSettings.fovSetting;
					Minecraft.getMinecraft().gameSettings.fovSetting = 20;
					Minecraft.getMinecraft().gameSettings.smoothCamera = true;
				}
			}else{
				if(ClientProxy.previewsFOV != -1){
					Minecraft.getMinecraft().gameSettings.fovSetting = ClientProxy.previewsFOV;
					ClientProxy.previewsFOV = -1;
					Minecraft.getMinecraft().gameSettings.smoothCamera = false;
				}
			}
		}
    }

	
}
