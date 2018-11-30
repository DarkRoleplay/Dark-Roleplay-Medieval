package net.dark_roleplay.medieval.common.objects.items;

import net.dark_roleplay.medieval.common.handler.MedievalModels;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMultiBlock extends ItemBlock{

	public ItemMultiBlock(Block block) {
		super(block);
		MedievalModels.addItemToRegisterMesh(this);
	}

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
}
