package net.drpmedieval.common.achievements;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class AchievementPages {

	private final static Achievement[] achievements = new Achievement[] {Achievements.DrpOpenInv, Achievements.DrpOpenCraft, Achievements.DrpCraftCrate, Achievements.DrpCraftChoppingBlock, Achievements.DrpCraftAnvil};
	public static AchievementPage DarkRoleplay = new AchievementPage("Dark Roleplay", achievements);
	// static final Achievement VegieStew = new Achievement(2001, "VegieStew",
	// 1, -2, DarkRoleplayFood.itemVegieStew, null);

	public static void Load(FMLInitializationEvent event) {

		AchievementPage.registerAchievementPage(DarkRoleplay);
	}

}
