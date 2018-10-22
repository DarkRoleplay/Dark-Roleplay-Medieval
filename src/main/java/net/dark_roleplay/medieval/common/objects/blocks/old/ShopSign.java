package net.dark_roleplay.medieval.common.objects.blocks.old;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.common.handler.MedievalItemsOld;
import net.dark_roleplay.medieval.common.objects.blocks.old.wall_mounted.WallMounted;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_ShopSign;
import net.dark_roleplay.medieval.old.GuiUtil;
import net.dark_roleplay.medieval.old.ImageConversion;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ShopSign extends WallMounted{

	public ShopSign(String registryName, BlockSettings settings) {
		super(registryName, settings, new AxisAlignedBB(0.4375F, -0.3125F, -0.3125F, 0.5625F, 1F, 1F));
		this.setHarvestLevel("none", 0);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote && player.getHeldItem(hand).getItem() == MedievalItemsOld.BLACK_PAINTBRUSH){
			GuiUtil.openShopSignGui(world, pos);
		}
		return true;
	}

	@Override
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune){}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state){
		TileEntity te = worldIn.getTileEntity(pos);

		ItemStack stack = new ItemStack(Item.getItemFromBlock(this), 1, this.damageDropped(state));

		if (te instanceof TE_ShopSign){
			TE_ShopSign tes = (TE_ShopSign) te;
			stack.setTagCompound(ImageConversion.imgToNBT(tes.getIMG()));
			spawnAsEntity(worldIn, pos, stack);
		}
		worldIn.updateComparatorOutputLevel(pos, state.getBlock());

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		TileEntity te = world.getTileEntity(pos);
		if(te instanceof TE_ShopSign){
			TE_ShopSign tes = (TE_ShopSign) te;
			if(stack.hasTagCompound())
				tes.setDrawing(ImageConversion.imgFromNBT(stack.getTagCompound()));
		}
	}
}
