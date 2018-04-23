package net.dark_roleplay.medieval.common.blocks.building;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CleanPlanks extends Block{
	
    public static final PropertyEnum<CleanPlanks.EnumType> VARIANT = PropertyEnum.<CleanPlanks.EnumType>create("variant", CleanPlanks.EnumType.class);

    public CleanPlanks(String registryName){
        super(Material.WOOD);
        this.setRegistryName(registryName);
        this.setUnlocalizedName(registryName);
        this.setDefaultState(this.blockState.getBaseState().withProperty(CleanPlanks.VARIANT, CleanPlanks.EnumType.OAK));
        this.setCreativeTab(DRPMedievalCreativeTabs.BUILDING_MATS);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setSoundType(SoundType.WOOD);
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items){
    	for(int i = 0; i < 6; i++){
    		items.add(new ItemStack(this, 1, i));
		}
    }

    
    @Override
    public int damageDropped(IBlockState state)
    {
        return state.getValue(CleanPlanks.VARIANT).getMetadata();
    }
    
    @Override
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(CleanPlanks.VARIANT, CleanPlanks.EnumType.byMetadata(meta));
    }
    
    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos){
        return state.getValue(CleanPlanks.VARIANT).getMapColor();
    }

    @Override
	public int getMetaFromState(IBlockState state)
    {
        return state.getValue(CleanPlanks.VARIANT).getMetadata();
    }

    @Override
	protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {CleanPlanks.VARIANT});
    }

	public static enum EnumType implements IStringSerializable
    {
        OAK(0, "oak", MapColor.WOOD),
        SPRUCE(1, "spruce", MapColor.OBSIDIAN),
        BIRCH(2, "birch", MapColor.SAND),
        JUNGLE(3, "jungle", MapColor.DIRT),
        DARK_OAK(4, "dark_oak", MapColor.BROWN),
        ACACIA(5, "acacia", MapColor.ADOBE);

        private static final CleanPlanks.EnumType[] META_LOOKUP = new CleanPlanks.EnumType[EnumType.values().length];
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

        @Override
		public String toString(){
            return this.name;
        }

        public static CleanPlanks.EnumType byMetadata(int meta){
            if ((meta < 0) || (meta >= EnumType.META_LOOKUP.length)){
                meta = 0;
            }

            return EnumType.META_LOOKUP[meta];
        }

        @Override
		public String getName(){
            return this.name;
        }

        public String getUnlocalizedName(){
            return this.unlocalizedName;
        }

        static{
            for (CleanPlanks.EnumType type : EnumType.values()){
                EnumType.META_LOOKUP[type.getMetadata()] = type;
            }
        }
    }
	
}
