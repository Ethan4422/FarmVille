package me.ethan.farmvill.listeners;

import me.ethan.farmvill.Configuration.PlayerConfig;
import me.ethan.farmvill.FarmVill;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.Arrays;
import java.util.List;

public class User implements Listener {

    PlayerConfig userConfig = new PlayerConfig();
    FarmVill plugin;

    public User(FarmVill plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void setup(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.setCollidable(false);
        userConfig.playerConfig(player);
        if (userConfig.getRaining(player)) {
            player.setPlayerWeather(WeatherType.DOWNFALL);
        } else {
            player.setPlayerWeather(WeatherType.CLEAR);
        }
    }

    @EventHandler
    public void death(PlayerDeathEvent e) {
        Player player = e.getPlayer();
        if (player.isDead()) {
            player.spigot().respawn();
            player.teleport(plugin.getConfig().getLocation("Spawn"));
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (event.getPlayer().getGameMode() != GameMode.CREATIVE) {
            final Block block = event.getBlock();
            if (block.getType() == Material.WHEAT) {
                Ageable CropAge = (Ageable) block.getBlockData();
                if (CropAge.getAge() == CropAge.getMaximumAge()) {
                    event.setCancelled(true);
                    ItemStack mainHand = event.getPlayer().getInventory().getItemInMainHand();

                    if (mainHand.hasItemMeta()) {
                        switch (mainHand.getItemMeta().getDisplayName()) {
                            case "§f§lHoe1":
                                event.getPlayer().getInventory().addItem(new ItemStack(Material.WHEAT, 2));
                                break;

                            case "§f§lHoe2":
                                event.getPlayer().getInventory().addItem(new ItemStack(Material.WHEAT, 3));
                                break;

                            default:
                                event.getPlayer().getInventory().addItem(new ItemStack(Material.WHEAT, 1));
                                break;
                        }
                    } else {
                        event.getPlayer().getInventory().addItem(new ItemStack(Material.WHEAT, 1));
                    }
                    Bukkit.getWorld(block.getWorld().getName()).getBlockAt(block.getLocation()).setType(Material.AIR);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (Bukkit.getWorld(block.getWorld().getName()).getBlockAt(block.getLocation().subtract(0, 1, 0)).getType() == Material.FARMLAND) {
                                Bukkit.getWorld(block.getWorld().getName()).getBlockAt(block.getLocation()).setType(CropAge.getMaterial());
                            } else {
                                Bukkit.getWorld(block.getWorld().getName()).getBlockAt(block.getLocation().subtract(0, 1, 0)).setType(Material.FARMLAND);
                                Bukkit.getWorld(block.getWorld().getName()).getBlockAt(block.getLocation()).setType(CropAge.getMaterial());
                            }
                            CropAge.setAge(6);
                        }
                    }.runTaskLater(plugin, 20);
                }
            }
        }
    }

    @EventHandler
    public void closeVault(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        if (e.getView().getTitle() == player.getUniqueId().toString()) {
            for (ItemStack item : e.getInventory().getStorageContents()) {

            }
        }
    }

    @EventHandler
    public void joinWhileVanish(PlayerJoinEvent e) {
        if (userConfig.getVanish(e.getPlayer())) {
            e.setJoinMessage("");
            e.getPlayer().sendMessage("You are hidden from online players!");
            for (Player people : Bukkit.getOnlinePlayers()) {
                people.hidePlayer(plugin, e.getPlayer());
            }
        }
        else{
            if(e.getPlayer().hasPlayedBefore()){
                e.setJoinMessage("§fWelcome back " + e.getPlayer().getName() + "!");
            }
            else {
                e.setJoinMessage("§fWelcome to the server " + e.getPlayer().getName() + "!");
            }
        }
    }

    @EventHandler
    public void leaveWhileVanish(PlayerQuitEvent e) {
        if (userConfig.getVanish(e.getPlayer())) {
            e.setQuitMessage("");
        }
    }

    private static final List<String> bannedWords = Arrays.asList("cunt", "shit", "fuck", "shit", "cock", "whore", "nigger", "bitch", "rape", "ni66er");

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage().toLowerCase();
        for (String word : bannedWords) {
            if (message.contains(word)) {
                message = message.replaceAll(word, "***");
            }
        }
        event.setMessage(message);
    }

    @EventHandler
    public void collision(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getTeam("NoCollisionTeam");

        team.addEntry(player.getName());
    }


    @EventHandler
    public void zipline(PlayerInteractAtEntityEvent e){

    }
}