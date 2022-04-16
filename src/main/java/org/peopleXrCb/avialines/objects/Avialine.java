package org.peopleXrCb.avialines.objects;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Avialine {
    private static HashMap<String, Avialine> avialines;

    private String name;
    private AvialineIcon icon;
    private int price, bagage;

    static {
        avialines = new HashMap<>();
    }

    public Avialine(String name, AvialineIcon icon, int price, int bagage) {
        this.name = name;
        this.icon = icon;
        this.price = price;
        this.bagage = bagage;

        avialines.put(name, this);
    }

    public String getName() {
        return name;
    }

    public AvialineIcon getIcon() {
        return icon;
    }

    public int getPrice() {
        return price;
    }

    public int getPrice(Location from, Location to) {
        return price * (int) from.distance(to);
    }

    public int getBagage() {
        return bagage;
    }

    public static boolean isAvialine(String name) {
        return avialines.containsKey(name);
    }

    public static Avialine getAvialine(String name) {
        return avialines.get(name);
    }

    public static List<Avialine> getAvialines() {
        List<Avialine> avialineList = new ArrayList<>();
        avialines.forEach((name, avialine) -> avialineList.add(avialine));

        return avialineList;
    }
}