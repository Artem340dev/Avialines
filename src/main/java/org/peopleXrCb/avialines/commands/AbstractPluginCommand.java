package org.peopleXrCb.avialines.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.peopleXrCb.avialines.AvialinesPlugin;

public abstract class AbstractPluginCommand<T> implements CommandExecutor {
    private String name;

    public AbstractPluginCommand(String name) {
        this.name = name;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (this.hasAccess(sender)) {
            T entity = (T) sender;
            this.execute(entity, args);

            return true;
        }

        return false;
    }

    public void register() {
        AvialinesPlugin.getInstance().getCommand(name).setExecutor(this);
    }

    protected abstract void execute(T entity, String[] args);
    protected abstract void help(T entity);

    protected abstract boolean hasAccess(CommandSender sender);
}