package net.drpmedieval.common.achievements;

import net.drpmedieval.common.handler.DRPMedievalItems;
import net.drpmedieval.common.handler.DRPMedievalBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class Achievements {

	private Achievement[] achievements = new Achievement[] {this.DrpOpenInv, this.DrpOpenCraft, this.DrpCraftCrate, this.DrpCraftChoppingBlock, this.DrpCraftAnvil};
	public  AchievementPage DarkRoleplay = new AchievementPage("Dark Roleplay", achievements);
	
	//TODO Achievements
	public  Achievement DrpOpenInv = new Achievement("drp.achievement.openInv", "openDRPInventory", 0, 0, (Item) DRPMedievalItems.LeatherPurse, (Achievement) null);
	public  Achievement DrpOpenCraft = new Achievement("drp.achievement.openCraft", "openDRPCrafting", 0, 2, Blocks.CRAFTING_TABLE, (Achievement) null);
	public  Achievement DrpCraftChoppingBlock = new Achievement("drp.achievement.craftChoppingBlock", "craftChoppingBlock", 2, 2, DRPMedievalBlocks.CHOPPING_BLOCK, DrpOpenCraft);
	public  Achievement DrpCraftAnvil = new Achievement("drp.achievement.craftAnvil", "craftAnvil", 2, 4, DRPMedievalBlocks.ANVIL, DrpOpenCraft);
	public  Achievement DrpCraftCrate = new Achievement("drp.achievement.craftCrate", "craftCrate", 2, 6, DRPMedievalBlocks.CRATE, DrpOpenCraft);
}
