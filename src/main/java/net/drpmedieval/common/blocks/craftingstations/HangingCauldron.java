package net.drpmedieval.common.blocks.craftingstations;

import net.drpcore.common.DarkRoleplayCore;
import net.drpcore.common.gui.GuiHandler;
import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.blocks.templates.DRPMedievalMaterials;
import net.drpmedieval.common.blocks.tileentitys.TileEntityHangingCauldron;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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

public class HangingCauldron extends BlockContainer {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public HangingCauldron() {
		super(DRPMedievalMaterials.iron);
		this.setRegistryName("HangingCauldron");
		this.setUnlocalizedName("HangingCauldron");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
		this.setHardness(5F);
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.ANVIL);
	}
	
	// -------------------------------------------------- Block Data --------------------------------------------------
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.0625F, 0F, 0.0625F, 0.9375F, 0.75F, 0.9375F);
    }
	
	@Override
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

	@Override
	public int getMetaFromState(IBlockState state) {

		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		if(facing.equals(EnumFacing.NORTH)) return 0;
		if(facing.equals(EnumFacing.EAST)) return 1;
		if(facing.equals(EnumFacing.SOUTH)) return 2;
		if(facing.equals(EnumFacing.WEST)) return 3;
		return 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {FACING});
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
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock){

		if(!this.canBlockStay(worldIn, pos, EnumFacing.UP)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
		super.neighborChanged(state, worldIn, pos, neighborBlock);
	}
	
	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {
		return worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true) || worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock().equals(DRPMedievalBlocks.IRON_HOOK);
	}
	
	// -------------------------------------------------- Block Events --------------------------------------------------
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		if(!worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true) && !worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock().equals(DRPMedievalBlocks.IRON_HOOK)) return Blocks.AIR.getDefaultState();
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
		return Blocks.AIR.getDefaultState();
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(world.isRemote){
			player.openGui(DarkRoleplayCore.instance,GuiHandler.GUI_CRAFTING_RECIPESELECTION,player.worldObj,pos.getX(),pos.getY(),pos.getZ());
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

		return new TileEntityHangingCauldron();
	}
}
