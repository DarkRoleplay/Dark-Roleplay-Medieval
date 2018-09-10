package net.dark_roleplay.medieval.mess.common.objects.blocks.decorative;

import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.mess.common.objects.blocks.templates.FacedBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class MugEmpty extends FacedBlock {

	public MugEmpty(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(1F);
		this.setSoundType(SoundType.WOOD);
	}
	
	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return new AxisAlignedBB(0.3125F, 0F, 0.3125F, 0.6875F, 0.4375F, 0.6875F);
    }

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
}
