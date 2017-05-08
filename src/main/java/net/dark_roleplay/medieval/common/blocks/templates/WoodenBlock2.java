package net.dark_roleplay.medieval.common.blocks.templates;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class WoodenBlock2 extends Block{

	public WoodenBlock2(Material materialIn) {
		super(materialIn);
	}
	
	public int typesPerBlock(){
		return 1;
	}
	
	public WoodenBlock2 createInstance(String registryName){
		WoodenBlock2 copied = new WoodenBlock2(this.blockMaterial);
		copied.setRegistryName(registryName);
		copied.setUnlocalizedName(registryName);
		return copied ;
	}

}
