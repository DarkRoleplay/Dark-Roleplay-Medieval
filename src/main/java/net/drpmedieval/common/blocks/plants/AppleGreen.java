package net.drpmedieval.common.blocks.plants;

import java.util.Collections;
import java.util.Random;

import net.drpmedieval.common.items.DRPMedievalItems;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AppleGreen extends Block {

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 5);

	public AppleGreen() {
		super(Material.plants);
		this.setBlockBounds(0.3125F, 0F, 0.3125F, 0.6875F, 0.4375F, 0.6875F);
		this.setUnlocalizedName("blockAppleGreen");
		this.setStepSound(Block.soundTypeGrass);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
		this.setTickRandomly(true);
	}

	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		if(facing.equals(facing.UP) && worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true))
			return this.getDefaultState().withProperty(AGE, 5);
		else if(facing.equals(facing.DOWN) && (worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock().equals(Blocks.leaves) || worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock().equals(Blocks.leaves2)))
			return this.getDefaultState().withProperty(AGE, 4);
		else
			return Blocks.air.getDefaultState();
	}

	// Growing Start

	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		super.updateTick(worldIn, pos, state, rand);

		int i = ((Integer) state.getValue(AGE)).intValue();

		if(canGrow(state)){
			if(rand.nextInt((int) (25.0F) + 1) == 0){
				if(Collections.max(AGE.getAllowedValues()) - 2 == state.getValue(AGE).intValue()){

					worldIn.spawnEntityInWorld(new EntityFallingBlock(worldIn, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, state.withProperty(AGE, Integer.valueOf(i) + 2)));

				}
				else{
					worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i + 1)), 2);
				}
			}
		}
	}

	public boolean canGrow(IBlockState state) {

		if(Collections.max(AGE.getAllowedValues()) - 1 > state.getValue(AGE).intValue()) return true;
		return false;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {

		if(!worldIn.isRemote){
			if(Collections.max(AGE.getAllowedValues()) - 2 == state.getValue(AGE).intValue()){
				worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(DRPMedievalItems.itemAppleGreen, 1)));
				worldIn.setBlockState(pos, state.withProperty(AGE, 0));
			}
			else if(Collections.max(AGE.getAllowedValues()) - 2 < state.getValue(AGE).intValue()){
				worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(DRPMedievalItems.itemAppleGreen, 1)));
				worldIn.setBlockToAir(pos);
			}
		}
		return true;
	}

	// Growing End

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {

		return DRPMedievalItems.itemAppleGreen;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos) {

		if(!worldIn.getBlockState(pos).getBlock().equals(this)) return;
		int age = ((Integer) worldIn.getBlockState(pos).getValue(AGE)).intValue();
		switch (age) {
			case 0:
				this.setBlockBounds(0.3125F, 0.625F, 0.3125F, 0.6875F, 1F, 0.6875F);
				break;
			case 1:
				this.setBlockBounds(0.3125F, 0.625F, 0.3125F, 0.6875F, 1F, 0.6875F);
				break;
			case 2:
				this.setBlockBounds(0.3125F, 0.625F, 0.3125F, 0.6875F, 1F, 0.6875F);
				break;
			case 3:
				this.setBlockBounds(0.3125F, 0.625F, 0.3125F, 0.6875F, 1F, 0.6875F);
				break;
			case 4:
				this.setBlockBounds(0.3125F, 0.625F, 0.3125F, 0.6875F, 1F, 0.6875F);
				break;
			case 5:
				this.setBlockBounds(0.3125F, 0F, 0.3125F, 0.6875F, 0.375F, 0.6875F);
				break;
			default:
				break;
		}
	}

	public IBlockState getStateFromMeta(int meta) {

		return this.getDefaultState().withProperty(AGE, meta);
	}

	public int getMetaFromState(IBlockState state) {

		return ((Integer) state.getValue(AGE)).intValue();
	}

	protected BlockState createBlockState() {

		return new BlockState(this, new IProperty[] {AGE});
	}

	@Override
	public boolean isFullCube() {

		return false;
	}

	public boolean isSolidFullCube() {

		return false;
	}

	public boolean isOpaqueCube() {

		return false;
	}

	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {

		this.setBlockBoundsBasedOnState(worldIn, pos);
		return super.getCollisionBoundingBox(worldIn, pos, state);
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos) {

		this.setBlockBoundsBasedOnState(worldIn, pos);
		return super.getSelectedBoundingBox(worldIn, pos);
	}

	// Ground Blocks
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {

		if(!this.canBlockStay(worldIn, pos, EnumFacing.UP)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
		super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {

		if(worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock().equals(Blocks.leaves) || worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock().equals(Blocks.leaves2))
			return true;
		else
			return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true);

	}

}
