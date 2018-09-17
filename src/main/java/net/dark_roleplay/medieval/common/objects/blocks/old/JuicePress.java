package net.dark_roleplay.medieval.common.objects.blocks.old;

import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.FACING_HORIZONTAL;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.common.objects.blocks.blocks.FacedBlock;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class JuicePress  extends FacedBlock {

	public static final PropertyBool TOP = PropertyBool.create("top");

	public JuicePress (String name, BlockSettings settings) {
		super(name, settings);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {

		boolean top = meta / 4 == 1 ? true : false;

		meta %= 4;

		switch (meta) {
		case 0:
			return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.NORTH).withProperty(JuicePress.TOP, top);
		case 1:
			return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.EAST).withProperty(JuicePress.TOP, top);
		case 2:
			return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.SOUTH).withProperty(JuicePress.TOP, top);
		case 3:
			return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.WEST).withProperty(JuicePress.TOP, top);
		default:
			return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.NORTH).withProperty(JuicePress.TOP, top);
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int ret = state.getValue(JuicePress.TOP) ? 4 : 0;

		EnumFacing facing = state.getValue(FACING_HORIZONTAL);
		if(facing.equals(EnumFacing.NORTH)) return 0 + ret;
		if(facing.equals(EnumFacing.EAST)) return 1 + ret;
		if(facing.equals(EnumFacing.SOUTH)) return 2 + ret;
		if(facing.equals(EnumFacing.WEST)) return 3 + ret;
		return 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING_HORIZONTAL, JuicePress.TOP});
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos){
		return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && worldIn.isAirBlock(pos.up()) && worldIn.isSideSolid(pos.down(), EnumFacing.UP);
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, placer.getHorizontalFacing().getOpposite()).withProperty(JuicePress.TOP, false);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		worldIn.setBlockState(pos.add(0,1,0), state.withProperty(JuicePress.TOP, true));
	}

	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state){
		if(worldIn.getBlockState(pos.add(0,1,0)).getBlock() == this){
			worldIn.setBlockToAir(pos.add(0,1,0));
		}else if(worldIn.getBlockState(pos.add(0,-1,0)).getBlock() == this){
			worldIn.setBlockToAir(pos.add(0,-1,0));
		}
	}
}
