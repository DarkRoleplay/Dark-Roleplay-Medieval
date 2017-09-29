package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.dark_roleplay.medieval.common.blocks.tileentities.TileEntity_AdvancedCrop;
import net.dark_roleplay.medieval.common.blocks.tileentities.TileEntity_FlowerStorage;
import net.dark_roleplay.medieval.common.blocks.tileentities.lectern.TileEntity_Lectern;
import net.dark_roleplay.medieval.common.blocks.tileentities.storage.TileEntity_SimpleStorage;
import net.dark_roleplay.medieval.common.blocks.tileentitys.BedFrameTileEntity;
import net.dark_roleplay.medieval.common.blocks.tileentitys.RopeCoilTileEntity;
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
import net.dark_roleplay.medieval.common.blocks.util.shop_sign.TE_ShopSign;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DRPMedievalTileEntities {

	public static final void init(FMLPreInitializationEvent event) {
		
		GameRegistry.registerTileEntity(TE_ShopSign.class, DRPMedievalInfo.MODID + ":te_shop_sign");
		GameRegistry.registerTileEntity(TileEntityAnvil.class, DRPMedievalInfo.MODID + ":" + "TileEntityAnvil");
		GameRegistry.registerTileEntity(TileEntityMortar.class, DRPMedievalInfo.MODID + ":" + "TileEntityMortar");
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, DRPMedievalInfo.MODID + ":" + "TileEntityGrindstone");
		GameRegistry.registerTileEntity(TileEntityHangingCauldron.class, DRPMedievalInfo.MODID + ":" + "TileEntityHangingCauldron");
		GameRegistry.registerTileEntity(TileEntityBookOne.class, DRPMedievalInfo.MODID + ":" + "TileEntityBookOne");
		GameRegistry.registerTileEntity(TileEntityCauldron.class, DRPMedievalInfo.MODID + ":" + "TileEntityCauldron");
		GameRegistry.registerTileEntity(TileEntityChain.class, DRPMedievalInfo.MODID + ":" + "TileEntityChain");
		GameRegistry.registerTileEntity(TileEntityHook.class, DRPMedievalInfo.MODID + ":" + "TileEntityHook");
		GameRegistry.registerTileEntity(TileEntityKeyHanging.class, DRPMedievalInfo.MODID + ":" + "TileEntityKeyHanging");
		GameRegistry.registerTileEntity(TileEntityShipsWheel.class, DRPMedievalInfo.MODID + ":" + "TileEntityShipsWheel");
		GameRegistry.registerTileEntity(TileEntityTarget.class, DRPMedievalInfo.MODID + ":" + "TileEntityTarget");
		GameRegistry.registerTileEntity(TileEntityRopeAnchor.class, DRPMedievalInfo.MODID + ":" + "TileEntityRopeAnchor");
		GameRegistry.registerTileEntity(TileEntityFirepit.class, DRPMedievalInfo.MODID + ":" + "TileEntityFirepit");
        GameRegistry.registerTileEntity(TileEntity_FlowerStorage.class, DRPMedievalInfo.MODID + "BucketTileEntity");
        GameRegistry.registerTileEntity(RopeCoilTileEntity.class, DRPMedievalInfo.MODID + "rope_coil_tilenentity");
		
		// Storage Blocks
        //New Storage
        GameRegistry.registerTileEntity(TileEntity_SimpleStorage.class, DRPMedievalInfo.MODID + ":" + "tile_entity_simple_storage");
        GameRegistry.registerTileEntity(TileEntity_Lectern.class, DRPMedievalInfo.MODID + ":" + "tile_entity_lectern");
        
        //Old Storage
		GameRegistry.registerTileEntity(TileEntityCrate.class, DRPMedievalInfo.MODID + ":" + "TilEntityCrate");
		GameRegistry.registerTileEntity(TileEntityDungeonChest.class, DRPMedievalInfo.MODID + ":" + "TileEntityDungeonChest");
		GameRegistry.registerTileEntity(BedFrameTileEntity.class, "BedFrameTileEntity");
		GameRegistry.registerTileEntity(TileEntity_AdvancedCrop.class, DRPMedievalInfo.MODID + ":" + "tile_entity_advanced_crop");
		
	}
	
	public static final void init(FMLInitializationEvent event) {}
	
	public static final void init(FMLPostInitializationEvent event) {}
	
}
