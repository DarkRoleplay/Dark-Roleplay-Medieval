package net.dark_roleplay.medieval.client;

import java.util.ArrayList;

import net.dark_roleplay.medieval.client.entities.fox.Render_Fox;
import net.dark_roleplay.medieval.client.renderer.entity.RenderEntityRopedArrow;
import net.dark_roleplay.medieval.client.renderer.entity.RenderEntitySledge;
import net.dark_roleplay.medieval.client.sound.SoundEvents;
import net.dark_roleplay.medieval.common.DRPInfo;
import net.dark_roleplay.medieval.common.blocks.specialrenderer.SpecialRenderAnvil;
import net.dark_roleplay.medieval.common.blocks.specialrenderer.SpecialRenderBookOne;
import net.dark_roleplay.medieval.common.blocks.specialrenderer.SpecialRenderCauldron;
import net.dark_roleplay.medieval.common.blocks.specialrenderer.SpecialRenderChain;
import net.dark_roleplay.medieval.common.blocks.specialrenderer.SpecialRenderCrate;
import net.dark_roleplay.medieval.common.blocks.specialrenderer.SpecialRenderDungeonChest;
import net.dark_roleplay.medieval.common.blocks.specialrenderer.SpecialRenderFirepit;
import net.dark_roleplay.medieval.common.blocks.specialrenderer.SpecialRenderGrindstone;
import net.dark_roleplay.medieval.common.blocks.specialrenderer.SpecialRenderHangingCauldron;
import net.dark_roleplay.medieval.common.blocks.specialrenderer.SpecialRenderHook;
import net.dark_roleplay.medieval.common.blocks.specialrenderer.SpecialRenderKeyHanging;
import net.dark_roleplay.medieval.common.blocks.specialrenderer.SpecialRenderMortar;
import net.dark_roleplay.medieval.common.blocks.specialrenderer.SpecialRenderRopeAnchor;
import net.dark_roleplay.medieval.common.blocks.specialrenderer.SpecialRenderShipsWheel;
import net.dark_roleplay.medieval.common.blocks.specialrenderer.SpecialRenderTarget;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityAnvil;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityBookOne;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityCauldron;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityChain;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityCrate;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityDungeonChest;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityFirepit;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityGrindstone;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityHangingCauldron;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityHook;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityKeyHanging;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityMortar;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityRopeAnchor;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityShipsWheel;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityTarget;
import net.dark_roleplay.medieval.common.entities.fox.Entity_Fox;
import net.dark_roleplay.medieval.common.entity.item.EntitySledge;
import net.dark_roleplay.medieval.common.entity.projectile.EntityRopedArrow;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.dark_roleplay.medieval.common.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	ArrayList<Item> toRegisterMeshes = new ArrayList<Item>();
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntitySledge.class, RenderEntitySledge.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityRopedArrow.class, RenderEntityRopedArrow.FACTORY);

		RenderingRegistry.registerEntityRenderingHandler(Entity_Fox.class, Render_Fox.FACTORY);
        
		this.registerRenders();	
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		SoundEvents.registerSounds();
		//Minecraft.getMinecraft().renderEngine.loadTickableTexture(textureLocation, textureObj);

		
		this.forceAdditionalModels();
		
		//SPECIAL
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Firewood, 0, new ModelResourceLocation(DRPInfo.MODID + ":" + "firewood/firewood_oak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Firewood, 1, new ModelResourceLocation(DRPInfo.MODID + ":" + "firewood/firewood_spruce", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Firewood, 2, new ModelResourceLocation(DRPInfo.MODID + ":" + "firewood/firewood_birch", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Firewood, 3, new ModelResourceLocation(DRPInfo.MODID + ":" + "firewood/firewood_jungle", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Firewood, 4, new ModelResourceLocation(DRPInfo.MODID + ":" + "firewood/firewood_dark_oak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Firewood, 5, new ModelResourceLocation(DRPInfo.MODID + ":" + "firewood/firewood_acacia", "inventory"));

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Plank, 0, new ModelResourceLocation(DRPInfo.MODID + ":" + "planks/plank_oak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Plank, 1, new ModelResourceLocation(DRPInfo.MODID + ":" + "planks/plank_spruce", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Plank, 2, new ModelResourceLocation(DRPInfo.MODID + ":" + "planks/plank_birch", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Plank, 3, new ModelResourceLocation(DRPInfo.MODID + ":" + "planks/plank_jungle", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Plank, 4, new ModelResourceLocation(DRPInfo.MODID + ":" + "planks/plank_dark_oak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Plank, 5, new ModelResourceLocation(DRPInfo.MODID + ":" + "planks/plank_acacia", "inventory"));
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DRPMedievalBlocks.CLEAN_PLANKS), 0, new ModelResourceLocation(DRPInfo.MODID + ":" + "clean_planks/clean_plank_oak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DRPMedievalBlocks.CLEAN_PLANKS), 1, new ModelResourceLocation(DRPInfo.MODID + ":" + "clean_planks/clean_plank_spruce", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DRPMedievalBlocks.CLEAN_PLANKS), 2, new ModelResourceLocation(DRPInfo.MODID + ":" + "clean_planks/clean_plank_birch", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DRPMedievalBlocks.CLEAN_PLANKS), 3, new ModelResourceLocation(DRPInfo.MODID + ":" + "clean_planks/clean_plank_jungle", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DRPMedievalBlocks.CLEAN_PLANKS), 4, new ModelResourceLocation(DRPInfo.MODID + ":" + "clean_planks/clean_plank_dark_oak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DRPMedievalBlocks.CLEAN_PLANKS), 5, new ModelResourceLocation(DRPInfo.MODID + ":" + "clean_planks/clean_plank_acacia", "inventory"));
		
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.DoughPumpkin, 0, new ModelResourceLocation(DRPInfo.MODID + ":" + "dough_pumpkin_wheat", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.DoughPumpkin, 1, new ModelResourceLocation(DRPInfo.MODID + ":" + "dough_pumpkin_barley", "inventory"));
	
		
		
	}

	@Override
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
		this.registerItemMesh(DRPMedievalBlocks.bookOne);
		this.registerItemMesh(DRPMedievalBlocks.ANVIL);
		this.registerItemMesh(DRPMedievalBlocks.GRINDSTONE);
		this.registerItemMesh(DRPMedievalBlocks.HANGING_CAULDRON);
		this.registerItemMesh(DRPMedievalBlocks.MORTAR);
		this.registerItemMesh(DRPMedievalBlocks.CAULDRON);
		this.registerItemMesh(DRPMedievalBlocks.ROPE_ANCHOR);
		this.registerItemMesh(DRPMedievalBlocks.FIREPIT);
		
		for(Item item : this.toRegisterMeshes){
			this.registerItemMesh(item);
		}
		this.toRegisterMeshes = null;
		
		this.registerItemMesh("SimpleChairs",DRPMedievalBlocks.SIMPLE_CHAIR_OAK);
		this.registerItemMesh("SimpleChairs",DRPMedievalBlocks.SIMPLE_CHAIR_BIRCH);
		this.registerItemMesh("SimpleChairs",DRPMedievalBlocks.SIMPLE_CHAIR_SPRUCE);
		this.registerItemMesh("SimpleChairs",DRPMedievalBlocks.SIMPLE_CHAIR_JUNGLE);
		this.registerItemMesh("SimpleChairs",DRPMedievalBlocks.SIMPLE_CHAIR_ACACIA);
		this.registerItemMesh("SimpleChairs",DRPMedievalBlocks.SIMPLE_CHAIR_DARK_OAK);
		
		this.registerItemMesh("SimpleTables",DRPMedievalBlocks.SIMPLE_TABLE_OAK);
		this.registerItemMesh("SimpleTables",DRPMedievalBlocks.SIMPLE_TABLE_BIRCH);
		this.registerItemMesh("SimpleTables",DRPMedievalBlocks.SIMPLE_TABLE_SPRUCE);
		this.registerItemMesh("SimpleTables",DRPMedievalBlocks.SIMPLE_TABLE_JUNGLE);
		this.registerItemMesh("SimpleTables",DRPMedievalBlocks.SIMPLE_TABLE_ACACIA);
		this.registerItemMesh("SimpleTables",DRPMedievalBlocks.SIMPLE_TABLE_DARK_OAK);
		
//		registerItemMesh("Apiaries",DRPMBlocks.APIARY_OAK);
//		registerItemMesh("Apiaries",DRPMBlocks.APIARY_BIRCH);
//		registerItemMesh("Apiaries",DRPMBlocks.APIARY_SPRUCE);
//		registerItemMesh("Apiaries",DRPMBlocks.APIARY_JUNGLE);
//		registerItemMesh("Apiaries",DRPMBlocks.APIARY_ACACIA);
//		registerItemMesh("Apiaries",DRPMBlocks.APIARY_DARK_OAK);
		
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_EMPTY_OAK);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_EMPTY_BIRCH);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_EMPTY_SPRUCE);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_EMPTY_JUNGLE);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_EMPTY_ACACIA);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_EMPTY_DARK_OAK);
		
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_CLOSED_OAK);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_CLOSED_BIRCH);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_CLOSED_SPRUCE);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_CLOSED_JUNGLE);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_CLOSED_ACACIA);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_CLOSED_DARK_OAK);
		
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_WATER_OAK);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_WATER_BIRCH);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_WATER_SPRUCE);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_WATER_JUNGLE);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_WATER_ACACIA);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_WATER_DARK_OAK);
		
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_GUNPOWDER_OAK);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_GUNPOWDER_BIRCH);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_GUNPOWDER_SPRUCE);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_GUNPOWDER_JUNGLE);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_GUNPOWDER_ACACIA);
		this.registerItemMesh("Barrels",DRPMedievalBlocks.BARREL_GUNPOWDER_DARK_OAK);
		
		this.registerItemMesh("BarrelChairs", DRPMedievalBlocks.BARREL_CHAIR_OAK);
		this.registerItemMesh("BarrelChairs", DRPMedievalBlocks.BARREL_CHAIR_BIRCH);
		this.registerItemMesh("BarrelChairs", DRPMedievalBlocks.BARREL_CHAIR_SPRUCE);
		this.registerItemMesh("BarrelChairs", DRPMedievalBlocks.BARREL_CHAIR_JUNGLE);
		this.registerItemMesh("BarrelChairs", DRPMedievalBlocks.BARREL_CHAIR_ACACIA);
		this.registerItemMesh("BarrelChairs", DRPMedievalBlocks.BARREL_CHAIR_DARK_OAK);
		
		this.registerItemMesh("LogChairs", DRPMedievalBlocks.LOG_CHAIR_OAK);
		this.registerItemMesh("LogChairs", DRPMedievalBlocks.LOG_CHAIR_BIRCH);
		this.registerItemMesh("LogChairs", DRPMedievalBlocks.LOG_CHAIR_SPRUCE);
		this.registerItemMesh("LogChairs", DRPMedievalBlocks.LOG_CHAIR_JUNGLE);
		this.registerItemMesh("LogChairs", DRPMedievalBlocks.LOG_CHAIR_ACACIA);
		this.registerItemMesh("LogChairs", DRPMedievalBlocks.LOG_CHAIR_DARK_OAK);
		
		this.registerItemMesh("Buckets",DRPMedievalBlocks.BUCKET_EMPTY);
		this.registerItemMesh("Buckets",DRPMedievalBlocks.BUCKET_WATER);
		this.registerItemMesh("Buckets",DRPMedievalBlocks.BUCKET_DIRT);

		
		this.registerItemMesh("Planks",DRPMedievalItems.Plank);
	}


	@Override
	public void addItemToRegisterMesh(Item item) {
		this.toRegisterMeshes.add(item);
	}
	
	public void forceAdditionalModels() {
		ModelBakery.registerItemVariants(DRPMedievalItems.CHARCOAL_POWDER, new ResourceLocation[]{ new ResourceLocation(DRPInfo.MODID, "minerals/charcoal_powder")});
		ModelBakery.registerItemVariants(DRPMedievalItems.CHARCOAL_POWDER, new ResourceLocation[]{ new ResourceLocation(DRPInfo.MODID, "minerals/charcoal_powder")});
		ModelBakery.registerItemVariants(DRPMedievalItems.Firewood, new ResourceLocation[] {new ResourceLocation(DRPInfo.MODID + ":" + "firewood/firewood_oak"), new ResourceLocation(DRPInfo.MODID + ":" + "firewood/firewood_spruce"), new ResourceLocation(DRPInfo.MODID + ":" + "firewood/firewood_birch"), new ResourceLocation(DRPInfo.MODID + ":" + "firewood/firewood_jungle"), new ResourceLocation(DRPInfo.MODID + ":" + "firewood/firewood_dark_oak"), new ResourceLocation(DRPInfo.MODID + ":" + "firewood/firewood_acacia")});
		ModelBakery.registerItemVariants(DRPMedievalItems.Plank, new ResourceLocation[] {new ResourceLocation(DRPInfo.MODID + ":" + "planks/plank_oak"), new ResourceLocation(DRPInfo.MODID + ":" + "planks/plank_spruce"), new ResourceLocation(DRPInfo.MODID + ":" + "planks/plank_birch"), new ResourceLocation(DRPInfo.MODID + ":" + "planks/plank_jungle"), new ResourceLocation(DRPInfo.MODID + ":" + "planks/plank_dark_oak"), new ResourceLocation(DRPInfo.MODID + ":" + "planks/plank_acacia")});
		ModelBakery.registerItemVariants(DRPMedievalItems.DoughPumpkin, new ResourceLocation[] {new ResourceLocation(DRPInfo.MODID + ":" + "dough_pumpkin_wheat"), new ResourceLocation(DRPInfo.MODID + ":" + "dough_pumpkin_barley")});
		ModelBakery.registerItemVariants(Item.getItemFromBlock(DRPMedievalBlocks.CLEAN_PLANKS), new ResourceLocation[] {new ResourceLocation(DRPInfo.MODID + ":" + "clean_planks/clean_plank_oak"), new ResourceLocation(DRPInfo.MODID + ":" + "clean_planks/clean_plank_spruce"), new ResourceLocation(DRPInfo.MODID + ":" + "clean_planks/clean_plank_birch"), new ResourceLocation(DRPInfo.MODID + ":" + "clean_planks/clean_plank_jungle"), new ResourceLocation(DRPInfo.MODID + ":" + "clean_planks/clean_plank_dark_oak"), new ResourceLocation(DRPInfo.MODID + ":" + "clean_planks/clean_plank_acacia")});
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
	    String path = this.stringParseName(item.getUnlocalizedName().toString().substring(item.getUnlocalizedName().toString().indexOf(".") + 1, item.getUnlocalizedName().toString().length()));
		if(folder != null){
			path = this.stringParseName(folder) + "/" + path;
			ModelBakery.registerItemVariants(item,new ResourceLocation(DRPInfo.MODID + ":" + path));
		}
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(DRPInfo.MODID + ":" + path, "inventory"));
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(DRPInfo.MODID + ":" + path, "inventory"));
	}
	
	private String stringParseName(String name){
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
}
