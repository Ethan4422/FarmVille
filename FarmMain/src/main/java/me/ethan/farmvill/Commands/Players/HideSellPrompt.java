package me.ethan.farmvill.Commands.Players;

import me.ethan.farmvill.Configuration.PlayerConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class HideSellPrompt implements CommandExecutor, TabCompleter {

    PlayerConfig userConfig = new PlayerConfig();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
                userConfig.setHideSell(player, Boolean.valueOf(args[0]));
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 1){
            List<String> Booleans = new ArrayList<>();
            Booleans.add("true");
            Booleans.add("false");
            return Booleans;
        }
        return null;
    }
}
