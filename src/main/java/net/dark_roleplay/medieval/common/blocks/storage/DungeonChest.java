package net.dark_roleplay.medieval.common.blocks.storage;

import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityCrate;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TE_DungeonChest;
import net.dark_roleplay.medieval.common.gui.GuiHandler;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.common.property.Properties;

public class DungeonChest extends Block {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public DungeonChest(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.UTILITY);
		this.setHardness(2F);
		this.setSoundType(SoundType.WOOD);
	}

	// -------------------------------------------------- Block Data
	// --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if (state.getValue(DungeonChest.FACING) == EnumFacing.NORTH)
			return new AxisAlignedBB(0.0625F, 0F, 0.125F, 0.9375F, 0.75F, 0.875F);
		else if (state.getValue(DungeonChest.FACING) == EnumFacing.EAST)
			return new AxisAlignedBB(0.125F, 0F, 0.0625F, 0.875F, 0.75F, 0.9375F);
		else if (state.getValue(DungeonChest.FACING) == EnumFacing.SOUTH)
			return new AxisAlignedBB(0.0625F, 0F, 0.125F, 0.9375F, 0.75F, 0.875F);
		else if (state.getValue(DungeonChest.FACING) == EnumFacing.WEST)
			return new AxisAlignedBB(0.125F, 0F, 0.0625F, 0.875F, 0.75F, 0.9375F);
		return null;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {

		switch (meta) {
		case 0:
			return this.getDefaultState().withProperty(DungeonChest.FACING, EnumFacing.NORTH);
		case 1:
			return this.getDefaultState().withProperty(DungeonChest.FACING, EnumFacing.EAST);
		case 2:
			return this.getDefaultState().withProperty(DungeonChest.FACING, EnumFacing.SOUTH);
		case 3:
			return this.getDefaultState().withProperty(DungeonChest.FACING, EnumFacing.WEST);
		default:
			return this.getDefaultState().withProperty(DungeonChest.FACING, EnumFacing.NORTH);
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {

		EnumFacing facing = state.getValue(DungeonChest.FACING);
		if (facing.equals(EnumFacing.NORTH))
			return 0;
		if (facing.equals(EnumFacing.EAST))
			return 1;
		if (facing.equals(EnumFacing.SOUTH))
			return 2;
		if (facing.equals(EnumFacing.WEST))
			return 3;
		return 0;
	}

	@Override
	protected ExtendedBlockState createBlockState() {

		return new ExtendedBlockState(this, new IProperty[] { DungeonChest.FACING, Properties.StaticProperty },
				new IUnlistedProperty[] { Properties.AnimationProperty });
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		return state.withProperty(Properties.StaticProperty, true);
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	// -------------------------------------------------- Block Events
	// --------------------------------------------------

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		if (!worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true))
			return Blocks.AIR.getDefaultState();
		EntityPlayer entity = (EntityPlayer) placer;
		if (entity != null) {
			int dir = MathHelper.floor((entity.rotationYaw * 4.0F) / 360.0F + 0.5D) & 3;
			switch (dir) {
			case 0:
				return this.getDefaultState().withProperty(DungeonChest.FACING, EnumFacing.NORTH);
			case 1:
				return this.getDefaultState().withProperty(DungeonChest.FACING, EnumFacing.EAST);
			case 2:
				return this.getDefaultState().withProperty(DungeonChest.FACING, EnumFacing.SOUTH);
			case 3:
				return this.getDefaultState().withProperty(DungeonChest.FACING, EnumFacing.WEST);
			default:
				return this.getDefaultState().withProperty(DungeonChest.FACING, EnumFacing.NORTH);
			}
		}
		return Blocks.AIR.getDefaultState();
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (world.isRemote) {
			TileEntity tileentity = world.getTileEntity(pos);
			if (tileentity instanceof TE_DungeonChest) {
//				player.openGui(DarkRoleplayMedieval.instance, GuiHandler.GUI_DUNGEONCHEST, world, pos.getX(), pos.getY(), pos.getZ());
				((TE_DungeonChest) tileentity).click(player.isSneaking());
			}
		}
		return true;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {

		TileEntity tileEntity = worldIn.getTileEntity(pos);

		if (tileEntity instanceof TE_DungeonChest) {
			TE_DungeonChest tileentityChest = (TE_DungeonChest) tileEntity;
			InventoryHelper.dropInventoryItems(worldIn, pos, tileentityChest.inventory);
		}

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TE_DungeonChest();
	}

}
