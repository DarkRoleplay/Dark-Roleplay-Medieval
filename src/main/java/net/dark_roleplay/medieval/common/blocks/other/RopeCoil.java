package net.dark_roleplay.medieval.common.blocks.other;

import java.util.Random;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.common.blocks.tileentitys.RopeCoilTileEntity;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;

public class RopeCoil extends BlockContainer{

	public static final PropertyBool POWERED = PropertyBool.create("powered");
	
	public RopeCoil(String registryName) {
	    super(Material.WOOD);
	    this.setRegistryName(registryName);
	    this.setUnlocalizedName(registryName);
	    this.setCreativeTab(DRPMedievalCreativeTabs.BUILDING_MATS);
	    this.setHardness(2.0F);
	    this.setSoundType(SoundType.WOOD);
        this.isBlockContainer = true;
    }	

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new RopeCoilTileEntity();
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state){
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	protected BlockStateContainer createBlockState(){
		return new BlockStateContainer(this, new IProperty[] {POWERED});
	}
	
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos){
		if (!world.isRemote) {
            if (state.getValue(POWERED) && !world.isBlockPowered(pos)){
            	world.setBlockState(pos, state.cycleProperty(POWERED));
            }else if(!state.getValue(POWERED) && world.isBlockPowered(pos)){
            	world.setBlockState(pos, state.cycleProperty(POWERED));
            }
        }

    }
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(POWERED, meta > 0 ? true : false);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		if(state.getValue(POWERED)){
			return 1;
		}
		return 0;
	}
}