package net.dark_roleplay.medieval.temporary.model_quality;

import net.minecraft.client.renderer.model.IUnbakedModel;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;

public class ModelQualityModelLoader implements ICustomModelLoader {
	
	public static final ModelQualityModelLoader INSTANCE = new ModelQualityModelLoader();
	
	private ModelQualityModelLoader() {}
	
	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {}

	@Override
	public boolean accepts(ResourceLocation modelLocation) {
		System.out.println("DEBUG");
		return "drpmodels".equals(modelLocation.getNamespace()) && "block/quality".equals(modelLocation.getPath());
	}

	@Override
	public IUnbakedModel loadModel(ResourceLocation modelLocation) throws Exception {
		return ModelQualityModel.INSTANCE;
	}
}
