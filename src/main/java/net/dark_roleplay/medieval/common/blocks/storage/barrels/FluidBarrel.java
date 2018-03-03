package net.dark_roleplay.medieval.common.blocks.storage.barrels;

import net.dark_roleplay.medieval.common.blocks.storage.shelf.TE_Shelf;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class FluidBarrel extends Block{

	public FluidBarrel(String name) {
		super(Material.WOOD);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TE_FluidBarrel();
    }
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			TileEntity tileentity = world.getTileEntity(pos);
			if(tileentity instanceof TE_FluidBarrel){
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
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
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
	public void fillWithRain(World world, BlockPos pos){
		if(!world.isRemote){
			TileEntity tileentity = world.getTileEntity(pos);
			if(tileentity instanceof TE_FluidBarrel){
				FluidTank fluid = (FluidTank) tileentity.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null);
				fluid.fill(FluidRegistry.getFluidStack("water", 250), true);
			}
		}
    }
}
