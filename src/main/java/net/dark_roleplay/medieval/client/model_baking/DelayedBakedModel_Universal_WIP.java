package net.dark_roleplay.medieval.client.model_baking;

import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.Charsets;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.dark_roleplay.medieval.client.custom_resources.ResourceHelper;
import net.dark_roleplay.medieval.common.DRPMedievalInfo;
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
import net.minecraft.client.renderer.block.model.VariantList;
import net.minecraft.client.renderer.block.model.multipart.Multipart;
import net.minecraft.client.renderer.block.model.multipart.Selector;
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

public class DelayedBakedModel_Universal_WIP  implements IBakedModel, IModel, ICustomModelLoader {
	
    protected VertexFormat format;
    protected Function<ResourceLocation, TextureAtlasSprite> textureGetter;
   
    protected final List<ResourceLocation> textures = Lists.newArrayList();
    
    //Cached Models
    protected final Map<IBlockState, List<BakedQuad>> cache = Maps.newHashMap();
    
    protected final Map<String, List<IModel>> models = Maps.newHashMap();
    protected final Map<String, List<ModelRotation>> modelRotations = Maps.newHashMap();
    protected final Map<String, List<Selector>> multiparts = Maps.newHashMap();
    
    
	@Override
	public boolean accepts(ResourceLocation modelLocation){
		if(modelLocation.getResourceDomain().equals(DRPMedievalInfo.MODID)&& (modelLocation instanceof ModelResourceLocation))
			if(modelLocation.getResourcePath().contains("hanging_bridge"))
				return true;
		return false;
	}
    
    @Override
    public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> textureGetter) {
        this.format = format;
        this.textureGetter = textureGetter;
        return this;
    }
    
    protected void addQuads(List<BakedQuad> list, IModel model, ModelRotation rotation, IBlockState state, EnumFacing side, long rand) {
        TRSRTransformation transform = new TRSRTransformation(rotation);
        
        
        IBakedModel baked = model.bake(model.getDefaultState(), this.format, this.textureGetter);
        list.addAll(baked.getQuads(state, null, rand));
        list.addAll(baked.getQuads(state, side, rand));
    }
    
    protected void addQuads(List<BakedQuad> list, IModel model,IBlockState state, EnumFacing side, long rand) {
        this.addQuads(list, model, ModelRotation.getModelRotation(0, 0), state, side, rand);
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
		this.modelRotations.clear();
	}

	@Override
	public Collection<ResourceLocation> getTextures() {
		return this.textures;
	}
    
	Gson GSON = (new GsonBuilder()).registerTypeAdapter(ModelBlockDefinition.class, new ModelBlockDefinition.Deserializer()).registerTypeAdapter(Variant.class, new Variant.Deserializer()).registerTypeAdapter(VariantList.class, new VariantList.Deserializer()).registerTypeAdapter(Multipart.class, new Multipart.Deserializer()).registerTypeAdapter(Selector.class, new Selector.Deserializer()).create();
	
	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws Exception{
	
		if(!this.models.containsKey(modelLocation)) {
	
			IResource blockstateFile = ResourceHelper.getResource(new ResourceLocation(modelLocation.getResourceDomain(), "blockstates/" + modelLocation.getResourcePath() + ".json"));
		
	    	ModelBlockDefinition modelDef = BlockStateLoader.load(new InputStreamReader(blockstateFile.getInputStream(), Charsets.UTF_8), this.GSON);
	    	
	    	
	    	List<IModel> finishedModels = Lists.newArrayList();
	    	List<ModelRotation> finishedRotations = Lists.newArrayList();
	    	
	    	//VARIANT LOADING
	    	VariantList mainList = modelDef.getVariant(modelLocation.toString().split("#")[1]);
	    	List<Variant> list = mainList.getVariantList();
	    	
	    	for(int i = 0; i < list.size(); i++){
	    		IModel temp = ModelLoaderRegistry.getModelOrLogError(list.get(i).getModelLocation(), "The following Model is Missing:" + list.get(i).getModelLocation() + "\nFor the following Mod: " + modelLocation.getResourceDomain());
	    		
	    		this.textures.addAll(temp.getTextures());
	    		finishedModels.add(temp);
	    		finishedRotations.add(list.get(i).getRotation());
	    	}
	    	//VARIANT LOADING
	    	
	    	//MULTiPART LOADING
	    	if(!this.multiparts.containsKey(modelLocation.getResourceDomain() + ":" + modelLocation.getResourcePath())){
		    	Multipart mult = modelDef.getMultipartData();
		    	Set<VariantList> multipartList = mult.getVariants();
		    	
		    	List<Selector> selectors = mult.getSelectors();
		    	this.multiparts.put(modelLocation.getResourceDomain() + ":" + modelLocation.getResourcePath(), selectors);
//		    	for(int i = 0; i < selectors.size(); i++){
//		    		Selector sel = selectors.get(i);
//		    		Predicate<IBlockState> pred = sel.getPredicate(null);
//		    		pred.apply
//		    	}
	    	}
	    	//MULTIPART LOADING
	    	
	    	
		
			this.models.put(modelLocation.toString(), finishedModels);
			this.modelRotations.put(modelLocation.toString(), finishedRotations);
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
	    if(sb.lastIndexOf("]") >= 0) {
			sb.deleteCharAt(sb.lastIndexOf("]"));
			//sb.deleteCharAt(sb.length());
		}
	    String stateString = sb.toString();
	    
	    List<IModel> unbakedModels = this.models.get(stateString);
	    List<ModelRotation> rotations = this.modelRotations.get(stateString);
	    
	    //ADD MULTIPARTS
	    List<Selector> selectors = this.multiparts.get(state.getBlock().getRegistryName());
	    	
	    for(int i = 0; i < selectors.size(); i ++){
	    	Selector sel = selectors.get(i);
	    	Predicate pred = sel.getPredicate(state.getBlock().getBlockState());
	    	if(pred.apply(state)){
	    		List<Variant> list = sel.getVariantList().getVariantList();
	    		for(int j = 0; j < list.size(); j ++){
	    			IModel model = ModelLoaderRegistry.getModelOrLogError(list.get(j).getModelLocation(), "The following Model is Missing:" + list.get(j).getModelLocation() + "\nFor the following Mod: " + list.get(j).getModelLocation().getResourceDomain());
		    		unbakedModels.add(model);
		    		rotations.add(list.get(j).getRotation());
	    		}
	    	}
	    }
	    
	    //ADD MULTIPARTS
	    
	    
	    for(int i = 0; i < unbakedModels.size(); i++){
	    	this.addQuads(result, unbakedModels.get(i), rotations.get(i), state, side, rand);
	    }
	    
	    this.cache.put(state, result);
	    
		return result;
	}
}