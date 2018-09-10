package net.dark_roleplay.medieval.mess.common.objects.blocks.building;

import java.util.Random;

import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DryClayGrass extends Block{

    public static final PropertyBool SNOWY = PropertyBool.create("snowy");

    public DryClayGrass(String name){
        super(Material.GRASS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(SNOWY, Boolean.valueOf(false)));
	    this.setRegistryName(name);
	    this.setUnlocalizedName(name);
	    this.setCreativeTab(DRPMedievalCreativeTabs.BUILDING_MATS);
	    this.setHardness(0.6F);
	    this.setSoundType(SoundType.GROUND);
        this.setTickRandomly(true);
	    this.setHarvestLevel("shovel", -1);
    }
	
    @Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
    	return DRPMedievalItems.DRY_CLAY_CHUNK;
    }

    @Override
	public int quantityDropped(Random random){
        return 3 + random.nextInt(2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer(){
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return 0;
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {SNOWY});
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos){
        Block block = world.getBlockState(pos.up()).getBlock();
        return state.withProperty(SNOWY, Boolean.valueOf(block == Blocks.SNOW || block == Blocks.SNOW_LAYER));
    }
    
    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand){
        if (!world.isRemote){
            if (world.getLightFromNeighbors(pos.up()) < 4 && world.getBlockState(pos.up()).getLightOpacity(world, pos.up()) > 2){
                world.setBlockState(pos, DRPMedievalBlocks.DRY_CLAY.getDefaultState());
            }else{
                if (world.getLightFromNeighbors(pos.up()) >= 9) {
                    for (int i = 0; i < 2; ++i){
                        BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                        if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !world.isBlockLoaded(blockpos)) {
                            return;
                        }

                        IBlockState iblockstate = world.getBlockState(blockpos.up());
                        IBlockState iblockstate1 = world.getBlockState(blockpos);

                        if (iblockstate1.getBlock() == DRPMedievalBlocks.DRY_CLAY && world.getLightFromNeighbors(blockpos.up()) >= 4 && iblockstate.getLightOpacity(world, pos.up()) <= 2){
                            world.setBlockState(blockpos, this.getDefaultState());
                        }
                    }
                }
            }
        }
    }    

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable){
    	return plantable instanceof BlockBush;
    }
}
