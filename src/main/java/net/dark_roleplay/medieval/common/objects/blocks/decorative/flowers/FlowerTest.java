package net.dark_roleplay.medieval.common.objects.blocks.decorative.flowers;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.common.objects.blocks.templates.FacedBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlowerTest extends FacedBlock {

	public FlowerTest(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
//		if(player.getHeldItem(hand).getItem() == Item.getItemFromBlock(Blocks.YELLOW_FLOWER) || player.getHeldItem(hand).getItem() == Item.getItemFromBlock(Blocks.RED_FLOWER) || player.getHeldItem(hand).getItem() == Item.getItemFromBlock(Blocks.DOUBLE_PLANT)) {
		if(player.getHeldItem(hand).getItem() instanceof ItemBlock) {
			TileEntity te = world.getTileEntity(pos);
			if(!(te instanceof FlowersTileEntity)) return false;
			
			FlowersTileEntity flower = (FlowersTileEntity) te;
			return flower.addFlower(player.getHeldItem(hand).copy(), world.isRemote);
		}
		
        return false;
    }

	@Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }
    
    @Nullable
    public TileEntity createTileEntity(World world, IBlockState state){
        return new FlowersTileEntity(4);
    }
}
