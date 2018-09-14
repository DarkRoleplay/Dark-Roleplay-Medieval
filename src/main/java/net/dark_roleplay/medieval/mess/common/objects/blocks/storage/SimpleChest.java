package net.dark_roleplay.medieval.mess.common.objects.blocks.storage;

import net.dark_roleplay.medieval.common.handler.MedievalGuis;
import net.dark_roleplay.medieval.mess.api.items.IKey;
import net.dark_roleplay.medieval.mess.api.items.ILock;
import net.dark_roleplay.medieval.mess.api.storage.LockStackHandler;
import net.dark_roleplay.medieval.mess.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalCapabilities;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.storage.TileEntity_SimpleStorage;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SimpleChest extends Block implements ITileEntityProvider{

	public SimpleChest(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
//		this.setCreativeTab(DRPMedievalCreativeTabs.UTILITY);
		this.setHardness(2F);
		this.setSoundType(SoundType.WOOD);
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntity_SimpleStorage(24);
	}


	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }
	
	 @Override
	 public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
	        if (world.isRemote)
				return true;
	        TileEntity te = world.getTileEntity(pos);
	        if (!(te instanceof TileEntity_SimpleStorage))
				return false;
	        
        	TileEntity_SimpleStorage teSS = (TileEntity_SimpleStorage) te;
        	LockStackHandler handler = teSS.getCapability(DRPMedievalCapabilities.LOCK_HANDLER_CAPABILITY, null);
        	System.out.println(handler.getStackInSlot(0).isEmpty());
        	if(handler.getStackInSlot(0).isEmpty() && player.getHeldItemMainhand().getItem() instanceof ILock){
        		player.setHeldItem(EnumHand.MAIN_HAND, handler.insertItem(0, player.getHeldItemMainhand(), false));
        	}else if(!handler.getStackInSlot(0).isEmpty() && handler.getStackInSlot(0).getItem() instanceof ILock){
        		if(player.getHeldItemMainhand().getItem() instanceof IKey){
        			ItemStack lock = handler.getStackInSlot(0);
            		if(((ILock) lock.getItem()).doesFit(lock, player.getHeldItemMainhand())){
            			if(player.isSneaking()){
            				ItemStack output = handler.extractItem(0, 1, false);
            				if(!player.inventory.addItemStackToInventory(output)){
            					world.spawnEntity(new EntityItem(player.world, player.posX, player.posY, player.posZ, output));
            				}
            			}else{
                	        player.openGui(DarkRoleplayMedieval.instance, MedievalGuis.GUI_SIMPLE_STORAGE, world, pos.getX(), pos.getY(), pos.getZ());
            			}
            	        return true;
            		}
        		}else{
        			player.sendStatusMessage(new TextComponentTranslation("drpcore.blocks.chest.locked"), true);
        		}
        	}else{
    	        player.openGui(DarkRoleplayMedieval.instance, MedievalGuis.GUI_SIMPLE_STORAGE, world, pos.getX(), pos.getY(), pos.getZ());
        	}
	        return true;
	    }
	
}
