package me.ethan.farmvill.Commands.Players;

import me.ethan.farmvill.Configuration.PlayerConfig;
import me.ethan.farmvill.FarmVill;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnTeleport implements CommandExecutor {

    PlayerConfig userConfig = new PlayerConfig();

    FarmVill plugin;

    public SpawnTeleport(FarmVill plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            player.teleport(plugin.getConfig().getLocation("Spawn"));
        }
        return false;
    }
}
