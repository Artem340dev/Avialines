package org.peopleXrCb.avialines.utils;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.Warps;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class WarpService {
    private static Essentials essentials;

    static {
        essentials = (Essentials) Bukkit.getPluginManager().getPlugin("Essentials");
    }

    public static Location getWarp(String name) {
        try {
            return essentials.getWarps().getWarp(name);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isWarp(String name) {
        return essentials.getWarps().isWarp(name);
    }
}