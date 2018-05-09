package net.dark_roleplay.medieval.client.model_baking.advanced;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;

import net.dark_roleplay.medieval.client.blocks.tesrs.roof.TESR_Roof;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

public class CustomBlockstateLoader implements ICustomModelLoader{

	private IResourceManager manager;
	
	private HashMap<String, HashMap<String, JsonObject>> cache;
	
	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		manager = resourceManager;
		TESR_Roof.north = new HashMap<IBlockState, TextureAtlasSprite>(); 
		TESR_Roof.east = new HashMap<IBlockState, TextureAtlasSprite>();  
		TESR_Roof.south = new HashMap<IBlockState, TextureAtlasSprite>(); 
		TESR_Roof.west = new HashMap<IBlockState, TextureAtlasSprite>();  
	}

	@Override
	public boolean accepts(ResourceLocation modelLocation) {
//		if(modelLocation instanceof ModelResourceLocation){
//			try{
//				manager.getResource(new ResourceLocation(modelLocation.getResourceDomain(), "drp/blockstates/" + modelLocation.getResourcePath() + ".json"));
//				return true;
//			}catch(IOException e){
//				return false;
//			}
//		}
		return false;
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws Exception {
		System.out.println("SEARCH ME BIATCH : " + modelLocation);
		
		String domain = modelLocation.getResourceDomain();
		String path = modelLocation.getResourcePath();
		JsonObject file;
		
		if(!cache.containsKey(domain)){
			cache.put(domain, new HashMap<String,JsonObject>());
		}
		
		if(!cache.get(domain).containsKey(path)){
			cache.get(domain).put(path, BlockStateLoader.getBlockState(new ResourceLocation(modelLocation.getResourceDomain(), "drp/blockstates/" + modelLocation.getResourcePath() + ".json")));
		}
		
		JsonObject blockstate = cache.get(domain).get(path);
		
		return new DelayedModel();
	}

}
