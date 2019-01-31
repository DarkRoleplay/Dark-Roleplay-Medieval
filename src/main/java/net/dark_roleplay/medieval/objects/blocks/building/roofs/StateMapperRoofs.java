package net.dark_roleplay.medieval.objects.blocks.building.roofs;

import java.util.Map;

import com.google.common.collect.Maps;

import net.dark_roleplay.medieval.holders.MedievalBlockProperties;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.ResourceLocation;

public class StateMapperRoofs extends StateMapperBase {

    public static final StateMapperRoofs INSTANCE = new StateMapperRoofs("");

    private String folder;

    public StateMapperRoofs(String folder) {
    	this.folder = folder;
    }

	@Override
	protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
		final ResourceLocation rl = Block.REGISTRY.getNameForObject(state.getBlock());
        Map < IProperty<?>, Comparable<? >> map = Maps. < IProperty<?>, Comparable<? >> newLinkedHashMap(state.getProperties());

		map.remove(MedievalBlockProperties.SNOWED);
		map.remove(MedievalBlockProperties.HAS_TE);

		if(state.getValue(MedievalBlockProperties.SNOWED))
			return new ModelResourceLocation(new ResourceLocation(rl.getNamespace(), String.format("%ssnowed_%s", this.folder, rl.getPath())), this.getPropertyString(map));
		return new ModelResourceLocation(new ResourceLocation(rl.getNamespace(), String.format("%s%s", this.folder, rl.getPath())), this.getPropertyString(map));

	}

}