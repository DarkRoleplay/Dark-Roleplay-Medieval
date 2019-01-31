package net.dark_roleplay.medieval.objects.blocks.decoration.barrels.behaviors;

import net.dark_roleplay.library.experimental.blocks.behaviors.IActivatedBehavior;
import net.dark_roleplay.library.experimental.blocks.behaviors.IRainTickBehavior;
import net.dark_roleplay.medieval.objects.blocks.decoration.barrels.TileEntityFluidBarrel;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

public class Behavior_FluidFill implements IActivatedBehavior, IRainTickBehavior{
	
	@Override
	public boolean execute(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!world.isRemote){
			TileEntity tileentity = world.getTileEntity(pos);
			if(tileentity instanceof TileEntityFluidBarrel){
				FluidTank fluid = (FluidTank) tileentity.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null);
				if(player.getHeldItem(hand).hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)) {					
					
					FluidActionResult result = FluidUtil.tryEmptyContainer(player.getHeldItem(hand), fluid, 16000, player, true);
					if(result.isSuccess()) {
						if(!player.capabilities.isCreativeMode)
							player.setHeldItem(hand, result.getResult());
					}else {
						result = FluidUtil.tryFillContainer(player.getHeldItem(hand), fluid, 16000, player, true);
						if(result.isSuccess()) {
							if(!player.capabilities.isCreativeMode)
								player.setHeldItem(hand, result.getResult());
							
						}
					}
					
					if(fluid.getFluid().getFluid().getTemperature() > 500) {
						world.destroyBlock(pos, false);
						FluidUtil.tryPlaceFluid(player, world, pos, fluid, fluid.getFluid());
					}

					return true;
				}
			}
		}else {
			return player.getHeldItem(hand).hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);			
		}
		
		return false;
	}

	@Override
	public void execute(World world, BlockPos pos) {
		if(!world.isRemote){
			TileEntity tileentity = world.getTileEntity(pos);
			if(tileentity instanceof TileEntityFluidBarrel){
				FluidTank fluid = (FluidTank) tileentity.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null);
				fluid.fill(FluidRegistry.getFluidStack("water", 250), true);
			}
		}
	}
}
