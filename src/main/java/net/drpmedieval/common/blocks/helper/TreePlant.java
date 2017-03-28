package net.drpmedieval.common.blocks.helper;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TreePlant extends Block{
	
	/**
	 * musst be Override
	 */
	public static PropertyInteger AGE; //=  PropertyInteger.create("AGE", 0, 3);
	
	/**
	 * Specifies if this fruit can drop when its to Ripe
	 */
	public static final boolean dropWhenRipe = true;
	
	/**
	 * Helper value for dropping when ripe
	 */
	protected int ripe;
	/**
	 * Helper value when fruit has been placed on a Tree/bottom of a block
	 */
	protected int placedTop;
	/**
	 * Helper value for placed ones
	 */
	protected int placedBottom;
	
	protected float growingSpeed;
	
	ItemStack harvest;
	
	/**
	 * You need also to override the PropertyInteger Age
	 * @param stages Number of growing stages this fruit can grow (Only naturaly growing)
	 * @param specifies how fast the fruit will grow (Lower = Faster)
	 * @param dropWhenRipe specifies if this fruit drops when it's Ripe (Defualt true)
	 */
	public TreePlant(int stages, float growingSpeed, boolean dropWhenRipe, ItemStack stack){
		super(Material.PLANTS);
		this.ripe = stages - 1;
		this.placedTop = stages;
		this.placedBottom = stages + 1;
		this.growingSpeed = growingSpeed;
		this.harvest = stack;
		this.setTickRandomly(true);
	}
	
	
	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
		if(state.getValue(AGE).intValue() < placedBottom){
			return new AxisAlignedBB(0.3125F, 0.625F, 0.3125F, 0.6875F, 1F, 0.6875F);
		}else if(state.getValue(AGE).intValue() == placedBottom){
			return new AxisAlignedBB(0.3125F, 0F, 0.3125F, 0.6875F, 0.4375F, 0.6875F);
		}
		return null;
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
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if(this.ripe <= state.getValue(AGE).intValue())
		return this.harvest.getItem();
		
		return null;
	}
	
	public boolean canGrow(IBlockState state) {

		if(ripe + 1 > state.getValue(AGE).intValue()) return true;
		return false;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {

		return this.getDefaultState().withProperty(AGE, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state) {

		return ((Integer) state.getValue(AGE)).intValue();
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {AGE});
	}
	
	// -------------------------------------------------- Block Placement --------------------------------------------------
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos){

		if(!this.canBlockStay(state,worldIn, pos, EnumFacing.UP)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
				super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
	}

	protected boolean canBlockStay(IBlockState state,World worldIn, BlockPos pos, EnumFacing facing) {

		if(state.getValue(AGE).intValue() < this.placedBottom){
			return worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock() instanceof BlockLeaves;
		}else{
			return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true);
		}
	}
	
	// -------------------------------------------------- Block Events --------------------------------------------------
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){

		if(!world.isRemote){
			if(this.ripe == state.getValue(AGE).intValue()){
				world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), this.harvest));
				world.setBlockState(pos, state.withProperty(AGE, 0));
			}
			else if(this.ripe < state.getValue(AGE).intValue()){
				world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), this.harvest));
				world.setBlockToAir(pos);
			}
		}
		return true;
	}
	
	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){

		if(facing.equals(facing.UP) && worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true))
			return this.getDefaultState().withProperty(AGE, placedBottom);
		else if(facing.equals(facing.DOWN) && (worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock() instanceof BlockLeaves))
			return this.getDefaultState().withProperty(AGE, placedTop);
		else
			return Blocks.AIR.getDefaultState();
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		super.updateTick(worldIn, pos, state, rand);

		int i = ((Integer) state.getValue(AGE)).intValue();

		if(canGrow(state)){
			if(rand.nextInt((int) growingSpeed) == 0){
				if(this.ripe == state.getValue(AGE).intValue() && dropWhenRipe){

					worldIn.spawnEntity(new EntityFallingBlock(worldIn, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, state.withProperty(AGE, this.placedBottom)));

				}
				else{
					worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i + 1)), 2);
				}
			}
		}
	}
}
