package net.drpmedieval.client;

import java.util.ArrayList;
import java.util.Arrays;

import net.drpmedieval.client.events.ItemColorHandler;
import net.drpmedieval.client.renderer.entity.RenderEntityRopedArrow;
import net.drpmedieval.client.renderer.entity.RenderEntitySledge;
import net.drpmedieval.client.sound.SoundEvents;
import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.blocks.DRPMBlocks;
import net.drpmedieval.common.blocks.specialrenderer.*;
import net.drpmedieval.common.blocks.tileentitys.*;
import net.drpmedieval.common.entity.item.EntitySledge;
import net.drpmedieval.common.entity.models.TrainingDummyModel;
import net.drpmedieval.common.entity.projectile.EntityRopedArrow;
import net.drpmedieval.common.entity.renders.RenderTrainingDummy;
import net.drpmedieval.common.items.DRPMItems;
import net.drpmedieval.common.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.client.renderer.entity.RenderArrow;

public class ClientProxy extends CommonProxy {
	
	ArrayList<Item> toRegisterMeshes = new ArrayList<Item>();
	
	public void preInit(FMLPreInitializationEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntitySledge.class, RenderEntitySledge.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityRopedArrow.class, RenderEntityRopedArrow.FACTORY);
        //RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, renderer);
		registerRenders();
	}
	
	public void init(FMLInitializationEvent event) {

		
		forceAdditionalModels();
		
		
		//SPECIAL
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMItems.Firewood, 0, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "firewood/firewood_oak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMItems.Firewood, 1, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "firewood/firewood_spruce", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMItems.Firewood, 2, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "firewood/firewood_birch", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMItems.Firewood, 3, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "firewood/firewood_jungle", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMItems.Firewood, 4, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "firewood/firewood_dark_oak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMItems.Firewood, 5, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "firewood/firewood_acacia", "inventory"));

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMItems.Plank, 0, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "planks/plank_oak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMItems.Plank, 1, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "planks/plank_spruce", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMItems.Plank, 2, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "planks/plank_birch", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMItems.Plank, 3, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "planks/plank_jungle", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMItems.Plank, 4, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "planks/plank_dark_oak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMItems.Plank, 5, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "planks/plank_acacia", "inventory"));
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DRPMBlocks.CLEAN_PLANKS), 0, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "clean_planks/clean_plank_oak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DRPMBlocks.CLEAN_PLANKS), 1, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "clean_planks/clean_plank_spruce", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DRPMBlocks.CLEAN_PLANKS), 2, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "clean_planks/clean_plank_birch", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DRPMBlocks.CLEAN_PLANKS), 3, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "clean_planks/clean_plank_jungle", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DRPMBlocks.CLEAN_PLANKS), 4, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "clean_planks/clean_plank_dark_oak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DRPMBlocks.CLEAN_PLANKS), 5, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "clean_planks/clean_plank_acacia", "inventory"));
		
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMItems.DoughPumpkin, 0, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "dough_pumpkin_wheat", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMItems.DoughPumpkin, 1, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "dough_pumpkin_barley", "inventory"));
	
		
		SoundEvents.registerSounds();

	}

	public void postInit(FMLPostInitializationEvent event) {}


	public void registerRenders() {		
		//Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ItemColorHandler(), DRPMedievalItems.StringCoil);
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvil.class, new SpecialRenderAnvil());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMortar.class, new SpecialRenderMortar());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrindstone.class, new SpecialRenderGrindstone());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHangingCauldron.class, new SpecialRenderHangingCauldron());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBookOne.class, new SpecialRenderBookOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCauldron.class, new SpecialRenderCauldron());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChain.class, new SpecialRenderChain());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrate.class, new SpecialRenderCrate());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDungeonChest.class, new SpecialRenderDungeonChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHook.class, new SpecialRenderHook());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKeyHanging.class, new SpecialRenderKeyHanging());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShipsWheel.class, new SpecialRenderShipsWheel());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTarget.class, new SpecialRenderTarget());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRopeAnchor.class, new SpecialRenderRopeAnchor());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFirepit.class, new SpecialRenderFirepit());
		
		// Old Blocks
		registerItemMesh(DRPMBlocks.bookOne);
		registerItemMesh(DRPMBlocks.ANVIL);
		registerItemMesh(DRPMBlocks.GRINDSTONE);
		registerItemMesh(DRPMBlocks.HANGING_CAULDRON);
		registerItemMesh(DRPMBlocks.MORTAR);
		registerItemMesh(DRPMBlocks.CAULDRON);
		registerItemMesh(DRPMBlocks.ROPE_ANCHOR);
		registerItemMesh(DRPMBlocks.FIREPIT);
		
		for(Item item : toRegisterMeshes){
			registerItemMesh(item);
		}
		toRegisterMeshes = null;
		
		registerItemMesh("SimpleChairs",DRPMBlocks.SIMPLE_CHAIR_OAK);
		registerItemMesh("SimpleChairs",DRPMBlocks.SIMPLE_CHAIR_BIRCH);
		registerItemMesh("SimpleChairs",DRPMBlocks.SIMPLE_CHAIR_SPRUCE);
		registerItemMesh("SimpleChairs",DRPMBlocks.SIMPLE_CHAIR_JUNGLE);
		registerItemMesh("SimpleChairs",DRPMBlocks.SIMPLE_CHAIR_ACACIA);
		registerItemMesh("SimpleChairs",DRPMBlocks.SIMPLE_CHAIR_DARK_OAK);
		
		registerItemMesh("SimpleTables",DRPMBlocks.SIMPLE_TABLE_OAK);
		registerItemMesh("SimpleTables",DRPMBlocks.SIMPLE_TABLE_BIRCH);
		registerItemMesh("SimpleTables",DRPMBlocks.SIMPLE_TABLE_SPRUCE);
		registerItemMesh("SimpleTables",DRPMBlocks.SIMPLE_TABLE_JUNGLE);
		registerItemMesh("SimpleTables",DRPMBlocks.SIMPLE_TABLE_ACACIA);
		registerItemMesh("SimpleTables",DRPMBlocks.SIMPLE_TABLE_DARK_OAK);
		
		registerItemMesh("Apiaries",DRPMBlocks.APIARY_OAK);
		registerItemMesh("Apiaries",DRPMBlocks.APIARY_BIRCH);
		registerItemMesh("Apiaries",DRPMBlocks.APIARY_SPRUCE);
		registerItemMesh("Apiaries",DRPMBlocks.APIARY_JUNGLE);
		registerItemMesh("Apiaries",DRPMBlocks.APIARY_ACACIA);
		registerItemMesh("Apiaries",DRPMBlocks.APIARY_DARK_OAK);
		
		registerItemMesh("Barrels",DRPMBlocks.BARREL_EMPTY_OAK);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_EMPTY_BIRCH);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_EMPTY_SPRUCE);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_EMPTY_JUNGLE);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_EMPTY_ACACIA);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_EMPTY_DARK_OAK);
		
		registerItemMesh("Barrels",DRPMBlocks.BARREL_CLOSED_OAK);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_CLOSED_BIRCH);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_CLOSED_SPRUCE);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_CLOSED_JUNGLE);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_CLOSED_ACACIA);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_CLOSED_DARK_OAK);
		
		registerItemMesh("Barrels",DRPMBlocks.BARREL_WATER_OAK);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_WATER_BIRCH);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_WATER_SPRUCE);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_WATER_JUNGLE);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_WATER_ACACIA);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_WATER_DARK_OAK);
		
		registerItemMesh("Barrels",DRPMBlocks.BARREL_GUNPOWDER_OAK);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_GUNPOWDER_BIRCH);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_GUNPOWDER_SPRUCE);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_GUNPOWDER_JUNGLE);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_GUNPOWDER_ACACIA);
		registerItemMesh("Barrels",DRPMBlocks.BARREL_GUNPOWDER_DARK_OAK);
		
		registerItemMesh("BarrelChairs", DRPMBlocks.BARREL_CHAIR_OAK);
		registerItemMesh("BarrelChairs", DRPMBlocks.BARREL_CHAIR_BIRCH);
		registerItemMesh("BarrelChairs", DRPMBlocks.BARREL_CHAIR_SPRUCE);
		registerItemMesh("BarrelChairs", DRPMBlocks.BARREL_CHAIR_JUNGLE);
		registerItemMesh("BarrelChairs", DRPMBlocks.BARREL_CHAIR_ACACIA);
		registerItemMesh("BarrelChairs", DRPMBlocks.BARREL_CHAIR_DARK_OAK);
		
		registerItemMesh("LogChairs", DRPMBlocks.LOG_CHAIR_OAK);
		registerItemMesh("LogChairs", DRPMBlocks.LOG_CHAIR_BIRCH);
		registerItemMesh("LogChairs", DRPMBlocks.LOG_CHAIR_SPRUCE);
		registerItemMesh("LogChairs", DRPMBlocks.LOG_CHAIR_JUNGLE);
		registerItemMesh("LogChairs", DRPMBlocks.LOG_CHAIR_ACACIA);
		registerItemMesh("LogChairs", DRPMBlocks.LOG_CHAIR_DARK_OAK);
		
		registerItemMesh("Buckets",DRPMBlocks.BUCKET_EMPTY);
		registerItemMesh("Buckets",DRPMBlocks.BUCKET_WATER);
		registerItemMesh("Buckets",DRPMBlocks.BUCKET_DIRT);

		
		registerItemMesh("Planks",DRPMItems.Plank);
	}


	public void addItemToRegisterMesh(Item item) {
		toRegisterMeshes.add(item);
	}
	
	public void forceAdditionalModels() {
		ModelBakery.registerItemVariants(DRPMItems.Firewood, new ResourceLocation[] {new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "firewood/firewood_oak"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "firewood/firewood_spruce"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "firewood/firewood_birch"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "firewood/firewood_jungle"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "firewood/firewood_dark_oak"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "firewood/firewood_acacia")});
		ModelBakery.registerItemVariants(DRPMItems.Plank, new ResourceLocation[] {new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "planks/plank_oak"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "planks/plank_spruce"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "planks/plank_birch"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "planks/plank_jungle"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "planks/plank_dark_oak"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "planks/plank_acacia")});
		ModelBakery.registerItemVariants(DRPMItems.DoughPumpkin, new ResourceLocation[] {new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "dough_pumpkin_wheat"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "dough_pumpkin_barley")});
		ModelBakery.registerItemVariants(Item.getItemFromBlock(DRPMBlocks.CLEAN_PLANKS), new ResourceLocation[] {new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "clean_planks/clean_plank_oak"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "clean_planks/clean_plank_spruce"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "clean_planks/clean_plank_birch"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "clean_planks/clean_plank_jungle"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "clean_planks/clean_plank_dark_oak"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "clean_planks/clean_plank_acacia")});
	}

	public void registerItemMesh(Block block) {
		this.registerItemMesh(null, Item.getItemFromBlock(block));
	}
	
	public void registerItemMesh(String folder, Block block) {
		this.registerItemMesh(folder, Item.getItemFromBlock(block));
	}
	
	public void registerItemMesh(Item item){
		this.registerItemMesh(null, item);
	}
	
	public void registerItemMesh(String folder, Item item) {
	    String path = stringParseName(item.getUnlocalizedName().toString().substring(item.getUnlocalizedName().toString().indexOf(".") + 1, item.getUnlocalizedName().toString().length()));
		if(folder != null){
			path = stringParseName(folder) + "/" + path;
			ModelBakery.registerItemVariants(item,new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + path));
		}
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + path, "inventory"));
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + path, "inventory"));
	}
	
	private String stringParseName(String name){
		char[] nameArray = name.toCharArray();
		ArrayList<Character> nameList = new ArrayList();
		for(int i = 0; i < nameArray.length; i++){
			if(Character.isUpperCase(nameArray[i])){
				if(i > 0)
					nameList.add('_');
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
