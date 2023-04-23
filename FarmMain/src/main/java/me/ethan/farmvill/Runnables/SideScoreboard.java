package me.ethan.farmvill.Runnables;

import me.ethan.farmvill.Configuration.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.util.Set;


public class SideScoreboard extends BukkitRunnable {

    private final Plugin plugin;
    PlayerConfig userConfig = new PlayerConfig();
    private final ScoreboardManager scoreboardManager;

    public SideScoreboard(Plugin plugin) {
        this.plugin = plugin;
        this.scoreboardManager = Bukkit.getScoreboardManager();
    }

    @Override
    public void run() {
        for(Player people : Bukkit.getOnlinePlayers()) {
            ScoreboardManager manager = Bukkit.getScoreboardManager();
            Scoreboard board = manager.getNewScoreboard();
            Objective obj = board.registerNewObjective("§f§lFarmVille", "dummy");
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);

            Score Name = obj.getScore("§l> Name " + people.getName());

            Score Cash = obj.getScore("§l> Cash §a" + userConfig.getCash(people) + "$");

            Score FarmCoins = obj.getScore("§l> FarmCoins §5§l" + userConfig.getFarmCoins(people));

            Score Sack = obj.getScore("§l> Sack " + userConfig.getSackSpaceLeft(people) + "/" + userConfig.getSackSize(people));

            Name.setScore(3);
            Sack.setScore(2);
            Cash.setScore(1);
            FarmCoins.setScore(0);

            people.setScoreboard(board);
        }
    }
}
