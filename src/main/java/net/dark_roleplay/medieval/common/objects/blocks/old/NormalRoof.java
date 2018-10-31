package net.dark_roleplay.medieval.common.objects.blocks.old;

import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.FACING_HORIZONTAL;
import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.HAS_TE;
import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.STAIR_TYPE;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.StairType;
import net.dark_roleplay.medieval.common.objects.blocks.blocks.FacedBlock;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_Roof;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class NormalRoof extends FacedBlock{

	public NormalRoof (String name, BlockSettings settings) {
		super(name, settings);
		this.setDefaultState(this.getDefaultState().withProperty(STAIR_TYPE, StairType.STRAIGHT));
		this.setLightOpacity(0);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING_HORIZONTAL, STAIR_TYPE, HAS_TE});
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.byHorizontalIndex(meta % 8)).withProperty(HAS_TE, meta >= 8);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING_HORIZONTAL).getHorizontalIndex() + (state.getValue(HAS_TE) ? 8 : 0);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos){
		EnumFacing facing = state.getValue(FACING_HORIZONTAL);
		IBlockState otherBlock = world.getBlockState(pos.offset(facing));
		IBlockState otherBlock2 = world.getBlockState(pos.offset(facing.getOpposite()));
		if(otherBlock.getBlock() instanceof NormalRoof && otherBlock.getValue(FACING_HORIZONTAL) == facing.rotateY()) {
	        return state.withProperty(STAIR_TYPE, StairType.INNER_LEFT);
		}else if(otherBlock.getBlock() instanceof NormalRoof && otherBlock.getValue(FACING_HORIZONTAL) == facing.rotateYCCW()) {
	        return state.withProperty(STAIR_TYPE, StairType.INNER_RIGHT);
		}else if(otherBlock2.getBlock() instanceof NormalRoof && otherBlock2.getValue(FACING_HORIZONTAL) == facing.rotateY()) {
	        return state.withProperty(STAIR_TYPE, StairType.OUTER_LEFT);
		}else if(otherBlock2.getBlock() instanceof NormalRoof && otherBlock2.getValue(FACING_HORIZONTAL) == facing.rotateYCCW()) {
	        return state.withProperty(STAIR_TYPE, StairType.OUTER_RIGHT);
		}

        return state;
    }

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING_HORIZONTAL, placer.getHorizontalFacing().getOpposite()).withProperty(HAS_TE, worldIn.getBlockState(pos.down()).isFullCube());
    }

    @Override
	@Deprecated
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
    	world.setBlockState(pos, state.withProperty(HAS_TE, world.getBlockState(pos.down()).isFullCube()));
    }

	@Override
	public boolean hasTileEntity(IBlockState state){
        return state.getValue(HAS_TE);
    }

	@Override
	public TileEntity createTileEntity(World world, IBlockState state){
		return new TE_Roof();
    }


}
