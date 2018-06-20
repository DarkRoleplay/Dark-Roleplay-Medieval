package net.dark_roleplay.medieval.common.objects.blocks.decorative.barrels;

import java.util.List;
import java.util.Random;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SidewayBarrel extends Block {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool TAP = PropertyBool.create("tap");
	
	public SidewayBarrel(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(2F);
		this.setSoundType(SoundType.WOOD);
	}

	// -------------------------------------------------- Block Data
	// --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0F, 0F, 0F, 1F, 1F, 1F);
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }

	@Override
	public IBlockState getStateFromMeta(int meta) {
		boolean tap = meta >= 4 ? true : false;
		meta = meta >= 4 ? meta - 4 : meta;
		switch (meta) {
		case 0:
			return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(TAP, tap);
		case 1:
			return this.getDefaultState().withProperty(FACING, EnumFacing.EAST).withProperty(TAP, tap);
		case 2:
			return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(TAP, tap);
		case 3:
			return this.getDefaultState().withProperty(FACING, EnumFacing.WEST).withProperty(TAP, tap);
		default:
			return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(TAP, tap);
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = state.getValue(TAP).booleanValue() ? 4 : 0;
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		if (facing.equals(EnumFacing.NORTH))
			return 0 + i;
		if (facing.equals(EnumFacing.EAST))
			return 1 + i;
		if (facing.equals(EnumFacing.SOUTH))
			return 2 + i;
		if (facing.equals(EnumFacing.WEST))
			return 3 + i;
		return 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] { FACING, TAP});
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
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		return this.getDefaultState().withProperty(FACING,placer.getHorizontalFacing().getOpposite()).withProperty(TAP, false);
	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			if(player.getHeldItem(EnumHand.MAIN_HAND).getItem().equals(DRPMedievalItems.TAP) && !state.getValue(TAP).booleanValue()){
				world.setBlockState(pos, state.withProperty(TAP,true));		
				if(!player.capabilities.isCreativeMode) player.getHeldItem(hand).shrink(1);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune){
        List<ItemStack> ret = new java.util.ArrayList<ItemStack>();

        Random rand = world instanceof World ? ((World)world).rand : RANDOM;

        int count = quantityDropped(state, fortune, rand);
        for(int i = 0; i < count; i++){
            Item item = this.getItemDropped(state, rand, fortune);
            if (item != Items.AIR){
                ret.add(new ItemStack(item, 1, this.damageDropped(state)));
            }
        }
        
        if(state.getValue(TAP)){
        	ret.add(new ItemStack(DRPMedievalItems.TAP, 1, 0));
        }
        
        return ret;
    }
}