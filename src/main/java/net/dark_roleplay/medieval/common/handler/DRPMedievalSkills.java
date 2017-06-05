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

	public static SkillPoint TEST_POINT = new SkillPoint("drpcore:test_point", "drpcore.test_point", 5, "drpcore.test_point_desc", new ItemStack(Items.APPLE));
	public static SkillPoint TEST_POINT2 = new SkillPoint("drpcore:test_point2", "drpcore.test_poin2t", 5, "drpcore.test_point_desc2", new ItemStack(Items.IRON_PICKAXE));
	
	private static Skill TEST_SKILL_1;
	private static Skill TEST_SKILL_2;
	
	private static SkillTree TEST_SKILL_TREE = new SkillTree("drpcore:test_skill_tree", "drpcore:test_skill_tree", new ItemStack(Items.BED), null);
	
	public static final void init(FMLPreInitializationEvent event) {}
	
	public static final void init(FMLInitializationEvent event) {
		String prefix = DRPMedievalInfo.MODID + ":";
		
		SkillRegistry.registerSkillPoint(DRPMedievalSkills.TEST_POINT);
		SkillRegistry.registerSkillPoint(DRPMedievalSkills.TEST_POINT2);
		
		SkillRegistry.registerSkillPoint(DRPMedievalSkills.POINT_PROFESSION = new SkillPoint(prefix + "profession_point", prefix + "proffesion_point",  1, prefix + "proffesion_point_desc", new ItemStack(Blocks.CRAFTING_TABLE)));
		
		
		DRPMedievalSkills.TEST_SKILL_1 = new Skill("drpcore:test_skill_1", "drpcore:test_skill_1", new ItemStack(Items.BAKED_POTATO), 0, 0).addRequiredSkillPoints(DRPMedievalSkills.POINT_PROFESSION, (byte) 3).addRequiredSkillPoints(DRPMedievalSkills.POINT_PROFESSION, (byte) 1) ;
		DRPMedievalSkills.TEST_SKILL_2 = new Skill("drpcore:test_skill_2", "drpcore:test_skill_2", new ItemStack(Items.BAKED_POTATO), 2, 0).addRequiredSkillPoints(DRPMedievalSkills.POINT_PROFESSION, (byte) 1);
		
		DRPMedievalSkills.TEST_SKILL_TREE.addSkill(DRPMedievalSkills.TEST_SKILL_1);
		DRPMedievalSkills.TEST_SKILL_2.addParent(DRPMedievalSkills.TEST_SKILL_1);
		DRPMedievalSkills.TEST_SKILL_TREE.addSkill(DRPMedievalSkills.TEST_SKILL_2);
		
		SkillRegistry.registerSkillTree(DRPMedievalSkills.TEST_SKILL_TREE);
	}

	public static final void init(FMLPostInitializationEvent event) {}
	
	
}
