package net.dark_roleplay.medieval.objects.blocks.decoration.shop_signs;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.holders.MedievalItems;
import net.dark_roleplay.medieval.objects.blocks.decoration.wall_mounted.WallMounted;
import net.dark_roleplay.medieval.objects.guis.sign_drawing.GuiSignDrawing;
import net.dark_roleplay.medieval.objects.other.ImageConversion;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
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
		if(world.isRemote && player.getHeldItem(hand).getItem() == MedievalItems.DIRTY_PAINTBRUSH){
			Minecraft.getMinecraft().displayGuiScreen(new GuiSignDrawing((TileEntityShopSign) world.getTileEntity(pos)));
		}
		return true;
	}

	@Override
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune){}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state){
		TileEntity te = worldIn.getTileEntity(pos);

		ItemStack stack = new ItemStack(Item.getItemFromBlock(this), 1, this.damageDropped(state));

		if (te instanceof TileEntityShopSign){
			TileEntityShopSign tes = (TileEntityShopSign) te;
			stack.setTagCompound(ImageConversion.imgToNBT(tes.getIMG()));
			spawnAsEntity(worldIn, pos, stack);
		}
		worldIn.updateComparatorOutputLevel(pos, state.getBlock());

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		TileEntity te = world.getTileEntity(pos);
		if(te instanceof TileEntityShopSign){
			TileEntityShopSign tes = (TileEntityShopSign) te;
			if(stack.hasTagCompound())
				tes.setDrawing(ImageConversion.imgFromNBT(stack.getTagCompound()));
		}
	}
}
