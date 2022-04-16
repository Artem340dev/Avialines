package org.peopleXrCb.avialines.configuration;

import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.peopleXrCb.avialines.objects.Avialine;
import org.peopleXrCb.avialines.objects.AvialineIcon;

public class AvialinesPluginConfiguration extends CustomPluginConfiguration {
    public AvialinesPluginConfiguration(Plugin plugin) {
        super(plugin);
    }

    @Override
    public void enable() {
        super.getConfig().options().copyDefaults(true);
        super.getPlugin().saveDefaultConfig();

        for (String id : super.getConfig().getConfigurationSection("avialines").getKeys(false)) {
            String name = super.getString("avialines." + id + ".name");
            int price = super.getInt("avialines." + id + ".price");
            int bagage = super.getInt("avialines." + id + ".bagage");
            AvialineIcon icon = new AvialineIcon(name, Material.getMaterial(super.getString("avialines." + id + ".icon.material")), super.getInt("avialines." + id + ".icon.color"));
            Avialine avialine = new Avialine(name, icon, price, bagage);
        }
    }

    @Override
    public void disable() {
    }
}