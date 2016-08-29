package net.drpmedieval.common.items.seeds;

import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SeedBarley extends ItemSeeds {

	public SeedBarley() {
		super(DRPMedievalBlocks.barley, Blocks.FARMLAND);
		this.setRegistryName("SeedBarley");
		this.setUnlocalizedName("SeedBarley");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);
        if (facing == EnumFacing.UP && playerIn.canPlayerEdit(pos.offset(facing), facing, stack) && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up()))
        {
            worldIn.setBlockState(pos.up(),  DRPMedievalBlocks.barley.getDefaultState());
            --stack.stackSize;
            return EnumActionResult.SUCCESS;
        }
        else
        {
            return EnumActionResult.FAIL;
        }
    }

	
	 @Override
	 public net.minecraft.block.state.IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos)
	 {
		 return DRPMedievalBlocks.barley.getDefaultState();
	 }

}
