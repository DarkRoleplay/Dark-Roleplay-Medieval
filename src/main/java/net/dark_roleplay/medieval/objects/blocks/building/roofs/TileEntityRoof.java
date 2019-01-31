package net.dark_roleplay.medieval.objects.blocks.building.roofs;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityRoof extends TileEntity{

	@Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate){
        return oldState.getBlock() != newSate.getBlock();
    }

}
