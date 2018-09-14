package net.dark_roleplay.medieval.testing.blocks.spinning_wheel;

import javax.annotation.Nullable;

import net.dark_roleplay.core.api.old.crafting.Crafting_Util;
import net.dark_roleplay.medieval.mess.common.objects.blocks.BlockProperties;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SpinningWheel extends Block {

	public SpinningWheel(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setHardness(2F);
		this.setHarvestLevel("axe", 0);
		this.setSoundType(SoundType.WOOD);
	}

	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		switch(state.getValue(BlockProperties.FACING)){
		case NORTH:
			return new AxisAlignedBB(0.3125F, 0F, 0F, 1F, 0.6875F, 1F);
		case EAST:
	        return new AxisAlignedBB(0F, 0F, 0.3125F, 1F, 0.6875F, 1F);
		case SOUTH:
	        return new AxisAlignedBB(0F, 0F, 0F, 0.6875F, 0.6875F, 1F);
		case WEST:
	        return new AxisAlignedBB(0F, 0F, 0F, 1F, 0.6875F, 0.6875F);
	    default:
	        return new AxisAlignedBB(0F, 0F, 0F, 1F, 0.6875F, 1F);
		}
    }

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
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

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {
		return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true);
	}
	
	@Override
	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side){
		return worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true);
	}
	
	// -------------------------------------------------- Block Events --------------------------------------------------

	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote)
			Crafting_Util.openRecipeSelection(this);
//		if(!world.isRemote){
//			TileEntity tileentity = world.getTileEntity(pos);
//
//			if(tileentity instanceof SpinningWheelTileEntity){
//				player.openGui(DarkRoleplayMedieval.instance, GuiHandler.GUI_SPINNING_WHEEL_PARTS, world, pos.getX(), pos.getY(), pos.getZ());
//			}
//		}
		return true;
	}
	
	@Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    public TileEntity createTileEntity(World world, IBlockState state) {
    	return new SpinningWheelTileEntity();
    }
}