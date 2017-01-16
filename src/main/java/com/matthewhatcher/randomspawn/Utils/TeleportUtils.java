package com.matthewhatcher.randomspawn.Utils;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.matthewhatcher.randomspawn.RandomSpawn;

public class TeleportUtils {
	public static void teleport(Player p) {
		if(RandomSpawn.getInstance().getConfig().getBoolean("debug"))
			RandomSpawn.logger.info("Teleporting " + p.getName());
		
		p.teleport(randomLocation(p.getWorld()));
		MessageUtils.send(p, "You have been teleported to a random location.");
	}
	
	public static Location randomLocation(World w) {
		FileConfiguration c = RandomSpawn.getInstance().getConfig();
		Random r = new Random();
		
		int x = c.getInt("coods.x.min") + r.nextInt(c.getInt("coords.x.max") - c.getInt("coords.x.min") + 1);
		int z = c.getInt("coods.z.min") + r.nextInt(c.getInt("coords.z.max") - c.getInt("coords.z.min") + 1);
		int y = w.getHighestBlockYAt(x, z);
		
		return new Location(w, x, y, z);
	}
}
