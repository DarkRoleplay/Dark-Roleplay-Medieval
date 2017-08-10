package net.dark_roleplay.medieval.api.blocks.wood;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.ResourceLocation;

public class WoodType {

	private final ResourceLocation barkTexture;
	private final ResourceLocation barkTopTexture;
	private final ResourceLocation plankTexture;
	private final ResourceLocation cleanPlankTexture;
	
	private final String modid;
	private final String name;
	private final MapColor mapColor;
	
	public WoodType(ResourceLocation registryName, MapColor mapColor, ResourceLocation barkTexture, ResourceLocation barkTopTexture, ResourceLocation plankTexture, ResourceLocation cleanPlankTexture){
		this.barkTexture = barkTexture;
		this.barkTopTexture = barkTopTexture;
		this.plankTexture = plankTexture;
		this.cleanPlankTexture = cleanPlankTexture;
		this.modid = registryName.getResourceDomain();
		this.name = registryName.getResourcePath();
		this.mapColor = mapColor;
	}
}
