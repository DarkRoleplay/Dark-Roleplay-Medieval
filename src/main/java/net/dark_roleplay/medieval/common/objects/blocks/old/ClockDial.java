package net.dark_roleplay.medieval.common.objects.blocks.old;


import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.FACING_HORIZONTAL;

import java.util.Random;

import net.dark_roleplay.medieval.common.handler.MedievalBlocksOld;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ClockDial extends Block{

	public static final PropertyInteger POSITION = PropertyInteger.create("position", 0,8);

	private AxisAlignedBB northBB;
	private AxisAlignedBB eastBB;
	private AxisAlignedBB southBB;
	private AxisAlignedBB westBB;

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING_HORIZONTAL, POSITION});
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }

	public ClockDial(String registreName, AxisAlignedBB northBB) {
		super(Material.WOOD);
		this.setRegistryName(registreName);
		this.setTranslationKey(registreName);
		this.setHardness(1F);
		this.setSoundType(SoundType.WOOD);

		this.northBB = northBB;
		this.westBB = this.rotateAABB(this.northBB, 1);
		this.southBB = this.rotateAABB(this.northBB, 2);
		this.eastBB = this.rotateAABB(this.northBB, 3);
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
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing = EnumFacing.byHorizontalIndex(meta % 4);
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, facing).withProperty(POSITION, meta / 4);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		EnumFacing facing = state.getValue(FACING_HORIZONTAL);
		int i = facing.getHorizontalIndex();

		int pos = state.getValue(POSITION);
		if(pos != 0){
			i += (4 * ((pos % 2) + 1));
		}
		return i;
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		EnumFacing facing = state.getValue(FACING_HORIZONTAL);

		world.setBlockState(pos.up(), this.getDefaultState().withProperty(POSITION, 1).withProperty(FACING_HORIZONTAL, facing));
		world.setBlockState(pos.down(), this.getDefaultState().withProperty(POSITION, 1).withProperty(FACING_HORIZONTAL, facing));
		switch(facing.getAxis()){
			case X:
				world.setBlockState(pos.north(), this.getDefaultState().withProperty(POSITION, 1).withProperty(FACING_HORIZONTAL, facing));
				world.setBlockState(pos.south(), this.getDefaultState().withProperty(POSITION, 1).withProperty(FACING_HORIZONTAL, facing));
				world.setBlockState(pos.north().up(), this.getDefaultState().withProperty(POSITION, 2).withProperty(FACING_HORIZONTAL, facing));
				world.setBlockState(pos.south().up(), this.getDefaultState().withProperty(POSITION, 2).withProperty(FACING_HORIZONTAL, facing));
				world.setBlockState(pos.north().down(), this.getDefaultState().withProperty(POSITION, 2).withProperty(FACING_HORIZONTAL, facing));
				world.setBlockState(pos.south().down(), this.getDefaultState().withProperty(POSITION, 2).withProperty(FACING_HORIZONTAL, facing));
				break;
			case Z:
				world.setBlockState(pos.east(), this.getDefaultState().withProperty(POSITION, 1).withProperty(FACING_HORIZONTAL, facing));
				world.setBlockState(pos.west(), this.getDefaultState().withProperty(POSITION, 1).withProperty(FACING_HORIZONTAL, facing));
				world.setBlockState(pos.east().up(), this.getDefaultState().withProperty(POSITION, 2).withProperty(FACING_HORIZONTAL, facing));
				world.setBlockState(pos.west().up(), this.getDefaultState().withProperty(POSITION, 2).withProperty(FACING_HORIZONTAL, facing));
				world.setBlockState(pos.east().down(), this.getDefaultState().withProperty(POSITION, 2).withProperty(FACING_HORIZONTAL, facing));
				world.setBlockState(pos.west().down(), this.getDefaultState().withProperty(POSITION, 2).withProperty(FACING_HORIZONTAL, facing));
				break;
			default:
				break;
		}
    }

	@Override
	public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing side){
		if(world.getBlockState(pos.offset(side.getOpposite())).getBlock() != MedievalBlocksOld.CLOCK_CORE)
			return false;
		if(side.getAxis() == Axis.X){
	        return this.canPlacePart(world, pos) && this.canPlacePart(world, pos.up()) && this.canPlacePart(world, pos.down()) && this.canPlacePart(world, pos.north()) && this.canPlacePart(world, pos.south());
		}else if(side.getAxis() == Axis.Z){
	        return this.canPlacePart(world, pos) && this.canPlacePart(world, pos.up()) && this.canPlacePart(world, pos.down()) && this.canPlacePart(world, pos.east()) && this.canPlacePart(world, pos.west());
		}
		return false;

    }

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
		if(state.getValue(POSITION) == 0)
			return Item.getItemFromBlock(this);
		return null;
    }

	@Override
	public void onPlayerDestroy(World world, BlockPos pos, IBlockState state){
		EnumFacing facing = state.getValue(FACING_HORIZONTAL);

		int position = state.getValue(POSITION);
		for(int i = 0; i < 14 && position != 0; i++){
			switch(i){
				case 0:
				case 6:
				case 7:
				case 12:
				case 13:
					pos = pos.up();
					break;
				case 1:
					pos = pos.west();
					break;
				case 2:
				case 3:
				case 9:
				case 10:
					pos = pos.down();
					break;
				case 4:
				case 5:
					pos = pos.east();
					break;
				case 8:
					pos = pos.west().north();
					break;
				case 11:
					pos = pos.south().south();
					break;
			}
			position = world.getBlockState(pos).getBlock() == this ? world.getBlockState(pos).getValue(POSITION) : 2;
		}
		if(position == 0){
			world.destroyBlock(pos, true);
			world.destroyBlock(pos.up(), true);
			world.destroyBlock(pos.down(), true);
			switch(facing.getAxis()){
				case X:
					world.destroyBlock(pos.north(), true);
					world.destroyBlock(pos.south(), true);
					world.destroyBlock(pos.north().up(), true);
					world.destroyBlock(pos.south().up(), true);
					world.destroyBlock(pos.north().down(), true);
					world.destroyBlock(pos.south().down(), true);
					break;
				case Z:
					world.destroyBlock(pos.east(), true);
					world.destroyBlock(pos.west(), true);
					world.destroyBlock(pos.east().up(), true);
					world.destroyBlock(pos.west().up(), true);
					world.destroyBlock(pos.east().down(), true);
					world.destroyBlock(pos.west().down(), true);
					break;
				default:
					break;
			}
		}
	}

	private boolean canPlacePart(World world, BlockPos pos){
		 return world.getBlockState(pos).getBlock().isReplaceable(world, pos);
	}

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING_HORIZONTAL, facing);
    }

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos){
//		System.out.println(state.getValue(POSITION));
		int position = state.getValue(POSITION);
		EnumFacing facing = state.getValue(FACING_HORIZONTAL);

		if(position == 0){
			return state;
		}else if(position == 1){
			if(this.checkSide(world, pos.offset(facing.rotateY()))){
				return state.withProperty(POSITION, 3);
			}else if(this.checkSide(world, pos.offset(facing.rotateY().getOpposite()))){
				return state.withProperty(POSITION, 7);
			}else if(this.checkSide(world, pos.up())){
				return state.withProperty(POSITION, 5);
			}
		}else if(position == 2){
			if(this.checkCorner(world, pos.offset(facing.rotateY())) && this.checkCorner(world, pos.up())){
				return state.withProperty(POSITION, 4);
			}else if(this.checkCorner(world, pos.offset(facing.rotateYCCW())) && this.checkCorner(world, pos.up())){
				return state.withProperty(POSITION, 6);
			}else if(this.checkCorner(world, pos.offset(facing.rotateYCCW())) && this.checkCorner(world, pos.down())){
				return state.withProperty(POSITION, 8);
			}
			return state;
		}
		return state;
    }

	private boolean checkSide(IBlockAccess world, BlockPos pos){
		IBlockState state2 = world.getBlockState(pos);
		if(state2.getBlock() == this){
			if(state2.getValue(POSITION) == 0){
				return true;
			}
		}
		return false;
	}

	private boolean checkCorner(IBlockAccess world, BlockPos pos){
		IBlockState state2 = world.getBlockState(pos);
		if(state2.getBlock() == this){
			if(state2.getValue(POSITION) == 1){
				return true;
			}
		}
		return false;
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

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		switch(state.getValue(FACING_HORIZONTAL)){
			case NORTH:
				return this.northBB;
			case EAST:
				return this.eastBB;
			case SOUTH:
				return this.southBB;
			case WEST:
				return this.westBB;
			default:
				return this.northBB;
		}
    }

	@Override
    public IBlockState withRotation(IBlockState state, Rotation rot){
		EnumFacing facing = state.getValue(FACING_HORIZONTAL);
		switch(rot) {
			case CLOCKWISE_180:
				facing = facing.rotateY().rotateY();
				break;
			case CLOCKWISE_90:
				facing = facing.rotateY();
				break;
			case COUNTERCLOCKWISE_90:
				facing = facing.rotateYCCW();
				break;
			case NONE:
				break;
			default:
				break;
		}
        return state.withProperty(FACING_HORIZONTAL, facing);
    }

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirror) {
		EnumFacing facing = state.getValue(FACING_HORIZONTAL);
		switch(mirror) {
			case FRONT_BACK:
				if(facing == EnumFacing.EAST || facing == EnumFacing.WEST)
				facing = facing.getOpposite();
				break;
			case LEFT_RIGHT:
				if(facing == EnumFacing.SOUTH || facing == EnumFacing.NORTH)
					facing = facing.getOpposite();
			case NONE:
			default:
				break;
		}
        return state.withProperty(FACING_HORIZONTAL, facing);
    }
}