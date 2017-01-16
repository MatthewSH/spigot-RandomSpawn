package com.matthewhatcher.randomspawn.Utils;

import java.io.File;

import com.matthewhatcher.randomspawn.RandomSpawn;

public class FileUtils {
	public void firstRun() {
		RandomSpawn p = RandomSpawn.getInstance();
		
		try {
			if(!p.getDataFolder().exists())
				p.getDataFolder().mkdirs();
			
			File f = new File(p.getDataFolder(), "config.yml");
			
			if(!f.exists())
				p.saveDefaultConfig();
		} catch(Exception e) {
			RandomSpawn.logger.severe("Can not read data folder. Shutting down...");
			p.getPluginLoader().disablePlugin(RandomSpawn.getInstance());
		}
	}
}
