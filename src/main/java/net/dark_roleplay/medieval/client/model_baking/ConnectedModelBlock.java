package net.dark_roleplay.medieval.client.model_baking;

import static net.dark_roleplay.library.experimental.connected_model.ConnectedModelBlockStates.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class ConnectedModelBlock extends Block{

	public ConnectedModelBlock() {
		super(Material.WOOD);
		this.setRegistryName("table_test");
		this.setUnlocalizedName("table_test");
		this.setDefaultState(
			this.getDefaultState()
			.withProperty(NORTH_LEFT, false)
			.withProperty(NORTH_CENTER, false)
			.withProperty(NORTH_RIGHT, false)
			.withProperty(SOUTH_LEFT, false)
			.withProperty(SOUTH_CENTER, false)
			.withProperty(SOUTH_RIGHT, false)
			.withProperty(CENTER_LEFT, false)
			.withProperty(CENTER_RIGHT, false)
		);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this,  HORIZONTAL);
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
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		IBlockState stateCopy = state;
		
		stateCopy = stateCopy.withProperty(NORTH_LEFT, world.getBlockState(pos.north().west()).getBlock() == this);
		stateCopy = stateCopy.withProperty(NORTH_CENTER, world.getBlockState(pos.north()).getBlock() == this);
		stateCopy = stateCopy.withProperty(NORTH_RIGHT, world.getBlockState(pos.north().east()).getBlock() == this);
		stateCopy = stateCopy.withProperty(SOUTH_LEFT, world.getBlockState(pos.south().west()).getBlock() == this);
		stateCopy = stateCopy.withProperty(SOUTH_CENTER, world.getBlockState(pos.south()).getBlock() == this);
		stateCopy = stateCopy.withProperty(SOUTH_RIGHT, world.getBlockState(pos.south().east()).getBlock() == this);
		stateCopy = stateCopy.withProperty(CENTER_LEFT, world.getBlockState(pos.west()).getBlock() == this);
		stateCopy = stateCopy.withProperty(CENTER_RIGHT, world.getBlockState(pos.east()).getBlock() == this);
		
		return stateCopy;
	}
	
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    @Deprecated
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState();
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state){
    	return 0;
    }
}
