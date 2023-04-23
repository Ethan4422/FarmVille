package me.ethan.farmvill.Commands;

import me.ethan.farmvill.FarmVill;
import org.apache.commons.lang3.Validate;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Line implements CommandExecutor {

    FarmVill plugin;
    public Line(FarmVill plugin){this.plugin = plugin;}

    public void drawLine(Player player, Location point1, Location point2, double space) {
        World world = point1.getWorld();
        Validate.isTrue(point2.getWorld().equals(world), "Lines cannot be in different worlds!");
        double distance = point1.distance(point2);
        Vector p1 = point1.toVector();
        Vector p2 = point2.toVector();
        Vector vector = p2.clone().subtract(p1).normalize().multiply(space);
        double length = 0;
        for (; length < distance; p1.add(vector)) {

            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.WHITE, 2);
            player.spawnParticle(Particle.REDSTONE, p1.getX(), p1.getY(), p1.getZ(), 1, dustOptions);

            length += space;
        }
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.isOp()){
                if(!player.getName().equalsIgnoreCase(args[0]) && Bukkit.getPlayer(args[0]) != null) {
                    for (int i = 0; i < 50; i++) {
                        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                            @Override
                            public void run() {
                                drawLine(player, player.getLocation(), Bukkit.getPlayer(args[0]).getLocation(), 0.5);
                            }
                        }, 5 * i);
                    }
                }
                else {
                    player.sendMessage("§4Name is invalid or you tried drawing a line to yourself.");
                }

            }
        }
        return false;
    }
}
