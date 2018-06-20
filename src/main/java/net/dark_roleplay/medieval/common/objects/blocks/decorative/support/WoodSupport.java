package net.dark_roleplay.medieval.common.objects.blocks.decorative.support;

import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.rope_fence.RopeFence;
import net.dark_roleplay.medieval.common.objects.blocks.helper.RopeFixPoint;
import net.dark_roleplay.medieval.common.objects.blocks.templates.FacedBlock;
import net.dark_roleplay.medieval.common.util.InventoryHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class WoodSupport extends FacedBlock{

	public static PropertyInteger TYPE = PropertyInteger.create("type", 0, 5);
	
	public static AxisAlignedBB[] boundingBoxes = new AxisAlignedBB[9];
	
	public WoodSupport(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(0.5F);
		this.setSoundType(SoundType.CLOTH);
		boundingBoxes[0] = new AxisAlignedBB(0.375F, 0F, 0.375F, 0.625F, 1F, 0.625F);
		boundingBoxes[1] = new AxisAlignedBB(0.375F, 0F, 0.0F, 0.625F, 1F, 0.25F);
		boundingBoxes[2] = new AxisAlignedBB(0.75F, 0F, 0.75F, 1F, 1F, 1F);
		boundingBoxes[3] = rotateAABB(boundingBoxes[1], 1);
		boundingBoxes[4] = new AxisAlignedBB(0.75F, 0F, 0F, 1F, 1F, 0.25F);
		boundingBoxes[5] = rotateAABB(boundingBoxes[1], 2);
		boundingBoxes[6] = rotateAABB(boundingBoxes[2], 2);
		boundingBoxes[7] = rotateAABB(boundingBoxes[1], 3);
		boundingBoxes[8] = rotateAABB(boundingBoxes[4], 2);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(TYPE, meta % 4).withProperty(BlockProperties.FACING, EnumFacing.getHorizontal(meta / 4));
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }

	@Override
	public int getMetaFromState(IBlockState state) {
		return (state.getValue(TYPE) % 3) + (state.getValue(BlockProperties.FACING).getHorizontalIndex() * 4);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { TYPE, BlockProperties.FACING});
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos){
        return state.withProperty(TYPE, world.getBlockState(pos.up()).isSideSolid(world, pos.down(), EnumFacing.DOWN) ? state.getValue(TYPE) + 3 : state.getValue(TYPE));
    }
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		IBlockState state = this.getDefaultState();
		if(facing == EnumFacing.DOWN || facing == EnumFacing.UP){
			state = state.withProperty(TYPE, 0);
		}else{
			if(facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH){
				if(hitX <= 0.2){
					state = state.withProperty(BlockProperties.FACING, facing == EnumFacing.NORTH ? facing.getOpposite() : facing.rotateYCCW().getOpposite());
					state = state.withProperty(TYPE, 2);
				}else if(hitX >= 0.8){
					state = state.withProperty(BlockProperties.FACING, facing == EnumFacing.NORTH ? facing.rotateYCCW().getOpposite() : facing.getOpposite());
					state = state.withProperty(TYPE, 2);
				}else{
					state = state.withProperty(BlockProperties.FACING, facing.getOpposite());
					state = state.withProperty(TYPE, 1);
				}
			}else if(facing == EnumFacing.EAST || facing == EnumFacing.WEST){
				if(hitZ <= 0.2){
					state = state.withProperty(BlockProperties.FACING, facing == EnumFacing.EAST ? facing.getOpposite() : facing.rotateYCCW().getOpposite());
					state = state.withProperty(TYPE, 2);
				}else if(hitZ >= 0.8){
					state = state.withProperty(BlockProperties.FACING, facing == EnumFacing.EAST ? facing.rotateYCCW().getOpposite() : facing.getOpposite());
					state = state.withProperty(TYPE, 2);
				}else{
					state = state.withProperty(BlockProperties.FACING, facing.getOpposite());
					state = state.withProperty(TYPE, 1);
				}
			}
			System.out.println(facing.toString() + ": " + hitX + " : " + hitZ);
		}
		
		return state;
	}
	

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		EnumFacing facing = state.getValue(BlockProperties.FACING);
        if(state.getValue(TYPE) == 0){
            return boundingBoxes[0];
        }else if(state.getValue(TYPE) == 1){
        	return facing == EnumFacing.NORTH ? boundingBoxes[1] :
        		facing == EnumFacing.EAST ? boundingBoxes[7] : 
        		facing == EnumFacing.WEST ? boundingBoxes[3] :
        			boundingBoxes[5];
        }if(state.getValue(TYPE) == 2){
        	return facing == EnumFacing.NORTH ? boundingBoxes[4] :
        		facing == EnumFacing.EAST ? boundingBoxes[2] :
        		facing == EnumFacing.WEST ? boundingBoxes[6] :
        			boundingBoxes[8];
        }
        return boundingBoxes[2];
    }
	
	private AxisAlignedBB rotateAABB(AxisAlignedBB bb, int amount){
		switch(amount){
			case 0://NORTH
				return bb;
			case 1://WEST
				return new AxisAlignedBB(bb.maxZ, bb.minY, bb.minX, bb.minZ, bb.maxY, bb.maxX);
			case 2://SOUTH
				return new AxisAlignedBB(1 - bb.maxX, bb.minY, 1 - bb.maxZ, 1 - bb.minX, bb.maxY, 1 - bb.minZ);
			case 3://EAST 
				return new AxisAlignedBB(1 - bb.minZ, bb.minY, 1 - bb.maxX, 1 - bb.maxZ, bb.maxY, 1 - bb.minX);
			default:
				return bb;
		}
	}
}
