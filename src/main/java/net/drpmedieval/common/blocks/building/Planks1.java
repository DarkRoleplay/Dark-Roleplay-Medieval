package net.drpmedieval.common.blocks.building;

import net.drpmedieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Planks1 extends Block{
    public static final PropertyEnum<Planks1.EnumType> VARIANT = PropertyEnum.<Planks1.EnumType>create("variant", Planks1.EnumType.class);

    public Planks1(String registryName, String unlocalizedName){
        super(Material.WOOD);
    	this.setRegistryName(registryName);
    	this.setUnlocalizedName(unlocalizedName);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, Planks1.EnumType.APPLE));
        this.setCreativeTab(DRPMedievalCreativeTabs.BUILDING_MATS);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
    }

    public int damageDropped(IBlockState state){
        return ((Planks1.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list){
        for (Planks1.EnumType Planks1$enumtype : Planks1.EnumType.values()){
            list.add(new ItemStack(itemIn, 1, Planks1$enumtype.getMetadata()));
        }
    }

    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(VARIANT, Planks1.EnumType.byMetadata(meta));
    }

    public MapColor getMapColor(IBlockState state){
        return ((Planks1.EnumType)state.getValue(VARIANT)).getMapColor();
    }

    public int getMetaFromState(IBlockState state){
        return ((Planks1.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

	public static enum EnumType implements IStringSerializable {
		APPLE(0, "apple", MapColor.WOOD),
		PEAR(1, "pear", MapColor.WOOD);

		private static final Planks1.EnumType[] META_LOOKUP = new Planks1.EnumType[values().length];
		private final int meta;
		private final String name;
		private final String unlocalizedName;
		/** The color that represents this entry on a map. */
		private final MapColor mapColor;

		private EnumType(int metaIn, String nameIn, MapColor mapColorIn) {
			this(metaIn, nameIn, nameIn, mapColorIn);
		}

		private EnumType(int metaIn, String nameIn, String unlocalizedNameIn, MapColor mapColorIn) {
			this.meta = metaIn;
			this.name = nameIn;
			this.unlocalizedName = unlocalizedNameIn;
			this.mapColor = mapColorIn;
		}

		public int getMetadata() {
			return this.meta;
		}

		/**
		 * The color which represents this entry on a map.
		 */
		public MapColor getMapColor() {
			return this.mapColor;
		}

		public String toString() {
			return this.name;
		}

		public static Planks1.EnumType byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}

			return META_LOOKUP[meta];
		}

		public String getName() {
			return this.name;
		}

		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}

		static {
			for (Planks1.EnumType Planks1$enumtype : values()) {
				META_LOOKUP[Planks1$enumtype.getMetadata()] = Planks1$enumtype;
			}
		}
	}

}
