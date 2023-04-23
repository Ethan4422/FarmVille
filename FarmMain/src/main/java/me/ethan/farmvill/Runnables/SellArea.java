package me.ethan.farmvill.Runnables;

import me.ethan.farmvill.FarmVill;
import me.ethan.farmvill.functions;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class SellArea extends BukkitRunnable {

    FarmVill plugin;

    public SellArea(FarmVill plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for(Player player : Bukkit.getOnlinePlayers()){
            for(Entity entity : Objects.requireNonNull(Bukkit.getWorld(player.getWorld().getName())).getEntities()){
                if(entity.getType() == EntityType.ARMOR_STAND && entity.getCustomName() == "§a§lSell Area"){
                    if(player.getLocation().distance(entity.getLocation()) < 3){
                        functions.Sell(player);
                    }
                }
            }
        }
    }
}
