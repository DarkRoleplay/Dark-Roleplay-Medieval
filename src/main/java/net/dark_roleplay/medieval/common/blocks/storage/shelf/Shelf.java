package net.dark_roleplay.medieval.common.blocks.storage.shelf;

import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.blocks.BlockProperties;
import net.dark_roleplay.medieval.common.blocks.templates.FacedBlock;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityDungeonChest;
import net.dark_roleplay.medieval.common.gui.GuiHandler;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class Shelf extends FacedBlock{

	public Shelf(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.UTILITY);
		this.setHardness(2F);
		this.setSoundType(SoundType.WOOD);
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		int slot = getSlotClicked(state, hitX, hitY, hitZ);
		if(slot == -1)
			return false;
		if(!world.isRemote){
			TileEntity tileentity = world.getTileEntity(pos);
			if(tileentity instanceof TE_Shelf){
				
				
				IItemHandler invHandler = tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
				if(player.isSneaking() && player.getHeldItem(hand).isEmpty())
					player.setHeldItem(hand, invHandler.extractItem(slot, 64, false));
				else player.setHeldItem(hand, invHandler.insertItem(slot, player.getHeldItem(hand), false));
				
			}
		}
		return true;
	}

	protected int getSlotClicked(IBlockState state, float hitX, float hitY, float hitZ){
		System.out.println(hitX + " -> " + hitY + " -> " + hitZ);
		switch(state.getValue(BlockProperties.FACING)){
		case EAST:
			return hitX == 1 ? hitY > 0.5 ? hitZ < 0.5 ? 2 : 3 : hitZ > 0.5 ? 0 : 1 : -1;
		case NORTH:
			return hitZ == 0 ? hitX > 0.5 ? hitY > 0.5 ? 2 : 0 : hitY > 0.5 ? 3 : 1 : -1;
		case SOUTH:
			return hitZ == 1 ? hitX > 0.5 ? hitY > 0.5 ? 3 : 1 : hitY > 0.5 ? 2 : 0 : -1;
		case WEST:
			return hitX == 0 ? hitY > 0.5 ? hitZ < 0.5 ? 2 : 3 : hitZ > 0.5 ? 0 : 1 : -1;
		default:
			return 0;
		}
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {

		TileEntity te = worldIn.getTileEntity(pos);

		if(te instanceof TE_Shelf){
			IItemHandler invHandler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

			for(int i = 0; i < 4; i++){
				ItemStack stack = invHandler.extractItem(i, 64, false);
				while(!stack.isEmpty()){
					InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
					stack = invHandler.extractItem(i, 64, false);
				}
	        }
		}

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TE_Shelf();
    }
}
