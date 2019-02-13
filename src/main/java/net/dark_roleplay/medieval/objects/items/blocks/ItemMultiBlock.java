package net.dark_roleplay.medieval.objects.items.blocks;

import net.dark_roleplay.medieval.handler.ModelRegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMultiBlock extends ItemBlock{

	protected CreativeTabs creativeTab = null;

	public ItemMultiBlock(Block block) {
		super(block);
		ModelRegistryHandler.addItemToRegisterMesh(this);
	}

	@Override
	@SideOnly(Side.CLIENT)
    public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack stack){
        Block block = worldIn.getBlockState(pos).getBlock();

        if (block == Blocks.SNOW_LAYER && block.isReplaceable(worldIn, pos)){
            side = EnumFacing.UP;
        }else if (!block.isReplaceable(worldIn, pos)){
            pos = pos.offset(side);
        }

        EnumFacing playerFacing = player.getHorizontalFacing().getOpposite();

        return worldIn.mayPlace(this.block, pos, false, side, (Entity)null) && worldIn.getBlockState(pos.offset(playerFacing.rotateYCCW())).getBlock().isReplaceable(worldIn, pos.offset(playerFacing.rotateYCCW()));

    }

	@Override
	public CreativeTabs getCreativeTab(){
        return this.creativeTab;
	}

	@Override
	public Item setCreativeTab(CreativeTabs tab){
        this.creativeTab = tab;
        return this;
    }
}
