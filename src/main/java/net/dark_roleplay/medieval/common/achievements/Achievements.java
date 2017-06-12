package net.dark_roleplay.medieval.common.achievements;

import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.minecraft.init.Blocks;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class Achievements {

	private Achievement[] achievements = new Achievement[] {this.DrpOpenInv, this.DrpOpenCraft, this.DrpCraftCrate, this.DrpCraftChoppingBlock, this.DrpCraftAnvil};
	public  AchievementPage DarkRoleplay = new AchievementPage("Dark Roleplay", this.achievements);
	
	//TODO Achievements
	public  Achievement DrpOpenInv = new Achievement("drp.achievement.openInv", "openDRPInventory", 0, 0, DRPMedievalItems.LeatherPurse, (Achievement) null);
	public  Achievement DrpOpenCraft = new Achievement("drp.achievement.openCraft", "openDRPCrafting", 0, 2, Blocks.CRAFTING_TABLE, (Achievement) null);
	public  Achievement DrpCraftChoppingBlock = new Achievement("drp.achievement.craftChoppingBlock", "craftChoppingBlock", 2, 2, DRPMedievalBlocks.CHOPPING_BLOCK, this.DrpOpenCraft);
	public  Achievement DrpCraftAnvil = new Achievement("drp.achievement.craftAnvil", "craftAnvil", 2, 4, DRPMedievalBlocks.ANVIL, this.DrpOpenCraft);
	public  Achievement DrpCraftCrate = new Achievement("drp.achievement.craftCrate", "craftCrate", 2, 6, DRPMedievalBlocks.CRATE, this.DrpOpenCraft);
}
