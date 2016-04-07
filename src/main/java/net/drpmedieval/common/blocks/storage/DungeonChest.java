package net.drpmedieval.common.blocks.storage;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.blocks.templates.DRPMedievalMaterials;
import net.drpmedieval.common.blocks.tileentitys.TileEntityChain;
import net.drpmedieval.common.blocks.tileentitys.TileEntityDungeonChest;
import net.drpmedieval.common.gui.GuiHandler;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DungeonChest extends BlockContainer {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public DungeonChest() {
		super(DRPMedievalMaterials.wood);
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.75F, 1F);
		this.setUnlocalizedName("blockDungeonChest");
		this.setStepSound(Block.soundTypeWood);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
	}

	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		if(!worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true)) return Blocks.air.getDefaultState();
		EntityPlayer entity = (EntityPlayer) placer;
		if(entity != null){
			int dir = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			switch (dir) {
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
		return Blocks.air.getDefaultState();
	}

	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {

		this.setBlockBoundsBasedOnState(worldIn, pos);
		return super.getCollisionBoundingBox(worldIn, pos, state);
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos) {

		this.setBlockBoundsBasedOnState(worldIn, pos);
		return super.getSelectedBoundingBox(worldIn, pos);
	}

	public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos) {

		if(!worldIn.getBlockState(pos).getBlock().equals(this)) return;
		EnumFacing facing = (EnumFacing) worldIn.getBlockState(pos).getValue(FACING);
		if(facing.equals(EnumFacing.NORTH))
			this.setBlockBounds(0.0625F, 0F, 0.125F, 0.9375F, 0.75F, 0.875F);
		else if(facing.equals(EnumFacing.EAST))
			this.setBlockBounds(0.125F, 0F, 0.0625F, 0.875F, 0.75F, 0.9375F);
		else if(facing.equals(EnumFacing.SOUTH))
			this.setBlockBounds(0.0625F, 0F, 0.125F, 0.9375F, 0.75F, 0.875F);
		else if(facing.equals(EnumFacing.WEST)) this.setBlockBounds(0.125F, 0F, 0.0625F, 0.875F, 0.75F, 0.9375F);

	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {

		if(!worldIn.isRemote){
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if(tileentity instanceof TileEntityDungeonChest){
				playerIn.openGui(DarkRoleplayMedieval.instance, GuiHandler.GUI_DUNGEONCHEST, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
		}
		return true;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {

		TileEntity tileEntity = worldIn.getTileEntity(pos);

		if(tileEntity instanceof TileEntityDungeonChest){
			TileEntityDungeonChest tileentityChest = (TileEntityDungeonChest) tileEntity;
			InventoryHelper.dropInventoryItems(worldIn, pos, tileentityChest.inventory);
		}

		super.breakBlock(worldIn, pos, state);
	}

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

	public int getMetaFromState(IBlockState state) {

		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		if(facing.equals(EnumFacing.NORTH)) return 0;
		if(facing.equals(EnumFacing.EAST)) return 1;
		if(facing.equals(EnumFacing.SOUTH)) return 2;
		if(facing.equals(EnumFacing.WEST)) return 3;
		return 0;
	}

	protected BlockState createBlockState() {

		return new BlockState(this, new IProperty[] {FACING});
	}

	@Override
	public boolean isFullCube() {

		return false;
	}

	public boolean isSolidFullCube() {

		return false;
	}

	public boolean isOpaqueCube() {

		return false;
	}

	// Ground Blocks
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {

		if(!this.canBlockStay(worldIn, pos, EnumFacing.UP)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
		super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {

		return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true);
	}

	public boolean isSideSolid(IBlockAccess world, BlockPos pos, EnumFacing side) {

		return false;
	}

	// TODO
	public int getRenderType() {

		return -1;
	}

	public TileEntity createNewTileEntity(World world, int meta) {

		return new TileEntityDungeonChest();
	}
}
