package net.dark_roleplay.medieval.client.model_baking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.dark_roleplay.core.modules.Modules;
import net.dark_roleplay.core_modules.maarg.api.materials.Material;
import net.dark_roleplay.core_modules.maarg.handler.MaterialRegistry;
import net.dark_roleplay.medieval.common.References;
import net.dark_roleplay.medieval.common.objects.blocks.building.TimberedClay;
import net.minecraft.block.Block;
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

public class DelayedBaker_Timbering extends DelayedBaker implements ICustomModelLoader {

	protected static final Map<IBlockState, Map<EnumFacing, List<BakedQuad>>> CACHE = Maps.newHashMap();
	
	protected static ImmutableList<ResourceLocation> textures;

	protected static IModel timbering;

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		CACHE.clear();
		timbering = null;
		textures = null;
	}

	@Override
	public Collection<ResourceLocation> getTextures() {
		return textures;
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		if (state == null)
			return Collections.EMPTY_LIST;

		if (CACHE.containsKey(state) && CACHE.get(state).containsKey(side))
			return CACHE.get(state).get(side);

		List<BakedQuad> result = Lists.newArrayList();

		boolean top = state.getValue(TimberedClay.UP);
		boolean right = state.getValue(TimberedClay.RIGHT);
		boolean bottom = state.getValue(TimberedClay.DOWN);
		boolean left = state.getValue(TimberedClay.LEFT);

		String bitCode = (top ? "1" : "0") + (right ? "1" : "0") + (bottom ? "1" : "0") + (left ? "1" : "0");
		
		String[] textures = state.getBlock().getRegistryName().getResourcePath().split("_timbered_clay_");

		this.addQuads(result, 
			timbering.retexture(
				ImmutableMap.<String, String>of(
					"end","drpmedieval:blocks/timbered_clay/timbered_clay",
					"side","drpmedieval:blocks/timbered_clay/" + textures[1] + "/" + textures[0] + "_timbered_clay_" + bitCode
				)
			), 
			0, 0, state, side, rand
		);

		if(CACHE.containsKey(state)) {
			Map<EnumFacing, List<BakedQuad>> map = CACHE.get(state);
			map.put(side, result);
			CACHE.replace(state, map);
		}else {
			Map<EnumFacing, List<BakedQuad>> map = Maps.newHashMap();
			CACHE.put(state, map);
		}
		
		return result;
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws Exception {

		if (timbering == null) {
			timbering = getModel();
		}

		if (textures == null) {
			ImmutableList.Builder<ResourceLocation> builder = ImmutableList.builder();
			List<ResourceLocation> locations = new ArrayList<ResourceLocation>();
			
			Set<Material> mats = MaterialRegistry.getMaterialsForType("wood");

			locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/timbered_clay"));
			
			for(int i = 0; i < 16; i ++) {
				String bitCode = ((i & 1) == 1 ? "1" : "0") + ((i & 2) == 2 ? "1" : "0") + ((i & 4) == 4 ? "1" : "0") + ((i & 8) == 8 ? "1" : "0");

				for(Material mat : mats) {
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/clean/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/diagonal_bt/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/diagonal_tb/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/cross/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/double_diagonal_t_bt/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/double_diagonal_b_bt/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/double_diagonal_t_tb/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/double_diagonal_b_tb/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/arrow_b/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/arrow_t/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/arrow_r/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/arrow_l/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/double_diagonal_l_lr/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/double_diagonal_r_lr/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/double_diagonal_l_rl/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/double_diagonal_r_rl/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/vertical/" + mat.getName() + "_timbered_clay_" + bitCode));
					locations.add(new ResourceLocation("drpmedieval:blocks/timbered_clay/horizontal/" + mat.getName() + "_timbered_clay_" + bitCode));

				}
			}
			
			builder.addAll(locations);
			textures = builder.build();
		}

		return this;
	}

	@Override
	public IBakedModel bake(IModelState state, VertexFormat format, java.util.function.Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		this.bakeInfo(format, bakedTextureGetter, new ResourceLocation(References.MODID, "blocks/timbered_clay/timbered_clay"));
		return this;
	}

	@Override
	public boolean accepts(ResourceLocation modelLocation) {
		return ((modelLocation instanceof ModelResourceLocation) && (modelLocation.toString().contains("_timbered_clay_")));

	}

	protected static IModel getModel() {
		return ModelLoaderRegistry.getModelOrLogError(
				new ResourceLocation("drpmedieval:block/timbering"),
				"A problem occured while trying to load: " + "minecraft:block/cube_column");
	}
}