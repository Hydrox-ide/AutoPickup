package me.Hydroxide.AutoPickup;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor{

	public static ArrayList<Player>pickupEnabled = new ArrayList<Player>();
	String prefix = ChatColor.GRAY + "[" + ChatColor.RED + "AutoPickup" + ChatColor.GRAY + "]" + " ";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(prefix + ChatColor.RED + "Console commands are not supported by AutoPickup at this time.");
			return false;
		}
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("autopickup") && args.length == 0) {
			player.sendMessage(prefix + ChatColor.RED + "Please specify args.");
			return false;
		} else if(args.length == 1) {
			if(args[0].equalsIgnoreCase("on")) {
				pickupEnabled.add(player);
				player.sendMessage(prefix + ChatColor.GREEN + "AutoPickup has been enabled.");
				return true;
			}else if(args[0].equalsIgnoreCase("off")) {
				pickupEnabled.remove(player);
				player.sendMessage(prefix + ChatColor.RED + "AutoPickup has been disabled.");
				return true;
			}
		}
		return false;
	}
	
}
