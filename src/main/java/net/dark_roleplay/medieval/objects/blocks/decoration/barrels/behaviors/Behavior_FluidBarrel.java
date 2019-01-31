package net.dark_roleplay.medieval.objects.blocks.decoration.barrels.behaviors;

import net.dark_roleplay.core_modules.maarg.api.materials.Material;
import net.dark_roleplay.library.experimental.blocks.behaviors.IActivatedBehavior;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

public class Behavior_FluidBarrel implements IActivatedBehavior {

	private String key = "";

	public Behavior_FluidBarrel(String key, Material mat) {
		this.key = mat.getNamed(key);
	}

	@Override
	public boolean execute(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack stack = player.getHeldItem(hand);
		if(!stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)) return false;



		world.setBlockState(pos, Block.getBlockFromName(this.key).getDefaultState());
		return true;
	}

}
