package net.dark_roleplay.medieval.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.ForgeVersion.CheckResult;

public class DRPMedievalInfo {

	public static final String NAME = "Dark Roleplay Medieval";
	public static final String VERSION = "0.2.0.0";
	public static final String MODID = "drpmedieval";
	public static final String ACCEPTEDVERSIONS = "[1.12,1.12.1]";
//	public static final String REQUIREMENTS = 
	public static final String DEPENDECIES = "required-after:drpcore@0.3.1,)";
	public static final String UPDATECHECK = "https://raw.githubusercontent.com/DarkRoleplay/Dark-Roleplay-Medieval/master/DarkRoleplayMedieval.json";
    public static final Logger LOGGER = LogManager.getLogger(DRPMedievalInfo.MODID);
    
	public static CheckResult VERSION_STATUS;


}
