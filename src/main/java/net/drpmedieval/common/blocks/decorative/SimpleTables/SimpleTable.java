package net.drpmedieval.common.blocks.decorative.SimpleTables;

import net.drpmedieval.common.blocks.templates.DRPMedievalMaterials;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SimpleTable extends Block{
	
    public static final PropertyEnum<SimpleTable.EnumTableAxis> TABLE_AXIS = PropertyEnum.<SimpleTable.EnumTableAxis>create("axis", SimpleTable.EnumTableAxis.class);
	
	public SimpleTable(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
		this.setHardness(2F);
		this.setHarvestLevel("axe", 0);
		this.setSoundType(SoundType.WOOD);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		switch (meta) {
			case 0:
				return this.getDefaultState().withProperty(TABLE_AXIS, SimpleTable.EnumTableAxis.X);
			case 1:
				return this.getDefaultState().withProperty(TABLE_AXIS, SimpleTable.EnumTableAxis.Z);
			default:
				return this.getDefaultState().withProperty(TABLE_AXIS, SimpleTable.EnumTableAxis.X);
		}
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {

		SimpleTable.EnumTableAxis facing = (SimpleTable.EnumTableAxis) state.getValue(TABLE_AXIS);
		if(facing.equals(SimpleTable.EnumTableAxis.X)) return 0;
		if(facing.equals(SimpleTable.EnumTableAxis.Z)) return 1;

		return 0;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {TABLE_AXIS});
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
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		switch(placer.getHorizontalFacing().getOpposite()){
		case EAST:
		case WEST:
			return this.getDefaultState().withProperty(TABLE_AXIS, EnumTableAxis.Z);
		case NORTH:
		case SOUTH:
	        return this.getDefaultState().withProperty(TABLE_AXIS, EnumTableAxis.X);
	    default:
	        return this.getDefaultState().withProperty(TABLE_AXIS, EnumTableAxis.X);
		}
    }
	
	public static enum EnumTableAxis implements IStringSerializable{
        X("x"),
        Z("z");

        private final String name;

        private EnumTableAxis(String name) {
            this.name = name;
        }

        public String toString(){
            return this.name;
        }

        public static SimpleTable.EnumTableAxis fromFacingAxis(EnumFacing.Axis axis){
            switch (axis){
                case X:
                    return X;
                case Z:
                    return Z;
                default:
                	return X;
            }
        }

        public String getName(){
            return this.name;
        }
    }
}
