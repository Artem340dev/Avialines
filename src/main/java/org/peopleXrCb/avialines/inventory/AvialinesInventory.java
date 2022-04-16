package org.peopleXrCb.avialines.inventory;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.peopleXrCb.avialines.objects.Avialine;
import org.peopleXrCb.avialines.utils.WarpService;

public class AvialinesInventory extends CustomInventory {
    public AvialinesInventory(Player target, String warp) {
        super("Оформить билет на рейс", InventoryType.HOPPER);

        Avialine.getAvialines().forEach(avialine -> {
            ItemStack icon = avialine.getIcon().getItemIcon((int) target.getLocation().distance(WarpService.getWarp(warp)), avialine.getPrice(target.getLocation(), WarpService.getWarp(warp)), avialine.getBagage());
            this.addItem(icon, new ItemActionListener(this, icon) {
                @Override
                public void execute(Player target) {
                    target.performCommand("avialines " + warp + " " + avialine.getName());
                }
            });
        });
    }

    public static AvialinesInventory createInventory(Player target, String warp) {
        return new AvialinesInventory(target, warp);
    }
}