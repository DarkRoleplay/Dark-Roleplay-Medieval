package net.dark_roleplay.medieval.testing.blockstate_loading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class BlockStateLoader {

	public static JsonObject getBlockState(ResourceLocation loc){
		InputStream in;
		Gson gson = new Gson();
		try {
			in = Minecraft.getInstance().getResourceManager().getResource(loc).getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			JsonElement je = gson.fromJson(reader, JsonElement.class);
			in.close();
			JsonObject json = je.getAsJsonObject();
			return json;
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return null;
	}
}
