package net.dark_roleplay.medieval.common.blocks.templates;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.dark_roleplay.medieval.common.blocks.WoodHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import java.lang.reflect.*;

public abstract class WoodenBlock extends Block{

	public final PropertyEnum<WoodHelper.WoodType> VARIANT;
	
	public WoodenBlock(Material material, WoodHelper.WoodType... types) {
		super(material);
		this.VARIANT = PropertyEnum.<WoodHelper.WoodType>create("variant", WoodHelper.WoodType.class, WoodHelper.apiaryTypes);
	}
	
	public static int getTypeAmount(){
		return 1;
	}
	
	public IBlockState getStateForVariant(WoodHelper.WoodType type){
		return VARIANT.getAllowedValues().contains(type) ? this.getDefaultState().withProperty(VARIANT, type) : this.getDefaultState();
	}
}

