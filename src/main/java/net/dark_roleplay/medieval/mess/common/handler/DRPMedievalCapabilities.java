package net.dark_roleplay.medieval.mess.common.handler;

import net.dark_roleplay.medieval.mess.api.storage.LockStackHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class DRPMedievalCapabilities {

	@CapabilityInject(LockStackHandler.class)
	public static Capability<LockStackHandler> LOCK_HANDLER_CAPABILITY = null;

	public static void register() {
		CapabilityManager.INSTANCE.register(LockStackHandler.class, new Capability.IStorage<LockStackHandler>() {
			@Override
			public NBTBase writeNBT(Capability<LockStackHandler> capability, LockStackHandler instance, EnumFacing side) {
				return instance.serializeNBT();
			}

			@Override
			public void readNBT(Capability<LockStackHandler> capability, LockStackHandler instance, EnumFacing side, NBTBase base) {
				instance.deserializeNBT((NBTTagCompound) base);
			}
		}, LockStackHandler::new);
	}

}
