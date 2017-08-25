package net.dark_roleplay.medieval.common.blocks.decorative.pottery;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class FiredPottery extends Block {

	private AxisAlignedBB bb;
	
	public FiredPottery(String registryName, AxisAlignedBB bb) {
		super(Material.ROCK);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setSoundType(SoundType.STONE);
		this.bb = bb;
	}

	// -------------------------------------------------- Block Data --------------------------------------------------
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return bb == null ? FULL_BLOCK_AABB : bb;
	}
}