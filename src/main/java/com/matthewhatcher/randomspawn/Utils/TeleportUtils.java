package com.matthewhatcher.randomspawn.Utils;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
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
		
		if(c.getBoolean("use-as-whitelist", false)) {
			if(!c.getStringList("world-blacklist.worlds").contains(w.getName())) {
				if(Bukkit.getWorld(c.getString("world-blacklist.fallback-world")) != null) {
					w = Bukkit.getWorld(c.getString("world-blacklist.fallback-world"));
				}
			}
		} else {
			if(c.getStringList("world-blacklist.worlds").contains(w.getName())) {
				if(Bukkit.getWorld(c.getString("world-blacklist.fallback-world")) != null) {
					w = Bukkit.getWorld(c.getString("world-blacklist.fallback-world"));
				}
			}
		}
		
		int x = generateInt(c.getInt("coords.x.min"), c.getInt("coords.x.max"));
		int z = generateInt(c.getInt("coords.z.min"), c.getInt("coords.z.max"));
		int y = 0;
		
		Location loc = new Location(w, x, y, z);
		Chunk chunk = loc.getChunk();
		
		
		if(!chunk.isLoaded()) {
			chunk.load(true);
		}
		
		loc.setY(w.getHighestBlockYAt(loc));
		
		Block under = w.getBlockAt(loc);
		
		if(under.getType() == Material.LAVA || under.getType() == Material.STATIONARY_LAVA) {
			under.setType(Material.STONE);
			loc.setY(loc.getY() + 1);
		}
		
		return loc;
	}
	
	public static int generateInt(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
}
