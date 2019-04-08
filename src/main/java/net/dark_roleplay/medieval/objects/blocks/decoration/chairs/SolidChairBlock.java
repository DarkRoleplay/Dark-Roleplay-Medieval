package net.dark_roleplay.medieval.objects.blocks.decoration.chairs;

import java.util.EnumMap;
import java.util.stream.Stream;

import net.dark_roleplay.medieval.holders.MedievalItems;
import net.dark_roleplay.medieval.holders.MedievalTileEntities;
import net.dark_roleplay.medieval.objects.blocks.decoration.chairs.template.ChairBlock;
import net.dark_roleplay.medieval.util.sitting.SittingUtil;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class SolidChairBlock extends ChairBlock {

	public static final BooleanProperty HIDDEN_COMPARTMENT = BooleanProperty.create("hidden_compartment");

	protected final EnumMap<EnumFacing, VoxelShape> compartmentShapes = new EnumMap<EnumFacing, VoxelShape>(
			EnumFacing.class);

	protected final EnumMap<EnumFacing, AxisAlignedBB> buttons = new EnumMap<EnumFacing, AxisAlignedBB>(
			EnumFacing.class);

	public SolidChairBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.getDefaultState().with(HIDDEN_COMPARTMENT, false));

		setShapes(Stream.of(Block.makeCuboidShape(1.5, 0, 3, 3.5, 7, 5), Block.makeCuboidShape(12.5, 0, 3, 14.5, 7, 5),
				Block.makeCuboidShape(12.5, 0, 13, 14.5, 18, 15), Block.makeCuboidShape(1.5, 0, 13, 3.5, 18, 15),
				VoxelShapes.combineAndSimplify(Block.makeCuboidShape(2, 5.5, 3.5, 14, 7, 14.5),
						Block.makeCuboidShape(3, 5.5, 4.5, 13, 7, 13.5), IBooleanFunction.ONLY_FIRST),
				Block.makeCuboidShape(1, 7, 2.5, 15, 8, 15), Block.makeCuboidShape(3.5, 11, 13.5, 12.5, 17, 14.5))
				.reduce((v1, v2) -> {
					return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
				}).get(),
				Stream.of(Block.makeCuboidShape(11, 0, 1.5, 13, 7, 3.5),
						Block.makeCuboidShape(11, 0, 12.5, 13, 7, 14.5), Block.makeCuboidShape(1, 0, 12.5, 3, 18, 14.5),
						Block.makeCuboidShape(1, 0, 1.5, 3, 18, 3.5),
						VoxelShapes.combineAndSimplify(Block.makeCuboidShape(1.5, 5.5, 2, 12.5, 7, 14),
								Block.makeCuboidShape(2.5, 5.5, 3, 11.5, 7, 13), IBooleanFunction.ONLY_FIRST),
						Block.makeCuboidShape(1, 7, 1, 13.5, 8, 15), Block.makeCuboidShape(1.5, 11, 3.5, 2.5, 17, 12.5))
						.reduce((v1, v2) -> {
							return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
						}).get(),
				Stream.of(Block.makeCuboidShape(12.5, 0, 11, 14.5, 7, 13),
						Block.makeCuboidShape(1.5, 0, 11, 3.5, 7, 13), Block.makeCuboidShape(1.5, 0, 1, 3.5, 18, 3),
						Block.makeCuboidShape(12.5, 0, 1, 14.5, 18, 3),
						VoxelShapes.combineAndSimplify(Block.makeCuboidShape(2, 5.5, 1.5, 14, 7, 12.5),
								Block.makeCuboidShape(3, 5.5, 2.5, 13, 7, 11.5), IBooleanFunction.ONLY_FIRST),
						Block.makeCuboidShape(1, 7, 1, 15, 8, 13.5), Block.makeCuboidShape(3.5, 11, 1.5, 12.5, 17, 2.5))
						.reduce((v1, v2) -> {
							return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
						}).get(),
				Stream.of(Block.makeCuboidShape(3, 0, 12.5, 5, 7, 14.5), Block.makeCuboidShape(3, 0, 1.5, 5, 7, 3.5),
						Block.makeCuboidShape(13, 0, 1.5, 15, 18, 3.5),
						Block.makeCuboidShape(13, 0, 12.5, 15, 18, 14.5),
						VoxelShapes.combineAndSimplify(Block.makeCuboidShape(3.5, 5.5, 2, 14.5, 7, 14),
								Block.makeCuboidShape(4.5, 5.5, 3, 13.5, 7, 13), IBooleanFunction.ONLY_FIRST),
						Block.makeCuboidShape(2.5, 7, 1, 15, 8, 15),
						Block.makeCuboidShape(13.5, 11, 3.5, 14.5, 17, 12.5)).reduce((v1, v2) -> {
							return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
						}).get());

		setShapesCompartment(
				Stream.of(
					Block.makeCuboidShape(1.5, 0, 3, 3.5, 7, 5),
					Block.makeCuboidShape(12.5, 0, 3, 14.5, 7, 5), 
					Block.makeCuboidShape(12.5, 0, 13, 14.5, 18, 15),
					Block.makeCuboidShape(1.5, 0, 13, 3.5, 18, 15), 
					Block.makeCuboidShape(1, 7, 2.5, 15, 8, 15),
					Block.makeCuboidShape(3.5, 11, 13.5, 12.5, 17, 14.5),
					Block.makeCuboidShape(6.5, 6.5, 14.5, 9.5, 7, 14.75), 
					Block.makeCuboidShape(2, 5.5, 3.5, 14, 7, 14.5))
				.reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get(),
				Stream.of(Block.makeCuboidShape(11, 0, 1.5, 13, 7, 3.5),
					Block.makeCuboidShape(11, 0, 12.5, 13, 7, 14.5), 
					Block.makeCuboidShape(1, 0, 12.5, 3, 18, 14.5),
					Block.makeCuboidShape(1, 0, 1.5, 3, 18, 3.5), 
					Block.makeCuboidShape(1, 7, 1, 13.5, 8, 15),
					Block.makeCuboidShape(1.5, 11, 3.5, 2.5, 17, 12.5),
					Block.makeCuboidShape(1.25, 6.5, 6.5, 1.5, 7, 9.5),
					Block.makeCuboidShape(1.5, 5.5, 2, 12.5, 7, 14))
				.reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get(),
				Stream.of(Block.makeCuboidShape(12.5, 0, 11, 14.5, 7, 13),
					Block.makeCuboidShape(1.5, 0, 11, 3.5, 7, 13), 
					Block.makeCuboidShape(1.5, 0, 1, 3.5, 18, 3),
					Block.makeCuboidShape(12.5, 0, 1, 14.5, 18, 3), 
					Block.makeCuboidShape(1, 7, 1, 15, 8, 13.5),
					Block.makeCuboidShape(3.5, 11, 1.5, 12.5, 17, 2.5),
					Block.makeCuboidShape(6.5, 6.5, 1.25, 9.5, 7, 1.5),
					Block.makeCuboidShape(2, 5.5, 1.5, 14, 7, 12.5))
				.reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get(),
				Stream.of(Block.makeCuboidShape(3, 0, 12.5, 5, 7, 14.5), 
					Block.makeCuboidShape(3, 0, 1.5, 5, 7, 3.5),
					Block.makeCuboidShape(13, 0, 1.5, 15, 18, 3.5),
					Block.makeCuboidShape(13, 0, 12.5, 15, 18, 14.5), 
					Block.makeCuboidShape(2.5, 7, 1, 15, 8, 15),
					Block.makeCuboidShape(13.5, 11, 3.5, 14.5, 17, 12.5),
					Block.makeCuboidShape(14.5, 6.5, 6.5, 14.75, 7, 9.5),
					Block.makeCuboidShape(3.5, 5.5, 2, 14.5, 7, 14))
				.reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get());
		setButtons(
			Block.makeCuboidShape(6.5, 6.5, 14.5, 9.5, 7, 14.75),
			Block.makeCuboidShape(1.25, 6.5, 6.5, 1.5, 7, 9.5), 
			Block.makeCuboidShape(6.5, 6.5, 1.25, 9.5, 7, 1.5),
			Block.makeCuboidShape(14.5, 6.5, 6.5, 14.75, 7, 9.5)
		);
	}

	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
		if (state.get(HIDDEN_COMPARTMENT)) {
			return compartmentShapes.get(state.get(HORIZONTAL_FACING));
		} else {
			return shapes.get(state.get(HORIZONTAL_FACING));
		}
	}

	protected void setButtons(VoxelShape north, VoxelShape east, VoxelShape south, VoxelShape west) {
		this.buttons.put(EnumFacing.NORTH,
				north.getBoundingBox().expand(0.0001, 0.0001, 0.0001).expand(-0.0001, -0.0001, -0.0001));
		this.buttons.put(EnumFacing.EAST,
				east.getBoundingBox().expand(0.0001, 0.0001, 0.0001).expand(-0.0001, -0.0001, -0.0001));
		this.buttons.put(EnumFacing.SOUTH,
				south.getBoundingBox().expand(0.0001, 0.0001, 0.0001).expand(-0.0001, -0.0001, -0.0001));
		this.buttons.put(EnumFacing.WEST,
				west.getBoundingBox().expand(0.0001, 0.0001, 0.0001).expand(-0.0001, -0.0001, -0.0001));
	}

	protected void setShapesCompartment(VoxelShape north, VoxelShape east, VoxelShape south, VoxelShape west) {
		this.compartmentShapes.put(EnumFacing.NORTH, north);
		this.compartmentShapes.put(EnumFacing.EAST, east);
		this.compartmentShapes.put(EnumFacing.SOUTH, south);
		this.compartmentShapes.put(EnumFacing.WEST, west);
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(HIDDEN_COMPARTMENT);
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return state.get(HIDDEN_COMPARTMENT);
	}

	@Override
	public TileEntity createTileEntity(IBlockState state, IBlockReader world) {
		return new SolidChairTileEntity();
	}

	@Override
	public void onReplaced(IBlockState state, World world, BlockPos pos, IBlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity tileentity = world.getTileEntity(pos);
			
			if (tileentity == null) return;
			LazyOptional<IItemHandler> itemHandler = tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
			if (!itemHandler.isPresent()) return;
			IItemHandler handler = itemHandler.orElse(null);
			if (!handler.getStackInSlot(0).isEmpty())
				InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), handler.extractItem(0, handler.getStackInSlot(0).getCount(), false));
		}
		super.onReplaced(state, world, pos, newState, isMoving);
	}

	@Override
	public boolean onBlockActivated(IBlockState state, World world, BlockPos pos, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {

		if (state.get(HIDDEN_COMPARTMENT) && buttons.get(state.get(HORIZONTAL_FACING)).contains(hitX, hitY, hitZ)) {
			TileEntity te = world.getTileEntity(pos);

			if (te == null)
				return true;
			LazyOptional<IItemHandler> itemHandler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
			if (!itemHandler.isPresent())
				return true;
			IItemHandler handler = itemHandler.orElse(null);
			if (handler.getStackInSlot(0).isEmpty() && !player.getHeldItem(hand).isEmpty()) {
				player.setHeldItem(hand, handler.insertItem(0, player.getHeldItem(hand), false));
			} else if (!handler.getStackInSlot(0).isEmpty() && player.getHeldItem(hand).isEmpty()) {
				handler.insertItem(0, player.getHeldItem(hand), false);
				player.setHeldItem(hand, handler.extractItem(0, handler.getStackInSlot(0).getCount(), false));
			}

			return true;
		} else {
			if (player.getDistance(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) < 3) {
				SittingUtil.sitOnBlockWithRotation(world, pos.getX(), pos.getY(), pos.getZ(), player,
						state.get(HORIZONTAL_FACING), 0.2F);
			} else {
				player.sendStatusMessage(new TextComponentTranslation("interaction.drpmedieval.chair.to_far",
						state.getBlock().getNameTextComponent().getFormattedText()), true);
			}
			return true;
		}
	}
}
