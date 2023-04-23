package me.ethan.farmvill.Commands;

import me.ethan.farmvill.Configuration.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class set2xsell implements CommandExecutor {
    PlayerConfig userConfig = new PlayerConfig();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            if (args.length == 2) {
                userConfig.set2XSell(Bukkit.getOfflinePlayer(args[0]), Boolean.parseBoolean(args[1]));
            }
            else {
                Bukkit.getLogger().warning("set2xsell PlayerName Boolean");
            }
        }
        return false;
    }
}