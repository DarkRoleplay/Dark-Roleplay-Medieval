package net.dark_roleplay.medieval.client.model_baking;

import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Level;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;

import net.dark_roleplay.medieval.client.custom_resources.ResourceHelper;
import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.block.model.ModelBlockDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.model.ModelRotation;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.BlockStateLoader;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;

public class DelayedBakedModel  implements IBakedModel, IModel, ICustomModelLoader {

    protected VertexFormat format;
    protected Function<ResourceLocation, TextureAtlasSprite> textureGetter;
   
    protected final List<ResourceLocation> textures = Lists.newArrayList();
    
    //Cached Models
    protected final Map<IBlockState, List<BakedQuad>> cache = Maps.newHashMap();
    
    protected final Map<String, List<IModel>> models = Maps.newHashMap();
    
    @Override
    public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> textureGetter) {
        
        this.format = format;
        this.textureGetter = textureGetter;
        return this;
    }
    
    protected void addQuads(List<BakedQuad> list, IModel model, int yRotate, IBlockState state, EnumFacing side, long rand) {
        TRSRTransformation transform = new TRSRTransformation(ModelRotation.getModelRotation(0, yRotate));
        
        IBakedModel baked = model.bake(transform, this.format, this.textureGetter);
        
        list.addAll(baked.getQuads(state, side, rand));
    }
    
    protected void addQuads(List<BakedQuad> list, IModel model,IBlockState state, EnumFacing side, long rand) {
        this.addQuads(list, model, 0, state, side, rand);
    }
        
    @Override
    public boolean isAmbientOcclusion() {
        return false;
    }

    @Override
    public boolean isGui3d() {
        return true;
    }

    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleTexture() {
        return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("");
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return ItemCameraTransforms.DEFAULT;
    }
    
    @Override
    public ItemOverrideList getOverrides() {
        return ItemOverrideList.NONE;
    }
    
    @Override
    public IModelState getDefaultState() {
        return TRSRTransformation.identity();
    }
    
    @Override
    public Collection<ResourceLocation> getDependencies() {
        return ImmutableList.of();
    }

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		this.cache.clear();
		this.models.clear();
	}

	@Override
	public Collection<ResourceLocation> getTextures() {
		return this.textures;
	}
	

	@Override
	public boolean accepts(ResourceLocation modelLocation){
		if(modelLocation.getResourceDomain().equals(DRPMedievalInfo.MODID) && modelLocation.getResourcePath().contains("rope_fence") && (modelLocation instanceof ModelResourceLocation))
			return true;
		return false;
	}

    
	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws Exception{
	
		if(!this.models.containsKey(modelLocation)) {
	
			IResource blockstateFile = ResourceHelper.getResource(new ResourceLocation(modelLocation.getResourceDomain(), "blockstates/" + modelLocation.getResourcePath() + ".json"));
		
	    	ModelBlockDefinition modelDef = BlockStateLoader.load(new InputStreamReader(blockstateFile.getInputStream()), new Gson());
	
	    	List<Variant> list = modelDef.getVariant(modelLocation.toString().split("#")[1]).getVariantList();
	    	
	    	List<IModel> finishedModels = Lists.newArrayList();
	    	
	    	for(int i = 0; i < list.size(); i++){
	    		DarkRoleplayMedieval.LOGGER.log(Level.DEBUG, list.get(i).getModelLocation());
	    		DarkRoleplayMedieval.LOGGER.log(Level.DEBUG, "SEARCH ME");
	    		IModel temp = ModelLoaderRegistry.getModelOrLogError(list.get(i).getModelLocation(), "The following Model is Missing:" + list.get(i).getModelLocation() + "\nFor the following Mod: " + modelLocation.getResourceDomain());
	    		this.textures.addAll(temp.getTextures());
	    		finishedModels.add(temp);
	    	}
		
	    	System.out.println("TYPE1" + modelLocation.toString());
			this.models.put(modelLocation.toString(), finishedModels);
		}
		return this;
	}
	
	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		if((state == null) || (side == null))
			return Collections.emptyList();

		if (this.cache.containsKey(state))
			return this.cache.get(state);
	        
	    List<BakedQuad> result = Lists.newArrayList();
	    
	    StringBuilder sb = new StringBuilder(state.toString().replace('[', '#'));
	    sb.deleteCharAt(sb.lastIndexOf("]"));
	    String stateString = sb.toString();
		
	    for(IModel model : this.models.get(stateString)){
	    	System.out.println("TEST" + model.toString());
	    	this.addQuads(result, model, state, side, rand);
	    }
	    
	    this.cache.put(state, result);
	    
		return result;
	}
}