package net.dark_roleplay.medieval.mess.common.handler;

import net.dark_roleplay.core.api.old.crafting.Crafting_Util;
import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.library.experimental.blocks.behaviors.IActivatedBehavior;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBehaviours {

	public static final BlockSettings SHINGLES = new BlockSettings(Material.ROCK, MapColor.BROWN_STAINED_HARDENED_CLAY, SoundType.STONE, 1.0F, 1.0F);
	
	public static final BlockSettings WOOD_DEFAULT = new BlockSettings(Material.WOOD, MapColor.BROWN_STAINED_HARDENED_CLAY, SoundType.WOOD, 1.0F, 1.0F);
	
	
	public static final IActivatedBehavior CRAFTING_STATION = new IActivatedBehavior() {
		@Override
		public boolean execute(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
			if(world.isRemote)
				Crafting_Util.openRecipeSelection(state.getBlock());
			return true;
		}
	};
	
}
