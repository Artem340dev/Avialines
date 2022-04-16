package org.peopleXrCb.avialines.configuration;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public abstract class CustomPluginConfiguration {
    private Plugin plugin;

    public CustomPluginConfiguration(Plugin plugin) {
        this.plugin = plugin;
    }

    protected Plugin getPlugin() {
        return plugin;
    }

    protected FileConfiguration getConfig() {
        return plugin.getConfig();
    }

    protected String getString(String path) {
        return this.getConfig().getString(path);
    }

    protected int getInt(String path) {
        return this.getConfig().getInt(path);
    }

    protected void setValue(String path, Object value) {
        this.getConfig().set(path, value);
        this.getPlugin().saveConfig();
    }

    public abstract void enable();
    public abstract void disable();
}