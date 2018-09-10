package net.dark_roleplay.medieval.mess.common.handler;

import java.util.ArrayList;

import net.dark_roleplay.library_old.items.DRPItem;
import net.dark_roleplay.library_old.items.ItemUtil;
import net.dark_roleplay.medieval.mess.common.References;
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
		ItemUtil.registerItemMeshs();

		for(Item item : toRegisterMeshes){
			registerItemMesh(item);
		}
		toRegisterMeshes = null;

		
		// Old Blocks
		registerItemMesh(DRPMedievalBlocks.ANVIL);
		registerItemMesh(DRPMedievalBlocks.GRINDSTONE);
		registerItemMesh(DRPMedievalBlocks.HANGING_CAULDRON);
		registerItemMesh(DRPMedievalBlocks.MORTAR);
		registerItemMesh(DRPMedievalBlocks.CAULDRON);
		registerItemMesh(DRPMedievalBlocks.ROPE_ANCHOR);
		registerItemMesh(DRPMedievalBlocks.FIREPIT_LIT);
		
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
			ModelBakery.registerItemVariants(item,new ResourceLocation(References.MODID + ":" + path));
		}
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(References.MODID + ":" + path, "inventory"));
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

	}
}
