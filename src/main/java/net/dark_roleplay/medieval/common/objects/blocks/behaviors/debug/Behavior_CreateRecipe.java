package net.dark_roleplay.medieval.common.objects.blocks.behaviors.debug;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.dark_roleplay.library.experimental.blocks.behaviors.IActivatedBehavior;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Behavior_CreateRecipe implements IActivatedBehavior{

	@Override
	public boolean execute(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		this.createRecipe();
		return true;
	}

	private void createRecipe(){
		Block station = Block.REGISTRY.getObject(new ResourceLocation("drpmedieval", "anvil"));
//		Block station = Blocks.AIR;
		String category = "decorations";

		ItemStack output = null;

		JsonArray outputArr = new JsonArray();
		JsonArray inputArr = new JsonArray();

		NonNullList<ItemStack> inv = Minecraft.getMinecraft().player.inventory.mainInventory;

		for(int i = 9; i < 18; i++){
			if(!inv.get(i).isEmpty()){
				if(output == null)
					output = inv.get(i);
				outputArr.add(serializeItem(inv.get(i)));;
			}
		}

		for(int i = 18; i < 27; i++){
			if(!inv.get(i).isEmpty()){
				inputArr.add(serializeItem(inv.get(i)));;
			}
		}

		JsonObject obj = new JsonObject();
		if(station != Blocks.AIR)
			obj.addProperty("station", station.getRegistryName().toString());

		obj.addProperty("category", category);
		obj.addProperty("name", output.getItem().getRegistryName().getPath());
		obj.add("outputs", outputArr);
		obj.add("ingredients", inputArr);


//		File file = new File(References.FOLDER_RECIPES.getPath() + "/" + output.getItem().getRegistryName().getPath() + ".json");
//		int i = 1;
//		while(file.exists()){
//			file = new File(References.FOLDER_RECIPES.getPath() + "/" + output.getItem().getRegistryName().getPath() + i + ".json");
//			i++;
//		}

//		try {
//			file.createNewFile();
//
//
//
//			System.out.println(obj.toString());
//
//			FileWriter writer = new FileWriter(file);
//		    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		    gson.toJson(obj, writer);
//		    writer.flush();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

	public static JsonObject serializeItem(ItemStack stack) {
		JsonObject obj = new JsonObject();
		obj.addProperty("item", stack.getItem().getRegistryName().toString());
		if(stack.getCount() != 1)
			obj.addProperty("count", stack.getCount());
		if(stack.getMetadata() != 0)
			obj.addProperty("data", stack.getMetadata());

		return obj;
    }
}
