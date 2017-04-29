package net.dark_roleplay.medieval.common.blocks.decorative;

import net.dark_roleplay.medieval.common.blocks.templates.DRPMedievalMaterials;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.util.SittingUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Chair extends Block {

	public static final PropertyDirection FACING = BlockHorizontal.FACING;;
	private float yOffset;
	
	
	public Chair(Material mat, String registreName,String unlocalizedName, float yOffset) {
		super(mat);
		this.yOffset = yOffset;
		this.setRegistryName(registreName);
		this.setUnlocalizedName(unlocalizedName);
	}
	
	// -------------------------------------------------- Block Data --------------------------------------------------
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		switch (meta) {
			case 0:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
			case 1:
				return this.getDefaultState().withProperty(FACING, EnumFacing.EAST);
			case 2:
				return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
			case 3:
				return this.getDefaultState().withProperty(FACING, EnumFacing.WEST);
			default:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
		}
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {

		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		if(facing.equals(EnumFacing.NORTH)) return 0;
		if(facing.equals(EnumFacing.EAST)) return 1;
		if(facing.equals(EnumFacing.SOUTH)) return 2;
		if(facing.equals(EnumFacing.WEST)) return 3;
		return 0;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {FACING});
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	// -------------------------------------------------- Block Events --------------------------------------------------
	
	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){	
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }
	
	@Override
	    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(!worldIn.isRemote)
			return SittingUtil.sitOnBlock(worldIn, pos.getX(), pos.getY(), pos.getZ(), playerIn, yOffset);
		return false;
	}
}
