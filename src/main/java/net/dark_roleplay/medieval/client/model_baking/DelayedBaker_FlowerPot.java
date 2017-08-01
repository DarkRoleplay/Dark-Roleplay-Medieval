package net.dark_roleplay.medieval.client.model_baking;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.dark_roleplay.medieval.common.blocks.decorative.flowerPot.FlowerPot;
import net.dark_roleplay.medieval.common.blocks.decorative.hangingBridges.HangingBridge;
import net.dark_roleplay.medieval.common.blocks.helper.EnumAxis;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.property.IExtendedBlockState;

public class DelayedBaker_FlowerPot extends DelayedBaker implements ICustomModelLoader{

	protected static final Map<IBlockState, List<BakedQuad>> CACHE = Maps.newHashMap();
	
	private static final String[] flowers = new String[]{
			"drpmedieval:blocks/invisible",
			"blocks/flower_dandelion",
			"blocks/flower_rose",
			"blocks/flower_blue_orchid",
			"blocks/flower_allium",
			"blocks/flower_houstonia",
			"blocks/flower_tulip_red",
			"blocks/flower_tulip_orange",
			"blocks/flower_tulip_white",
			"blocks/flower_tulip_pink",
			"blocks/flower_oxeye_daisy"};
	
	protected static ImmutableList<ResourceLocation> textures;
	
	protected static IModel baseModel;
	
	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		side = null;
		
		if(this.CACHE.containsKey(state))
			return this.CACHE.get(state);
		
		List<BakedQuad> result = Lists.newArrayList();
		
		int yRot = state.getValue(HangingBridge.AXIS) == EnumAxis.Z ? 90 : 0;
		
		if(state instanceof IExtendedBlockState){
			IExtendedBlockState ext = (IExtendedBlockState) state;
			
			int flower1 = ext.getValue(FlowerPot.FLOWER1); 
			int flower2 = ext.getValue(FlowerPot.FLOWER2);  
			int flower3 = ext.getValue(FlowerPot.FLOWER3);
			
			this.addQuads(result, this.baseModel, yRot, 0, state, side, rand);
			
			ImmutableList.Builder<ResourceLocation> builder = ImmutableList.builder();
			
				builder.addAll(this.baseModel.getTextures());
			
			this.textures = builder.build();
			
			for(int i = 0; i < 100; i++)
			System.out.println(baseModel.getTextures());
		}
		
		this.CACHE.put(state, result);
		return result;
	}

	@Override
	public Collection<ResourceLocation> getTextures() { return this.textures; }

	@Override
	public IBakedModel bake(IModelState state, VertexFormat format, java.util.function.Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		this.bakeInfo(format, bakedTextureGetter, new ResourceLocation(DRPMedievalInfo.MODID, "blocks/clean_plank_spruce"));
		return this;
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) { this.CACHE.clear(); }

	@Override
	public boolean accepts(ResourceLocation modelLocation) {
		return false;
//		return ((modelLocation instanceof ModelResourceLocation) && DRPMedievalBlocks.FLOWER_POT.getRegistryName().equals(modelLocation));
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws Exception {
		if(this.baseModel == null){
			this.baseModel = this.getModel("flower_pot");
		}
		
		if(this.textures == null){
			ImmutableList.Builder<ResourceLocation> builder = ImmutableList.builder();
			builder.addAll(this.baseModel.getTextures());
			
			this.textures = builder.build();
		}
		
		return this;
	}

	protected static IModel getModel(String modelName){
		return ModelLoaderRegistry.getModelOrLogError(new ResourceLocation(DRPMedievalInfo.MODID, "block/flower_pot/" + modelName), "A problem occured while trying to load: " + DRPMedievalInfo.MODID + ":block/flower_pot/" + modelName);
	}
}
