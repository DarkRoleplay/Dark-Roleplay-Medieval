package net.dark_roleplay.medieval.mess.common.objects.blocks.craftingstations;

import net.dark_roleplay.core.api.old.crafting.Crafting_Util;
import net.dark_roleplay.medieval.mess.common.objects.blocks.BlockProperties;
import net.dark_roleplay.medieval.mess.common.objects.blocks.templates.FacedBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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

public class Forge extends FacedBlock {

	public static final PropertyBool LEFT = PropertyBool.create("left");
	
	public Forge(String registryName) {
		super(Material.ROCK);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setHardness(2F);
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.STONE);
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
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
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
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.NORTH).withProperty(LEFT, north);
			case 1:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.EAST).withProperty(LEFT, north);
			case 2:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.SOUTH).withProperty(LEFT, north);
			case 3:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.WEST).withProperty(LEFT, north);
			default:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.NORTH).withProperty(LEFT, north);
		}
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {

		int i = state.getValue(LEFT) ? 4 : 0;
		
		EnumFacing facing = (EnumFacing) state.getValue(BlockProperties.FACING);
		if(facing.equals(EnumFacing.NORTH)) return 0 + i;
		if(facing.equals(EnumFacing.EAST)) return 1 + i;
		if(facing.equals(EnumFacing.SOUTH)) return 2 + i;
		if(facing.equals(EnumFacing.WEST)) return 3 + i;
		return 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {BlockProperties.FACING, LEFT});
	}

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){	
        return this.getDefaultState().withProperty(BlockProperties.FACING, placer.getHorizontalFacing().getOpposite()).withProperty(LEFT, false);
    }
	
	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos){
        return world.getBlockState(pos).getBlock().isReplaceable(world, pos);
    }

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		world.setBlockState(pos.offset(state.getValue(LEFT) ? state.getValue(BlockProperties.FACING).rotateY() : state.getValue(BlockProperties.FACING).rotateYCCW()), state.withProperty(LEFT, !state.getValue(LEFT)));
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state){
		world.setBlockToAir(pos.offset(state.getValue(LEFT) ? state.getValue(BlockProperties.FACING).rotateY() : state.getValue(BlockProperties.FACING).rotateYCCW()));
    }
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			Crafting_Util.openRecipeSelection(this);
		}
		return true;
	}
}