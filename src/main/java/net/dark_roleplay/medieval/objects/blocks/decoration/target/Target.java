package net.dark_roleplay.medieval.objects.blocks.decoration.target;

import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.FACING_HORIZONTAL;
import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.IS_TOP;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.objects.blocks.general.FacedBlock;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Target extends FacedBlock {

	public Target (String name, BlockSettings settings) {
		super(name, settings);
	}

	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0F, 0F, 0F, 1F, 1F, 1F);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING_HORIZONTAL, IS_TOP });
	}


	// -------------------------------------------------- Block Placement --------------------------------------------------

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && worldIn.isAirBlock(pos.up())
				&& worldIn.isSideSolid(pos.down(), EnumFacing.UP);
	}

	// -------------------------------------------------- Block Events --------------------------------------------------

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		worldIn.setBlockState(pos.add(0, 1, 0), state.withProperty(IS_TOP, true));
	}

	@Override
	public void onPlayerDestroy(World worldIn, BlockPos pos, IBlockState state) {
		if (worldIn.getBlockState(pos.add(0, 1, 0)).getBlock() == this) {
			worldIn.setBlockToAir(pos.add(0, 1, 0));
		} else if (worldIn.getBlockState(pos.add(0, -1, 0)).getBlock() == this) {
			worldIn.setBlockToAir(pos.add(0, -1, 0));
		}
	}

	// -------------------------------------------------- Old Rendering System --------------------------------------------------

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return !state.getValue(IS_TOP);
	}

}
