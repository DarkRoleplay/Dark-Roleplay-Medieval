package net.drpmedieval.common.blocks.craftingstations;

import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.blocks.templates.DRPMedievalMaterials;
import net.drpmedieval.common.blocks.tileentitys.TileEntityGrindstone;
import net.drpmedieval.common.blocks.tileentitys.TileEntityHangingCauldron;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class HangingCauldron extends BlockContainer{

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public HangingCauldron() {
		super(DRPMedievalMaterials.iron);
		this.setBlockBounds(0.0625F,0F,0.0625F,0.9375F,0.75F,0.9375F);
		this.setUnlocalizedName("blockHangingCauldron");
		this.setStepSound(Block.soundTypeMetal);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
	}

	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
		if(!worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP,true) && !worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock().equals(DRPMedievalBlocks.hook)) return Blocks.air.getDefaultState();
		EntityPlayer entity =  (EntityPlayer) placer;
		if(entity!=null){
			int dir = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			switch(dir){
			case 0:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
			case 1:
				return this.getDefaultState().withProperty(FACING, EnumFacing.EAST);
			case 2:
				return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
			case 3:
				return this.getDefaultState().withProperty(FACING, EnumFacing.WEST);
			default:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
			}
		}
		return Blocks.air.getDefaultState();
    }
	
	public IBlockState getStateFromMeta(int meta)
    {
		switch(meta){
			case 0:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
			case 1:
				return this.getDefaultState().withProperty(FACING, EnumFacing.EAST);
			case 2:
				return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
			case 3:
				return this.getDefaultState().withProperty(FACING, EnumFacing.WEST);
			default:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
		}
    }

    public int getMetaFromState(IBlockState state)
    {
    	EnumFacing facing = (EnumFacing) state.getValue(FACING);
    	if(facing.equals(EnumFacing.NORTH)) return 0;
    	if(facing.equals(EnumFacing.EAST)) return 1;
    	if(facing.equals(EnumFacing.SOUTH)) return 2;
    	if(facing.equals(EnumFacing.WEST)) return 3;
    	return 0;
    }
	
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING});
    }
    
	@Override
	public boolean isFullCube()
    {
        return false;
    }
    
    public boolean isSolidFullCube()
    {
        return false;
    }
    
    public boolean isOpaqueCube()
	{
		return false;
	}
	
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
        return 	worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP,true) || worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock().equals(DRPMedievalBlocks.hook);

    }
    
    public boolean isSideSolid(IBlockAccess world, BlockPos pos, EnumFacing side)
    {
    	return false;
    }
    
    //TODO 
    public int getRenderType() {
		return -1;
	}
    
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityHangingCauldron();
	}
}

