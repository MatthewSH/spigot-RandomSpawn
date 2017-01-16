package com.matthewhatcher.randomspawn.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.matthewhatcher.randomspawn.Utils.TeleportUtils;

public class FirstJoinListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if(!e.getPlayer().hasPlayedBefore()) {
			TeleportUtils.teleport(e.getPlayer());
		}
	}
}
