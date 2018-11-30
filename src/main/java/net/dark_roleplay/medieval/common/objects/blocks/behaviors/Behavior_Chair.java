package net.dark_roleplay.medieval.common.objects.blocks.behaviors;

import net.dark_roleplay.core.modules.sitting.SittingUtil;
import net.dark_roleplay.library.experimental.blocks.behaviors.IActivatedBehavior;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Behavior_Chair implements IActivatedBehavior{
	private float yOffset = 0.5F;
	
	public Behavior_Chair() {
		this(0.5F);
	}
	
	public Behavior_Chair(float yOffset) {
		this.yOffset = yOffset;
	}
	
	@Override
	public boolean execute(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!world.isRemote){
			boolean result = SittingUtil.sitOnBlock(world, pos.getX(), pos.getY(), pos.getZ(), player, yOffset);
			return result;
		}
		return true;
	}
}
