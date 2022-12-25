package me.ethan.farmvill.Commands;

import me.ethan.farmvill.Configuration.PlayerConfig;
import me.ethan.farmvill.FarmVill;
import me.ethan.farmvill.functions;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.*;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class essentials implements CommandExecutor, TabCompleter {

    PlayerConfig userConfig = new PlayerConfig();
    FarmVill plugin;

    public essentials(FarmVill plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            String cmd = args[0];
            if (player.isOp()) {
                switch (cmd.toLowerCase()) {
                    case "v":
                    case "vanish":
                        if (player.isOp()) {
                            if (!userConfig.getVanish(player)) {
                                for (Player people : Bukkit.getOnlinePlayers()) {
                                    people.hidePlayer(plugin, player);
                                }
                                userConfig.setVanish(player, true);
                                player.sendMessage("Vanish Enabled");
                            } else {
                                for (Player people : Bukkit.getOnlinePlayers()) {
                                    people.showPlayer(plugin, player);
                                }
                                userConfig.setVanish(player, false);
                                player.sendMessage("Vanish Disabled");
                            }
                        }
                        break;

                    case "worldtp":
                        if (player.isOp()) {
                            functions.WorldTp(player, args[1]);
                        }
                        break;

                    case "placecrops":
                        if (player.isOp()) {
                            if (args.length == 3) {
                                Location playerLocation = player.getLocation();
                                World world = playerLocation.getWorld();
                                int radius = Integer.parseInt(args[1]);
                                for (int x = -radius; x <= radius; x++) {
                                    for (int z = -radius; z <= radius; z++) {
                                        int blockX = playerLocation.getBlockX() + x;
                                        int blockZ = playerLocation.getBlockZ() + z;
                                        Location blockLocation = new Location(world, blockX, 0, blockZ);
                                        int topBlockY = world.getHighestBlockYAt(blockLocation);
                                        Location topBlockLocation = new Location(world, blockX, topBlockY + 1, blockZ);
                                        Block topBlock = topBlockLocation.getBlock();

                                        if (Bukkit.getWorld(topBlock.getWorld().getName()).getBlockAt(topBlockLocation.subtract(0, 1, 0)).getType() == Material.FARMLAND) {
                                            topBlock.setType(Material.valueOf(args[2].toUpperCase()));
                                        }
                                    }
                                }

                            } else {
                                player.sendMessage("/e radius, material");
                            }
                        }
                        break;

                    case "setspawn":
                        if (player.isOp()) {
                            plugin.getConfig().set("Spawn", player.getLocation());
                            plugin.saveConfig();
                        }
                        break;

                    case "setvoidtp":
                        if (player.isOp()) {
                            if (args.length == 2) {
                                plugin.getConfig().set("VoidTp", Integer.parseInt(args[1]));
                                plugin.saveConfig();
                            } else {
                                player.sendMessage("/e voidtp int");
                            }
                        }
                        break;

                    case "setcash":
                        if (player.isOp()) {
                            if (args.length == 3) {
                                userConfig.setCash(Bukkit.getPlayer(args[1]), Double.parseDouble(args[2]));
                            } else if (args.length <= 2) {
                                player.sendMessage("/e SetCash Player, Amount");
                            }
                        }
                        break;

                    case "set2xsell":
                        if (player.isOp()) {
                            if (args.length == 3) {
                                userConfig.set2XSell(Bukkit.getPlayer(args[1]), Boolean.parseBoolean(args[2]));
                            } else if (args.length <= 2) {
                                player.sendMessage("/e Set2XSell Player, Amount");
                            }
                        }
                        break;

                    case "hologram":
                        if(args.length >= 2){
                            String holo = args[1].replaceAll("&", "§");
                            ArmorStand armorStand = (ArmorStand) Bukkit.getWorld(player.getWorld().getName()).spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
                            armorStand.setInvisible(true);
                            armorStand.setCustomNameVisible(true);
                            armorStand.setGravity(false);
                            armorStand.setAI(false);
                            for (int arg = 2; arg < args.length; arg++) {
                                holo = holo + " " + args[arg].replaceAll("&", "§");
                                armorStand.setCustomName(holo);
                            }
                        }
                        break;


                    case "disable":
                        if (args.length == 2 && plugin != null) {
                            String pluginName = args[1];
                            Plugin plugin = Bukkit.getPluginManager().getPlugin(pluginName);
                            if (plugin == null) {
                                sender.sendMessage("Plugin not found: " + pluginName);
                            }

                            Bukkit.getPluginManager().disablePlugin(plugin);
                            sender.sendMessage("Plugin disabled: " + pluginName);
                        } else {
                            sender.sendMessage("Usage: /disable <plugin>");
                        }
                        break;
                }
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.isOp()) {
            if (args.length == 1) {
                List<String> cmd = new ArrayList<>();
                cmd.add("Vanish");
                cmd.add("WorldTp");
                cmd.add("SetSpawn");
                cmd.add("SetCash");
                cmd.add("SetVoidTp");
                cmd.add("PlaceCrops");
                cmd.add("Set2XSell");
                cmd.add("Hologram");
                cmd.add("Disable");
                return cmd;
            }
        }

        return null;
    }
}