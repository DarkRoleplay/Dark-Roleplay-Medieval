package net.dark_roleplay.medieval.common.blocks.storage;

import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.blocks.tileentities.storage.TileEntity_SimpleStorage;
import net.dark_roleplay.medieval.common.gui.GuiHandler;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SimpleChest extends Block implements ITileEntityProvider{

	public SimpleChest(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.UTILITY);
		this.setHardness(2F);
		this.setSoundType(SoundType.WOOD);
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntity_SimpleStorage(24);
	}

	//DEBUG STUFF TODO REMOVE
	 @Override
	 public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
	        // Only execute on the server
	        if (world.isRemote)
				return true;
	        TileEntity te = world.getTileEntity(pos);
	        if (!(te instanceof TileEntity_SimpleStorage))
				return false;
	        player.openGui(DarkRoleplayMedieval.instance, GuiHandler.GUI_SIMPLE_STORAGE, world, pos.getX(), pos.getY(), pos.getZ());
	        return true;
	    }
	
}
