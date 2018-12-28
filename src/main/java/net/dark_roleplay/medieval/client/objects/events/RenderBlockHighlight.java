package net.dark_roleplay.medieval.client.objects.events;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//@EventBusSubscriber(modid = References.MODID, value = Side.CLIENT)
public class RenderBlockHighlight {

	//TODO create Placement preview for special (large) blocks
	@SubscribeEvent
	public static void highlightGhostBlock(DrawBlockHighlightEvent event){
		RayTraceResult result = event.getTarget();
		BlockPos target = result.getBlockPos();
		if(target == null || event.getPlayer().getEntityWorld().isAirBlock(target))
			return;


	}
}
