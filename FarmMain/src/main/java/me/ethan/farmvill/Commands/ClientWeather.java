package me.ethan.farmvill.Commands;

import me.ethan.farmvill.Configuration.PlayerConfig;
import me.ethan.farmvill.FarmVill;
import org.bukkit.WeatherType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ClientWeather implements CommandExecutor, TabCompleter {

    PlayerConfig userConfig = new PlayerConfig();

    FarmVill plugin;

    public ClientWeather(FarmVill plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("downfall")) {
                    userConfig.setRaining(player, true);
                } else if (args[0].equalsIgnoreCase("clear")) {
                    userConfig.setRaining(player, false);
                }
                player.setPlayerWeather(WeatherType.valueOf(args[0].toUpperCase()));
            } else {
                player.sendMessage("Clear", "Downfall");
            }
        }
        return false;
    }
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 1){
            List<String> WeatherType = new ArrayList<>();
            WeatherType.add("Downfall");
            WeatherType.add("Clear");
            return WeatherType;
        }
        return null;
    }
}

