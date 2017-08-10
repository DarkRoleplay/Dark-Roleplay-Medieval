package net.dark_roleplay.medieval.common.handler;

import java.util.ArrayList;

import net.dark_roleplay.drpcore.api.items.DRPItem;
import net.dark_roleplay.drpcore.api.items.ItemApi;
import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class DRPMedievalModels {

	static ArrayList<Item> toRegisterMeshes = new ArrayList<Item>();
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event){
		ItemApi.registerItemMeshs();

		for(Item item : toRegisterMeshes){
			registerItemMesh(item);
		}
		toRegisterMeshes = null;
		
		registerItemMesh("simple_chairs", DRPMedievalBlocks.SIMPLE_CHAIR_OAK);
		registerItemMesh("simple_chairs", DRPMedievalBlocks.SIMPLE_CHAIR_BIRCH);
		registerItemMesh("simple_chairs", DRPMedievalBlocks.SIMPLE_CHAIR_SPRUCE);
		registerItemMesh("simple_chairs", DRPMedievalBlocks.SIMPLE_CHAIR_JUNGLE);
		registerItemMesh("simple_chairs", DRPMedievalBlocks.SIMPLE_CHAIR_ACACIA);
		registerItemMesh("simple_chairs", DRPMedievalBlocks.SIMPLE_CHAIR_DARK_OAK);
	 	
		registerItemMesh("simple_tables", DRPMedievalBlocks.SIMPLE_TABLE_OAK);
		registerItemMesh("simple_tables", DRPMedievalBlocks.SIMPLE_TABLE_BIRCH);
		registerItemMesh("simple_tables", DRPMedievalBlocks.SIMPLE_TABLE_SPRUCE);
		registerItemMesh("simple_tables", DRPMedievalBlocks.SIMPLE_TABLE_JUNGLE);
		registerItemMesh("simple_tables", DRPMedievalBlocks.SIMPLE_TABLE_ACACIA);
		registerItemMesh("simple_tables", DRPMedievalBlocks.SIMPLE_TABLE_DARK_OAK);
		
		registerItemMesh("buckets",DRPMedievalBlocks.BUCKET_DIRT);
		
		// Old Blocks
		registerItemMesh(DRPMedievalBlocks.bookOne);
		registerItemMesh(DRPMedievalBlocks.ANVIL);
		registerItemMesh(DRPMedievalBlocks.GRINDSTONE);
		registerItemMesh(DRPMedievalBlocks.HANGING_CAULDRON);
		registerItemMesh(DRPMedievalBlocks.MORTAR);
		registerItemMesh(DRPMedievalBlocks.CAULDRON);
		registerItemMesh(DRPMedievalBlocks.ROPE_ANCHOR);
		registerItemMesh(DRPMedievalBlocks.FIREPIT);
		
		forceAdditionalModels();
	}
	
	public static void registerItemMesh(Block block) {
		registerItemMesh(null, Item.getItemFromBlock(block));
	}
	
	public static void registerItemMesh(String folder, Block block) {
		registerItemMesh(folder, Item.getItemFromBlock(block));
	}
	
	public static void registerItemMesh(Item item){
		if(item instanceof DRPItem){
			
		}else{
			registerItemMesh(null, item);
		}
	}
	
	public static void addItemToRegisterMesh(Item item) {
		toRegisterMeshes.add(item);
	}
	
	public static void registerItemMesh(String folder, Item item) {
	    String path = stringParseName(item.getUnlocalizedName().toString().substring(item.getUnlocalizedName().toString().indexOf(".") + 1, item.getUnlocalizedName().toString().length()));
		if(folder != null){
			path = stringParseName(folder) + "/" + path;
			ModelBakery.registerItemVariants(item,new ResourceLocation(DRPMedievalInfo.MODID + ":" + path));
		}
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(DRPMedievalInfo.MODID + ":" + path, "inventory"));
	}
	
	private static String stringParseName(String name){
		char[] nameArray = name.toCharArray();
		ArrayList<Character> nameList = new ArrayList();
		for(int i = 0; i < nameArray.length; i++){
			if(Character.isUpperCase(nameArray[i])){
				if(i > 0) {
					nameList.add('_');
				}
				nameList.add(Character.toLowerCase(nameArray[i]));
			}else{
				nameList.add(nameArray[i]);
			}
		}
		
		StringBuilder builder = new StringBuilder(nameList.size());
	    for(Character ch: nameList){
	    	builder.append(ch);
	    	}
	    return builder.toString();
	}
	
	public static void forceAdditionalModels() {
		ModelBakery.registerItemVariants(Item.getItemFromBlock(DRPMedievalBlocks.CLEAN_PLANKS), new ResourceLocation[] {new ResourceLocation(DRPMedievalInfo.MODID + ":" + "clean_planks/clean_plank_oak"), new ResourceLocation(DRPMedievalInfo.MODID + ":" + "clean_planks/clean_plank_spruce"), new ResourceLocation(DRPMedievalInfo.MODID + ":" + "clean_planks/clean_plank_birch"), new ResourceLocation(DRPMedievalInfo.MODID + ":" + "clean_planks/clean_plank_jungle"), new ResourceLocation(DRPMedievalInfo.MODID + ":" + "clean_planks/clean_plank_dark_oak"), new ResourceLocation(DRPMedievalInfo.MODID + ":" + "clean_planks/clean_plank_acacia")});
	
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(DRPMedievalBlocks.CLEAN_PLANKS), 0, new ModelResourceLocation(DRPMedievalInfo.MODID + ":" + "clean_planks/clean_plank_oak", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(DRPMedievalBlocks.CLEAN_PLANKS), 1, new ModelResourceLocation(DRPMedievalInfo.MODID + ":" + "clean_planks/clean_plank_spruce", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(DRPMedievalBlocks.CLEAN_PLANKS), 2, new ModelResourceLocation(DRPMedievalInfo.MODID + ":" + "clean_planks/clean_plank_birch", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(DRPMedievalBlocks.CLEAN_PLANKS), 3, new ModelResourceLocation(DRPMedievalInfo.MODID + ":" + "clean_planks/clean_plank_jungle", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(DRPMedievalBlocks.CLEAN_PLANKS), 4, new ModelResourceLocation(DRPMedievalInfo.MODID + ":" + "clean_planks/clean_plank_dark_oak", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(DRPMedievalBlocks.CLEAN_PLANKS), 5, new ModelResourceLocation(DRPMedievalInfo.MODID + ":" + "clean_planks/clean_plank_acacia", "inventory"));

	}
}
