package net.dark_roleplay.medieval.objects.helper;

import net.dark_roleplay.medieval.objects.enums.TelescopeZoom;
import net.dark_roleplay.medieval.objects.items.equipment.tools.ItemTelescope;
import net.minecraft.client.Minecraft;

public class TelescopeHelper {

	private static TelescopeZoom currentZoom = TelescopeZoom.NONE;
	
	public static TelescopeZoom getCurrentZoom() {
		if(currentZoom != TelescopeZoom.NONE && !(Minecraft.getInstance().player.getHeldItemMainhand().getItem() instanceof ItemTelescope))
			currentZoom = TelescopeZoom.NONE;
		return currentZoom;
	}
	
	public static void increaseZoom() {
		switch(currentZoom) {
			case NONE:
				currentZoom = TelescopeZoom.LOW;
				break;
			case LOW:
				currentZoom = TelescopeZoom.MEDIUM;
				break;
			case MEDIUM:
				currentZoom = TelescopeZoom.HIGH;
				break;
			case HIGH:
				currentZoom = TelescopeZoom.NONE;
				break;
			default:
				currentZoom = TelescopeZoom.NONE;
				break;
		}
	}
	
	public static void resetZoom() {
		currentZoom = TelescopeZoom.NONE;
	}
	
	public static void decreaseZoom() {
		switch(currentZoom) {
		case NONE:
			currentZoom = TelescopeZoom.NONE;
			break;
		case LOW:
			currentZoom = TelescopeZoom.NONE;
			break;
		case MEDIUM:
			currentZoom = TelescopeZoom.LOW;
			break;
		case HIGH:
			currentZoom = TelescopeZoom.MEDIUM;
			break;
		default:
			currentZoom = TelescopeZoom.NONE;
			break;
	}
	}
}
