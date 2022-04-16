package org.peopleXrCb.avialines.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemUtil {
    public static ItemStack getItem(String name, List<String> lore, Material material, int color) {
        ItemStack item = new ItemStack(material, 1, (byte) color);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatUtil.parseColor(name));
        meta.setLore(ChatUtil.parseColor(lore));
        item.setItemMeta(meta);

        return item;
    }
}