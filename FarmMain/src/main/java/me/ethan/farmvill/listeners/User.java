package me.ethan.farmvill.listeners;

import me.ethan.farmvill.Configuration.PlayerConfig;
import me.ethan.farmvill.FarmVill;
import me.ethan.farmvill.functions;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.WeatherType;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

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
    public void ThrowEgg(ProjectileLaunchEvent e) {
        if (e.getEntity().getType() == EntityType.EGG) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
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
                                if (userConfig.getSackSpaceLeft(event.getPlayer()) + 2 <= userConfig.getSackSize(player)) {
                                    userConfig.setWheatAmount(event.getPlayer(), userConfig.getWheatAmount(event.getPlayer()) + 2);
                                } else {
                                    player.sendTitle("§4Warning!", "You have no more space inside your sack!", 1, 20, 1);
                                    return;
                                }
                                break;

                            case "§f§lHoe2":
                                if (userConfig.getSackSpaceLeft(event.getPlayer()) + 3 <= userConfig.getSackSize(player)) {
                                    userConfig.setWheatAmount(event.getPlayer(), userConfig.getWheatAmount(event.getPlayer()) + 3);
                                } else {
                                    player.sendTitle("§4Warning!", "You have no more space inside your sack!", 1, 20, 1);
                                    return;
                                }
                                break;

                            case "§f§lHoe3":
                                if (userConfig.getSackSpaceLeft(event.getPlayer()) + 4 <= userConfig.getSackSize(player)) {
                                    userConfig.setWheatAmount(event.getPlayer(), userConfig.getWheatAmount(event.getPlayer()) + 4);
                                } else {
                                    player.sendTitle("§4Warning!", "You have no more space inside your sack!", 1, 20, 1);
                                    return;
                                }
                                break;

                            case "§f§lHoe4":
                                if (userConfig.getSackSpaceLeft(event.getPlayer()) + 5 <= userConfig.getSackSize(player)) {
                                    userConfig.setWheatAmount(event.getPlayer(), userConfig.getWheatAmount(event.getPlayer()) + 5);
                                } else {
                                    player.sendTitle("§4Warning!", "You have no more space inside your sack!", 1, 20, 1);
                                    return;
                                }
                                break;

                            default:
                                if (userConfig.getSackSpaceLeft(event.getPlayer()) + 1 <= userConfig.getSackSize(player)) {
                                    userConfig.setWheatAmount(event.getPlayer(), userConfig.getWheatAmount(event.getPlayer()) + 1);
                                } else {
                                    player.sendTitle("§4Warning!", "You have no more space inside your sack!", 1, 20, 1);
                                    return;
                                }
                                break;
                        }
                    } else {
                        if (userConfig.getSackSpaceLeft(event.getPlayer()) + 1 <= userConfig.getSackSize(player)) {
                            userConfig.setWheatAmount(event.getPlayer(), userConfig.getWheatAmount(event.getPlayer()) + 1);
                        } else {
                            player.sendTitle("§4Warning!", "You have no more space inside your sack!", 1, 20, 1);
                            return;
                        }
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
    public void pickupEgg(PlayerAttemptPickupItemEvent e) {
        Player player = e.getPlayer();
        if (e.getItem().getItemStack().getType().equals(Material.EGG)) {
            if (userConfig.getSackSpaceLeft(player) + 1 <= userConfig.getSackSize(player)) {
                userConfig.setEggAmount(player, userConfig.getEggAmount(player) + 1);
                e.getItem().setItemStack(new ItemStack(Material.AIR));
            }
            e.setCancelled(true);
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
        } else {
            if (e.getPlayer().hasPlayedBefore()) {
                e.setJoinMessage("§fWelcome back " + e.getPlayer().getName() + "!");
            } else {
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
}