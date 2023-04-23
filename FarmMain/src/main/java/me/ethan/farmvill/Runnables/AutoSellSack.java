package me.ethan.farmvill.Runnables;

import me.ethan.farmvill.Configuration.PlayerConfig;
import me.ethan.farmvill.FarmVill;
import me.ethan.farmvill.functions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AutoSellSack extends BukkitRunnable {


    FarmVill plugin;

    public AutoSellSack(FarmVill plugin) {
        this.plugin = plugin;
    }

    PlayerConfig userConfig = new PlayerConfig();

    @Override
    public void run() {
        for(Player people : Bukkit.getOnlinePlayers()){
            if(userConfig.getAutoSellSack(people)){
                functions.Sell(people);
            }
        }
    }
}
