package com.matthewhatcher.randomspawn.Listeners;

import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.matthewhatcher.randomspawn.RandomSpawn;
import com.matthewhatcher.randomspawn.Utils.TeleportUtils;

import net.md_5.bungee.api.ChatColor;

public class SignListener implements Listener {
	boolean debug = false;
	
	public SignListener(boolean debug) {
		this.debug = debug;
	}
	
	@EventHandler
	public void onSignCreate(SignChangeEvent e) {
		if(e.getLine(0).equalsIgnoreCase("randomspawn")) {
			FileConfiguration c = RandomSpawn.getInstance().getConfig();
			e.setLine(0, "§l§a[Random Spawn]");
			e.setLine(1, c.getString("sign-messages.line-1").replaceAll("&", "§"));
			e.setLine(2, c.getString("sign-messages.line-2").replaceAll("&", "§"));
			e.setLine(3, c.getString("sign-messages.line-3").replaceAll("&", "§"));
		}
	}
	
	@EventHandler
	public void onSignInteract(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK && e.hasBlock() && (e.getClickedBlock().getState() instanceof Sign)) {
			Sign s = (Sign) e.getClickedBlock().getState();
			
			if(debug) {
				RandomSpawn.logger.info(e.getPlayer().getName() + " is interacting with a sign...checking to see if it's ours.");
				RandomSpawn.logger.info("The sign's first line is: " + s.getLine(0));
			}
			
			if(s.getLine(0).equalsIgnoreCase(ChatColor.GREEN + "[Random Spawn]"))
				if(debug)
					RandomSpawn.logger.info("It's our sign. Let's get moving.");
				TeleportUtils.teleport(e.getPlayer());
		}
	}
}
