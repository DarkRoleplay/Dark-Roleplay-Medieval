package net.dark_roleplay.medieval.objects.blocks.general;

import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.AXIS_HORIZONTAL;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.library.experimental.blocks.DRPBlock;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AxisBlock extends DRPBlock{

	public AxisBlock (String name, BlockSettings settings) {
		super(name, settings);
	}
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AXIS_HORIZONTAL, meta == 0 ? EnumFacing.Axis.X : EnumFacing.Axis.Z);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(AXIS_HORIZONTAL) == EnumFacing.Axis.X ? 0 : 1;
	}

	@Override
    public IBlockState withRotation(IBlockState state, Rotation rot){
		EnumFacing.Axis axis = state.getValue(AXIS_HORIZONTAL);
		switch(rot) {
			case CLOCKWISE_90:
			case COUNTERCLOCKWISE_90:
				axis = axis == EnumFacing.Axis.X ? EnumFacing.Axis.Z : EnumFacing.Axis.X;
				break;
			case CLOCKWISE_180:
			case NONE:
			default:
				break;
		}
        return state.withProperty(AXIS_HORIZONTAL, axis);
    }

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirror) {
        return state;
    }

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {AXIS_HORIZONTAL});
	}

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(AXIS_HORIZONTAL, placer.getHorizontalFacing().rotateY().getAxis());
    }
}
