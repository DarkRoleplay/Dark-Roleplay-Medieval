package net.dark_roleplay.medieval.common.events;

import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

@Mod.EventBusSubscriber(modid = DRPMedievalInfo.MODID)
public class KeyInput {

	@SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
		Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown();
	}
}
