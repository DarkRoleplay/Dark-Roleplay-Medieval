package net.dark_roleplay.medieval.objects.world_gen.village.carpenter;

import java.util.List;
import java.util.Random;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class VillageHandlerCarpenter implements VillagerRegistry.IVillageCreationHandler{

    @Override
    public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int i){
        return new StructureVillagePieces.PieceWeight(CarpenterHouse.class, 10, 1);
    }

    @Override
    public Class<?> getComponentClass(){
        return CarpenterHouse.class;
    }

    @Override
    public StructureVillagePieces.Village buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List<StructureComponent> pieces, Random random, int p1, int p2, int p3, EnumFacing facing, int p5){
        return CarpenterHouse.buildComponent(pieces, p1, p2, p3, facing);
    }
}