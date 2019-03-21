package net.dark_roleplay.medieval.objects.blocks.decoration.light_sources;

import java.util.Random;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.holders.MedievalItems;
import net.dark_roleplay.medieval.objects.enums.TorchHolderEnums.Addons;
import net.dark_roleplay.medieval.objects.enums.TorchHolderEnums.Torch;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.Particles;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TorchHolderBlock extends Block {

	private static VoxelShape EMPTY_NORTH = Block.makeCuboidShape(5.75, 1.5, 10.75, 10.25, 9.5, 16);
	private static VoxelShape EMPTY_EAST = Block.makeCuboidShape(0, 1.5, 5.75, 5.25, 9.5, 10.25);
	private static VoxelShape EMPTY_SOUTH = Block.makeCuboidShape(5.75, 1.5, 0, 10.25, 9.5, 5.25);
	private static VoxelShape EMPTY_WEST = Block.makeCuboidShape(10.75, 1.5, 5.75, 16, 9.5, 10.25);

	protected static final EnumProperty<Addons> ADDONS = EnumProperty.create("addons", Addons.class);
	protected static final EnumProperty<Torch> TORCH = EnumProperty.create("torch", Torch.class);
	public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;

	public TorchHolderBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.getDefaultState().with(ADDONS, Addons.NONE).with(TORCH, Torch.NONE));
	}

	@Override
	public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
		super.getDrops(state, drops, world, pos, fortune);
		switch(state.get(TORCH)) {
			case LIT:
			case UNLIT:
				drops.add(new ItemStack(Blocks.TORCH));
				break;
			case NONE:
			default:
				break;
		}
		
		switch(state.get(ADDONS)) {
			case HIDDEN_LEVER:
			case PULLED_HIDDEN_LEVER:				
				drops.add(new ItemStack(Blocks.LEVER));
				break;
			case LEVER:
			case PULLED_LEVER:
				drops.add(new ItemStack(MedievalItems.TRIGGER_TRAP));
				break;
			case LIGHTER:
				drops.add(new ItemStack(Items.FLINT));
				break;
			case NONE:
			default:
				break;
		}
	}

	@Override
	public boolean onBlockActivated(IBlockState state, World world, BlockPos pos, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		if (world.isRemote) {
			return true;
		}
		ItemStack heldItem = player.getHeldItem(hand);

		// First do Torch Logic
		if (state.get(TORCH) == Torch.NONE && heldItem.getItem() == Blocks.TORCH.asItem()) {
			world.setBlockState(pos, state.with(TORCH, Torch.UNLIT), 3);
			if (!player.isCreative())
				heldItem.shrink(1);
			return true;
		} else if (state.get(TORCH) == Torch.UNLIT && heldItem.getItem() == Items.FLINT_AND_STEEL) {
			world.setBlockState(pos, state.with(TORCH, Torch.LIT), 3);
			world.playSound(null, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, 0.9F);
			if (!player.isCreative())
				heldItem.attemptDamageItem(1, player.getRNG(), (EntityPlayerMP) player);
			return true;
		} else if (state.get(TORCH) == Torch.UNLIT && heldItem.isEmpty() && player.isSneaking()) {
			world.setBlockState(pos, state.with(TORCH, Torch.NONE), 3);
			if (!player.inventory.addItemStackToInventory(new ItemStack(Blocks.TORCH.asItem())))
				world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(),
						new ItemStack(Blocks.TORCH.asItem())));
			return true;
		} else if (state.get(TORCH) == Torch.LIT && heldItem.isEmpty() && player.isSneaking()) {
			world.setBlockState(pos, state.with(TORCH, Torch.UNLIT), 3);
			return true;
		}

		if (state.get(ADDONS) == Addons.NONE) {
			if (heldItem.getItem() == MedievalItems.TRIGGER_TRAP) {
				world.setBlockState(pos, state.with(ADDONS, Addons.LEVER), 3);
				if (!player.isCreative())
					heldItem.shrink(1);
				return true;
			} else if (heldItem.getItem() == Blocks.LEVER.asItem()) {
				world.setBlockState(pos, state.with(ADDONS, Addons.HIDDEN_LEVER), 3);
				if (!player.isCreative())
					heldItem.shrink(1);
				return true;
			}
			if (heldItem.getItem() == Items.FLINT) {
				world.setBlockState(pos, state.with(ADDONS, Addons.LIGHTER), 3);
				if (!player.isCreative())
					heldItem.shrink(1);
				return true;
			}
		} else if (state.get(ADDONS).isLever()) {
			world.setBlockState(pos, state.with(ADDONS, state.get(ADDONS).toggleLever()), 3);
			world.playSound(null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 0.3F, 0.1F);
			world.notifyNeighborsOfStateChange(pos.offset(state.get((HORIZONTAL_FACING)).getOpposite()), this);
			return true;
		}

		return false;
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!world.isRemote) {
			if (state.get(ADDONS) == Addons.LIGHTER
					&& (state.get(TORCH) == Torch.UNLIT || state.get(TORCH) == Torch.LIT)) {
				if (world.isBlockPowered(pos)) {
					world.getPendingBlockTicks().scheduleTick(pos, this, 4);
				}
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(IBlockState state, World world, BlockPos pos, Random rand) {
		if (state.get(TORCH) == Torch.LIT) {
			EnumFacing enumfacing = state.get(HORIZONTAL_FACING);
			double d0 = (double) pos.getX() + 0.5D;
			double d1 = (double) pos.getY() + 0.7D + (!state.get(ADDONS).isPulledLever() ? 0.12D : -0.02D);
			double d2 = (double) pos.getZ() + 0.5D;
			double d3 = !state.get(ADDONS).isPulledLever() ? 0.16D : 0D;
			EnumFacing enumfacing1 = enumfacing.getOpposite();
			world.spawnParticle(Particles.SMOKE, d0 + d3 * (double) enumfacing1.getXOffset(), d1,
					d2 + d3 * (double) enumfacing1.getZOffset(), 0.0D, 0.0D, 0.0D);
			world.spawnParticle(Particles.FLAME, d0 + d3 * (double) enumfacing1.getXOffset(), d1,
					d2 + d3 * (double) enumfacing1.getZOffset(), 0.0D, 0.0D, 0.0D);
		}
	}

	@Override
	public void tick(IBlockState state, World world, BlockPos pos, Random random) {
		if (!world.isRemote) {
			if (state.get(ADDONS) == Addons.LIGHTER
					&& (state.get(TORCH) == Torch.UNLIT || state.get(TORCH) == Torch.LIT)) {
				if (world.isBlockPowered(pos)) {
					world.setBlockState(pos,
							state.with(TORCH, state.get(TORCH) == Torch.UNLIT ? Torch.LIT : Torch.UNLIT), 2);
				}
			}
		}
	}

	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
		switch ((EnumFacing) state.get(HORIZONTAL_FACING)) {
		case NORTH:
		default:
			return EMPTY_NORTH;
		case SOUTH:
			return EMPTY_SOUTH;
		case WEST:
			return EMPTY_WEST;
		case EAST:
			return EMPTY_EAST;
		}
	}

	@Override
	public int getLightValue(IBlockState state) {
		return state.get(TORCH) == Torch.LIT ? 15 : 0;
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
		builder.add(HORIZONTAL_FACING, ADDONS, TORCH);
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public int getWeakPower(IBlockState blockState, IBlockReader blockAccess, BlockPos pos, EnumFacing side) {
		return blockState.get(ADDONS).isPulledLever() ? 15 : 0;
	}

	@Override
	public int getStrongPower(IBlockState blockState, IBlockReader blockAccess, BlockPos pos, EnumFacing side) {
		return blockState.get(HORIZONTAL_FACING) == side && blockState.get(ADDONS).isPulledLever() ? 15 : 0;
	}

	@Override
	public boolean canProvidePower(IBlockState state) {
		return true;
	}

	@Nullable
	@Override
	public IBlockState getStateForPlacement(BlockItemUseContext context) {
		EnumFacing face = context.getFace();
		if (face.getAxis() == Axis.Y)
			return null;

		BlockFaceShape shape = context.getWorld().getBlockState(context.getPos().offset(face.getOpposite()))
				.getBlockFaceShape(context.getWorld(), context.getPos().offset(face.getOpposite()), face);
		if (shape != BlockFaceShape.SOLID)
			return null;

		return this.getDefaultState().with(HORIZONTAL_FACING, face);
	}

	@Override
	public IBlockState updatePostPlacement(IBlockState state, EnumFacing facing, IBlockState facingState, IWorld world,
			BlockPos currentPos, BlockPos facingPos) {
		if (facing != state.get(HORIZONTAL_FACING).getOpposite())
			return state;
		if (facingState.getBlockFaceShape(world, facingPos, facing.getOpposite()) != BlockFaceShape.SOLID)
			return Blocks.AIR.getDefaultState();
		return state;
	}
}
