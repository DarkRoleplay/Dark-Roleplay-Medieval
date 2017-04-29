package net.dark_roleplay.medieval.common.blocks.storage;

import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.blocks.templates.DRPMedievalMaterials;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityCrate;
import net.dark_roleplay.medieval.common.gui.GuiHandler;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Crate extends BlockContainer {

	public Crate(String registryName) {
		super(DRPMedievalMaterials.wood);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.UTILITY);
		this.setHardness(2F);
		this.setSoundType(SoundType.WOOD);
	}
	
	// -------------------------------------------------- Block Data --------------------------------------------------
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return new AxisAlignedBB(0F, 0F, 0F, 1F, 1F, 1F);
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	
	// -------------------------------------------------- Block Events --------------------------------------------------

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){

		if(!world.isRemote){
			TileEntity tileentity = world.getTileEntity(pos);
			if(tileentity instanceof TileEntityCrate){
				player.openGui(DarkRoleplayMedieval.instance, GuiHandler.GUI_CRATE, world, pos.getX(), pos.getY(), pos.getZ());
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

		return new TileEntityCrate();
	}
	
}
