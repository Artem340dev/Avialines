package org.peopleXrCb.avialines.inventory;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomInventory {
    private List<ItemActionListener> listeners = new ArrayList<>();
    private Inventory inventory;

    public CustomInventory(String title, int size) {
        this.inventory = Bukkit.createInventory(null, size, title);
    }

    public CustomInventory(String title, InventoryType type) {
        this.inventory = Bukkit.createInventory(null, type, title);
    }

    public String getTitle() {
        return inventory.getTitle();
    }

    public Inventory getInventory() {
        return inventory;
    }

    protected void addItem(ItemStack item, ItemActionListener listener) {
        inventory.addItem(item);
        listener.register();

        listeners.add(listener);
    }

    protected void addItem(ItemStack item) {
        inventory.addItem(item);
    }

    protected void finalize() {
        listeners.forEach(listener -> listener.unregister());
    }
}