package net.dark_roleplay.medieval.objects.blocks.general;

import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.*;

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

public class PillarBlock extends DRPBlock{

	public PillarBlock (String name, BlockSettings settings) {
		super(name, settings);
	}
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AXIS, meta == 0 ? EnumFacing.Axis.X : meta == 1 ? EnumFacing.Axis.Z : EnumFacing.Axis.Y);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(AXIS) == EnumFacing.Axis.X ? 0 : state.getValue(AXIS) == EnumFacing.Axis.Z ?  1 : 2;
	}

	@Override
    public IBlockState withRotation(IBlockState state, Rotation rot){
		EnumFacing.Axis axis = state.getValue(AXIS);
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
        return state.withProperty(AXIS, axis);
    }
	
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirror) {
        return state;
    }

	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {AXIS});
	}

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){	
        return this.getDefaultState().withProperty(AXIS, facing.getAxis());
    }
}
