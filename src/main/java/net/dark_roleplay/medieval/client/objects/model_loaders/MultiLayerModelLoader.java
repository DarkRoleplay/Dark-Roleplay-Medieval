package net.dark_roleplay.medieval.client.objects.model_loaders;

import java.util.Optional;

import com.google.common.collect.ImmutableMap;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.MultiLayerModel;

public class MultiLayerModelLoader implements ICustomModelLoader
{

    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) {}

    @Override
    public boolean accepts(ResourceLocation modelLocation){
        return modelLocation.getResourcePath().equals("lantern");
    }

    @Override
    public IModel loadModel(ResourceLocation modelLocation){

    	ModelResourceLocation mLoc = (ModelResourceLocation) modelLocation;
        return new MultiLayerModel(ImmutableMap.of(Optional.of(BlockRenderLayer.SOLID), new ModelResourceLocation("drpmedieval:lantern_solid" + "#" + mLoc.getVariant()),
        		Optional.of(BlockRenderLayer.TRANSLUCENT), new ModelResourceLocation("drpmedieval:lantern_translucent" + "#" + mLoc.getVariant())));
    }
}