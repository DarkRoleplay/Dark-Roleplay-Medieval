package net.dark_roleplay.medieval.common.handler;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class DRPMedievalSkills {
//
//	public static SkillPoint POINT_PROFESSION;
//
//	private static SkillTree PROFESSION_TREE;
//	
//	private static SkillTree LUMBERJACK;
//	private static SkillTree CARPENTER;
//	private static SkillTree MINER;
//	private static SkillTree MASON;
//	private static SkillTree SMITH;
//	private static SkillTree HUNTER;
//	private static SkillTree FARMER;
//	private static SkillTree COOK;
//	
//	public static Skill BASIC_TREE_CUTTING;
//	public static Skill BASIC_CARPENTING;
//	public static Skill BASIC_MINING;
//	public static Skill BASIC_STONE_CUTTING;
//	public static Skill BASIC_ORE_PROCESSING;
//	public static Skill BASIC_ANATOMY;
//	public static Skill BASIC_SEED_KNOWLEDGE;
//	public static Skill BASIC_STEWS;
//	
//	
//	private static Skill TEST_SKILL_1;
//	private static Skill TEST_SKILL_2;
		
	public static final void init(FMLPreInitializationEvent event) {}
	
	public static final void init(FMLInitializationEvent event) {
//		String prefix = DRPMedievalInfo.MODID + ":";
//		
//		SkillRegistry.registerSkillPoint(DRPMedievalSkills.POINT_PROFESSION = new SkillPoint(prefix + "profession_point", prefix + "profession_point", 1, new ItemStack(Blocks.CRAFTING_TABLE)));
//		
////		DRPMedievalSkills.LUMBERJACK = new SkillTree(prefix + "lumberjack", prefix + "lumberjack", new ItemStack(Items.IRON_AXE), null);
//		
//		DRPMedievalSkills.PROFESSION_TREE = new SkillTree(prefix + "profession_tree", prefix + "profession_tree", new ItemStack(Blocks.CRAFTING_TABLE), null);
//		DRPMedievalSkills.LUMBERJACK = new SkillTree(prefix + "lumberjack", prefix + "lumberjack", new ItemStack(Items.IRON_AXE), null);
//		DRPMedievalSkills.CARPENTER = new SkillTree(prefix + "carpenter", prefix + "carpenter", new ItemStack(Items.IRON_AXE), null);
//		DRPMedievalSkills.MINER = new SkillTree(prefix + "miner", prefix + "miner", new ItemStack(Items.IRON_AXE), null);
//		DRPMedievalSkills.MASON = new SkillTree(prefix + "mason", prefix + "mason", new ItemStack(Items.IRON_AXE), null);
//		DRPMedievalSkills.SMITH = new SkillTree(prefix + "smith", prefix + "smith", new ItemStack(Items.IRON_AXE), null);
//		DRPMedievalSkills.HUNTER = new SkillTree(prefix + "hunter", prefix + "hunter", new ItemStack(Items.IRON_AXE), null);
//		DRPMedievalSkills.FARMER = new SkillTree(prefix + "farmer", prefix + "farmer", new ItemStack(Items.IRON_AXE), null);
//		DRPMedievalSkills.COOK = new SkillTree(prefix + "cook", prefix + "cook", new ItemStack(Items.IRON_AXE), null);
//
//		
////		DRPMedievalSkills.TEMPORARY.addSkill(DRPMedievalSkills. = new Skill(prefix + "basic_", prefix + "basic__desc", new ItemStack(DRPMedievalBlocks.CHOPPING_BLOCK), -, 0).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));
//
//		
//		DRPMedievalSkills.PROFESSION_TREE.addSkill(DRPMedievalSkills.BASIC_TREE_CUTTING = new Skill(prefix + "basic_tree_cutting", prefix + "basic_tree_cutting.desc", new ItemStack(Items.WOODEN_AXE), -4, -2).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));
//		DRPMedievalSkills.PROFESSION_TREE.addSkill(DRPMedievalSkills.BASIC_CARPENTING = new Skill(prefix + "basic_carpenting", prefix + "basic_carpenting.desc", new ItemStack(DRPMedievalBlocks.SIMPLE_CHAIR_SPRUCE), -4, 0).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));
//		DRPMedievalSkills.PROFESSION_TREE.addSkill(DRPMedievalSkills.BASIC_MINING = new Skill(prefix + "basic_mining", prefix + "basic_mining.desc", new ItemStack(Items.WOODEN_PICKAXE), -2, 0).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));
//		DRPMedievalSkills.PROFESSION_TREE.addSkill(DRPMedievalSkills.BASIC_STONE_CUTTING = new Skill(prefix + "basic_stone_cutting", prefix + "basic_stone_cutting.desc", new ItemStack(DRPMedievalBlocks.DIORITE_BRICKS), 0, 0).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));
//		DRPMedievalSkills.PROFESSION_TREE.addSkill(DRPMedievalSkills.BASIC_ORE_PROCESSING = new Skill(prefix + "basic_ore_processing", prefix + "basic_ore_processing.desc", new ItemStack(DRPMedievalItems.ORE_CHUNK_COPPER), 2, 0).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));
//		DRPMedievalSkills.PROFESSION_TREE.addSkill(DRPMedievalSkills.BASIC_ANATOMY = new Skill(prefix + "basic_anatomy", prefix + "basic_anatomy.desc", new ItemStack(Items.LEATHER), 4, 0).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));
//		DRPMedievalSkills.PROFESSION_TREE.addSkill(DRPMedievalSkills.BASIC_SEED_KNOWLEDGE = new Skill(prefix + "basic_seed_knowledge", prefix + "basic_seed_knowledge.desc", new ItemStack(Items.WOODEN_HOE), 0,-2).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));
//		DRPMedievalSkills.PROFESSION_TREE.addSkill(DRPMedievalSkills.BASIC_STEWS = new Skill(prefix + "basic_stews", prefix + "basic_stews.desc", new ItemStack(Items.MUSHROOM_STEW), -2, -2).addRequiredSkillPoint(DRPMedievalSkills.POINT_PROFESSION));
//
//		DRPMedievalSkills.LUMBERJACK.addSkill(DRPMedievalSkills.BASIC_TREE_CUTTING);
//		DRPMedievalSkills.CARPENTER.addSkill(DRPMedievalSkills.BASIC_CARPENTING);
//		DRPMedievalSkills.MINER.addSkill(DRPMedievalSkills.BASIC_MINING);
//		DRPMedievalSkills.MASON.addSkill(DRPMedievalSkills.BASIC_STONE_CUTTING);
//		DRPMedievalSkills.SMITH.addSkill(DRPMedievalSkills.BASIC_ORE_PROCESSING);
//		DRPMedievalSkills.HUNTER.addSkill(DRPMedievalSkills.BASIC_ANATOMY);
//		DRPMedievalSkills.FARMER.addSkill(DRPMedievalSkills.BASIC_SEED_KNOWLEDGE);
//		DRPMedievalSkills.COOK.addSkill(DRPMedievalSkills.BASIC_STEWS);
//		
//		SkillRegistry.registerSkillTree(DRPMedievalSkills.PROFESSION_TREE);
//		SkillRegistry.registerSkillTree(DRPMedievalSkills.LUMBERJACK);
//		SkillRegistry.registerSkillTree(DRPMedievalSkills.CARPENTER);
//		SkillRegistry.registerSkillTree(DRPMedievalSkills.MINER);
//		SkillRegistry.registerSkillTree(DRPMedievalSkills.MASON);
//		SkillRegistry.registerSkillTree(DRPMedievalSkills.SMITH);
//		SkillRegistry.registerSkillTree(DRPMedievalSkills.HUNTER);
//		SkillRegistry.registerSkillTree(DRPMedievalSkills.FARMER);
//		SkillRegistry.registerSkillTree(DRPMedievalSkills.COOK);

	}

	public static final void init(FMLPostInitializationEvent event) {}
	
	
}
