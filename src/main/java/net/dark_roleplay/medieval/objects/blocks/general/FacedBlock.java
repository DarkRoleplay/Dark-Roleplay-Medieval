package net.dark_roleplay.medieval.objects.blocks.general;

import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.FACING_HORIZONTAL;

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

public class FacedBlock extends DRPBlock{

	public FacedBlock (String name, BlockSettings settings) {
		super(name, settings);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.byHorizontalIndex(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING_HORIZONTAL).getHorizontalIndex();
	}

	@Override
    public IBlockState withRotation(IBlockState state, Rotation rot){
		EnumFacing facing = state.getValue(FACING_HORIZONTAL);
		switch(rot) {
			case CLOCKWISE_180:
				facing = facing.rotateY().rotateY();
				break;
			case CLOCKWISE_90:
				facing = facing.rotateY();
				break;
			case COUNTERCLOCKWISE_90:
				facing = facing.rotateYCCW();
				break;
			case NONE:
				break;
			default:
				break;
		}
        return state.withProperty(FACING_HORIZONTAL, facing);
    }

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirror) {
		EnumFacing facing = state.getValue(FACING_HORIZONTAL);
		switch(mirror) {
			case FRONT_BACK:
				if(facing == EnumFacing.EAST || facing == EnumFacing.WEST)
				facing = facing.getOpposite();
				break;
			case LEFT_RIGHT:
				if(facing == EnumFacing.SOUTH || facing == EnumFacing.NORTH)
					facing = facing.getOpposite();
			case NONE:
			default:
				break;
		}
        return state.withProperty(FACING_HORIZONTAL, facing);
    }


	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING_HORIZONTAL});
	}

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING_HORIZONTAL, placer.getHorizontalFacing().getOpposite());
    }
}
