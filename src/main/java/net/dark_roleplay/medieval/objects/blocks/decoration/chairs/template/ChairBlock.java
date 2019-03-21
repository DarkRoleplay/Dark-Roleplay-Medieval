package net.dark_roleplay.medieval.objects.blocks.decoration.chairs.template;

import net.dark_roleplay.medieval.objects.blocks.templates.HorizontalBlock;
import net.dark_roleplay.medieval.util.sitting.SittingUtil;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class ChairBlock extends HorizontalBlock {

	public ChairBlock(Properties properties) {
		super(properties);
		
	}
	
	@Override
	public IBlockState updatePostPlacement(IBlockState state, EnumFacing facing, IBlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
		if (facing != EnumFacing.DOWN)
			return state;
		if (facingState.getBlockFaceShape(world, facingPos, EnumFacing.UP) != BlockFaceShape.SOLID)
			return Blocks.AIR.getDefaultState();
		return state;
	}
	
	@Override
	public boolean onBlockActivated(IBlockState state, World world, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(player.getDistance(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) < 3) {
			SittingUtil.sitOnBlockWithRotation(world, pos.getX(), pos.getY(), pos.getZ(), player, state.get(HORIZONTAL_FACING), 0.2F);
		}else {
			player.sendStatusMessage(new TextComponentTranslation("interaction.drpmedieval.chair.to_far", state.getBlock().getNameTextComponent().getFormattedText()), true);
		}
		return true;
	}
}
