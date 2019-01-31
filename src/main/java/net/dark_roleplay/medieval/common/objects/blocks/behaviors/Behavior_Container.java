package net.dark_roleplay.medieval.common.objects.blocks.behaviors;

import net.dark_roleplay.core.api.storage.DynamicStorageTileEntity;
import net.dark_roleplay.library.experimental.blocks.behaviors.IActivatedBehavior;
import net.dark_roleplay.library.experimental.blocks.behaviors.IBreakingBehavior;
import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.holders.MedievalGuis;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class Behavior_Container implements IBreakingBehavior, IActivatedBehavior {

	@Override
	public void execute(World world, BlockPos pos, IBlockState state) {
		TileEntity tileEntity = world.getTileEntity(pos);

		if (tileEntity instanceof DynamicStorageTileEntity) {
			DynamicStorageTileEntity tileentityChest = (DynamicStorageTileEntity) tileEntity;
			ItemStackHandler handler = (ItemStackHandler) tileentityChest.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

			EntityItem entityItem;
			for (int i = 0; i < handler.getSlots(); i++) {
				ItemStack stack = handler.getStackInSlot(i);

				if (!stack.isEmpty()) {
					entityItem = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
					entityItem.setDefaultPickupDelay();
					world.spawnEntity(entityItem);
				}
			}
		}

		EntityPlayer p;
		PlayerCapabilities c;
	}

	@Override
	public boolean execute(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {

		TileEntity tileentity = world.getTileEntity(pos);
		if (tileentity instanceof DynamicStorageTileEntity) {
//			DynamicStorageTileEntity chest = (DynamicStorageTileEntity) tileentity;
			if (!world.isRemote) {
				player.openGui(DarkRoleplayMedieval.INSTANCE, MedievalGuis.GUI_GENERAL_STORAGE, world, pos.getX(), pos.getY(), pos.getZ());
			}
		}
		return true;
	}

}
