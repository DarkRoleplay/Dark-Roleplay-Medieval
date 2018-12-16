package net.dark_roleplay.medieval.common.objects.blocks.old;


import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.FACING_HORIZONTAL;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.common.objects.blocks.blocks.FacedBlock;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_Shelf;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class Shelf extends FacedBlock{

	public Shelf(String name, BlockSettings settings) {
		super(name, settings);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		int slot = this.getSlotClicked(state, hitX, hitY, hitZ);
		System.out.println(String.format("%f : %f : %f, %d", hitX, hitY, hitZ, slot));
		if(slot == -1)
			return false;
		if(!world.isRemote){
			TileEntity tileentity = world.getTileEntity(pos);
			if(tileentity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)){

				IItemHandler invHandler = tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
				if(player.isSneaking() && player.getHeldItem(hand).isEmpty())
					player.setHeldItem(hand, invHandler.extractItem(slot, 64, false));
				else player.setHeldItem(hand, invHandler.insertItem(slot, player.getHeldItem(hand), false));
			}
		}
		return true;
	}

	protected int getSlotClicked(IBlockState state, float hitX, float hitY, float hitZ){
		switch(state.getValue(FACING_HORIZONTAL)){
		case EAST:
			return hitX > 0 ? hitY > 0.5 ? hitZ < 0.5 ? 2 : 3 : hitZ > 0.5 ? 0 : 1 : -1;
		case NORTH:
			return hitZ < 1 ? hitX > 0.5 ? hitY > 0.5 ? 2 : 0 : hitY > 0.5 ? 3 : 1 : -1;
		case SOUTH:
			return hitZ > 0 ? hitX > 0.5 ? hitY > 0.5 ? 3 : 1 : hitY > 0.5 ? 2 : 0 : -1;
		case WEST:
			return hitX < 1 ? hitY > 0.5 ? hitZ < 0.5 ? 2 : 3 : hitZ > 0.5 ? 0 : 1 : -1;
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
}
