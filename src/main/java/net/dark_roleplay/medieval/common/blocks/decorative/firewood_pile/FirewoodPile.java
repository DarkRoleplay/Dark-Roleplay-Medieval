package net.dark_roleplay.medieval.common.blocks.decorative.firewood_pile;

import java.util.Random;

import net.dark_roleplay.medieval.common.blocks.decorative.tables.SimpleTable;
import net.dark_roleplay.medieval.common.blocks.helper.EnumAxis;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FirewoodPile extends Block{

	public FirewoodPile(String registreName) {
		super(Material.WOOD);
		this.setRegistryName(registreName);
		this.setUnlocalizedName(registreName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(1F); 
		this.setSoundType(SoundType.WOOD);
	}
	
	public int quantityDropped(Random random){
        return 16;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return DRPMedievalItems.FIREWOOD;
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		switch (meta) {
			case 0:
				return this.getDefaultState().withProperty(SimpleTable.TABLE_AXIS, EnumAxis.X);
			case 1:
				return this.getDefaultState().withProperty(SimpleTable.TABLE_AXIS, EnumAxis.Z);
			default:
				return this.getDefaultState().withProperty(SimpleTable.TABLE_AXIS, EnumAxis.X);
		}
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {

		EnumAxis facing = state.getValue(SimpleTable.TABLE_AXIS);
		if(facing.equals(EnumAxis.X)) return 0;
		if(facing.equals(EnumAxis.Z)) return 1;

		return 0;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {SimpleTable.TABLE_AXIS});
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
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){	
		switch(placer.getHorizontalFacing().getOpposite()){
		case EAST:
		case WEST:
			return this.getDefaultState().withProperty(SimpleTable.TABLE_AXIS, EnumAxis.Z);
		case NORTH:
		case SOUTH:
	        return this.getDefaultState().withProperty(SimpleTable.TABLE_AXIS, EnumAxis.X);
	    default:
	        return this.getDefaultState().withProperty(SimpleTable.TABLE_AXIS, EnumAxis.X);
		}
    }
	
}
