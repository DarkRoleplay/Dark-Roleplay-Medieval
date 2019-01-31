package net.dark_roleplay.medieval.common.objects.blocks.old;

import java.util.Random;

import net.dark_roleplay.medieval.holders.MedievalBlocks;
import net.dark_roleplay.medieval.holders.MedievalItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Hops extends Block {

	//0-3 Growing till fully grown, 4-7  fruit levels
	public static PropertyInteger AGE = PropertyInteger.create("age", 0, 7);

	public Hops(String registryName) {
		super(Material.PLANTS);
		this.setRegistryName(registryName);
		this.setTranslationKey(registryName);
		this.setTickRandomly(true);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {AGE});
	}

	public boolean canGrow(IBlockState state) {
		return state.getValue(AGE).intValue() < 7 ? true : false;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AGE, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(AGE).intValue();
	}

	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer(){
        return BlockRenderLayer.CUTOUT;
    }

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return Item.getItemFromBlock(MedievalBlocks.ROPE);
    }

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.375F, 0F, 0.375F,  0.625F, 1F, 0.625F);
	}

	@Override
	public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
		return true;
	}

//	public boolean canPlaceBlockAt(World worldIn, BlockPos pos){
//        IBlockState soil = worldIn.getBlockState(pos.down());
//        return super.canPlaceBlockAt(worldIn, pos) && soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
//    }

	protected boolean canSustainBush(IBlockState state){
        return state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.FARMLAND;
    }

	// -------------------------------------------------- Block Events --------------------------------------------------

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			if(7 == state.getValue(AGE).intValue()){
				world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(MedievalItems.HOPS, 1)));
				world.setBlockState(pos, state.withProperty(AGE, 4));
			}
		}
		return true;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		super.updateTick(worldIn, pos, state, rand);

		int i = state.getValue(AGE).intValue();

		if(this.canGrow(state)){
			if((i < 4 && rand.nextInt(10) == 0) || (i >= 4 && rand.nextInt(5) == 0)){
				if(state.getValue(AGE).intValue() == 3){
					if(worldIn.getBlockState(pos.up()).getBlock() == MedievalBlocks.ROPE){
						worldIn.setBlockState(pos.up(), state.withProperty(AGE, 0), 2);
					}
				}
				worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i + 1)), 2);
			}
		}
	}
}