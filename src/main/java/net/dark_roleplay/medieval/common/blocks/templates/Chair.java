package net.dark_roleplay.medieval.common.blocks.templates;

import net.dark_roleplay.drpcore.api.old.util.sitting.SittingUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Chair extends FacedBlock {
	
	private float yOffset;
	
	public Chair(Material mat, String registryName,String unlocalizedName, float yOffset) {
		super(mat);
		this.yOffset = yOffset;
		this.setRegistryName(registryName);
		this.setUnlocalizedName(unlocalizedName);
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
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }
	
	// -------------------------------------------------- Block Events --------------------------------------------------
	
	@Override
	    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(!worldIn.isRemote){
			boolean result = SittingUtil.sitOnBlock(worldIn, pos.getX(), pos.getY(), pos.getZ(), player, yOffset);
			return result;
		}
		return true;
	}
}
