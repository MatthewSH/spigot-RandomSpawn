package com.matthewhatcher.randomspawn.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.matthewhatcher.randomspawn.Utils.TeleportUtils;

public class CommandRandomSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player && label.equalsIgnoreCase("randomspawn")) {
			Player player = (Player)sender;
			
			if(!player.hasPermission("randomspawn.command")) {
				player.sendMessage(ChatColor.GREEN + "[Random Spawn]" + ChatColor.AQUA + " You do not have the correct permission to perform this action.");
				return true;
			}
			
			if(args.length < 1) {
				if(!player.hasPermission("randomspawn.teleportothers")) {
					player.sendMessage(ChatColor.GREEN + "[Random Spawn]" + ChatColor.AQUA + " You do not have the correct permission to perform this action.");
					return true;
				}
				
				TeleportUtils.teleport(player);
				return true;
			}
			
			Player tpPlayer = Bukkit.getPlayer(args[0]);
			
			if(tpPlayer == null) {
				player.sendMessage(ChatColor.GREEN + "[Random Spawn]" + ChatColor.AQUA + " That player is not online.");
				return true;
			}
			
			TeleportUtils.teleport(player);
			
			player.sendMessage(ChatColor.GREEN + "[Random Spawn]" + ChatColor.AQUA + " Player has been teleported.");
			
			return true;
		} else if (sender instanceof ConsoleCommandSender) {
			if(args.length < 1) {
				sender.sendMessage(ChatColor.GREEN + "[Random Spawn]" + ChatColor.AQUA + " You must include a player since you're on the console.");
				return true;
			}
			
			Player player = Bukkit.getPlayer(args[0]);
			
			if(player == null) {
				sender.sendMessage(ChatColor.GREEN + "[Random Spawn]" + ChatColor.AQUA + " That player is not online.");
				return true;
			}
			
			TeleportUtils.teleport(player);
			
			return true;
		}
		
		
		return false;
	}

}
