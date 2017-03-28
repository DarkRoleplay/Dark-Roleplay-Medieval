package net.drpmedieval.common.blocks.rotary;

import net.drpmedieval.common.blocks.WoodHelper;
import net.drpmedieval.common.blocks.WoodHelper.WoodType;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Axle extends Block{

	public static final int ROTATE_NONE = 0;
	public static final int ROTATE_LEFT = 1;
	public static final int ROTATE_RIGHT = 2;
	
    public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.<EnumFacing.Axis>create("axis", EnumFacing.Axis.class);
    public static final PropertyInteger ROTATING = PropertyInteger.create("rotating", 0, 2); // 0 = none, 1 = left; 2 = right;

    public Axle(String registryName) {
	    super(Material.WOOD);
	    this.setRegistryName(registryName);
	    this.setUnlocalizedName(registryName);
	    this.setCreativeTab(DRPMedievalCreativeTabs.BUILDING_MATS);
	    this.setHardness(2.0F);
	    this.setSoundType(SoundType.WOOD);
    }	
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		int rotating = 0;
		if(meta >= 6){
			rotating = 2;
			meta -= 6;
		}else if(meta >= 3){
			rotating = 1;
			meta -= 3;
		}
		
		switch(meta){
		case ROTATE_NONE:
			return this.getDefaultState().withProperty(AXIS, EnumFacing.Axis.X).withProperty(ROTATING, rotating);
		case ROTATE_LEFT:
			return this.getDefaultState().withProperty(AXIS, EnumFacing.Axis.Y).withProperty(ROTATING, rotating);
		case ROTATE_RIGHT:
			return this.getDefaultState().withProperty(AXIS, EnumFacing.Axis.Z).withProperty(ROTATING, rotating);
		}
		
		return null;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int value = 0;
		
		switch(state.getValue(AXIS)){
		case X:
			value = 0;
			break;
		case Y:
			value = 1;
			break;
		case Z:
			value = 2;
			break;
		default:
			break;
		}
		
		switch(state.getValue(ROTATING)){
		case 0:
			break;
		case 1:
			value += 3;
			break;
		case 2:
			value += 6;
			break;
		}
		
		
		return value;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { AXIS, ROTATING});
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos){
		if(!world.isRemote){
			IBlockState source = world.getBlockState(fromPos);
			if(source.getBlock() == this){
				if(source.getValue(AXIS) == state.getValue(AXIS)){
					switch(source.getValue(AXIS)){
					case X:
						if(pos.west() == fromPos || pos.east() == fromPos)
							world.setBlockState(fromPos, source.withProperty(ROTATING, state.getValue(ROTATING)));
						break;
					case Y:
						if(pos.up() == fromPos || pos.down() == fromPos)
							world.setBlockState(fromPos, source.withProperty(ROTATING, state.getValue(ROTATING)));
						break;
					case Z:
						if(pos.north() == fromPos || pos.south() == fromPos)
							world.setBlockState(fromPos, source.withProperty(ROTATING, state.getValue(ROTATING)));
						break;
					default:
						break;
					}
				}
			}
		}
    }
}
