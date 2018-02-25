package net.dark_roleplay.medieval.common;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.ForgeVersion.CheckResult;

public class DRPMedievalInfo {

	public static final String NAME = "Dark Roleplay Medieval";
	public static final String VERSION = "0.2.4.3";
	public static final String MODID = "drpmedieval";
	public static final String ACCEPTEDVERSIONS = "[1.12,1.13)";
	public static final String DEPENDECIES = "required-after:drpcore@[0.3.5,)";
	public static final String UPDATECHECK = "http://dark-roleplay.net/version_files/DarkRoleplayMedieval.json";
	public static final List<String> AUTHORS = Arrays.asList("JTK222", "Rolfaal", "Kanno");
	public static final String CREDITS = "Lead Programmer: JTK222, Artists: Rolfaal & Kanno";
    public static final Logger LOGGER = LogManager.getLogger(DRPMedievalInfo.MODID);
    
	public static CheckResult VERSION_STATUS;


}
