package net.dark_roleplay.medieval.common.objects.blocks.decorative.lanterns;

import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.ADDON_LIGHTER;
import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.ADDON_TRAP;

import java.util.List;
import java.util.Random;

import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.wall_mounted.EmptyWallMount;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.wall_mounted.UnlitWallMount;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Lantern extends Block{
	
	//TODO ROTATION

	public static final PropertyBool CANDLE = PropertyBool.create("candle");
	public static final PropertyBool LIT = PropertyBool.create("lit");
	
	private AxisAlignedBB northBB;

	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand){
		if(state.getValue(LIT)){
			world.spawnParticle(EnumParticleTypes.FLAME, pos.getX() + 0.5F, pos.getY() + 0.55F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
		}
	}
	
	public Lantern(String registryName, Material material, AxisAlignedBB northBB) {
		super(material);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.northBB = northBB;
		this.setHardness(1F);
		this.setHarvestLevel("pickaxe", 0);
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return this.northBB;
    }

	@Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		return this.getDefaultState().withProperty(CANDLE, false).withProperty(LIT, false);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(CANDLE, meta > 0).withProperty(LIT, meta/2 == 1);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int meta = state.getValue(CANDLE) ? 1 : 0;
		if(state.getValue(LIT))
			meta *= 2;
		return meta;
	}

	@Deprecated
    public int getLightValue(IBlockState state){
        return state.getValue(LIT) ? 15 : 0;
    }

	
	// -------------------------------------------------- Rendering --------------------------------------------------

	@Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune){
		NonNullList<ItemStack> stacks = NonNullList.create();
		
		stacks.add(new ItemStack(DRPMedievalItems.LANTERN));
		
		if(state.getValue(CANDLE))
			stacks.add(new ItemStack(DRPMedievalItems.BEESWAX_CANDLE));

		return stacks;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer(){
		 return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {CANDLE, LIT});
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
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			boolean hasCandle = state.getValue(CANDLE);
			ItemStack heldStack = player.getHeldItem(hand);
			
			if(heldStack.isEmpty() && state.getValue(LIT) && player.isSneaking()){
				world.setBlockState(pos, state.withProperty(LIT, false));
			}else if(!hasCandle && heldStack.getItem() == Item.getItemFromBlock(DRPMedievalBlocks.BEESWAX_CANDLE)){
				player.getHeldItem(hand).shrink(1);
				world.setBlockState(pos, state.withProperty(CANDLE, true));
			}else if(hasCandle && heldStack.getItem() == Items.FLINT_AND_STEEL){
				player.getHeldItem(hand).damageItem(1, player);
				world.setBlockState(pos, state.withProperty(LIT, true));
			}
		}
		return true;
	}
	
	public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer){
        return layer == BlockRenderLayer.SOLID || layer == BlockRenderLayer.TRANSLUCENT;
    }
}
