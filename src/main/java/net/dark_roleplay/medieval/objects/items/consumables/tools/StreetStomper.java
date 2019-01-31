package net.dark_roleplay.medieval.objects.items.consumables.tools;

import net.dark_roleplay.library_old.items.DRPItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StreetStomper extends DRPItem {

	public StreetStomper(String name, String itemFolder, int stackSize, int damage, String... subNames) {
		super(name, itemFolder, stackSize, subNames);
		this.setMaxDamage(damage);
	}

	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack itemstack = player.getHeldItem(hand);

		if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack)) {
			return EnumActionResult.FAIL;
		} else {
			IBlockState iblockstate = world.getBlockState(pos);
			Block block = iblockstate.getBlock();

			if (facing != EnumFacing.DOWN && world.getBlockState(pos.up()).getMaterial() == Material.AIR && block == Blocks.GRASS) {
				IBlockState iblockstate1 = Blocks.GRASS_PATH.getDefaultState();
				world.playSound(player, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);

				if (!world.isRemote) {
					world.setBlockState(pos, iblockstate1, 11);
					itemstack.damageItem(1, player);
				}

				return EnumActionResult.SUCCESS;
			} else {
				return EnumActionResult.PASS;
			}
		}
	}

}
