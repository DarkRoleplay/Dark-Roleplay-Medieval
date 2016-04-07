package net.drpmedieval.common.blocks.storage;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.blocks.templates.DRPMedievalMaterials;
import net.drpmedieval.common.blocks.tileentitys.TileEntityCauldron;
import net.drpmedieval.common.blocks.tileentitys.TileEntityCrate;
import net.drpmedieval.common.blocks.tileentitys.TileEntityDungeonChest;
import net.drpmedieval.common.gui.GuiHandler;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Crate extends BlockContainer {

	public Crate() {
		super(DRPMedievalMaterials.wood);
		this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		this.setUnlocalizedName("blockCrate");
		this.setStepSound(Block.soundTypeWood);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
	}

	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		if(worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true))
			return this.getDefaultState();
		else
			return Blocks.air.getDefaultState();
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

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {

		if(!worldIn.isRemote){
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if(tileentity instanceof TileEntityCrate){
				playerIn.openGui(DarkRoleplayMedieval.instance, GuiHandler.GUI_CRATE, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}

		}
		return true;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {

		TileEntity tileEntity = worldIn.getTileEntity(pos);

		if(tileEntity instanceof TileEntityCrate){
			TileEntityCrate tileentityChest = (TileEntityCrate) tileEntity;
			InventoryHelper.dropInventoryItems(worldIn, pos, tileentityChest.inventory);
		}

		super.breakBlock(worldIn, pos, state);
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

		return true;
	}

	// TODO
	public int getRenderType() {

		return -1;
	}

	public TileEntity createNewTileEntity(World world, int meta) {

		return new TileEntityCrate();
	}
}
