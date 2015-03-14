package me.Hydroxide.AutoPickup;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EventListener implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		ItemStack brokenBlock = new ItemStack(event.getBlock().getType());
		Player player = event.getPlayer();
		Inventory playerInven = player.getInventory();
				
		new CommandHandler();
		if(CommandHandler.pickupEnabled.contains(player)) {
			if(brokenBlock.getType() == Material.DEAD_BUSH || brokenBlock.getType() == Material.LEAVES ||brokenBlock.getType() == Material.VINE || brokenBlock.getType() == Material.THIN_GLASS || brokenBlock.getType() == Material.LONG_GRASS) { 
				return;
			}
		playerInven.addItem(brokenBlock);
		event.getBlock().getWorld().getBlockAt(event.getBlock().getLocation()).setType(Material.AIR);
		}
	}	
	
	
}
