package net.dark_roleplay.medieval;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.relauncher.Side;

public class References {

	public static final String NAME = "Dark Roleplay Medieval";
	public static final String VERSION = "1.12.2-0.2.8-pre1";
	public static final String MODID = "drpmedieval";
	public static final String ACCEPTEDVERSIONS = "[1.12,1.13)";
	public static final String DEPENDECIES = "";
	public static final String UPDATECHECK = "https://dark-roleplay.net/files/versions/drpmedieval/drpmedieval-1.12.2.json";
	public static final List<String> AUTHORS = Arrays.asList("JTK222", "0Mr_X0", "Rolfaal", "Kanno");
	public static final String CREDITS = "Lead Programmer: JTK222, Jr. Programmer: 0Mr_X0, Artists: Rolfaal & Kanno (https://twitter.com/lKanno_)";
    public static final Logger LOGGER = LogManager.getLogger(References.MODID);

    public static final int MAARG_VERSION = 1;

	public static Side SIDE;
}
