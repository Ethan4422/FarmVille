package me.ethan.farmvill.Commands;

import me.ethan.farmvill.Commands.ShopStuff.FCShopUtils;
import me.ethan.farmvill.Configuration.PlayerConfig;
import me.ethan.farmvill.FarmVill;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class fcCommand implements CommandExecutor {

    PlayerConfig userConfig = new PlayerConfig();

    FarmVill plugin;

    public fcCommand(FarmVill plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            FCShopUtils.openShopMain(player);
        }
        return false;
    }
}
