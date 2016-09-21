package net.drpmedieval.client.sound;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SoundEvents {
	
	public static SoundEvent ShipsBell;
	

	/**
	 * Register the {@link SoundEvent}s.
	 */
	public static void registerSounds() {
		ShipsBell = registerSound("block.ships_bell");
	}

	/**
	 * Register a {@link SoundEvent}.
	 *
	 * @param soundName The SoundEvent's name without the testmod3 prefix
	 * @return The SoundEvent
	 */
	private static SoundEvent registerSound(String soundName) {
		final ResourceLocation soundID = new ResourceLocation(DarkRoleplayMedieval.MODID, soundName);
		return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
	}
	
}
