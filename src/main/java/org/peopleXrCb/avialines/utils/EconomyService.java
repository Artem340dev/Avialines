package org.peopleXrCb.avialines.utils;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public class EconomyService {
    private static Economy economy;

    static {
        economy = Bukkit.getServicesManager().getRegistration(Economy.class).getProvider();
    }

    public static double getBalance(OfflinePlayer player) {
        return economy.getBalance(player);
    }

    public static boolean hasBalance(OfflinePlayer player, int count) {
        return economy.getBalance(player) >= count;
    }

    public static void depositPlayer(OfflinePlayer player, int count) {
        economy.depositPlayer(player, count);
    }

    public static void withdrawPlayer(OfflinePlayer player, int count) {
        economy.withdrawPlayer(player, count);
    }
}