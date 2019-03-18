package net.dark_roleplay.medieval.minigame;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class MinigameHandler {
	
	private static final Map<Integer, IMinigame> activeMinigames = new HashMap<Integer, IMinigame>();
	
	private static int currentID = 0;
	
	private static Logger LOGGER = LogManager.getLogger("drpmedieval-minigames");
	
	public static void setupCommonStuff(FMLCommonSetupEvent event) {
//		SimpleChannel channel = new SimpleChannel
	}

	
	public static int launchGame(ResourceLocation location) {
		Optional<Supplier<IMinigame>> supplier = MinigameRegistry.getMinigameSupplier(location);
		if(!supplier.isPresent()) {
			LOGGER.warn("Failed attempt to initialize not existing minigame of type: %s", location.toString());
			return -1;
		}
		
		currentID += 1;
		IMinigame game = supplier.get().get();
		activeMinigames.put(currentID, game);
		return currentID;
	}
	
	public static Optional<IMinigame> getMinigame(int id) {
		if(activeMinigames.containsKey(id)) return Optional.of(activeMinigames.get(id));
		return Optional.empty();
	}
}
