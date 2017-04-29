package net.dark_roleplay.medieval.api.blocks.plants;

import java.util.Collections;
import java.util.Random;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.common.tileentities.TileEntity_AdvancedCrop;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class Block_AdvancedCrop extends Block implements ITileEntityProvider {

	public static final PropertyBool PROVIDER = PropertyBool.create("provider");

	public Block_AdvancedCrop(String registryName, PropertyInteger age, int daysToGrow) {
		super(Material.PLANTS);
		this.setHardness(0.0F);
		this.setSoundType(SoundType.PLANT);
		this.disableStats();
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setDefaultState(this.getDefaultState().withProperty(this.getAgeProperty(), 0).withProperty(PROVIDER, false));
	}

	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public java.util.List<ItemStack> getDrops(net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state,
			int fortune) {
		java.util.List<ItemStack> ret = super.getDrops(world, pos, state, fortune);
		int age = getAge(state);
		Random rand = world instanceof World ? ((World) world).rand : new Random();

		if (age >= getMaxAge()) {
			int k = 3 + fortune;

			for (int i = 0; i < 3 + fortune; ++i) {
				if (rand.nextInt(2 * getMaxAge()) <= age) {
					ret.add(new ItemStack(this.getSeed(), 1, 0));
				}
			}
		}
		return ret;
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return state.getValue(PROVIDER);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return this.isMaxAge(state) ? this.getCrop() : this.getSeed();
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(this.getSeed());
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntity_AdvancedCrop();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.withAge(meta % 8).withProperty(PROVIDER, meta/8 > 0 ? true : false) ;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return this.getAge(state) + (state.getValue(PROVIDER) ? 8 : 0);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { this.getAgeProperty(), PROVIDER });
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		for(int i = -10; i <= 10; i++){
			for(int j = -10; j <= 10; j++){
				for(int h = -1; h <= 1; h++){
					if(world.getBlockState(pos.add(i,h,j)).getBlock() instanceof Block_AdvancedCrop){
						if(world.getBlockState(pos.add(i,h,j)).getValue(PROVIDER)){
							((TileEntity_AdvancedCrop)world.getTileEntity(pos.add(i,h,j))).addCrop(pos);
							return;
						}
					}
				}
			}
		}
		world.setBlockState(pos, state.withProperty(PROVIDER, true));
		//world.getBlockState(pos).getBlock().createTileEntity(world, state.withProperty(PROVIDER, true));
    }
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state){
        if (state.getValue(PROVIDER) && world.getTileEntity(pos) != null && world.getTileEntity(pos) instanceof TileEntity_AdvancedCrop){
        	BlockPos newPos = ((TileEntity_AdvancedCrop)world.getTileEntity(pos)).getNextCrop();
        	
        	if(newPos != null){
	        	world.setBlockState(newPos, world.getBlockState(newPos).withProperty(PROVIDER, true));
	        	((TileEntity_AdvancedCrop)world.getTileEntity(pos)).removeCrop(newPos);
	        	world.getTileEntity(newPos).readFromNBT(world.getTileEntity(pos).writeToNBT(new NBTTagCompound()));
        	}
            world.removeTileEntity(pos);
        }
    }
	
	//JUST FOR DEBUG!!!!
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(!world.isRemote)
		if(state.getValue(PROVIDER)){
			TileEntity_AdvancedCrop crop = (TileEntity_AdvancedCrop) world.getTileEntity(pos);
			for(BlockPos pos2 : crop.getCrops()){
				player.sendMessage(new TextComponentString(pos2.getX() + " : " + pos2.getY() + " : " + pos2.getZ()));
			}
		}
		
        return true;
    }

	/** ----------------- Crop Specific methods -------------------- **/

	protected int getAge(IBlockState state) {
		return ((Integer) state.getValue(this.getAgeProperty())).intValue();
	}

	public IBlockState withAge(int age) {
		return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age));
	}

	public boolean isMaxAge(IBlockState state) {
		return ((Integer) state.getValue(this.getAgeProperty())).intValue() >= this.getMaxAge();
	}

	public int getMaxAge() {
		return Collections.max(getAgeProperty().getAllowedValues());
	}
	
	protected abstract Item getSeed();

	protected abstract Item getCrop();

	protected abstract PropertyInteger getAgeProperty();
}