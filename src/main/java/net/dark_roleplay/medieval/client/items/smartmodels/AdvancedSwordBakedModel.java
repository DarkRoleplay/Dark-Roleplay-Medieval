package net.dark_roleplay.medieval.client.items.smartmodels;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

public class AdvancedSwordBakedModel implements IBakedModel {
	  
	private final List<BakedQuad> cubes;
	
	public AdvancedSwordBakedModel(ItemStack stack) {
		cubes = new ArrayList<BakedQuad>();
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		return cubes;
	}

	@Override
	public boolean isAmbientOcclusion() {return false;}

	@Override
	public boolean isGui3d() {return false;}

	@Override
	public boolean isBuiltInRenderer() {return false;}

	@Override
	public TextureAtlasSprite getParticleTexture() {return null;}

	@Override
	public ItemCameraTransforms getItemCameraTransforms() {return null;}

	@Override
	public ItemOverrideList getOverrides() {return null;}
}
