package net.dark_roleplay.medieval.common;

import com.google.common.collect.ImmutableMap;

import jline.internal.Nullable;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void init(FMLPreInitializationEvent event) {}
	
	public void init(FMLInitializationEvent event) {}

	public void init(FMLPostInitializationEvent event) {}
	
	@Nullable
	public IAnimationStateMachine load(ResourceLocation location, ImmutableMap<String, ITimeValue> parameters){ return null;}
}
