package net.dark_roleplay.medieval.objects.blocks.utility.crafting.honey_centrifuge;

import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.FACING_HORIZONTAL;
import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.IS_TOP;

import javax.annotation.Nullable;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.objects.blocks.general.FacedBlock;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.Properties;

public class HoneyCentrifuge extends FacedBlock {

	public HoneyCentrifuge(String name, BlockSettings settings) {
		super(name, settings);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.byHorizontalIndex(meta % 4)).withProperty(IS_TOP, meta / 4 > 0);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING_HORIZONTAL).getHorizontalIndex() + (state.getValue(IS_TOP) ? 4 : 0);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING_HORIZONTAL, IS_TOP, Properties.StaticProperty );
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		return state.withProperty(Properties.StaticProperty, true);
	}

	/* Double Block Placement/Breaking */

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos){
		return world.getBlockState(pos).getBlock().isReplaceable(world, pos) && world.getBlockState(pos.up()).getBlock().isReplaceable(world, pos.up());
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, placer.getHorizontalFacing().getOpposite()).withProperty(IS_TOP, false);
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		world.setBlockState(pos.up(), state.withProperty(IS_TOP, true));
	}

	@Override
	public void onPlayerDestroy(World world, BlockPos pos, IBlockState state){
		if(state.getValue(IS_TOP)) {
			if(world.getBlockState(pos.down()).getBlock() == this) world.destroyBlock(pos.down(), false);
		}else {
			if(world.getBlockState(pos.up()).getBlock() == this) world.destroyBlock(pos.up(), false);
		}
	}

	/* TileEntity Stuff */

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getTileEntity(state.getValue(IS_TOP) ? pos : pos.up());

		if(te instanceof TileEntityHoneyCentrifuge) {
			((TileEntityHoneyCentrifuge)te).addSpeed(360F);
		}

		return true;
	}

	@Override
	public boolean hasTileEntity(IBlockState state){
		return state.getValue(IS_TOP);
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(World world, IBlockState state){
		return new TileEntityHoneyCentrifuge();
	}
}
