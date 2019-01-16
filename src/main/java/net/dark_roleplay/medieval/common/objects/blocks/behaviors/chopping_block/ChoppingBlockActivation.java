package net.dark_roleplay.medieval.common.objects.blocks.behaviors.chopping_block;

import java.util.HashMap;

import net.dark_roleplay.library.experimental.blocks.behaviors.IActivatedBehavior;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_ChoppingBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class ChoppingBlockActivation implements IActivatedBehavior{

	public static HashMap<ItemStack, ItemStack> firewoodRecipes;

	@Override
	public boolean execute(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!world.isRemote){
			ItemStack stack = player.getHeldItem(hand);
			if(!stack.getItem().getRegistryName().toString().contains("log") && !stack.getItem().getToolClasses(stack).contains("axe")) return false;

			TileEntity te = world.getTileEntity(pos);
			if(te != null && te instanceof TE_ChoppingBlock) {
				TE_ChoppingBlock teCB = (TE_ChoppingBlock) te;
				IItemHandlerModifiable items = (IItemHandlerModifiable) te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

				if(items.getStackInSlot(0).isEmpty()) {
					player.sendStatusMessage(new TextComponentTranslation("drpmedieval.blocks.chopping_block.no_logs"), true);
				}

				if(stack.getItem().getRegistryName().toString().contains("log")) {
					ItemStack old = items.getStackInSlot(0);
					if(!old.isEmpty()) {
						world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY() + 1, pos.getZ(), old));
					}
					items.setStackInSlot(0, stack);
					player.setHeldItem(hand, ItemStack.EMPTY);
				}else {
					if(items.getStackInSlot(0).getCount() > 0) {
						teCB.progress(50);
					}
				}
			}

//			player.openGui(DarkRoleplayMedieval.INSTANCE, MedievalGuis.GUI_CHOPPING_BLOCK, world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
}
