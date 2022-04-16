package org.peopleXrCb.avialines.inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.peopleXrCb.avialines.AvialinesPlugin;

public abstract class ItemActionListener implements Listener {
    private CustomInventory inventory;
    private ItemStack item;

    public ItemActionListener(CustomInventory inventory, ItemStack item) {
        this.inventory = inventory;
        this.item = item;
    }

    @EventHandler
    public void onInventoryAction(InventoryClickEvent event) {
        Player target = (Player) event.getWhoClicked();

        if (event.getInventory().getTitle().equals(inventory.getTitle()) && event.getCurrentItem().equals(item)) {
            event.setCancelled(true);
            target.closeInventory();
            this.execute(target);
        }

        inventory.finalize();
    }

    public void register() {
        Bukkit.getPluginManager().registerEvents(this, AvialinesPlugin.getInstance());
    }

    public void unregister() {
        Bukkit.getPluginManager().registerEvents(this, null);
    }

    public abstract void execute(Player target);
}