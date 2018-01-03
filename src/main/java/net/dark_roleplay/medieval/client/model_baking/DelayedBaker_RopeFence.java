package net.dark_roleplay.medieval.client.model_baking;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.dark_roleplay.medieval.common.blocks.decorative.rope_fence.RopeFence;
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
		DelayedBaker_RopeFence.CACHE.clear();
		DelayedBaker_RopeFence.pole = null;
		DelayedBaker_RopeFence.straight_rope0 = null;
		DelayedBaker_RopeFence.straight_rope1 = null;
		DelayedBaker_RopeFence.straight_rope2 = null;
		DelayedBaker_RopeFence.diagonal_rope = null;
		DelayedBaker_RopeFence.textures = null;
	}

	@Override
	public Collection<ResourceLocation> getTextures() {
		return DelayedBaker_RopeFence.textures;
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		side = null;

		// IExtendedBlockState state = (IExtendetBlockState)
		// state.getBlock().getExtendedState(state, world, pos);

		if (state == null)
			return Collections.EMPTY_LIST;
		//
		// IExtendedBlockState state = (IExtendedBlockState) st;

		if (DelayedBaker_RopeFence.CACHE.containsKey(state))
			return DelayedBaker_RopeFence.CACHE.get(state);

		List<BakedQuad> result = Lists.newArrayList();

		int north = 3;
		int east = 3;
		int south = 3;
		int west = 3;

		boolean north_east = state.getValue(RopeFence.NORTH_EAST);
		boolean south_east = state.getValue(RopeFence.SOUTH_EAST);
		boolean south_west = state.getValue(RopeFence.SOUTH_WEST);
		boolean north_west = state.getValue(RopeFence.NORTH_WEST);

		this.addQuads(result, DelayedBaker_RopeFence.pole, 0, 0, state, side, rand);

		if (state instanceof IExtendedBlockState) {
			IExtendedBlockState exState = (IExtendedBlockState) state;
			if (exState.getUnlistedNames().contains(RopeFence.NORTH))
				north = exState.getValue(RopeFence.NORTH);
			if (exState.getUnlistedNames().contains(RopeFence.EAST))
				east = exState.getValue(RopeFence.EAST);
			if (exState.getUnlistedNames().contains(RopeFence.SOUTH))
				south = exState.getValue(RopeFence.SOUTH);
			if (exState.getUnlistedNames().contains(RopeFence.WEST))
				west = exState.getValue(RopeFence.WEST);
		}

		if (north == 2) {
			this.addQuads(result, DelayedBaker_RopeFence.straight_rope2, 180, 0, state, side, rand);
		} else if (north == 1) {
			this.addQuads(result, DelayedBaker_RopeFence.straight_rope1, 0, 0, state, side, rand);
		} else if (north == 0) {
			this.addQuads(result, DelayedBaker_RopeFence.straight_rope0, 0, 0, state, side, rand);
		}
		if (east == 2) {
			this.addQuads(result, DelayedBaker_RopeFence.straight_rope2, 270, 0, state, side, rand);
		} else if (east == 1) {
			this.addQuads(result, DelayedBaker_RopeFence.straight_rope1, 90, 0, state, side, rand);
		} else if (east == 0) {
			this.addQuads(result, DelayedBaker_RopeFence.straight_rope0, 90, 0, state, side, rand);
		}
		if (south == 2) {
			this.addQuads(result, DelayedBaker_RopeFence.straight_rope2, 0, 0, state, side, rand);
		} else if (south == 1) {
			this.addQuads(result, DelayedBaker_RopeFence.straight_rope1, 180, 0, state, side, rand);
		} else if (south == 0) {
			this.addQuads(result, DelayedBaker_RopeFence.straight_rope0, 180, 0, state, side, rand);
		}
		if (west == 2) {
			this.addQuads(result, DelayedBaker_RopeFence.straight_rope2, 90, 0, state, side, rand);
		} else if (west == 1) {
			this.addQuads(result, DelayedBaker_RopeFence.straight_rope1, 270, 0, state, side, rand);
		} else if (west == 0) {
			this.addQuads(result, DelayedBaker_RopeFence.straight_rope0, 270, 0, state, side, rand);
		}

		if (north_east) {
			this.addQuads(result, DelayedBaker_RopeFence.diagonal_rope, 0, 0, state, side, rand);
		}
		if (south_east) {
			this.addQuads(result, DelayedBaker_RopeFence.diagonal_rope, 90, 0, state, side, rand);
		}
		if (south_west) {
			this.addQuads(result, DelayedBaker_RopeFence.diagonal_rope, 180, 0, state, side, rand);
		}
		if (north_west) {
			this.addQuads(result, DelayedBaker_RopeFence.diagonal_rope, 270, 0, state, side, rand);
		}

		DelayedBaker_HangingBridge.CACHE.put(state, result);
		return result;
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws Exception {
		if (DelayedBaker_RopeFence.pole == null) {
			DelayedBaker_RopeFence.pole = DelayedBaker_RopeFence.getModel("rope_fence_pole");
		}

		if (DelayedBaker_RopeFence.straight_rope0 == null) {
			DelayedBaker_RopeFence.straight_rope0 = DelayedBaker_RopeFence.getModel("rope_fence_rope_straight_0");
		}

		if (DelayedBaker_RopeFence.straight_rope1 == null) {
			DelayedBaker_RopeFence.straight_rope1 = DelayedBaker_RopeFence.getModel("rope_fence_rope_straight_1");
		}

		if (DelayedBaker_RopeFence.straight_rope2 == null) {
			DelayedBaker_RopeFence.straight_rope2 = DelayedBaker_RopeFence.getModel("rope_fence_rope_straight_2");
		}

		if (DelayedBaker_RopeFence.diagonal_rope == null) {
			DelayedBaker_RopeFence.diagonal_rope = DelayedBaker_RopeFence.getModel("rope_fence_rope_diagonal");
		}

		if (DelayedBaker_RopeFence.textures == null) {
			ImmutableList.Builder<ResourceLocation> builder = ImmutableList.builder();

			builder.addAll(DelayedBaker_RopeFence.pole.getTextures());
			builder.addAll(DelayedBaker_RopeFence.straight_rope1.getTextures());
			builder.addAll(DelayedBaker_RopeFence.diagonal_rope.getTextures());

			DelayedBaker_RopeFence.textures = builder.build();
		}

		return this;
	}

	@Override
	public IBakedModel bake(IModelState state, VertexFormat format,
			java.util.function.Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		this.bakeInfo(format, bakedTextureGetter,
				new ResourceLocation(DRPMedievalInfo.MODID, "blocks/clean_plank_spruce"));
		return this;
	}

	@Override
	public boolean accepts(ResourceLocation modelLocation) {
		return ((modelLocation instanceof ModelResourceLocation)
				&& DRPMedievalBlocks.ROPE_FENCE.getRegistryName().equals(modelLocation)
				&& !modelLocation.getResourcePath().contains("inventory"));
	}

	protected static IModel getModel(String modelName) {
		return ModelLoaderRegistry.getModelOrLogError(
				new ResourceLocation(DRPMedievalInfo.MODID, "block/rope_fence/" + modelName),
				"A problem occured while trying to load: " + DRPMedievalInfo.MODID + ":block/rope_fence/" + modelName);
	}
}
