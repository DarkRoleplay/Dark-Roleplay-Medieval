package net.dark_roleplay.medieval.mess.common.objects.blocks.building;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ObsidianGlass extends Block{

	public ObsidianGlass(String registryName) {
		super(Material.ROCK);
		this.setResistance(4000);
		this.setHardness(4F);
		this.setHarvestLevel("pickaxe", 3);
		this.setLightOpacity(6);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setSoundType(SoundType.STONE);
		
	}

	@Override
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer(){
        return BlockRenderLayer.TRANSLUCENT;
    }
	
	@Override
	public boolean isFullCube(IBlockState state){
        return false;
    }
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
        return false;
    }

    @Override
	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side){
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();

        if (block == this)
			return false;

        return true; 
    }
}
