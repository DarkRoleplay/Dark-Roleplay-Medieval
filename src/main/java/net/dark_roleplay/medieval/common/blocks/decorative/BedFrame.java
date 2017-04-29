package net.dark_roleplay.medieval.common.blocks.decorative;

import net.dark_roleplay.medieval.common.blocks.helper.AdvancedBed;
import net.dark_roleplay.medieval.common.blocks.helper.EnumMattressType;
import net.dark_roleplay.medieval.common.blocks.tileentitys.BedFrameTileEntity;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCapabilities;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.dark_roleplay.medieval.common.items.blocks.AdvancedBedItem;
import net.dark_roleplay.medieval.common.worldgen.feature.TreeTest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BedFrame extends AdvancedBed {
	
	AdvancedBedItem bed = null;
	
	public BedFrame(String registryName,AdvancedBedItem bed) {
		super(Material.WOOD,registryName,registryName);
		this.bed = bed;
	}
	
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state){
        return new ItemStack(bed);
    }

}
