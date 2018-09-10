package net.dark_roleplay.medieval.mess.common.config;

import net.dark_roleplay.medieval.mess.common.References;
import net.minecraftforge.common.config.Config;

@Config(modid = References.MODID, name = "Dark Roleplay Medieval/Client", category = "client")
public class Client {

	@Config.Comment("The last version that textures were created for, don't change this manually, this will delete the mods specific folder")
	@Config.Name("MaARG Version")
	public static int MAARG_VERSION = 0;
}