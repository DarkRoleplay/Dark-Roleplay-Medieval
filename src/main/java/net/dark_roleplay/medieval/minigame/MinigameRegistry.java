package net.dark_roleplay.medieval.minigame;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import net.minecraft.util.ResourceLocation;

public class MinigameRegistry {

	private static final Map<ResourceLocation, Supplier<IMinigame>> minigames = new HashMap<ResourceLocation, Supplier<IMinigame>>();
		
	public static void registerMinigame(ResourceLocation registryName, Supplier<IMinigame> supplier) {
		minigames.put(registryName, supplier);
	}
	
	public static Optional<Supplier<IMinigame>> getMinigameSupplier(ResourceLocation location){
		if(minigames.containsKey(location)) return Optional.of(minigames.get(location));
		return Optional.empty();
	}
}
