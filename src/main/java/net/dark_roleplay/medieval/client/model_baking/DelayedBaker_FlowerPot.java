package net.dark_roleplay.medieval.client.model_baking;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.dark_roleplay.medieval.common.blocks.decorative.buckets.BucketDirt;
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

public class DelayedBaker_FlowerPot extends DelayedBaker implements ICustomModelLoader {

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

	protected static IModel bucket;

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		DelayedBaker_DirtBucket.CACHE.clear();
		DelayedBaker_DirtBucket.bucket = null;
		DelayedBaker_DirtBucket.textures = null;
	}

	@Override
	public Collection<ResourceLocation> getTextures() {
		return DelayedBaker_DirtBucket.textures;
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		side = null;

		if (state == null)
			return Collections.EMPTY_LIST;

		if (DelayedBaker_DirtBucket.CACHE.containsKey(state))
			return DelayedBaker_DirtBucket.CACHE.get(state);

		List<BakedQuad> result = Lists.newArrayList();

		EnumAxis axis = state.getValue(BucketDirt.AXIS);
		int flower1 = state.getValue(BucketDirt.FLOWER1);
		int flower2 = state.getValue(BucketDirt.FLOWER2);
		int flower3 = state.getValue(BucketDirt.FLOWER3);

		String wood = state.getBlock().getRegistryName().getResourcePath().replace("_bucket_dirt", "");

		this.addQuads(result, 
				DelayedBaker_DirtBucket.bucket.retexture(
						ImmutableMap.<String, String>of(
								"0","drpmedieval:blocks/bucket/" + wood + "_bucket",
								"1","blocks/dirt",
								"flower1", flowers[flower1],
								"flower2", flowers[flower2],
								"flower3", flowers[flower3])), axis == EnumAxis.Z ? 90 : 0, 0, state, side, rand);

		DelayedBaker_HangingBridge.CACHE.put(state, result);
		return result;
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws Exception {
		if (DelayedBaker_DirtBucket.bucket == null) {
			DelayedBaker_DirtBucket.bucket = DelayedBaker_DirtBucket.getModel("bucket_dirt");
		}

		if (DelayedBaker_DirtBucket.textures == null) {
			ImmutableList.Builder<ResourceLocation> builder = ImmutableList.builder();

			builder.addAll(DelayedBaker_DirtBucket.bucket.getTextures());

			DelayedBaker_DirtBucket.textures = builder.build();
		}

		return this;
	}

	@Override
	public IBakedModel bake(IModelState state, VertexFormat format, java.util.function.Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		this.bakeInfo(format, bakedTextureGetter, new ResourceLocation(DRPMedievalInfo.MODID, "blocks/clean_plank_spruce"));
		return this;
	}

	@Override
	public boolean accepts(ResourceLocation modelLocation) {
		return ((modelLocation instanceof ModelResourceLocation)
				&& modelLocation.getResourcePath().endsWith("_dirt_bucket")
				&& !((ModelResourceLocation)modelLocation).getVariant().contains("inventory"));
	}

	protected static IModel getModel(String modelName) {
		return ModelLoaderRegistry.getModelOrLogError(
				new ResourceLocation(DRPMedievalInfo.MODID, "block/buckets/" + modelName),
				"A problem occured while trying to load: " + DRPMedievalInfo.MODID + ":block/buckets/" + modelName);
	}
}