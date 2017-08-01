package net.dark_roleplay.medieval.common.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.dark_roleplay.drpcore.api.crafting.simple_recipe.SimpleRecipe;
import net.dark_roleplay.drpcore.common.crafting.CraftingRegistry;
import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeFromJSON implements IResourceManagerReloadListener {
	
	@Override
	public void onResourceManagerReload(IResourceManager manager) {	
		DRPMedievalInfo.LOGGER.info("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
		DRPMedievalInfo.LOGGER.info("Starting to load Dark Roleplay crafting recipes");
		DRPMedievalInfo.LOGGER.info("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
		
//		SimpleRecipe rec = readRecipe(new ResourceLocation("drpmedieval:drpcore/recipes/test.json"));
//
//		if(rec != null)
//			CraftingRegistry.registerRecipe(rec.getStation(), rec.getCategory(), rec, false);

		DRPMedievalInfo.LOGGER.info("Finished loading of Dark Roleplay crafting recipes");
		DRPMedievalInfo.LOGGER.info("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
	}
	
	public static SimpleRecipe readRecipe(ResourceLocation loc){
		InputStream in;
		try {
			Gson gson = new Gson();
			in = Minecraft.getMinecraft().getResourceManager().getResource(loc).getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			JsonElement je = gson.fromJson(reader, JsonElement.class);
			JsonObject json = je.getAsJsonObject();
			
			String type;
			String registryName;
			String category;
			
			JsonElement recipe_type = json.get("recipe_type");
			JsonElement regName = json.get("registry_name");
			JsonElement cat = json.get("category");
			
			if(recipe_type == null){
				printLoadError(loc, "Recipe type is missing unable to read it!");
				return null;	
			}else if(regName == null){
				printLoadError(loc, "Registry name for the recipe is missing, cannot register it!");
				return null;
			}else if(cat == null){
				printLoadError(loc, "Recipe is missing a category!");
				return null;
			}
			
			type = recipe_type.getAsString();
			registryName = regName.getAsString();
			category = cat.getAsString();
			
			if(type.equals("simple_recipe")){
				JsonElement outputs = json.get("outputs");
				JsonElement ingredients = json.get("ingredients");
				
				if(outputs == null){
					printLoadError(loc, "The recipe doesn't have any output, we don't allow trolling!");
					return null;
				}else if(ingredients == null){
					printLoadError(loc, "The recipe doesn't have any ingredients, we don't want cheaters!");
					return null;
				}
				
				ItemStack temp;
				
				JsonArray outputsArr = outputs.getAsJsonArray();
				ArrayList<ItemStack> outputStacks = new ArrayList<ItemStack>();
				for(int i = 0; i < outputsArr.size(); i++){
					temp = readStackFromJSON(loc, outputsArr.get(i));
					if(temp != null)
						outputStacks.add(temp);
				}
				
				JsonArray inputsArr = ingredients.getAsJsonArray();
				ArrayList<ItemStack> inputStacks = new ArrayList<ItemStack>();
				for(int i = 0; i < inputsArr.size(); i++){
					temp = readStackFromJSON(loc, inputsArr.get(i));
					if(temp != null)
						inputStacks.add(temp);
				}
				
				ItemStack[] outs = new ItemStack[outputStacks.size()];
				outs = outputStacks.toArray(outs);
				ItemStack[] ins = new ItemStack[inputStacks.size()];
				ins = inputStacks.toArray(ins);
				return new SimpleRecipe(new ResourceLocation("custom", registryName), Blocks.AIR, category, outs, ins);
				
			}else{
				printLoadError(loc, "The recipe type: " + type + " is unknown and cannot be loaded!");
			}
			
			DRPMedievalInfo.LOGGER.info("Search me !  "+ type + "  =  " + registryName);
			
			
		} catch (IOException e) {
			DRPMedievalInfo.LOGGER.catching(e);
		}
		return null;
	}
	
	private static ItemStack readStackFromJSON(ResourceLocation loc, JsonElement element){
		JsonObject jsonStack = element.getAsJsonObject();
		JsonElement reg = jsonStack.get("item");
		if(reg == null){
			DRPMedievalInfo.LOGGER.warn("An itemstack in the following recipe is missing an item (really now?) " + loc.toString());
			return null;
		}else{
			if(!GameRegistry.findRegistry(Item.class).containsKey(new ResourceLocation(reg.getAsString()))){
				DRPMedievalInfo.LOGGER.warn("An itemstack in the following recipe is missing an item (really now?) " + loc.toString());
				return null;
			}
		}
		JsonElement size = jsonStack.get("amount");
		JsonElement meta = jsonStack.get("meta");
		
		return new ItemStack( GameRegistry.findRegistry(Item.class).getValue(new ResourceLocation(reg.getAsString())), size == null ? 1 : size.getAsInt(), meta == null ? 0 : meta.getAsInt());
	}
	
	private static void printLoadError(ResourceLocation loc, String reason){
		String errMsg = "Unable to load recipe " + loc.getResourcePath() + " from " + loc.getResourceDomain() + ", because of the following reason:";
		
		DRPMedievalInfo.LOGGER.warn(errMsg);
		DRPMedievalInfo.LOGGER.warn(reason);
	}
}
