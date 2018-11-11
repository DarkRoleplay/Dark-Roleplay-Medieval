package net.dark_roleplay.medieval.testing;

import org.lwjgl.input.Keyboard;

import net.dark_roleplay.medieval.References;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid = References.MODID,value = Side.CLIENT)
public class Keybinds {

	public static KeyBinding debugging = new KeyBinding("keyBinding.debuging2", Keyboard.KEY_N, "Dark Roleplay Core");

	@SubscribeEvent
	public static void KeyInput(KeyInputEvent event) {
		if(debugging.isKeyDown()) {
//			System.out.println("Test");
//			Minecraft.getMinecraft().displayGuiScreen(new GuiBrewing());
		}
	}

}
