package net.drpmedieval.common.items.book;

import org.lwjgl.util.Point;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class WriteablePage extends Item{
	
	public WriteablePage() {
		this.setRegistryName("WriteablePage");
		this.setUnlocalizedName("WriteablePage");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
		this.setMaxStackSize(1);
	}
	
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		
		 NBTTagCompound tag = stack.getTagCompound();
		 if(tag == null)
			 tag = new NBTTagCompound();
		 if(tag.hasKey("test")){
			 TextComponent tc = new TextComponent();
			 tc.parseFromCompound((NBTTagCompound) tag.getTag("test"));
			 playerIn.addChatMessage(new TextComponentString(tc.getText()));
		 }else{
			 NBTTagCompound[] texts = new NBTTagCompound[5];
			 
			 texts[0] = new TextComponent(new Point(0,0),"This is a simple test $0").parseToCompound();
			
			 tag.setTag("test", texts[0]);
			 stack.setTagCompound(tag);
		 }

		
        return EnumActionResult.PASS;
    }

}
