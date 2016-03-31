package net.drpmedieval.common.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import net.drpmedieval.common.DarkRoleplayMedieval;

public class UpdateCheck {

	private static final String UPDATE_URL = "https://www.dropbox.com/s/m3t5qhlvi7ic5g4/DarkRoleplayMedieval.txt?dl=1";
	
	private static boolean newVersionAvailable = false;
	
	private static String newVersion = "none";
	
	private static String downloadURL = "http://www.curse.com/users/JTK222/projects";
	
	private static String changelogURL = "http://www.curse.com/users/JTK222/projects";
	
	public static void checkForUpdate(){
		new Thread("Update-Checker") {
			
			public void run(){
				try {
					URL url = new URL(UPDATE_URL);
					Scanner scanner = new Scanner(url.openStream());
					
					String[] version = scanner.nextLine().split("~");

					scanner.close();
					
					if(version[0].equals("1.8")){
						if(!DarkRoleplayMedieval.VERSION.equals(version[1])){
							newVersion = version[1];
							setNewVersionAvailable();
							if(!version[2].equals("none")) downloadURL = version[2];
								 
							if(!version[3].equals("none")) changelogURL = version[3];
							
						}
					}
					
					
				} catch (MalformedURLException e) {
					System.err.println("Dark Roleplay Medieval Update Check failed!");
				} catch (IOException e) {
					System.err.println("Dark Roleplay Medieval Update Check failed!");
				}
			}
			
		}.start();
	}
	
	private static synchronized void setNewVersionAvailable(){
		newVersionAvailable = true;
	}
	
	public static synchronized boolean isNewVersionAvailable(){
		return newVersionAvailable;
	}
	
	public static synchronized String getDownloadURL(){
		return downloadURL;
	}
	
	public static synchronized String getChangelogURL(){
		return changelogURL;
	}
	
	public static synchronized String getVersion(){
		return newVersion;
	}
}
