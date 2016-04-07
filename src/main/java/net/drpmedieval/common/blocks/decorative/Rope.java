package net.drpmedieval.common.blocks.decorative;

import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.blocks.helper.RopeFixPoint;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Rope extends Block {

	public static PropertyInteger POSITION = PropertyInteger.create("position", 0, 4);

	public Rope() {
		super(Material.cloth);
		this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		this.setUnlocalizedName("blockRope");
		this.setStepSound(Block.soundTypeCloth);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
	}

	public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		int dir = 0;
		if(facing.equals(facing.UP)) dir = 0;
		if(facing.equals(facing.SOUTH)) dir = 1;
		if(facing.equals(facing.WEST)) dir = 2;
		if(facing.equals(facing.NORTH)) dir = 3;
		if(facing.equals(facing.EAST)) dir = 4;

		if(world.getBlockState(pos.offset(facing.getOpposite())).getBlock() instanceof RopeFixPoint){
			RopeFixPoint fixPoint = (RopeFixPoint) world.getBlockState(pos.offset(facing.getOpposite())).getBlock();
			pos = fixPoint.getPlacementOffset(world, pos.offset(facing.getOpposite()), pos);
			world.setBlockState(pos, this.getDefaultState().withProperty(POSITION, dir), 3);
			world.playSoundEffect((double) ((float) pos.getX() + 0.5F), (double) ((float) pos.getY() + 0.5F), (double) ((float) pos.getZ() + 0.5F), this.stepSound.getPlaceSound(), (this.stepSound.getVolume() + 1.0F) / 2.0F, this.stepSound.getFrequency() * 0.8F);
			return Blocks.air.getDefaultState();
		}
		return this.getDefaultState().withProperty(POSITION, dir);
	}

	@Override
	public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing facing) {

		if(world.getBlockState(pos.offset(facing.getOpposite())).getBlock() instanceof RopeFixPoint){
			RopeFixPoint fixPoint = (RopeFixPoint) world.getBlockState(pos.offset(facing.getOpposite())).getBlock();
			if(fixPoint.isRopeFixable(world, pos.offset(facing), facing)){ return true; }
		}
		return false;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos) {

		IBlockState state = worldIn.getBlockState(pos);
		if(state.getBlock() == this){
			if(state.getValue(POSITION).equals(0)){
				this.setBlockBounds(1.0F / 16F * 7F, 0.0F, 1.0F / 16F * 7F, 1.0F / 16F * 9F, 1.0F / 16F * 16F, 1.0F / 16F * 9F);
			}
			else if(state.getValue(POSITION).equals(1)){
				this.setBlockBounds(1.0F / 16F * 7F, 0.0F, 1.0F / 16F * 0F, 1.0F / 16F * 9F, 1.0F / 16F * 16F, 1.0F / 16F * 2F);
			}
			else if(state.getValue(POSITION).equals(2)){
				this.setBlockBounds(1.0F / 16F * 14F, 0.0F, 1.0F / 16F * 7F, 1.0F / 16F * 16F, 1.0F / 16F * 16F, 1.0F / 16F * 9F);
			}
			else if(state.getValue(POSITION).equals(3)){
				this.setBlockBounds(1.0F / 16F * 7F, 0.0F, 1.0F / 16F * 14F, 1.0F / 16F * 9F, 1.0F / 16F * 16F, 1.0F / 16F * 16F);
			}
			else if(state.getValue(POSITION).equals(4)){
				this.setBlockBounds(1.0F / 16F * 0F, 0.0F, 1.0F / 16F * 7F, 1.0F / 16F * 2F, 1.0F / 16F * 16F, 1.0F / 16F * 9F);
			}
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {

		if(player.getHeldItem() != null){
			if(player.getHeldItem().getItem().equals(Item.getItemFromBlock(DRPMedievalBlocks.rope))){
				for(int i = pos.getY() - 1; i > 0; i--){
					BlockPos pos2 = new BlockPos(pos.getX(), pos.getY() - (pos.getY() - i), pos.getZ());
					if(worldIn.getBlockState(pos2).getBlock().equals(DRPMedievalBlocks.rope)){
						continue;
					}
					else if(worldIn.getBlockState(pos2).getBlock().equals(Blocks.air)){
						worldIn.setBlockState(pos2, state);
						worldIn.playSoundEffect((double) ((float) pos.getX() + 0.5F), (double) ((float) pos.getY() + 0.5F), (double) ((float) pos.getZ() + 0.5F), this.stepSound.getPlaceSound(), (this.stepSound.getVolume() + 1.0F) / 2.0F, this.stepSound.getFrequency() * 0.8F);
						if(!player.capabilities.isCreativeMode) player.inventory.consumeInventoryItem(Item.getItemFromBlock(DRPMedievalBlocks.rope));
						return true;
					}
					else{
						return true;
					}
				}
			}
		}
		else{
			if(player.isSneaking()){
				for(int i = pos.getY() - 1; i > 0; i--){
					BlockPos pos2 = new BlockPos(pos.getX(), pos.getY() - (pos.getY() - i), pos.getZ());
					if(worldIn.getBlockState(pos2).getBlock().equals(DRPMedievalBlocks.rope)){
						continue;
					}
					else{
						BlockPos pos3 = new BlockPos(pos2.getX(), pos2.getY() + 1, pos2.getZ());
						worldIn.setBlockState(pos3, Blocks.air.getDefaultState());
						worldIn.playSoundEffect((double) ((float) pos.getX() + 0.5F), (double) ((float) pos.getY() + 0.5F), (double) ((float) pos.getZ() + 0.5F), this.stepSound.getBreakSound(), (this.stepSound.getVolume() + 1.0F) / 2.0F, this.stepSound.getFrequency() * 0.8F);

						if(!player.worldObj.isRemote) player.worldObj.spawnEntityInWorld(new EntityItem(player.worldObj, player.posX, player.posY, player.posZ, new ItemStack(DRPMedievalBlocks.rope, 1)));
						return true;
					}
				}
			}
		}
		return true;
	}

	public IBlockState getStateFromMeta(int meta) {

		return this.getDefaultState().withProperty(POSITION, Integer.valueOf(meta));
	}

	public int getMetaFromState(IBlockState state) {

		return ((Integer) state.getValue(POSITION)).intValue();
	}

	protected BlockState createBlockState() {

		return new BlockState(this, new IProperty[] {POSITION});
	}

	@Override
	public boolean isFullCube() {

		return false;
	}

	@Override
	public boolean isOpaqueCube() {

		return false;
	}

	@Override
	public boolean isLadder(IBlockAccess world, BlockPos pos, EntityLivingBase entity) {

		return true;
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

		return true;
	}

	public boolean isSideSolid(IBlockAccess world, BlockPos pos, EnumFacing side) {

		return false;
	}
}
