package net.dark_roleplay.medieval.temporary.model_quality;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.IUnbakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.model.IModelState;

public class ModelQualityModel implements IUnbakedModel {

    private static final Logger LOGGER = LogManager.getLogger();
	
	ResourceLocation trueModel = null;

	public static final ModelQualityModel INSTANCE = new ModelQualityModel(null);
	public static ModelQuality QUALITY = ModelQuality.NORMAL;
	
	public ModelQualityModel(ResourceLocation model) {
		this.trueModel = model;
	}

	@Override
	public IBakedModel bake(Function<ResourceLocation, IUnbakedModel> modelGetter, Function<ResourceLocation, TextureAtlasSprite> spriteGetter, IModelState state, boolean uvlock, VertexFormat format) {
		if(trueModel == null) return ModelLoaderRegistry.getMissingModel().bake(modelGetter, spriteGetter, state, uvlock, format);
		
		IUnbakedModel model = ModelLoaderRegistry.getModelOrLogError(trueModel, "Couldn't load ModelQualityModel dependency: " + trueModel);
		
		return model.bake(modelGetter, spriteGetter, state, uvlock, format);
	}

	@Override
	public Collection<ResourceLocation> getOverrideLocations() {
        return ImmutableList.of(trueModel);
	}

	@Override
	public Collection<ResourceLocation> getTextures(Function<ResourceLocation, IUnbakedModel> modelGetter, Set<String> missingTextureErrors) {
    	return Collections.emptyList();
	}

	@Override
	public ModelQualityModel process(ImmutableMap<String, String> customData) {
		for (String key : customData.keySet()) {
			if (QUALITY.toString().toLowerCase().equals(key)) {
				return new ModelQualityModel(getLocation(customData.get(key)));
			}
		}
		
		return INSTANCE;
	}

	private ModelResourceLocation getLocation(String json) {
		JsonElement e = new JsonParser().parse(json);
		if (e.isJsonPrimitive() && e.getAsJsonPrimitive().isString()) {
			return new ModelResourceLocation(e.getAsString());
		}
		LOGGER.fatal("Expect ModelResourceLocation, got: {}", json);
		return new ModelResourceLocation("builtin/missing", "missing");
	}

}
