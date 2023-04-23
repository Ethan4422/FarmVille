package me.ethan.farmvill.Commands;

import me.ethan.farmvill.Configuration.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.jetbrains.annotations.NotNull;

public class setAutoSellSack implements CommandExecutor {

    PlayerConfig userConfig = new PlayerConfig();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            if (args.length == 2) {
                userConfig.setAutoSellSack(Bukkit.getPlayer(args[0]), Boolean.parseBoolean(args[1]));
                userConfig.setSackSize(Bukkit.getPlayer(args[0]), Integer.MAX_VALUE);
            }
            else {
                Bukkit.getLogger().warning("setAutoSellSack PlayerName Boolean");
            }
        }
        return false;
    }
}