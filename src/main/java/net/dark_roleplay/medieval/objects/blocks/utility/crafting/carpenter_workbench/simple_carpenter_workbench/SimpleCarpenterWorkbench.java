package net.dark_roleplay.medieval.objects.blocks.utility.crafting.carpenter_workbench.simple_carpenter_workbench;

import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.FACING_HORIZONTAL;

import net.dark_roleplay.core.api.old.crafting.Crafting_Util;
import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.objects.blocks.general.FacedBlock;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SimpleCarpenterWorkbench extends FacedBlock{

	public static final PropertyBool LEFT = PropertyBool.create("left");

	public SimpleCarpenterWorkbench (String name, BlockSettings settings) {
		super(name, settings);
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		boolean north = false;
		if(meta > 3){
			north = true;
			meta -= 4;
		}
		switch (meta) {
		case 0:
			return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.NORTH).withProperty(LEFT, north);
		case 1:
			return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.EAST).withProperty(LEFT, north);
		case 2:
			return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.SOUTH).withProperty(LEFT, north);
		case 3:
			return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.WEST).withProperty(LEFT, north);
		default:
			return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.NORTH).withProperty(LEFT, north);
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {

		int i = state.getValue(LEFT) ? 4 : 0;

		EnumFacing facing = state.getValue(FACING_HORIZONTAL);
		if(facing.equals(EnumFacing.NORTH)) return 0 + i;
		if(facing.equals(EnumFacing.EAST)) return 1 + i;
		if(facing.equals(EnumFacing.SOUTH)) return 2 + i;
		if(facing.equals(EnumFacing.WEST)) return 3 + i;
		return 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING_HORIZONTAL, LEFT});
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, placer.getHorizontalFacing().getOpposite()).withProperty(LEFT, false);
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos){
		return world.getBlockState(pos).getBlock().isReplaceable(world, pos);
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		world.setBlockState(pos.offset(state.getValue(LEFT) ? state.getValue(FACING_HORIZONTAL).rotateY() : state.getValue(FACING_HORIZONTAL).rotateYCCW()), state.withProperty(LEFT, !state.getValue(LEFT)));
	}

	@Override
	public void onPlayerDestroy(World world, BlockPos pos, IBlockState state){
		world.setBlockToAir(pos.offset(state.getValue(LEFT) ? state.getValue(FACING_HORIZONTAL).rotateY() : state.getValue(FACING_HORIZONTAL).rotateYCCW()));
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			Crafting_Util.openRecipeSelection(this);
		}
		return true;
	}
}
