package net.dark_roleplay.medieval.objects.events;

import java.util.List;

import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = DarkRoleplayMedieval.MODID, value = Dist.CLIENT)
public class TooltipEvents {

	public static final Tag<Item> HAS_DESCRIPTION =  new ItemTags.Wrapper(new ResourceLocation(DarkRoleplayMedieval.MODID, "has_description"));
	public static final Tag<Item> WORK_IN_PROGRESS =  new ItemTags.Wrapper(new ResourceLocation(DarkRoleplayMedieval.MODID, "work_in_progress"));

	@SubscribeEvent
	public static void getInformation(ItemTooltipEvent event) {
		Item item = event.getItemStack().getItem();
		
		if(WORK_IN_PROGRESS.contains(item)) {
			event.getToolTip().add(new TextComponentTranslation("guis.drpmedieval.tooltip_work_in_progress" , TextFormatting.YELLOW));
		}
		
		if(HAS_DESCRIPTION.contains(item)) {
			if(GuiScreen.isCtrlKeyDown()) {
				List<ITextComponent> tooltip = event.getToolTip();
				event.getToolTip().add(new TextComponentTranslation(String.format("item.description.%s.%s", item.getRegistryName().getNamespace(), item.getRegistryName().getPath()), TextFormatting.GRAY));
			}else {
				event.getToolTip().add(new TextComponentTranslation("guis.drpmedieval.tooltip_description" , TextFormatting.GRAY));
			}
		}
	}
	
}
