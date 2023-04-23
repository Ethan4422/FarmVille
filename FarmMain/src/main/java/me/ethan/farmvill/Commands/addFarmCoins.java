package me.ethan.farmvill.Commands;

import me.ethan.farmvill.Configuration.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.jetbrains.annotations.NotNull;

public class addFarmCoins implements CommandExecutor {
    PlayerConfig userConfig = new PlayerConfig();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            if (args.length == 2) {
                userConfig.setFarmCoins(Bukkit.getPlayer(args[0]),userConfig.getFarmCoins(Bukkit.getPlayer(args[0])) + Double.parseDouble(args[1]));
            }
            else {
                Bukkit.getLogger().warning("setFarmCoins Player Double");
            }
        }
        return false;
    }
}