package com.matthewhatcher.randomspawn;

import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.matthewhatcher.randomspawn.Commands.CommandRandomSpawn;
import com.matthewhatcher.randomspawn.Listeners.FirstJoinListener;
import com.matthewhatcher.randomspawn.Listeners.JoinListener;
import com.matthewhatcher.randomspawn.Listeners.RespawnListener;
import com.matthewhatcher.randomspawn.Listeners.SignListener;
import com.matthewhatcher.randomspawn.Utils.FileUtils;

public class RandomSpawn extends JavaPlugin {
	public FileUtils fileUtils;
	
	public static Logger logger;
	private static RandomSpawn instance;
	
	public static RandomSpawn getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		instance = this;
		logger = getInstance().getLogger();
		
		fileUtils = new FileUtils();
		fileUtils.firstRun();
		
		this.registerListeners();
		this.registerCommands();
		
		super.onEnable();
	}
	
	private void registerCommands() {
		FileConfiguration c = getInstance().getConfig();
		boolean debug = c.getBoolean("debug");
		
		if(c.getBoolean("use-command")) {
			if(debug)
				logger.info("Registering the random spawn command.");
			
			getInstance().getCommand("randomspawn").setExecutor(new CommandRandomSpawn());
		}
	}
	
	private void registerListeners() {
		FileConfiguration c = getInstance().getConfig();
		boolean debug = c.getBoolean("debug");
		
		if(debug)
			logger.info("Debug is on, logging more info.");
		
		if(c.getBoolean("on-first-join")) {
			if(debug)
				logger.info("Registering first join event listener");
			
			getInstance().getServer().getPluginManager().registerEvents(new FirstJoinListener(), getInstance());
		}
		
		if(c.getBoolean("onjoin")) {
			if(debug)
				logger.info("Registering join event listener");
			
			getInstance().getServer().getPluginManager().registerEvents(new JoinListener(), getInstance());
		}
		
		if(c.getBoolean("onrespawn")) {
			if(debug)
				logger.info("Registering respawn event listener");
			
			getInstance().getServer().getPluginManager().registerEvents(new RespawnListener(), getInstance());
		}
		
		if(c.getBoolean("signs")) {
			if(debug)
				logger.info("Registering sign event listener");
			
			getInstance().getServer().getPluginManager().registerEvents(new SignListener(debug), getInstance());
		}
	}
}
