package org.peopleXrCb.avialines.objects;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.peopleXrCb.avialines.utils.ItemUtil;

import java.util.Arrays;

public final class AvialineIcon {
    private String name;
    private Material material;
    private int color;

    public AvialineIcon(String name, Material material, int color) {
        this.name = name;
        this.material = material;
        this.color = color;
    }

    public ItemStack getItemIcon(int distance, int price, int bagage) {
        return ItemUtil.getItem(name, Arrays.asList("", "&fДистанция: &c" + distance + " блоков", "&fБагаж: &cне более " + bagage + " шт.", "&fЦена: &c" + price + "$"), material, color);
    }
}