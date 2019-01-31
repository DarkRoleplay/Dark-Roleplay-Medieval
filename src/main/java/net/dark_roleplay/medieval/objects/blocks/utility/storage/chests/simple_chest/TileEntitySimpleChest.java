package net.dark_roleplay.medieval.objects.blocks.utility.storage.chests.simple_chest;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;

import net.dark_roleplay.core.api.storage.DynamicStorageTileEntity;
import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.holders.MedievalBlockProperties;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.animation.Animation;
import net.minecraftforge.common.animation.Event;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.animation.TimeValues.VariableValue;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.model.animation.CapabilityAnimation;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;

public class TileEntitySimpleChest extends DynamicStorageTileEntity {

	@Nullable
	public final IAnimationStateMachine asm;
	public final VariableValue clickTime = new VariableValue(Float.NEGATIVE_INFINITY);

	public TileEntitySimpleChest() {
		super(27);
		this.asm = DarkRoleplayMedieval.proxy.load(
				new ResourceLocation(References.MODID, "asms/block/simple_chest_top.json"),
				ImmutableMap.<String, ITimeValue>of("click_time", this.clickTime));
	}

	public void handleEvents(float time, Iterable<Event> pastEvents) {}

	@Override
	public boolean hasFastRenderer() {
		return true;
	}

	public void goToAnimation(String stage) {
		if(!this.asm.currentState().equals("opening") && !this.asm.currentState().equals("closing"))
			this.clickTime.setValue(Animation.getWorldTime(this.getWorld()));
		this.asm.transition(stage);
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
			return CapabilityAnimation.ANIMATION_CAPABILITY.cast(this.asm);
		}
		return super.getCapability(capability, side);
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
        return oldState.getBlock() != newSate.getBlock();
    }


	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt = super.writeToNBT(nbt);

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

		if(this.hasWorld() && this.getWorld().getBlockState(this.pos).getBlock() instanceof SimpleChest) {
			if(this.getWorld().getBlockState(this.pos).getValue(MedievalBlockProperties.IS_OPEN)) {
				this.goToAnimation("open");
			}
		}
	}
}
