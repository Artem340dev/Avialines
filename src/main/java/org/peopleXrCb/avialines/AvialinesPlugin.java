package org.peopleXrCb.avialines;

import org.bukkit.plugin.java.JavaPlugin;
import org.peopleXrCb.avialines.commands.AvialinesCommand;
import org.peopleXrCb.avialines.configuration.AvialinesPluginConfiguration;
import org.peopleXrCb.avialines.configuration.CustomPluginConfiguration;
import org.peopleXrCb.avialines.utils.ChatUtil;

public final class AvialinesPlugin extends JavaPlugin {
    public static final String PREFIX = ChatUtil.parseColor("&bАвиалинии &8> &f");
    private static AvialinesPlugin instance;
    private CustomPluginConfiguration configuration;

    @Override
    public void onEnable() {
        instance = this;

        configuration = new AvialinesPluginConfiguration(this);
        configuration.enable();

        new AvialinesCommand().register();
    }

    public static AvialinesPlugin getInstance() {
        return instance;
    }
}