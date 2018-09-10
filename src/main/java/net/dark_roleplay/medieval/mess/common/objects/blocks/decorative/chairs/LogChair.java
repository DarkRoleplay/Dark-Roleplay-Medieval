package net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.chairs;

import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.mess.common.objects.blocks.templates.Chair;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class LogChair extends Chair {

	public LogChair(String registryName) {
		super(Material.WOOD, registryName, registryName , 4 * 0.0625F);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(2F);
		this.setHarvestLevel("axe", 0);
		this.setSoundType(SoundType.WOOD);
	}
	

	// -------------------------------------------------- Block Placement --------------------------------------------------
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos){
		if(!this.canBlockStay(worldIn, pos, EnumFacing.UP)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
				super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }
	
	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {
		return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true);
	}


}

