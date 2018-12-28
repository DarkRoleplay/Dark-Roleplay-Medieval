package net.dark_roleplay.medieval.common.objects.world_gen.village.carpenter;

import java.util.List;
import java.util.Random;

import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.handler.MedievalVillagers;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

public class CarpenterHouse extends StructureVillagePieces.House1{

    private static final ResourceLocation STRUCTURE_RES_LOC = new ResourceLocation(References.MODID, "new_carpenter_house");

    private static final int X_SIZE = 9;
    private static final int Y_SIZE = 10;
    private static final int Z_SIZE = 14;

    private int averageGroundLevel = -1;

    public CarpenterHouse(){

    }

    public CarpenterHouse(StructureBoundingBox boundingBox, EnumFacing par5){
        this.setCoordBaseMode(par5);
        this.boundingBox = boundingBox;
    }

    public static CarpenterHouse buildComponent(List<StructureComponent> pieces, int p1, int p2, int p3, EnumFacing p4){
        StructureBoundingBox boundingBox = StructureBoundingBox.getComponentToAddBoundingBox(p1, p2, p3, 0, 0, 0, X_SIZE, Y_SIZE, Z_SIZE, p4);
        return canVillageGoDeeper(boundingBox) && StructureComponent.findIntersecting(pieces, boundingBox) == null ? new CarpenterHouse(boundingBox, p4) : null;
    }

    @Override
    public boolean addComponentParts(World world, Random rand, StructureBoundingBox sbb){
        if(this.averageGroundLevel < 0){
            this.averageGroundLevel = this.getAverageGroundLevel(world, sbb);
            if(this.averageGroundLevel < 0){
                return true;
            }
            this.boundingBox.offset(0, this.averageGroundLevel-this.boundingBox.maxY+Y_SIZE - 2, 0);
        }

        //this.fillWithBlocks(world, sbb, 0, 0, 0, X_SIZE-1, Y_SIZE-1, Z_SIZE-1, Blocks.AIR);
        this.spawnActualHouse(world, sbb);

        for(int i = 0; i < X_SIZE; i++){
            for(int j = 0; j < Z_SIZE; j++){
                this.clearCurrentPositionBlocksUpwards(world, i, Y_SIZE, j, sbb);
                this.replaceAirAndLiquidDownwards(world, Blocks.DIRT.getDefaultState(), i, -1, j, sbb);
            }
        }

        this.spawnVillagers(world, sbb, 3, 1, 5, 1);

        return true;
    }

    private void fillWithBlocks(World world, StructureBoundingBox sbb, int minX, int minY, int minZ, int maxX, int maxY, int maxZ, Block block){
        this.fillWithBlocks(world, sbb, minX, minY, minZ, maxX, maxY, maxZ, block.getDefaultState(), block.getDefaultState(), false);
    }

    private void spawnActualHouse(World world, StructureBoundingBox sbb){
        TemplateManager manager = world.getSaveHandler().getStructureTemplateManager();
        MinecraftServer server = world.getMinecraftServer();

        if(manager != null && server != null){
            EnumFacing facing = this.getCoordBaseMode();

            Mirror mirror;
            Rotation rotation;
            if(facing == EnumFacing.SOUTH){
                mirror = Mirror.NONE;
                rotation = Rotation.NONE;
            }
            else if(facing == EnumFacing.WEST){
                mirror = Mirror.NONE;
                rotation = Rotation.CLOCKWISE_90;
            }
            else if(facing == EnumFacing.EAST){
                mirror = Mirror.LEFT_RIGHT;
                rotation = Rotation.CLOCKWISE_90;
            }
            else{
                mirror = Mirror.LEFT_RIGHT;
                rotation = Rotation.NONE;
            }

            PlacementSettings placement = new PlacementSettings().setRotation(rotation).setMirror(mirror).setBoundingBox(sbb);
            Template template = manager.getTemplate(server, STRUCTURE_RES_LOC);

            if(template != null){
                template.addBlocksToWorld(world, new BlockPos(this.getXWithOffset(0, 0), this.getYWithOffset(0), this.getZWithOffset(0, 0)), placement);
            }
        }
    }

    @Override
    protected VillagerProfession chooseForgeProfession(int count, VillagerProfession prof){
    	return MedievalVillagers.CARPENTER;
    }
}