package net.dark_roleplay.medieval.handler;

import java.util.ArrayList;

import net.dark_roleplay.core_modules.maarg.api.arg.MaterialRequirements;
import net.dark_roleplay.core_modules.maarg.api.materials.Material;
import net.dark_roleplay.core_modules.maarg.handler.MaterialRegistry;
import net.dark_roleplay.library.experimental.connected_model.ConnectedModelLoader;
import net.dark_roleplay.library_old.items.DRPItem;
import net.dark_roleplay.library_old.items.ItemUtil;
import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties;
import net.dark_roleplay.medieval.common.objects.blocks.state_mappers.SnowStateMapper;
import net.dark_roleplay.medieval.holders.MedievalBlocks;
import net.dark_roleplay.medieval.holders.MedievalItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(modid = References.MODID, value = Side.CLIENT)
public class ModelRegistryHandler {

	static ArrayList<Item> toRegisterMeshes = new ArrayList<Item>();

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerModels(ModelRegistryEvent event){
		ItemUtil.registerItemMeshs();

		for(Item item : toRegisterMeshes){
			registerItemMesh(item);
		}
		toRegisterMeshes = null;

		// Old Blocks
		registerItemMesh("old_blocks", MedievalBlocks.ANVIL);
		registerItemMesh("old_blocks", MedievalBlocks.GRINDSTONE);
		registerItemMesh("old_blocks", MedievalBlocks.HANGING_CAULDRON);
		registerItemMesh("old_blocks", MedievalBlocks.MORTAR);
		registerItemMesh("old_blocks", MedievalBlocks.CAULDRON);
		registerItemMesh("old_blocks", MedievalBlocks.ROPE_ANCHOR);
		registerItemMesh("old_blocks", MedievalBlocks.FIREPIT_LIT);
		registerItemMesh("blocks", MedievalItems.TIMBERED_CLAY);

		IStateMapper roofMapper = SnowStateMapper.INSTANCE;
//		IStateMapper test = new StateMap.Builder().
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.CLAY_SHINGLE_ROOF				, roofMapper);
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.WHITE_CLAY_SHINGLE_ROOF 		, roofMapper);
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.ORANGE_CLAY_SHINGLE_ROOF 		, roofMapper);
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.MAGENTA_CLAY_SHINGLE_ROOF 	, roofMapper);
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.LIGHT_BLUE_CLAY_SHINGLE_ROOF 	, roofMapper);
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.YELLOW_CLAY_SHINGLE_ROOF 		, roofMapper);
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.LIGHT_GREEN_CLAY_SHINGLE_ROOF , roofMapper);
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.PINK_CLAY_SHINGLE_ROOF 		, roofMapper);
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.GRAY_CLAY_SHINGLE_ROOF 		, roofMapper);
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.LIGHT_GRAY_CLAY_SHINGLE_ROOF 	, roofMapper);
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.CYAN_CLAY_SHINGLE_ROOF 		, roofMapper);
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.PURPLE_CLAY_SHINGLE_ROOF 		, roofMapper);
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.BLUE_CLAY_SHINGLE_ROOF 		, roofMapper);
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.BROWN_CLAY_SHINGLE_ROOF 		, roofMapper);
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.GREEN_CLAY_SHINGLE_ROOF 		, roofMapper);
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.RED_CLAY_SHINGLE_ROOF 		, roofMapper);
		ModelLoader.setCustomStateMapper(MedievalBlocks.Roofs.BLACK_CLAY_SHINGLE_ROOF 		, roofMapper);

		IStateMapper candlesRemover = new StateMap.Builder().ignore(BlockProperties.BURNING_CANDLES).build();
		ModelLoader.setCustomStateMapper(MedievalBlocks.ADVENT_WREATH, candlesRemover);

		MaterialRequirements cleanPlankRequired = new MaterialRequirements("clean_planks");

		for(Material mat : MaterialRegistry.getMaterialsForType("wood")){
			if(cleanPlankRequired.doesFulfillRequirements(mat)) {
				Block b = Block.getBlockFromName("drpmedieval:" +mat.getName() + "_shingle_roof");
				ModelLoader.setCustomStateMapper(b, roofMapper);

				ModelLoader.setCustomStateMapper(MedievalBlocks.ADVENT_WREATH, candlesRemover);
			}
		}

		//TODO FIX
		ModelLoader.registerItemVariants(MedievalItems.TIMBERED_CLAY, MedievalItems.TIMBERED_CLAY.getRegistryName());
		ModelLoader.setCustomModelResourceLocation(MedievalItems.TIMBERED_CLAY, 0, new ModelResourceLocation(MedievalItems.TIMBERED_CLAY.getRegistryName().toString(), "inventory"));

//		ModelLoader.registerItemVariants(LANTERN, new ResourceLocation(References.MODID, "lantern_solid"), new ResourceLocation(References.MODID, "lantern_translucent"));
		new ModelRegistryHandler().registerTables();
	}

	//Special Code to rescue servers cause I am dumb.
	private void registerTables() {
		MaterialRequirements cleanPlankRequired = new MaterialRequirements("clean_planks");

		for(Material mat : MaterialRegistry.getMaterialsForType("wood")){
			if(cleanPlankRequired.doesFulfillRequirements(mat)) {

				Block solidSimpleTable = Block.getBlockFromName("drpmedieval:simple_solid_" +mat.getName() + "_table");//new SolidSimpleTable("simple_solid_" + mat.getName() + "_table"); //TODO Update to DRPBlock
				Block plankSimpleTable = Block.getBlockFromName("drpmedieval:simple_plank_" +mat.getName() + "_table");//new SimpleTable("simple_plank_" + mat.getName() + "_table"); //TODO Update to DRPBlock

				ConnectedModelLoader.registerConnectedModelBlock(solidSimpleTable);
				ConnectedModelLoader.registerConnectedModelBlock(plankSimpleTable);
			}
		}
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
	    String path = stringParseName(item.getRegistryName().getPath());//item.getTranslationKey().toString().substring(item.getTranslationKey().toString().indexOf(".") + 1, item.getTranslationKey().toString().length()));
		if(folder != null){
			path = stringParseName(folder) + "/" + path;
			ModelBakery.registerItemVariants(item,new ResourceLocation(References.MODID + ":" + path));
		}
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(References.MODID + ":" + path, "inventory"));
	}

	private static String stringParseName(String name){
		char[] nameArray = name.toCharArray();
		ArrayList<Character> nameList = new ArrayList<Character>();
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
}
