package net.drpmedieval.common.blocks.building;

import java.util.List;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CleanPlanks extends Block{
	
    public static final PropertyEnum<CleanPlanks.EnumType> VARIANT = PropertyEnum.<CleanPlanks.EnumType>create("variant", CleanPlanks.EnumType.class);

    public CleanPlanks(String registryName){
        super(Material.WOOD);
        this.setRegistryName(registryName);
        this.setUnlocalizedName(registryName);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, CleanPlanks.EnumType.OAK));
        this.setCreativeTab(DRPMedievalCreativeTabs.BUILDING_MATS);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setSoundType(SoundType.WOOD);
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list){
    	for(int i = 0; i < 6; i++){
			list.add(new ItemStack(itemIn, 1, i));
		}
    }

    
    @Override
    public int damageDropped(IBlockState state)
    {
        return ((CleanPlanks.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, CleanPlanks.EnumType.byMetadata(meta));
    }

    public MapColor getMapColor(IBlockState state)
    {
        return ((CleanPlanks.EnumType)state.getValue(VARIANT)).getMapColor();
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((CleanPlanks.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

	public static enum EnumType implements IStringSerializable
    {
        OAK(0, "oak", MapColor.WOOD),
        SPRUCE(1, "spruce", MapColor.OBSIDIAN),
        BIRCH(2, "birch", MapColor.SAND),
        JUNGLE(3, "jungle", MapColor.DIRT),
        ACACIA(4, "acacia", MapColor.ADOBE),
        DARK_OAK(5, "dark_oak", MapColor.BROWN);

        private static final CleanPlanks.EnumType[] META_LOOKUP = new CleanPlanks.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;
        /** The color that represents this entry on a map. */
        private final MapColor mapColor;

        private EnumType(int metaIn, String nameIn, MapColor mapColorIn){
            this(metaIn, nameIn, nameIn, mapColorIn);
        }

        private EnumType(int meta, String name, String unlocalizedNameIn, MapColor mapColorIn){
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = unlocalizedNameIn;
            this.mapColor = mapColorIn;
        }

        public int getMetadata(){
            return this.meta;
        }

        /**
         * The color which represents this entry on a map.
         */
        public MapColor getMapColor(){
            return this.mapColor;
        }

        public String toString(){
            return this.name;
        }

        public static CleanPlanks.EnumType byMetadata(int meta){
            if (meta < 0 || meta >= META_LOOKUP.length){
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName(){
            return this.name;
        }

        public String getUnlocalizedName(){
            return this.unlocalizedName;
        }

        static{
            for (CleanPlanks.EnumType type : values()){
                META_LOOKUP[type.getMetadata()] = type;
            }
        }
    }
	
}
