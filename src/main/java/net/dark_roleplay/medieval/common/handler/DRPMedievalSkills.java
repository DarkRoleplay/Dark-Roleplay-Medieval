package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.drpcore.api.skills.Skill;
import net.dark_roleplay.drpcore.api.skills.SkillPoint;
import net.dark_roleplay.drpcore.api.skills.SkillTree;
import net.dark_roleplay.drpcore.common.skills.SkillRegistry;
import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class DRPMedievalSkills {

	public static SkillPoint POINT_PROFESSION;

	private static SkillTree PROFESSION_TREE;
	
	private static SkillTree LUMBERJACK;
	private static SkillTree CARPENTER;
	private static SkillTree MINER;
	private static SkillTree MASON;
	private static SkillTree SMITH;
	private static SkillTree HUNTER;
	private static SkillTree FARMER;
	private static SkillTree COOK;
	
	private static Skill BASIC_TREE_CUTTING;
	private static Skill BASIC_CARPENTING;
	private static Skill BASIC_MINING;
	private static Skill BASIC_STONE_CUTTING;
	private static Skill BASIC_ORE_PROCESSING;
	private static Skill BASIC_ANATOMY;
	private static Skill BASIC_SEED_KNOWLEDGE;
	private static Skill BASIC_STEWS;
	
	
	private static Skill TEST_SKILL_1;
	private static Skill TEST_SKILL_2;
		
	public static final void init(FMLPreInitializationEvent event) {}
	
	public static final void init(FMLInitializationEvent event) {
		String prefix = DRPMedievalInfo.MODID + ":";
		
		SkillRegistry.registerSkillPoint(DRPMedievalSkills.POINT_PROFESSION = new SkillPoint(prefix + "profession_point", prefix + "profession_point", 1, new ItemStack(Blocks.CRAFTING_TABLE)));
		
//		DRPMedievalSkills.LUMBERJACK = new SkillTree(prefix + "lumberjack", prefix + "lumberjack", new ItemStack(Items.IRON_AXE), null);
		
		DRPMedievalSkills.PROFESSION_TREE = new SkillTree(prefix + "profession_tree", prefix + "profession_tree", new ItemStack(Blocks.CRAFTING_TABLE), null);

//		DRPMedievalSkills.TEMPORARY.addSkill(DRPMedievalSkills. = new Skill(prefix + "basic_", prefix + "basic__desc", new ItemStack(DRPMedievalBlocks.CHOPPING_BLOCK), -, 0).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));

		
		DRPMedievalSkills.PROFESSION_TREE.addSkill(DRPMedievalSkills.BASIC_TREE_CUTTING = new Skill(prefix + "basic_tree_cutting", prefix + "basic_tree_cutting.desc", new ItemStack(Items.WOODEN_AXE), -4, -2).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));
		DRPMedievalSkills.PROFESSION_TREE.addSkill(DRPMedievalSkills.BASIC_CARPENTING = new Skill(prefix + "basic_carpenting", prefix + "basic_carpenting.desc", new ItemStack(DRPMedievalBlocks.SIMPLE_CHAIR_SPRUCE), -4, 0).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));
		DRPMedievalSkills.PROFESSION_TREE.addSkill(DRPMedievalSkills.BASIC_MINING = new Skill(prefix + "basic_mining", prefix + "basic_mining.desc", new ItemStack(Items.WOODEN_PICKAXE), -2, 0).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));
		DRPMedievalSkills.PROFESSION_TREE.addSkill(DRPMedievalSkills.BASIC_STONE_CUTTING = new Skill(prefix + "basic_stone_cutting", prefix + "basic_stone_cutting.desc", new ItemStack(DRPMedievalBlocks.DIORITE_BRICKS), 0, 0).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));
		DRPMedievalSkills.PROFESSION_TREE.addSkill(DRPMedievalSkills.BASIC_ORE_PROCESSING = new Skill(prefix + "basic_ore_processing", prefix + "basic_ore_processing.desc", new ItemStack(DRPMedievalItems.COPPER_ORE_CHUNK), 2, 0).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));
		DRPMedievalSkills.PROFESSION_TREE.addSkill(DRPMedievalSkills.BASIC_ANATOMY = new Skill(prefix + "basic_anatomy", prefix + "basic_anatomy.desc", new ItemStack(Items.LEATHER), 4, 0).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));
		DRPMedievalSkills.PROFESSION_TREE.addSkill(DRPMedievalSkills.BASIC_SEED_KNOWLEDGE = new Skill(prefix + "basic_seed_knowledge", prefix + "basic_seed_knowledge.desc", new ItemStack(Items.WOODEN_HOE), 0,-2).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));
		DRPMedievalSkills.PROFESSION_TREE.addSkill(DRPMedievalSkills.BASIC_STEWS = new Skill(prefix + "basic_stews", prefix + "basic_stews.desc", new ItemStack(Items.MUSHROOM_STEW), -2, -2).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));

		
		SkillRegistry.registerSkillTree(DRPMedievalSkills.PROFESSION_TREE);

	}

	public static final void init(FMLPostInitializationEvent event) {}
	
	
}
