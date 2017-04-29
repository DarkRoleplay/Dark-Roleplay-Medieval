package net.dark_roleplay.medieval.common.blocks.building;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Logs1 extends BlockLog{
	
    public static final PropertyEnum<Planks1.EnumType> VARIANT = PropertyEnum.<Planks1.EnumType>create("variant", Planks1.EnumType.class, new Predicate<Planks1.EnumType>(){
        public boolean apply(@Nullable Planks1.EnumType p_apply_1_){
            return p_apply_1_.getMetadata() < 4;
        }
    });

    public Logs1(String registryName, String unlocalizedName){
    	this.setRegistryName(registryName);
    	this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(DRPMedievalCreativeTabs.BUILDING_MATS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, Planks1.EnumType.APPLE).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
    }

    /**
     * Get the MapColor for this Block and the given BlockState
     */
    public MapColor getMapColor(IBlockState state){
        Planks1.EnumType Planks1$enumtype = (Planks1.EnumType)state.getValue(VARIANT);

        switch ((BlockLog.EnumAxis)state.getValue(LOG_AXIS)){
            case X:
            case Z:
            case NONE:
            default:

                switch (Planks1$enumtype){
                    case APPLE:
                    default:
                        return Planks1.EnumType.APPLE.getMapColor();
                    case PEAR:
                        return Planks1.EnumType.PEAR.getMapColor();
                }
            case Y:
                return Planks1$enumtype.getMapColor();
        }
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list){
        list.add(new ItemStack(itemIn, 1, Planks1.EnumType.APPLE.getMetadata()));
        list.add(new ItemStack(itemIn, 1, Planks1.EnumType.PEAR.getMetadata()));
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta){
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, Planks1.EnumType.byMetadata((meta & 3)));
        switch (meta & 12){
            case 0:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;
            case 8:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;
            default:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }

        return iblockstate;
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @SuppressWarnings("incomplete-switch")
    public int getMetaFromState(IBlockState state){
        int i = 0;
        i = i | ((Planks1.EnumType)state.getValue(VARIANT)).getMetadata();

        switch ((BlockLog.EnumAxis)state.getValue(LOG_AXIS)){
            case X:
                i |= 4;
                break;
            case Z:
                i |= 8;
                break;
            case NONE:
                i |= 12;
        }

        return i;
    }

    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {VARIANT, LOG_AXIS});
    }

    protected ItemStack getSilkTouchDrop(IBlockState state){
        return new ItemStack(Item.getItemFromBlock(this), 1, ((Planks1.EnumType)state.getValue(VARIANT)).getMetadata());
    }

    public int damageDropped(IBlockState state){
        return ((Planks1.EnumType)state.getValue(VARIANT)).getMetadata();
    }
}