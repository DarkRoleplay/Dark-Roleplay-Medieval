package net.dark_roleplay.medieval.common.blocks.other.gunpowder_trail;

import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;

import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GunpowderTrail extends Block {

	public static final PropertyEnum<GunpowderTrail.EnumAttachPosition> NORTH = PropertyEnum.<GunpowderTrail.EnumAttachPosition>create("north", GunpowderTrail.EnumAttachPosition.class);
	public static final PropertyEnum<GunpowderTrail.EnumAttachPosition> EAST = PropertyEnum.<GunpowderTrail.EnumAttachPosition>create("east", GunpowderTrail.EnumAttachPosition.class);
	public static final PropertyEnum<GunpowderTrail.EnumAttachPosition> SOUTH = PropertyEnum.<GunpowderTrail.EnumAttachPosition>create("south", GunpowderTrail.EnumAttachPosition.class);
	public static final PropertyEnum<GunpowderTrail.EnumAttachPosition> WEST = PropertyEnum.<GunpowderTrail.EnumAttachPosition>create("west", GunpowderTrail.EnumAttachPosition.class);
	public static final PropertyInteger POWER = PropertyInteger.create("power", 0, 4);
	protected static final AxisAlignedBB[] TRAIL_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.0625D, 0.8125D),new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.0625D, 1.0D),new AxisAlignedBB(0.0D, 0.0D, 0.1875D, 0.8125D, 0.0625D, 0.8125D),	new AxisAlignedBB(0.0D, 0.0D, 0.1875D, 0.8125D, 0.0625D, 1.0D),	new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 0.8125D, 0.0625D, 0.8125D),new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 0.8125D, 0.0625D, 1.0D),	new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.8125D, 0.0625D, 0.8125D),new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.8125D, 0.0625D, 1.0D),new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 1.0D, 0.0625D, 0.8125D),new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 1.0D, 0.0625D, 1.0D),new AxisAlignedBB(0.0D, 0.0D, 0.1875D, 1.0D, 0.0625D, 0.8125D),new AxisAlignedBB(0.0D, 0.0D, 0.1875D, 1.0D, 0.0625D, 1.0D),new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 1.0D, 0.0625D, 0.8125D),new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D),new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 0.8125D),new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D) };
	private boolean canProvidePower = true;
	private final Set<BlockPos> blocksNeedingUpdate = Sets.<BlockPos>newHashSet();

	public GunpowderTrail(String registryName) {
		super(Material.CIRCUITS);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setDefaultState(this.blockState.getBaseState().withProperty(GunpowderTrail.NORTH, GunpowderTrail.EnumAttachPosition.NONE).withProperty(GunpowderTrail.EAST, GunpowderTrail.EnumAttachPosition.NONE).withProperty(GunpowderTrail.SOUTH, GunpowderTrail.EnumAttachPosition.NONE).withProperty(GunpowderTrail.WEST, GunpowderTrail.EnumAttachPosition.NONE).withProperty(GunpowderTrail.POWER, Integer.valueOf(0)));
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return GunpowderTrail.TRAIL_AABB[GunpowderTrail.getAABBIndex(state.getActualState(source, pos))];
	}

	private static int getAABBIndex(IBlockState state) {
		int i = 0;
		boolean flag = state.getValue(GunpowderTrail.NORTH) != GunpowderTrail.EnumAttachPosition.NONE;
		boolean flag1 = state.getValue(GunpowderTrail.EAST) != GunpowderTrail.EnumAttachPosition.NONE;
		boolean flag2 = state.getValue(GunpowderTrail.SOUTH) != GunpowderTrail.EnumAttachPosition.NONE;
		boolean flag3 = state.getValue(GunpowderTrail.WEST) != GunpowderTrail.EnumAttachPosition.NONE;

		if (flag || (flag2 && !flag && !flag1 && !flag3)) {
			i |= 1 << EnumFacing.NORTH.getHorizontalIndex();
		}
		if (flag1 || (flag3 && !flag && !flag1 && !flag2)) {
			i |= 1 << EnumFacing.EAST.getHorizontalIndex();
		}
		if (flag2 || (flag && !flag1 && !flag2 && !flag3)) {
			i |= 1 << EnumFacing.SOUTH.getHorizontalIndex();
		}
		if (flag3 || (flag1 && !flag && !flag2 && !flag3)) {
			i |= 1 << EnumFacing.WEST.getHorizontalIndex();
		}

		return i;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		state = state.withProperty(GunpowderTrail.WEST, this.getAttachPosition(worldIn, pos, EnumFacing.WEST));
		state = state.withProperty(GunpowderTrail.EAST, this.getAttachPosition(worldIn, pos, EnumFacing.EAST));
		state = state.withProperty(GunpowderTrail.NORTH, this.getAttachPosition(worldIn, pos, EnumFacing.NORTH));
		state = state.withProperty(GunpowderTrail.SOUTH, this.getAttachPosition(worldIn, pos, EnumFacing.SOUTH));
		return state;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.GUNPOWDER;
	}

	protected static boolean canConnectUpwardsTo(IBlockAccess worldIn, BlockPos pos) {
		return GunpowderTrail.canConnectTo(worldIn.getBlockState(pos), null, worldIn, pos);
	}

	private GunpowderTrail.EnumAttachPosition getAttachPosition(IBlockAccess worldIn, BlockPos pos, EnumFacing direction) {
		BlockPos blockpos = pos.offset(direction);
		IBlockState iblockstate = worldIn.getBlockState(pos.offset(direction));

		if (!GunpowderTrail.canConnectTo(worldIn.getBlockState(blockpos), direction, worldIn, blockpos) && (iblockstate.isNormalCube() || !GunpowderTrail.canConnectUpwardsTo(worldIn, blockpos.down()))) {
			IBlockState iblockstate1 = worldIn.getBlockState(pos.up());

			if (!iblockstate1.isNormalCube()) {
				boolean flag = worldIn.getBlockState(blockpos).isSideSolid(worldIn, blockpos, EnumFacing.UP) || (worldIn.getBlockState(blockpos).getBlock() == Blocks.GLOWSTONE);

				if (flag && GunpowderTrail.canConnectUpwardsTo(worldIn, blockpos.up())) {
					if (iblockstate.isBlockNormalCube())
						return GunpowderTrail.EnumAttachPosition.UP;

					return GunpowderTrail.EnumAttachPosition.SIDE;
				}
			}

			return GunpowderTrail.EnumAttachPosition.NONE;
		} else
			return GunpowderTrail.EnumAttachPosition.SIDE;
	}

	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return Block.NULL_AABB;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).isFullyOpaque() || (worldIn.getBlockState(pos.down()).getBlock() == Blocks.GLOWSTONE);
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(Items.GUNPOWDER);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(GunpowderTrail.POWER, Integer.valueOf(meta));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(GunpowderTrail.POWER).intValue();
	}

	protected static boolean canConnectTo(IBlockState blockState, @Nullable EnumFacing side, IBlockAccess world, BlockPos pos) {
		Block block = blockState.getBlock();

		if (block == DRPMedievalBlocks.GUNPOWDER_TRAIL)
			return true;
		else if (Blocks.UNPOWERED_REPEATER.isSameDiode(blockState)) {
			EnumFacing enumfacing = blockState.getValue(BlockHorizontal.FACING);
			return (enumfacing == side) || (enumfacing.getOpposite() == side);
		} else
			return Blocks.OBSERVER == blockState.getBlock() ? side == blockState.getValue(BlockDirectional.FACING) : blockState.getBlock().canConnectRedstone(blockState, world, pos, side);
	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			if(player.getHeldItem(hand).getItem() == Items.FLINT_AND_STEEL){
				world.setBlockState(pos, state.withProperty(GunpowderTrail.POWER, 4));
				world.scheduleUpdate(pos, this, 5);
			}
		}
		return true;
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		if(!world.isRemote){
			state = state.withProperty(GunpowderTrail.POWER, state.getValue(GunpowderTrail.POWER) - 1);
			world.setBlockState(pos, state, 3);

			if(state.getValue(GunpowderTrail.POWER) == 3){
				BlockPos currentPos;
				if(world.getBlockState((currentPos = pos.north())).getBlock() == DRPMedievalBlocks.GUNPOWDER_TRAIL){
					this.ingiteNeighbor(world, currentPos);
				}else if(world.getBlockState((currentPos = pos.north().up())).getBlock() == DRPMedievalBlocks.GUNPOWDER_TRAIL){
					this.ingiteNeighbor(world, currentPos);
				}else if(world.getBlockState((currentPos = pos.north().down())).getBlock() == DRPMedievalBlocks.GUNPOWDER_TRAIL){
					this.ingiteNeighbor(world, currentPos);
				}
				
				if(world.getBlockState((currentPos = pos.east())).getBlock() == DRPMedievalBlocks.GUNPOWDER_TRAIL){
					this.ingiteNeighbor(world, currentPos);
				}else if(world.getBlockState((currentPos = pos.east().up())).getBlock() == DRPMedievalBlocks.GUNPOWDER_TRAIL){
					this.ingiteNeighbor(world, currentPos);
				}else if(world.getBlockState((currentPos = pos.east().down())).getBlock() == DRPMedievalBlocks.GUNPOWDER_TRAIL){
					this.ingiteNeighbor(world, currentPos);
				}
				
				if(world.getBlockState((currentPos = pos.south())).getBlock() == DRPMedievalBlocks.GUNPOWDER_TRAIL){
					this.ingiteNeighbor(world, currentPos);
				}else if(world.getBlockState((currentPos = pos.south().up())).getBlock() == DRPMedievalBlocks.GUNPOWDER_TRAIL){
					this.ingiteNeighbor(world, currentPos);
				}else if(world.getBlockState((currentPos = pos.south().down())).getBlock() == DRPMedievalBlocks.GUNPOWDER_TRAIL){
					this.ingiteNeighbor(world, currentPos);
				}
				
				if(world.getBlockState((currentPos = pos.west())).getBlock() == DRPMedievalBlocks.GUNPOWDER_TRAIL){
					this.ingiteNeighbor(world, currentPos);
				}else if(world.getBlockState((currentPos = pos.west().up())).getBlock() == DRPMedievalBlocks.GUNPOWDER_TRAIL){
					this.ingiteNeighbor(world, currentPos);
				}else if(world.getBlockState((currentPos = pos.west().down())).getBlock() == DRPMedievalBlocks.GUNPOWDER_TRAIL){
					this.ingiteNeighbor(world, currentPos);
				}
				world.scheduleUpdate(pos, this, 5);
			}else if(state.getValue(GunpowderTrail.POWER) == 0){
				world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 0.1f, true);
			}else{
				world.scheduleUpdate(pos, this, 5);
			}
		}
    }
	
	private void ingiteNeighbor(World world, BlockPos pos){
		if(world.getBlockState(pos).getValue(GunpowderTrail.POWER) == 0){
			world.setBlockState(pos, world.getBlockState(pos).withProperty(GunpowderTrail.POWER, 4));
			world.scheduleUpdate(pos, this, 5);
		}
	}
	
	@Override
	protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {GunpowderTrail.NORTH, GunpowderTrail.EAST, GunpowderTrail.SOUTH, GunpowderTrail.WEST, GunpowderTrail.POWER});
    }

	static enum EnumAttachPosition implements IStringSerializable {
		UP("up"), SIDE("side"), NONE("none");

		private final String name;

		private EnumAttachPosition(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return this.getName();
		}

		@Override
		public String getName() {
			return this.name;
		}
	}
}
