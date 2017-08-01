package net.dark_roleplay.medieval.common.blocks.other;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BeeHive extends Block{
	
	public BeeHive(String registryName) {
		super(Material.CLAY);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setSoundType(SoundType.GROUND);
	}
	
	// -------------------------------------------------- Block Data --------------------------------------------------
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return new AxisAlignedBB(0.1875F, 0F, 0.1875F, 0.8125F, 0.625F, 0.8125F);
    }
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
}