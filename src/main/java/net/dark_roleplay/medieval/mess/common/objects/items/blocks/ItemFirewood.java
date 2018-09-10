package net.dark_roleplay.medieval.mess.common.objects.items.blocks;

import net.dark_roleplay.library_old.items.DRPItem;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemFirewood extends DRPItem {

	public ItemFirewood(String name, String itemFolder, int stackSize, String... subNames) {
		super(name, itemFolder, stackSize, subNames);

	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {
		ItemStack held = player.getHeldItem(hand);
		if (held.getItem() == this && held.getCount() >= 16) {

			Block pile = Block.getBlockFromName(this.getRegistryName().toString() + "_pile");

			IBlockState iblockstate = world.getBlockState(pos);
			Block block = iblockstate.getBlock();

			if (!block.isReplaceable(world, pos)) {
				pos = pos.offset(facing);
			}

			ItemStack itemstack = player.getHeldItem(hand);

			if (!itemstack.isEmpty() && player.canPlayerEdit(pos, facing, itemstack) && world.mayPlace(pile, pos, false, facing, (Entity) null)) {
				int i = this.getMetadata(itemstack.getMetadata());
				IBlockState iblockstate1 = pile.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, i, player,
						hand);

				if (placeBlockAt(itemstack, player, world, pos, facing, hitX, hitY, hitZ, iblockstate1)) {
					iblockstate1 = world.getBlockState(pos);
					SoundType soundtype = iblockstate1.getBlock().getSoundType(iblockstate1, world, pos, player);
					world.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS,
							(soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
					itemstack.shrink(16);
				}

				return EnumActionResult.SUCCESS;
			} else {
				return EnumActionResult.FAIL;
			}
		}

		return EnumActionResult.PASS;
	}

	public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, IBlockState newState) {
		if (!world.setBlockState(pos, newState, 11))
			return false;

		if (player instanceof EntityPlayerMP)
			CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) player, pos, stack);

		return true;
	}
	
	@Override
	public int getItemBurnTime(ItemStack itemStack){
        return 800;
    }
}
