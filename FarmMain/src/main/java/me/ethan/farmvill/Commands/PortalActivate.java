package me.ethan.farmvill.Commands;

import me.ethan.farmvill.Configuration.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PortalActivate implements CommandExecutor {

    PlayerConfig userConfig = new PlayerConfig();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            Location Area1TeleporterDown = new Location(Bukkit.getWorld("Worlds.Area1"), 106, 100, 1039);
            Location Area1TeleporterUp = new Location(Bukkit.getWorld("Worlds.Area1"), 46, 105, 1039);
            if(player.getLocation().getBlockY() == 100 && player.getWorld().getBlockAt(player.getLocation().add(0, -1, 0)).getType() == Material.MAGENTA_STAINED_GLASS){
                player.teleport(Area1TeleporterUp);
            } else if (player.getLocation().getBlockY() == 105 && player.getWorld().getBlockAt(player.getLocation().add(0, -1, 0)).getType() == Material.MAGENTA_STAINED_GLASS) {
                if(userConfig.getCash(player) >= 250) {
                    userConfig.setCash(player, userConfig.getCash(player) - 250);
                    player.teleport(Area1TeleporterDown);
                }
            }
        }
        return false;
    }
}
