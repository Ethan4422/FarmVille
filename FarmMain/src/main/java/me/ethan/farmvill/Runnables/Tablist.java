package me.ethan.farmvill.Runnables;

import me.ethan.farmvill.Configuration.PlayerConfig;
import me.ethan.farmvill.FarmVill;
import me.ethan.farmvill.functions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Tablist extends BukkitRunnable {

    FarmVill plugin;
    PlayerConfig userConfig = new PlayerConfig();

    public Tablist(FarmVill plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for (Player people : Bukkit.getOnlinePlayers()) {

            String listName = String.format(functions.getRank(people) + "§f " + people.getName());

            people.setPlayerListHeader("§fFarmVille.Feathermc.gg");
            people.setPlayerListName(listName);
        }
    }
}
