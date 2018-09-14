package net.dark_roleplay.medieval.common.objects.blocks.behaviors;

import net.dark_roleplay.library.experimental.blocks.behaviors.IActivatedBehavior;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_FlowerContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Behavior_FlowerContainer implements IActivatedBehavior{

	@Override
	public boolean execute(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(player.getHeldItem(hand).getItem() instanceof ItemBlock) {
			TileEntity te = world.getTileEntity(pos);
			if(!(te instanceof TE_FlowerContainer)) return false;
			
			TE_FlowerContainer flower = (TE_FlowerContainer) te;
			return flower.addFlower(player.getHeldItem(hand).copy(), world.isRemote);
		}
		
        return false;
	}

}
