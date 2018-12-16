package net.dark_roleplay.medieval.common.objects.blocks.state_mappers;

import java.util.Map;

import com.google.common.collect.Maps;

import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.ResourceLocation;

public class SnowStateMapper extends StateMapperBase {

    public static final SnowStateMapper INSTANCE = new SnowStateMapper("");

    private String folder;

    public SnowStateMapper(String folder) {
    	this.folder = folder;
    }

	@Override
	protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
		final ResourceLocation rl = Block.REGISTRY.getNameForObject(state.getBlock());
        Map < IProperty<?>, Comparable<? >> map = Maps. < IProperty<?>, Comparable<? >> newLinkedHashMap(state.getProperties());

		map.remove(BlockProperties.SNOWED);
		map.remove(BlockProperties.HAS_TE);

		if(state.getValue(BlockProperties.SNOWED))
			return new ModelResourceLocation(new ResourceLocation(rl.getNamespace(), String.format("%ssnowed_%s", this.folder, rl.getPath())), this.getPropertyString(map));
		return new ModelResourceLocation(new ResourceLocation(rl.getNamespace(), String.format("%s%s", this.folder, rl.getPath())), this.getPropertyString(map));

	}

}