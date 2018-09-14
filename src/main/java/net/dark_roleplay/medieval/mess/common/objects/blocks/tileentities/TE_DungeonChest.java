package net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;

import net.dark_roleplay.core.api.storage.DynamicStorageTileEntity;
import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.References;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.animation.Animation;
import net.minecraftforge.common.animation.Event;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.animation.TimeValues.VariableValue;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.model.animation.CapabilityAnimation;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;

public class TE_DungeonChest extends DynamicStorageTileEntity {

	private boolean isOpen = false;

	@Nullable
	public final IAnimationStateMachine asm;
	public final VariableValue clickTime = new VariableValue(Float.NEGATIVE_INFINITY);

	public TE_DungeonChest() {
		super(27);
		asm = DarkRoleplayMedieval.proxy.load(
				new ResourceLocation(References.MODID, "asms/block/simple_chest_top.json"),
				ImmutableMap.<String, ITimeValue>of("click_time", clickTime));
	}

	public void handleEvents(float time, Iterable<Event> pastEvents) {}

	@Override
	public boolean hasFastRenderer() {
		return true;
	}

	public boolean isOpen() {
		return this.isOpen;
	}

	public void click() {
		this.isOpen = !this.isOpen;
		if (world.isRemote) {
			if (asm.currentState().equals("closed")) {
				clickTime.setValue(Animation.getWorldTime(getWorld()));
				asm.transition("opening");
			} else if (asm.currentState().equals("open")) {
				clickTime.setValue(Animation.getWorldTime(getWorld()));
				asm.transition("closing");
			}
		}
	}

	@Override
	public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing side) {
		if (capability == CapabilityAnimation.ANIMATION_CAPABILITY) {
			return true;
		}
		return super.hasCapability(capability, side);
	}

	@Override
	@Nullable
	public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing side) {
		if (capability == CapabilityAnimation.ANIMATION_CAPABILITY) {
			return CapabilityAnimation.ANIMATION_CAPABILITY.cast(asm);
		}
		return super.getCapability(capability, side);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt = super.writeToNBT(nbt);
		
		nbt.setBoolean("isOpen", this.isOpen);
		
		return nbt;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		if(compound.hasKey("inventoryMain")) {
			super.readFromNBT(compound);
		}else {//Old Format, Update
			
			NBTTagList newItems = new NBTTagList();

			NBTTagList list = compound.getTagList("inventory", 10);
			for (int i = 0; i < list.tagCount(); i++) {
				NBTTagCompound tag = list.getCompoundTagAt(i);
				byte b = tag.getByte("slot");
				
				NBTTagCompound itemTag = new NBTTagCompound();
				itemTag.setInteger("Slot", b);
				new ItemStack(tag).writeToNBT(itemTag);
			}
			
			NBTTagCompound newInventory = new NBTTagCompound();
			newInventory.setTag("Items", newItems);
			newInventory.setInteger("Size", 27);
			compound.setTag("inventoryMain", newInventory);
		    
		    super.readFromNBT(compound);
		}

		this.isOpen = compound.hasKey("isOpen") ? compound.getBoolean("isOpen") : false;
		if (DarkRoleplayMedieval.SIDE.isClient() && this.isOpen) {
			this.asm.transition("open");
		}
	}
}
