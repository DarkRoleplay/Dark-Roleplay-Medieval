package net.dark_roleplay.medieval.client.model_baking;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.dark_roleplay.medieval.api.blocks.properties.UnlistedPropertyInteger;
import net.dark_roleplay.medieval.common.References;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.rope_fence.RopeFence;
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

public class DelayedBaker_RopeFence extends DelayedBaker implements ICustomModelLoader {

	protected static final Map<IBlockState, List<BakedQuad>> CACHE = Maps.newHashMap();

	protected static ImmutableList<ResourceLocation> textures;

	protected static IModel pole;
	protected static IModel straight_rope0;
	protected static IModel straight_rope1;
	protected static IModel straight_rope2;
	protected static IModel diagonal_rope;

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		CACHE.clear();
		pole = null;
		straight_rope0 = null;
		straight_rope1 = null;
		straight_rope2 = null;
		diagonal_rope = null;
		textures = null;
	}

	@Override
	public Collection<ResourceLocation> getTextures() {
		return textures;
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		side = null;
		
		// IExtendedBlockState state = (IExtendetBlockState)
		// state.getBlock().getExtendedState(state, world, pos);

		List<BakedQuad> result = Lists.newArrayList();
		this.addQuads(result, pole, 0, 0, state, side, rand);
	
		if (state == null) {
			return result;
		}
		//
		// IExtendedBlockState state = (IExtendedBlockState) st;

		if (CACHE.containsKey(state))
			return CACHE.get(state);

		int north = 3;
		int east = 3;
		int south = 3;
		int west = 3;

		boolean north_east = state.getValue(RopeFence.NORTH_EAST);
		boolean south_east = state.getValue(RopeFence.SOUTH_EAST);
		boolean south_west = state.getValue(RopeFence.SOUTH_WEST);
		boolean north_west = state.getValue(RopeFence.NORTH_WEST);

		if (state instanceof IExtendedBlockState) {
			IExtendedBlockState exState = (IExtendedBlockState) state;
			if (exState.getUnlistedNames().contains(RopeFence.NORTH) && exState.getValue(RopeFence.NORTH) != null)
				north = exState.getValue(RopeFence.NORTH);
			if (exState.getUnlistedNames().contains(RopeFence.EAST))
				east = exState.getValue(RopeFence.EAST);
			if (exState.getUnlistedNames().contains(RopeFence.SOUTH))
				south = exState.getValue(RopeFence.SOUTH);
			if (exState.getUnlistedNames().contains(RopeFence.WEST))
				west = exState.getValue(RopeFence.WEST);
		}

		if (north == 2) {
			this.addQuads(result, straight_rope2, 180, 0, state, side, rand);
		} else if (north == 1) {
			this.addQuads(result, straight_rope1, 0, 0, state, side, rand);
		} else if (north == 0) {
			this.addQuads(result, straight_rope0, 0, 0, state, side, rand);
		}
		if (east == 2) {
			this.addQuads(result, straight_rope2, 270, 0, state, side, rand);
		} else if (east == 1) {
			this.addQuads(result, straight_rope1, 90, 0, state, side, rand);
		} else if (east == 0) {
			this.addQuads(result, straight_rope0, 90, 0, state, side, rand);
		}
		if (south == 2) {
			this.addQuads(result, straight_rope2, 0, 0, state, side, rand);
		} else if (south == 1) {
			this.addQuads(result, straight_rope1, 180, 0, state, side, rand);
		} else if (south == 0) {
			this.addQuads(result, straight_rope0, 180, 0, state, side, rand);
		}
		if (west == 2) {
			this.addQuads(result, straight_rope2, 90, 0, state, side, rand);
		} else if (west == 1) {
			this.addQuads(result, straight_rope1, 270, 0, state, side, rand);
		} else if (west == 0) {
			this.addQuads(result, straight_rope0, 270, 0, state, side, rand);
		}

		if (north_east) {
			this.addQuads(result, diagonal_rope, 0, 0, state, side, rand);
		}
		if (south_east) {
			this.addQuads(result, diagonal_rope, 90, 0, state, side, rand);
		}
		if (south_west) {
			this.addQuads(result, diagonal_rope, 180, 0, state, side, rand);
		}
		if (north_west) {
			this.addQuads(result, diagonal_rope, 270, 0, state, side, rand);
		}

		CACHE.put(state, result);
		return result;
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws Exception {
		if (pole == null) {
			pole = getModel("rope_fence_pole");
		}

		if (straight_rope0 == null) {
			straight_rope0 = getModel("rope_fence_rope_straight_0");
		}

		if (straight_rope1 == null) {
			straight_rope1 = getModel("rope_fence_rope_straight_1");
		}

		if (straight_rope2 == null) {
			straight_rope2 = getModel("rope_fence_rope_straight_2");
		}

		if (diagonal_rope == null) {
			diagonal_rope = getModel("rope_fence_rope_diagonal");
		}

		if (textures == null) {
			ImmutableList.Builder<ResourceLocation> builder = ImmutableList.builder();

			builder.addAll(pole.getTextures());
			builder.addAll(straight_rope1.getTextures());
			builder.addAll(diagonal_rope.getTextures());

			textures = builder.build();
		}

		return this;
	}

	@Override
	public IBakedModel bake(IModelState state, VertexFormat format,
			java.util.function.Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		this.bakeInfo(format, bakedTextureGetter,
				new ResourceLocation(References.MODID, "blocks/clean_plank_spruce"));
		return this;
	}

	@Override
	public boolean accepts(ResourceLocation modelLocation) {
		return ((modelLocation instanceof ModelResourceLocation)
				&& DRPMedievalBlocks.ROPE_FENCE.getRegistryName().equals(modelLocation)
				&& !modelLocation.toString().contains("inventory"));
	}

	protected static IModel getModel(String modelName) {
		return ModelLoaderRegistry.getModelOrLogError(
				new ResourceLocation(References.MODID, "block/rope_fence/" + modelName),
				"A problem occured while trying to load: " + References.MODID + ":block/rope_fence/" + modelName);
	}
}
