package net.dark_roleplay.medieval.objects.blocks.decoration.chairs;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.objects.blocks.general.FacedBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class ChairBlock extends FacedBlock{

	private final AxisAlignedBB collisionBox;
	
	public ChairBlock(String name, BlockSettings settings, double height) {
		super(name, settings);
		this.collisionBox = new AxisAlignedBB(0,0,0, 1, height/16, 1);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return collisionBox;
	}

}
