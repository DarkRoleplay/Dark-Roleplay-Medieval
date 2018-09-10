package net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.pottery;

import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class UnfiredPottery extends Block {

	//TODO ROTATION
	private AxisAlignedBB bb;
	
	public UnfiredPottery(String registryName, AxisAlignedBB bb) {
		super(Material.CLAY);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setSoundType(SoundType.GROUND);
		this.setHardness(1.0F);
		
		this.bb = bb;
	}

	// -------------------------------------------------- Block Data --------------------------------------------------
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
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