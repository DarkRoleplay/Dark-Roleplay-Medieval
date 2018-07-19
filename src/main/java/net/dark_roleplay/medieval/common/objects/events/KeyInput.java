package net.dark_roleplay.medieval.common.objects.events;

import net.dark_roleplay.medieval.common.References;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

@Mod.EventBusSubscriber(modid = References.MODID)
public class KeyInput {

	@SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
		Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown();
	}
}
