package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.medieval.common.References;
import net.dark_roleplay.medieval.common.blocks.decorative.clocks.TE_ClockCore;
import net.dark_roleplay.medieval.common.blocks.storage.barrels.TE_FluidBarrel;
import net.dark_roleplay.medieval.common.blocks.storage.shelf.TE_Shelf;
import net.dark_roleplay.medieval.common.blocks.tileentities.TileEntity_AdvancedCrop;
import net.dark_roleplay.medieval.common.blocks.tileentities.TileEntity_FlowerStorage;
import net.dark_roleplay.medieval.common.blocks.tileentities.lectern.TileEntity_Lectern;
import net.dark_roleplay.medieval.common.blocks.tileentities.roof.TE_Roof;
import net.dark_roleplay.medieval.common.blocks.tileentities.storage.TileEntity_SimpleStorage;
import net.dark_roleplay.medieval.common.blocks.tileentitys.RopeCoilTileEntity;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityAnvil;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityBookOne;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityCauldron;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityChain;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityCrate;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TE_DungeonChest;
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
		
		GameRegistry.registerTileEntity(TE_ClockCore.class, References.MODID + ":te_clock_core");
		GameRegistry.registerTileEntity(TE_ShopSign.class, References.MODID + ":te_shop_sign");
        GameRegistry.registerTileEntity(TE_Shelf.class, References.MODID + ":te_shelf");
		GameRegistry.registerTileEntity(TileEntityAnvil.class, References.MODID + ":" + "TileEntityAnvil");
		GameRegistry.registerTileEntity(TileEntityMortar.class, References.MODID + ":" + "TileEntityMortar");
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, References.MODID + ":" + "TileEntityGrindstone");
		GameRegistry.registerTileEntity(TileEntityHangingCauldron.class, References.MODID + ":" + "TileEntityHangingCauldron");
		GameRegistry.registerTileEntity(TileEntityBookOne.class, References.MODID + ":" + "TileEntityBookOne");
		GameRegistry.registerTileEntity(TileEntityCauldron.class, References.MODID + ":" + "TileEntityCauldron");
		GameRegistry.registerTileEntity(TileEntityChain.class, References.MODID + ":" + "TileEntityChain");
		GameRegistry.registerTileEntity(TileEntityHook.class, References.MODID + ":" + "TileEntityHook");
		GameRegistry.registerTileEntity(TileEntityKeyHanging.class, References.MODID + ":" + "TileEntityKeyHanging");
		GameRegistry.registerTileEntity(TileEntityShipsWheel.class, References.MODID + ":" + "TileEntityShipsWheel");
		GameRegistry.registerTileEntity(TileEntityTarget.class, References.MODID + ":" + "TileEntityTarget");
		GameRegistry.registerTileEntity(TileEntityRopeAnchor.class, References.MODID + ":" + "TileEntityRopeAnchor");
		GameRegistry.registerTileEntity(TileEntityFirepit.class, References.MODID + ":" + "TileEntityFirepit");
        GameRegistry.registerTileEntity(TileEntity_FlowerStorage.class, References.MODID + "BucketTileEntity");
        GameRegistry.registerTileEntity(RopeCoilTileEntity.class, References.MODID + "rope_coil_tilenentity");
		
		// Storage Blocks
        //New Storage
        GameRegistry.registerTileEntity(TE_Roof.class, References.MODID + "tile_entity_roof");
        GameRegistry.registerTileEntity(TileEntity_SimpleStorage.class, References.MODID + ":" + "tile_entity_simple_storage");
        GameRegistry.registerTileEntity(TileEntity_Lectern.class, References.MODID + ":" + "tile_entity_lectern");
        GameRegistry.registerTileEntity(TE_FluidBarrel.class, References.MODID + ":" + "tile_entity_fluid_barrel");

        //Old Storage
		GameRegistry.registerTileEntity(TileEntityCrate.class, References.MODID + ":" + "TilEntityCrate");
		GameRegistry.registerTileEntity(TE_DungeonChest.class, References.MODID + ":" + "TileEntityDungeonChest");
		GameRegistry.registerTileEntity(TileEntity_AdvancedCrop.class, References.MODID + ":" + "tile_entity_advanced_crop");
		
	}
	
	public static final void init(FMLInitializationEvent event) {}
	
	public static final void init(FMLPostInitializationEvent event) {}
	
}
