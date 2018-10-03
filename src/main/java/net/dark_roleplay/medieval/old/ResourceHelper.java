package net.dark_roleplay.medieval.old;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;

public class ResourceHelper {


	public static IResource getResource(ResourceLocation location) throws IOException {
        IResourceManager manager = Minecraft.getMinecraft().getResourceManager();
        IResource res = manager.getResource(location);
        return res;
    }

	public static List<IResource> getResources(ResourceLocation location) throws IOException, URISyntaxException{
		List<IResource> resources = new ArrayList<IResource>();

		File folder = new File(ResourceHelper.class.getClassLoader().getResource("assets/" + location.getNamespace() + "/" + location.getPath()).toURI());

		for (final File file : folder.listFiles()) {
	        if (file.isDirectory()) {
	        } else {
	        	resources.add(ResourceHelper.getResource(new ResourceLocation(location.getNamespace(), location.getPath() + file.getName())));
	        }
	    }

		return resources;
	}
}
