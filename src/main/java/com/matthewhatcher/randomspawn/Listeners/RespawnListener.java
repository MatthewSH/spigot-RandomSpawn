package com.matthewhatcher.randomspawn.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.matthewhatcher.randomspawn.Utils.TeleportUtils;

public class RespawnListener implements Listener {
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		TeleportUtils.teleport(e.getPlayer());
	}
}
