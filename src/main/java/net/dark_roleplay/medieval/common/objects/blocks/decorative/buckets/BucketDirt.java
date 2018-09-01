package net.dark_roleplay.medieval.common.objects.blocks.decorative.buckets;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.flowers.FlowersTileEntity;
import net.dark_roleplay.medieval.common.objects.blocks.helper.EnumAxis;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BucketDirt extends Block{

    public static final PropertyEnum<EnumAxis> AXIS = PropertyEnum.<EnumAxis>create("axis", EnumAxis.class);

	public BucketDirt(String registreName) {
		super(Material.WOOD);
		this.setRegistryName(registreName);
		this.setUnlocalizedName(registreName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(1F);
		this.setSoundType(SoundType.WOOD);
	}

	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, BucketDirt.AXIS);
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
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
	public IBlockState getStateFromMeta(int meta) {
		switch (meta) {
			case 0:
				return this.getDefaultState().withProperty(BucketDirt.AXIS, EnumAxis.X);
			case 1:
				return this.getDefaultState().withProperty(BucketDirt.AXIS, EnumAxis.Z);
			default:
				return this.getDefaultState().withProperty(BucketDirt.AXIS, EnumAxis.X);
		}
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {

		EnumAxis facing = state.getValue(BucketDirt.AXIS);
		if(facing.equals(EnumAxis.X)) return 0;
		if(facing.equals(EnumAxis.Z)) return 1;

		return 0;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return new AxisAlignedBB(0.1875F, 0F, 0.1875F, 0.8125F, 0.625F, 0.8125F);
    }

	// -------------------------------------------------- Block Placement --------------------------------------------------
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos){

		if(!this.canBlockStay(worldIn, pos, EnumFacing.UP)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
				super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {

		return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true);
	}
	// -------------------------------------------------- Block Events --------------------------------------------------
	
	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){	
		switch(placer.getHorizontalFacing().getOpposite()){
		case EAST:
		case WEST:
			return this.getDefaultState().withProperty(BucketDirt.AXIS, EnumAxis.Z);
		case NORTH:
		case SOUTH:
	        return this.getDefaultState().withProperty(BucketDirt.AXIS, EnumAxis.X);
	    default:
	        return this.getDefaultState().withProperty(BucketDirt.AXIS, EnumAxis.X);
		}
    }
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		super.breakBlock(world, pos, state);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
//		if(player.getHeldItem(hand).getItem() == Item.getItemFromBlock(Blocks.YELLOW_FLOWER) || player.getHeldItem(hand).getItem() == Item.getItemFromBlock(Blocks.RED_FLOWER) || player.getHeldItem(hand).getItem() == Item.getItemFromBlock(Blocks.DOUBLE_PLANT)) {
		if(player.getHeldItem(hand).getItem() instanceof ItemBlock) {
			TileEntity te = world.getTileEntity(pos);
			if(!(te instanceof FlowersTileEntity)) return false;
			
			FlowersTileEntity flower = (FlowersTileEntity) te;
			return flower.addFlower(player.getHeldItem(hand).copy(), world.isRemote);
		}
		
        return false;
    }
	

	@Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }
    
    @Nullable
    public TileEntity createTileEntity(World world, IBlockState state){
        return new FlowersTileEntity(3);
    }
}
