package net.drpmedieval.common.items.blocks;

import net.drpmedieval.common.blocks.helper.AdvancedBed;
import net.drpmedieval.common.blocks.helper.EnumMattressType;
import net.drpmedieval.common.handler.DRPMedievalBlocks;
import net.drpmedieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AdvancedBedItem extends Item{

	Block bed = null;
	
	public AdvancedBedItem(String registryName,String unlocalizedName){
		super();
		this.setRegistryName(registryName);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
    }
	
	public void setBed(Block bed){
		this.bed = bed;
	}
	
	public Block getBed(){
		return this.bed;
	}
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return EnumActionResult.SUCCESS;
        }
        else if (facing != EnumFacing.UP)
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();
            boolean flag = block.isReplaceable(worldIn, pos);

            if (!flag)
            {
                pos = pos.up();
            }

            int i = MathHelper.floor((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
            EnumFacing enumfacing = EnumFacing.getHorizontal(i);
            BlockPos blockpos = pos.offset(enumfacing);

            if (player.canPlayerEdit(pos, facing, player.getHeldItem(hand)) && player.canPlayerEdit(blockpos, facing, player.getHeldItem(hand)))
            {
                boolean flag1 = worldIn.getBlockState(blockpos).getBlock().isReplaceable(worldIn, blockpos);
                boolean flag2 = flag || worldIn.isAirBlock(pos);
                boolean flag3 = flag1 || worldIn.isAirBlock(blockpos);

                if (flag2 && flag3 && worldIn.getBlockState(pos.down()).isSideSolid(worldIn, blockpos, EnumFacing.UP) && worldIn.getBlockState(blockpos.down()).isSideSolid(worldIn, blockpos, EnumFacing.UP))
                {
                	if(this.getBed() != null){
                		IBlockState iblockstate1 = this.getBed().getDefaultState().withProperty(BlockBed.OCCUPIED, Boolean.valueOf(false)).withProperty(BlockBed.FACING, enumfacing).withProperty(AdvancedBed.PART, BlockBed.EnumPartType.FOOT).withProperty(AdvancedBed.MATTRESS, EnumMattressType.NONE);

	                    if (worldIn.setBlockState(pos, iblockstate1, 11))
	                    {
	                        IBlockState iblockstate2 = iblockstate1.withProperty(BlockBed.PART, BlockBed.EnumPartType.HEAD);
	                        worldIn.setBlockState(blockpos, iblockstate2, 11);
	                    }
	
	                    SoundType soundtype = iblockstate1.getBlock().getSoundType();
	                    worldIn.playSound((EntityPlayer)null, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
	                    player.getHeldItem(hand).shrink(1);;
                	}else{
                		 System.out.println("MISSSING BED");
                	}
                    return EnumActionResult.SUCCESS;
                }
                else
                {
                    return EnumActionResult.FAIL;
                }
            }
            else
            {
                return EnumActionResult.FAIL;
            }
        }
    }
	
}
