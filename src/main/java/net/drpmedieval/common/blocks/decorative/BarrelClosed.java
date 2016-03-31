package net.drpmedieval.common.blocks.decorative;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BarrelClosed extends Block{

	public BarrelClosed() {
		super(Material.wood);
		this.setBlockBounds(0F,0F,0F,1F,1F,1F);
		this.setUnlocalizedName("blockBarrelClosed");
		this.setStepSound(Block.soundTypeWood);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
	}

	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
		if(facing.equals(facing.UP) && worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true)) return this.getDefaultState();
		else return Blocks.air.getDefaultState();
    }
	
	@Override
	public boolean isFullCube()
    {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube()
	{
		return false;
	}
	
    //Ground Blocks
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        if (!this.canBlockStay(worldIn, pos, EnumFacing.UP))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }
        super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
    }
    
    protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing)
    {
        return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true);
    }
    
    public boolean isSideSolid(IBlockAccess world, BlockPos pos, EnumFacing side)
    {
    	if(side.equals(EnumFacing.UP)) return true;
    	else return false;
    }
}