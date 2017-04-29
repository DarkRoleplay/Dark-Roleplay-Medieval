package net.drpmedieval.common.blocks.decorative.apiaries;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.drpmedieval.common.blocks.WoodHelper;
import net.drpmedieval.common.blocks.WoodHelper.WoodType;
import net.drpmedieval.common.blocks.building.CleanPlanks;
import net.drpmedieval.common.blocks.templates.DRPMedievalMaterials;
import net.drpmedieval.common.blocks.templates.WoodenBlock;
import net.drpmedieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Apiary extends WoodenBlock{

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public Apiary(String registryName, WoodHelper.WoodType... types) {
		super(Material.WOOD, types);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(2F);
		this.setSoundType(SoundType.WOOD);
	}
	

	@Override
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list){
		int size = VARIANT.getAllowedValues().size();
    	for(int i = 0; i < size; i++){
			list.add(new ItemStack(itemIn, 1, i));
		}
    }

    @Override
    public int damageDropped(IBlockState state){
        return (this.getMetaFromState(state));
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0F, 0F, 0F, 1F, 1F, 1F);
	}

	@Override
	public String getUnlocalizedName(){
		//+ WoodHelper.WoodType.byMetadata(meta).getUnlocalizedName()
        return "tile." + super.getUnlocalizedName();
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		int size =  VARIANT.getAllowedValues().size();
		WoodHelper.WoodType type = size >= 1 ? (WoodType) VARIANT.getAllowedValues().toArray()[0] : null;
		switch (meta % 4) {
		case 3:
			if(size >= 4){
				type = (WoodType) VARIANT.getAllowedValues().toArray()[3];
				break;
			}
		case 2:
			if(size >= 3){
				type = (WoodType) VARIANT.getAllowedValues().toArray()[2];
				break;
			}
		case 1:
			if(size >= 2){
				type = (WoodType) VARIANT.getAllowedValues().toArray()[1];
				break;
			}
		case 0:
			if(size >= 1){
				type = (WoodType) VARIANT.getAllowedValues().toArray()[0];
				break;
			}
		default:
			break;	
		}
		
		switch (meta / 4) {
			case 0:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(VARIANT, type);
			case 1:
				return this.getDefaultState().withProperty(FACING, EnumFacing.EAST).withProperty(VARIANT, type);
			case 2:
				return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(VARIANT, type);
			case 3:
				return this.getDefaultState().withProperty(FACING, EnumFacing.WEST).withProperty(VARIANT, type);
			default:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(VARIANT, type);
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		WoodHelper.WoodType type = state.getValue(VARIANT);
		
		int ret = 0;
		int size =  VARIANT.getAllowedValues().size();
		
		
		if(size >= 1 && type == (WoodType) VARIANT.getAllowedValues().toArray()[0]) ret = 0;
		if(size >= 2 && type == (WoodType) VARIANT.getAllowedValues().toArray()[1]) ret = 1;
		if(size >= 3 && type == (WoodType) VARIANT.getAllowedValues().toArray()[2]) ret = 2;
		if(size >= 4 && type == (WoodType) VARIANT.getAllowedValues().toArray()[3]) ret = 3;
		
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		if (facing.equals(EnumFacing.NORTH))
			return ret + 0;
		if (facing.equals(EnumFacing.EAST))
			return ret + 4;
		if (facing.equals(EnumFacing.SOUTH))
			return ret + 8;
		if (facing.equals(EnumFacing.WEST))
			return ret + 12;
		return 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, PropertyEnum.<WoodHelper.WoodType>create("variant", WoodHelper.WoodType.class, WoodHelper.apiaryTypes) });
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	// -------------------------------------------------- Block Placement
	// --------------------------------------------------

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!this.canBlockStay(worldIn, pos, EnumFacing.UP)) {
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
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand){
		if (!world.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true))
			return Blocks.AIR.getDefaultState();
		return this.getStateFromMeta(meta).withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

	@Override
	public IBlockState getStateForVariant(WoodType type) {
		return null;
	}

	
	public static int getTypeAmount(){
		return 4;
	}
}
