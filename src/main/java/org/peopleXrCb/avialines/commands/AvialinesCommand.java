package org.peopleXrCb.avialines.commands;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.EssentialsPluginListener;
import com.earth2me.essentials.IEssentials;
import com.earth2me.essentials.Warps;
import net.ess3.api.IWarps;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.peopleXrCb.avialines.AvialinesPlugin;
import org.peopleXrCb.avialines.inventory.AvialinesInventory;
import org.peopleXrCb.avialines.objects.Avialine;
import org.peopleXrCb.avialines.utils.ChatUtil;
import org.peopleXrCb.avialines.utils.EconomyService;
import org.peopleXrCb.avialines.utils.WarpService;

public class AvialinesCommand extends AbstractPluginCommand<Player> {
    public AvialinesCommand() {
        super("avialines");
    }

    @Override
    protected void execute(Player player, String[] args) {
        if (args.length == 1) {
            String warp = args[0];
            if (!WarpService.isWarp(warp)) {
                player.sendMessage(ChatUtil.parseColor(AvialinesPlugin.PREFIX + "&cДанного варпа не существует!"));
                return;
            }

            player.openInventory(AvialinesInventory.createInventory(player, warp).getInventory());
            return;
        }

        if (args.length == 2) {
            String warp = args[0];
            if (!WarpService.isWarp(warp)) {
                player.sendMessage(ChatUtil.parseColor(AvialinesPlugin.PREFIX + "&cДанного варпа не существует!"));
                return;
            }

            String avialine = args[1];
            if (!Avialine.isAvialine(avialine)) {
                player.sendMessage(ChatUtil.parseColor(AvialinesPlugin.PREFIX + "&cАвиакомпания не найдена!"));
                return;
            }

            if (!EconomyService.hasBalance(player, Avialine.getAvialine(avialine).getPrice(player.getLocation(), WarpService.getWarp(warp)))) {
                player.sendMessage(ChatUtil.parseColor(AvialinesPlugin.PREFIX + "&cНедостаточно средств!"));
                return;
            }

            if (Avialine.getAvialine(avialine).getBagage() < player.getInventory().getContents().length - player.getInventory().all(Material.AIR).size()) {
                player.sendMessage(ChatUtil.parseColor(AvialinesPlugin.PREFIX + "&cУ вас перевес! Данная авиакомпания позволяет только " + Avialine.getAvialine(avialine).getBagage() + " шт. багажа на борт!"));
                return;
            }

            EconomyService.withdrawPlayer(player, Avialine.getAvialine(avialine).getPrice(player.getLocation(), WarpService.getWarp(warp)));
            player.teleport(WarpService.getWarp(warp));
            player.sendMessage(ChatUtil.parseColor(AvialinesPlugin.PREFIX + "Авиакомпания " + avialine + " &fблагодарит Вас за использование услуг нашей авиакомпании!"));
            return;
        }

        this.help(player);
    }

    @Override
    protected void help(Player player) {
        player.sendMessage(ChatUtil.parseColor(AvialinesPlugin.PREFIX + "Использование: /avialines <название варпа> - долететь до места назначения."));
    }

    @Override
    protected boolean hasAccess(CommandSender sender) {
        return sender instanceof Player;
    }
}