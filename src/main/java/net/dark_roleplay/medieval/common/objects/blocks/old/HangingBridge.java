package net.dark_roleplay.medieval.common.objects.blocks.old;

import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.AXIS_HORIZONTAL;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.client.objects.blocks.properties.UnlistedPropertyBool;
import net.dark_roleplay.medieval.holders.MedievalBlocks;
import net.dark_roleplay.medieval.holders.MedievalItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;

public class HangingBridge extends Block {

	//TODO ROTATION

	public static final PropertyInteger HEIGHT = PropertyInteger.create("height", 0, 7);

	public static final UnlistedPropertyBool NORTH = UnlistedPropertyBool.create("north");
	public static final UnlistedPropertyBool SOUTH = UnlistedPropertyBool.create("south");
	public static final UnlistedPropertyBool WEST = UnlistedPropertyBool.create("west");
	public static final UnlistedPropertyBool EAST = UnlistedPropertyBool.create("east");

	public static final AxisAlignedBB BOTTOM_AABB = new AxisAlignedBB(0F, 0F, 0F, 1F, 0.125F, 1F);

	private float initialOffset = 0F;

	public HangingBridge(String registryName, float initialOffset) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setTranslationKey(registryName);
		this.setSoundType(SoundType.WOOD);
		this.setHardness(1F);
		this.initialOffset = initialOffset;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return MedievalItems.HANGING_BRIDGE;
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
	public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_){
        Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, HangingBridge.BOTTOM_AABB.offset(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge.HEIGHT)) + this.initialOffset, 0F)));

        if(state instanceof IExtendedBlockState){

			IExtendedBlockState ext = (IExtendedBlockState) this.getExtendedState(state, world, pos);;

			boolean east = ext.getValue(HangingBridge.EAST) == null ? false : ext.getValue(HangingBridge.EAST);
			boolean west = ext.getValue(HangingBridge.WEST) == null ? false : ext.getValue(HangingBridge.WEST);

			if(state.getValue(AXIS_HORIZONTAL) == EnumFacing.Axis.X ){
				if(west)
		        	Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0f,0.875f,0f,0.0625f,1f,1f).offset(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge.HEIGHT)) + this.initialOffset, 0F)));
				if(east)
		        	Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.9375f,0.875f,0f,1f,1f,1f).offset(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge.HEIGHT)) + this.initialOffset, 0F)));
			}else if(state.getValue(AXIS_HORIZONTAL) == EnumFacing.Axis.Z){
				if(east)
		        	Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0f,0.875f,0.9375f,1f,1f,1f).offset(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge.HEIGHT)) + this.initialOffset, 0F)));
				if(west)
		        	Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0f,0.875f,0f,1f,1f,0.0625f).offset(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge.HEIGHT)) + this.initialOffset, 0F)));
			}
        }
    }

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player){
        return MedievalItems.HANGING_BRIDGE.getDefaultInstance().copy();
    }

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return  HangingBridge.BOTTOM_AABB.offset(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge.HEIGHT)) + this.initialOffset, 0F));
    }

	@Override
	public IBlockState getStateFromMeta(int meta) {
		if(Math.floor(meta / 8) == 0)
			return this.getDefaultState().withProperty(AXIS_HORIZONTAL, EnumFacing.Axis.X).withProperty(HangingBridge.HEIGHT, meta);
		else
			return this.getDefaultState().withProperty(AXIS_HORIZONTAL, EnumFacing.Axis.Z).withProperty(HangingBridge.HEIGHT, meta % 8);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int meta = 0;
		if(state.getValue(AXIS_HORIZONTAL) == EnumFacing.Axis.Z) {
			meta += 8;
		}
		meta += state.getValue(HangingBridge.HEIGHT);
		return meta;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new ExtendedBlockState(this, new IProperty[] {AXIS_HORIZONTAL, HangingBridge.HEIGHT}, new IUnlistedProperty[]{HangingBridge.NORTH, HangingBridge.SOUTH, HangingBridge.EAST, HangingBridge.WEST});
	}


	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		switch(placer.getHorizontalFacing().getOpposite()){
		case EAST:
		case WEST:
			return this.getDefaultState().withProperty(AXIS_HORIZONTAL, EnumFacing.Axis.Z);
		case NORTH:
		case SOUTH:
	        return this.getDefaultState().withProperty(AXIS_HORIZONTAL, EnumFacing.Axis.X);
	    default:
	        return this.getDefaultState().withProperty(AXIS_HORIZONTAL, EnumFacing.Axis.X);
		}
    }

	@Override
	public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {

		state = super.getExtendedState(state, world, pos);

		if (state instanceof IExtendedBlockState){

			IExtendedBlockState ext = (IExtendedBlockState) state;

			boolean north = true;
			boolean east = true;
			boolean south = true;
			boolean west = true;
			if(state.getValue(AXIS_HORIZONTAL).equals(EnumFacing.Axis.X)){
				if(this.doesBlockAlign(world, pos.north())){
					north = false;
				}
				if(this.doesBlockAlign(world, pos.east())){
					east = false;
				}
				if(this.doesBlockAlign(world, pos.south())){
					south = false;
				}
				if(this.doesBlockAlign(world, pos.west())){
					west = false;
				}
			}else if(state.getValue(AXIS_HORIZONTAL).equals(EnumFacing.Axis.Z)){
				if(this.doesBlockAlign(world, pos.east())){
					north = false;
				}
				if(this.doesBlockAlign(world, pos.south())){
					east = false;
				}
				if(this.doesBlockAlign(world, pos.west())){
					south = false;
				}
				if(this.doesBlockAlign(world, pos.north())){
					west = false;
				}
			}
			ext = ext.withProperty(HangingBridge.NORTH, north).withProperty(HangingBridge.EAST, east).withProperty(HangingBridge.SOUTH, south).withProperty(HangingBridge.WEST, west);
			state = ext;
		}
		return state;
	}

	private boolean doesBlockAlign(IBlockAccess world, BlockPos pos){

		return world.getBlockState(pos).getBlock().equals(MedievalBlocks.HANGING_BRIDGE_BOTTOM) || world.getBlockState(pos).getBlock().equals(MedievalBlocks.HANGING_BRIDGE_TOP) ||
				world.getBlockState(pos.up()).getBlock().equals(MedievalBlocks.HANGING_BRIDGE_BOTTOM) || world.getBlockState(pos.up()).getBlock().equals(MedievalBlocks.HANGING_BRIDGE_TOP) ||
				world.getBlockState(pos.down()).getBlock().equals(MedievalBlocks.HANGING_BRIDGE_BOTTOM) || world.getBlockState(pos.down()).getBlock().equals(MedievalBlocks.HANGING_BRIDGE_TOP);
	}

	private void breakBridge(World world, BlockPos pos, BlockPos prevPos, EnumFacing.Axis axis){
		if(world.getBlockState(pos).getBlock() instanceof HangingBridge){
			world.destroyBlock(pos, true);
			if(axis == EnumFacing.Axis.X){
				boolean dir = pos.getZ() > prevPos.getZ();
				this.breakBridge(world, pos.add(0, 0, dir ? 1 : -1), pos, axis);
				this.breakBridge(world, pos.add(0, 1, dir ? 1 : -1), pos, axis);
				this.breakBridge(world, pos.add(0, -1, dir ? 1 : -1), pos, axis);
			}else{
				boolean dir = pos.getX() > prevPos.getX();
				this.breakBridge(world, pos.add(dir ? 1 : -1, 0, 0), pos, axis);
				this.breakBridge(world, pos.add(dir ? 1 : -1, 1, 0), pos, axis);
				this.breakBridge(world, pos.add(dir ? 1 : -1, -1, 0), pos, axis);
			}
		}
	}

	@Override
    public IBlockState withRotation(IBlockState state, Rotation rot){
		EnumFacing.Axis axis = state.getValue(AXIS_HORIZONTAL);
		switch(rot) {
			case CLOCKWISE_90:
			case COUNTERCLOCKWISE_90:
				axis = axis == EnumFacing.Axis.X ? EnumFacing.Axis.Z : EnumFacing.Axis.X;
				break;
			case CLOCKWISE_180:
			case NONE:
			default:
				break;
		}
        return state.withProperty(AXIS_HORIZONTAL, axis);
    }

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirror) {
        return state;
    }
}
