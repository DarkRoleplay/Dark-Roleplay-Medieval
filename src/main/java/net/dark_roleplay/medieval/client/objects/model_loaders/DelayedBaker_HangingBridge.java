package net.dark_roleplay.medieval.client.objects.model_loaders;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.dark_roleplay.medieval.common.References;
import net.dark_roleplay.medieval.common.handler.MedievalBlocks;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.hanging_bridges.HangingBridge;
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

public class DelayedBaker_HangingBridge extends DelayedBaker implements ICustomModelLoader{

	protected static final Map<IBlockState, List<BakedQuad>> CACHE = Maps.newHashMap();
	
	protected static ImmutableList<ResourceLocation> textures;
	
	protected static IModel[] planks;
	protected static IModel[] post_left;
	protected static IModel[] post_right;
	protected static IModel[] rope_side;
	
	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		side = null;
		
		if(CACHE.containsKey(state))
			return CACHE.get(state);
		
		List<BakedQuad> result = Lists.newArrayList();
		
		int yRot = state.getValue(BlockProperties.AXIS_HORIZONTAL) == EnumFacing.Axis.Z ? 90 : 0;
		int height = state.getValue(HangingBridge.HEIGHT) + (((HangingBridge)state.getBlock()).getRegistryName().getResourcePath().contains("top") ? 8 : 0);
		
		if(state instanceof IExtendedBlockState){
			IExtendedBlockState ext = (IExtendedBlockState) state;
			
			boolean north = ext.getValue(HangingBridge.NORTH); 
			boolean east = ext.getValue(HangingBridge.EAST); 
			boolean south = ext.getValue(HangingBridge.SOUTH); 
			boolean west = ext.getValue(HangingBridge.WEST);
			
			this.addQuads(result, planks[height], yRot, 0, state, side, rand);
			
			if(east){
				this.addQuads(result, rope_side[height], yRot + 180, 0, state, side, rand);
				if(north){
					this.addQuads(result, post_right[height], yRot, 0, state, side, rand);
				}
				if(south){
					this.addQuads(result, post_left[height], yRot + 180, 0, state, side, rand);
				}
			}
			if(west){
				this.addQuads(result, rope_side[height], yRot, 0, state, side, rand);
				if(north){
					this.addQuads(result, post_left[height], yRot, 0, state, side, rand);
				}
				if(south){
					this.addQuads(result, post_right[height], yRot + 180, 0, state, side, rand);
				}
			}
		}
		
		CACHE.put(state, result);
		return result;
	}

	@Override
	public Collection<ResourceLocation> getTextures() { return textures; }

	@Override
	public IBakedModel bake(IModelState state, VertexFormat format, java.util.function.Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		this.bakeInfo(format, bakedTextureGetter, new ResourceLocation(References.MODID, "blocks/clean_plank_spruce"));
		return this;
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) { CACHE.clear(); }

	@Override
	public boolean accepts(ResourceLocation modelLocation) {
		return ((modelLocation instanceof ModelResourceLocation) && (MedievalBlocks.HANGING_BRIDGE_BOTTOM.getRegistryName().equals(modelLocation)) || MedievalBlocks.HANGING_BRIDGE_TOP.getRegistryName().equals(modelLocation));
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws Exception {
		if(planks == null){
			planks = new IModel[16];
			for(int i = 0; i < 16; i++){
				planks[i] = getModel("planks_" + i);
			}
		}
		if(post_left == null){
			post_left = new IModel[16];
			for(int i = 0; i < 16; i++){
				post_left[i] = getModel("post_left_" + i);
			}
		}
		if(post_right == null){
			post_right = new IModel[16];
			for(int i = 0; i < 16; i++){
				post_right[i] = getModel("post_right_" + i);
			}
		}
		if(rope_side == null){
			rope_side = new IModel[16];
			for(int i = 0; i < 16; i++){
				rope_side[i] = getModel("rope_side_" + i);
			}
		}
		
		if(textures == null){
			ImmutableList.Builder<ResourceLocation> builder = ImmutableList.builder();
			
			for(int i = 0; i < 16; i++){
				builder.addAll(planks[i].getTextures());
				builder.addAll(post_left[i].getTextures());
				builder.addAll(post_right[i].getTextures());
				builder.addAll(rope_side[i].getTextures());

			}
			textures = builder.build();
		}
		
		return this;
	}

	protected static IModel getModel(String modelName){
		return ModelLoaderRegistry.getModelOrLogError(new ResourceLocation(References.MODID, "block/hanging_bridge/" + modelName), "A problem occured while trying to load: " + References.MODID + ":block/hanging_bridge/" + modelName);
	}
}
