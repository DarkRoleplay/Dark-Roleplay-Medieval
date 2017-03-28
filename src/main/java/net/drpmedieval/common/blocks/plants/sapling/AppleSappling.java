package net.drpmedieval.common.blocks.plants.sapling;

import java.util.Random;

import net.drpmedieval.common.blocks.WoodHelper;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenBirchTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AppleSappling extends BlockBush{
	
//	public static final PropertyEnum<WoodHelper.EnumDRPMType> TYPE = PropertyEnum.<WoodHelper.EnumDRPMType>create("type", WoodHelper.EnumDRPMType.class);
	
	protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

	public AppleSappling (String registryName){
    	this.setRegistryName(registryName);
    	this.setUnlocalizedName(registryName);
//        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, WoodHelper.EnumDRPMType.APPLE));
        this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab);
    }

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SAPLING_AABB;
	}

//	public String getLocalizedName() {
//		return I18n.translateToLocal(this.getUnlocalizedName() + "." + WoodHelper.EnumDRPMType.APPLE.getUnlocalizedName() + ".name");
//	}

	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			super.updateTick(worldIn, pos, state, rand);

			if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0) {
				this.grow(worldIn, pos, state, rand);
			}
		}
	}

	public void grow(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		this.generateTree(worldIn, pos, state, rand);
	}

	public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		
	}

	public int damageDropped(IBlockState state) {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {
		for (BlockPlanks.EnumType blockplanks$enumtype : BlockPlanks.EnumType.values()) {
			list.add(new ItemStack(itemIn, 1, blockplanks$enumtype.getMetadata()));
		}
	}

	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}
	
//	public IBlockState getStateFromMeta(int meta) {
//		return this.getDefaultState().withProperty(TYPE, WoodHelper.EnumDRPMType.byMetadata(meta & 7));
//	}
//
//	public int getMetaFromState(IBlockState state) {
//		int i = 0;
//		i = i | ((WoodHelper.EnumDRPMType) state.getValue(TYPE)).getMetadata();
//		return i;
//	}
//
//	protected BlockStateContainer createBlockState() {
//		return new BlockStateContainer(this, new IProperty[] { TYPE });
//	}
}
