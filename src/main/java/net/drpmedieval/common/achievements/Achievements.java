package net.drpmedieval.common.achievements;

import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.items.DRPMedievalItems;
import net.minecraft.init.Blocks;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class Achievements {

	private final static Achievement[] achievements = new Achievement[] {Achievements.DrpOpenInv, Achievements.DrpOpenCraft, Achievements.DrpCraftCrate, Achievements.DrpCraftChoppingBlock, Achievements.DrpCraftAnvil};
	public static AchievementPage DarkRoleplay = new AchievementPage("Dark Roleplay", achievements);
	
	//TODO Achievements
	public static Achievement DrpOpenInv = new Achievement("drp.achievement.openInv", "openDRPInventory", 0, 0, DRPMedievalItems.LeatherPurse, (Achievement) null);
	public static Achievement DrpOpenCraft = new Achievement("drp.achievement.openCraft", "openDRPCrafting", 0, 2, Blocks.CRAFTING_TABLE, (Achievement) null);
	public static Achievement DrpCraftChoppingBlock = new Achievement("drp.achievement.craftChoppingBlock", "craftChoppingBlock", 2, 2, DRPMedievalBlocks.choppingBlock, DrpOpenCraft);
	public static Achievement DrpCraftAnvil = new Achievement("drp.achievement.craftAnvil", "craftAnvil", 2, 4, DRPMedievalBlocks.anvil, DrpOpenCraft);
	public static Achievement DrpCraftCrate = new Achievement("drp.achievement.craftCrate", "craftCrate", 2, 6, DRPMedievalBlocks.crate, DrpOpenCraft);
}
