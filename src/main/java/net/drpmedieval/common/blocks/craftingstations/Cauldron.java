package net.drpmedieval.common.blocks.craftingstations;

import net.drpcore.main.DarkRoleplayCore;
import net.drpcore.server.GuiHandler;
import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.blocks.templates.DRPMedievalMaterials;
import net.drpmedieval.common.blocks.tileentitys.TileEntityBookOne;
import net.drpmedieval.common.blocks.tileentitys.TileEntityCauldron;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Cauldron extends BlockContainer {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool FILLED = PropertyBool.create("filled");

	public Cauldron() {
		super(DRPMedievalMaterials.iron);
		this.setBlockBounds(0.0625F, 0F, 0.0625F, 0.9375F, 1F, 0.9375F);
		this.setUnlocalizedName("blockCauldron");
		this.setStepSound(Block.soundTypeAnvil);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {

		if(!worldIn.isRemote){
			if(!(Boolean) state.getValue(FILLED) && player.getHeldItem() != null){

				if(player.getHeldItem().getItem().equals(Items.water_bucket)){
					player.inventory.consumeInventoryItem(Items.water_bucket);
					player.inventory.addItemStackToInventory(new ItemStack(Items.water_bucket, 1));
					worldIn.setBlockState(pos, state.withProperty(FILLED, true));
				}
			}
			else
				player.openGui(DarkRoleplayCore.instance, GuiHandler.GUI_CRAFTING, player.worldObj, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}

	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		if(!worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true)) return Blocks.air.getDefaultState();
		EntityPlayer entity = (EntityPlayer) placer;
		if(entity != null){
			int dir = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			switch (dir) {
				case 0:
					return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(FILLED, false);
				case 1:
					return this.getDefaultState().withProperty(FACING, EnumFacing.EAST).withProperty(FILLED, false);
				case 2:
					return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(FILLED, false);
				case 3:
					return this.getDefaultState().withProperty(FACING, EnumFacing.WEST).withProperty(FILLED, false);
				default:
					return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(FILLED, false);
			}
		}
		return Blocks.air.getDefaultState();
	}

	public IBlockState getStateFromMeta(int meta) {

		switch (meta) {
			case 0:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(FILLED, false);
			case 1:
				return this.getDefaultState().withProperty(FACING, EnumFacing.EAST).withProperty(FILLED, false);
			case 2:
				return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(FILLED, false);
			case 3:
				return this.getDefaultState().withProperty(FACING, EnumFacing.WEST).withProperty(FILLED, false);
			case 4:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(FILLED, true);
			case 5:
				return this.getDefaultState().withProperty(FACING, EnumFacing.EAST).withProperty(FILLED, true);
			case 6:
				return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(FILLED, true);
			case 7:
				return this.getDefaultState().withProperty(FACING, EnumFacing.WEST).withProperty(FILLED, true);
			default:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
		}
	}

	public int getMetaFromState(IBlockState state) {

		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		int dir = 0;
		if(facing.equals(EnumFacing.NORTH)) dir += 0;
		if(facing.equals(EnumFacing.EAST)) dir += 1;
		if(facing.equals(EnumFacing.SOUTH)) dir += 2;
		if(facing.equals(EnumFacing.WEST)) dir += 3;

		if((Boolean) state.getValue(FILLED)) dir += 4;

		return dir;
	}

	protected BlockState createBlockState() {

		return new BlockState(this, new IProperty[] {FACING, FILLED});
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

		return new TileEntityCauldron();
	}
}
