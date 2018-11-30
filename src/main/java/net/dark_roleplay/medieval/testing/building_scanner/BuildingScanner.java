package net.dark_roleplay.medieval.testing.building_scanner;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BuildingScanner extends Block{

	public BuildingScanner() {
		super(Material.ANVIL);
		this.setRegistryName("building_scanner");
	}

	@Override
	public boolean hasTileEntity(IBlockState state){
        return true;
    }

    @Override
	@Nullable
    public TileEntity createTileEntity(World world, IBlockState state){
    	return new TE_BuildingScanner();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
    	TE_BuildingScanner scan = (TE_BuildingScanner) worldIn.getTileEntity(pos);
    	scan.activate();
        return true;
    }
}
