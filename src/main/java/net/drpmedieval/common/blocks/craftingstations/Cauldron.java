package net.drpmedieval.common.blocks.craftingstations;

import net.dark_roleplay.drpcore.common.DarkRoleplayCore;
import net.dark_roleplay.drpcore.common.handler.DRPCoreGuis;
import net.drpmedieval.common.blocks.templates.DRPMedievalMaterials;
import net.drpmedieval.common.blocks.tileentitys.TileEntityCauldron;
import net.drpmedieval.common.handler.DRPMedievalCreativeTabs;
import net.drpmedieval.common.util.InventoryHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Cauldron extends BlockContainer {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool FILLED = PropertyBool.create("filled");

	public Cauldron(String registryName) {
		super(DRPMedievalMaterials.iron);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.UTILITY);
		this.setHardness(5F);
		this.setHarvestLevel("pickaxe", 0);
		this.setResistance(2000.0F);
		this.setSoundType(SoundType.ANVIL);
	}

	// -------------------------------------------------- Block Data --------------------------------------------------
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.0625F, 0F, 0.0625F, 0.9375F, 1F, 0.9375F);
    }
	
	@Override
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
	
	@Override
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
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING, FILLED});
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
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		Entity entity = (Entity) placer;
		int dir = MathHelper.floor((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
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
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){

		if(!world.isRemote){
			if(!(Boolean) state.getValue(FILLED) && player.getHeldItem(EnumHand.MAIN_HAND) != null){
				if(player.getHeldItem(EnumHand.MAIN_HAND).getItem().equals(Items.WATER_BUCKET)){
					if(!player.capabilities.isCreativeMode) player.inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(Items.WATER_BUCKET,  player.inventory.mainInventory.toArray(new ItemStack[]{})), 1);
					player.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET, 1));
					world.setBlockState(pos, state.withProperty(FILLED, true));
					return true;
				}
			}				
		}else if(world.isRemote && (Boolean) state.getValue(FILLED)){
			player.openGui(DarkRoleplayCore.instance, DRPCoreGuis.DRPCORE_GUI_CRAFTING_RECIPESELECTION, player.world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}

	
	// -------------------------------------------------- Old Rendering System --------------------------------------------------
	// TODO Old Rendering System
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.INVISIBLE;
    }

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCauldron();
	}
	
}
