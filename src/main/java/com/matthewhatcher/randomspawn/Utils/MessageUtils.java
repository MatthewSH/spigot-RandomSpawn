package com.matthewhatcher.randomspawn.Utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.matthewhatcher.randomspawn.RandomSpawn;

public class MessageUtils {
	private static String prefix = "&c[Random Spawn] &b";
	private static boolean displayMessages = true;
	
	public MessageUtils() {
		MessageUtils.prefix = RandomSpawn.getInstance().getConfig().getString("chat-prefix", "&c[Random Spawn] &b");
		MessageUtils.displayMessages = RandomSpawn.getInstance().getConfig().getBoolean("display-messages", true);
	}
	
	public static void send(Player p, String m) {
		if(MessageUtils.displayMessages) {
			String message = prefix + m;
			p.sendMessage(message.replaceAll("&", "§"));
		}
	}
	
	public static void send(CommandSender s, String m) {
		if(MessageUtils.displayMessages) {
			String message = prefix + m;
			s.sendMessage(message.replaceAll("&", "§"));
		}
	}
}
