package me.Hydroxide.AutoPickup;

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
		event.getBlock().getDrops().clear();
		playerInven.addItem(brokenBlock);
		}
	}	
}
