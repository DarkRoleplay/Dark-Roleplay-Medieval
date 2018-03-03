package net.dark_roleplay.medieval.common.blocks.decorative.lumbering;

import net.dark_roleplay.medieval.common.blocks.decorative.lecterns.LargeLectern;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Lumbering extends Block{

	public static final PropertyBool UP = PropertyBool.create("up");
	public static final PropertyBool DOWN = PropertyBool.create("down");
	public static final PropertyBool RIGHT = PropertyBool.create("right");
	public static final PropertyBool LEFT = PropertyBool.create("left");
	
	public Lumbering(String name) {
		super(Material.ROCK);
		this.setRegistryName(name);
		this.fullBlock = true;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState()
				.withProperty(UP, (meta & 8) == 8)
				.withProperty(DOWN, (meta & 4) == 4)
				.withProperty(RIGHT, (meta & 2) == 2)
				.withProperty(LEFT, (meta & 1) == 1);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int meta = 0;
		if(state.getValue(UP)) meta |= 8;
		if(state.getValue(DOWN)) meta |= 4;
		if(state.getValue(RIGHT)) meta |= 2;
		if(state.getValue(LEFT)) meta |= 1;
		
		return meta;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {UP, DOWN, RIGHT, LEFT});
	}
	
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		for(int i = 0; i < 16; i++) {
			worldIn.setBlockState(pos.add(0, i, 0), this.getStateFromMeta(i));
		}
        return false;
    }
}
