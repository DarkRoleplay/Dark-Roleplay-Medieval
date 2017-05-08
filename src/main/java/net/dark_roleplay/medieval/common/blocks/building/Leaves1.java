package net.dark_roleplay.medieval.common.blocks.building;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.dark_roleplay.medieval.common.blocks.templates.DRPMLeaves;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Leaves1 extends DRPMLeaves {
	public static final PropertyEnum<Planks1.EnumType> VARIANT = PropertyEnum.<Planks1.EnumType>create("variant",
			Planks1.EnumType.class, new Predicate<Planks1.EnumType>() {
				public boolean apply(@Nullable Planks1.EnumType p_apply_1_) {
					return p_apply_1_.getMetadata() < 4;
				}
			});

	public Leaves1(String registryName, String unlocalizedName){
    	this.setRegistryName(registryName);
    	this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(DRPMedievalCreativeTabs.BUILDING_MATS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, Planks1.EnumType.APPLE).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
    }

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {
		list.add(new ItemStack(itemIn, 1, Planks1.EnumType.APPLE.getMetadata()));
		list.add(new ItemStack(itemIn, 1, Planks1.EnumType.PEAR.getMetadata()));
	}

	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(Item.getItemFromBlock(this), 1,
				((Planks1.EnumType) state.getValue(VARIANT)).getMetadata());
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, this.getWoodType(meta))
				.withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0))
				.withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((Planks1.EnumType) state.getValue(VARIANT)).getMetadata();

		if (!((Boolean) state.getValue(DECAYABLE)).booleanValue()) {
			i |= 4;
		}

		if (((Boolean) state.getValue(CHECK_DECAY)).booleanValue()) {
			i |= 8;
		}

		return i;
	}

	public Planks1.EnumType getWoodType(int meta) {
		return Planks1.EnumType.byMetadata((meta & 3) % 4);
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { VARIANT, CHECK_DECAY, DECAYABLE });
	}

	public int damageDropped(IBlockState state) {
		return ((Planks1.EnumType) state.getValue(VARIANT)).getMetadata();
	}

//	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state,@Nullable TileEntity te, ItemStack stack) {
//		if (!worldIn.isRemote && stack.getItem() == Items.SHEARS) {
//			player.addStat(StatList.getBlockStats(this));
//		} else {
//			super.harvestBlock(worldIn, player, pos, state, te, stack);
//		}
//	}

	@Override
	public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
		return NonNullList.withSize(1, new ItemStack(this, 1, world.getBlockState(pos).getValue(VARIANT).getMetadata()));
	}
}
