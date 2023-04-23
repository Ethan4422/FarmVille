package me.ethan.farmvill.Commands;

import me.ethan.farmvill.Configuration.PlayerConfig;
import me.ethan.farmvill.FarmVill;
import me.ethan.farmvill.functions;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
                        if (userConfig.getRank((Player) sender) >= 40) {

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
                        if (userConfig.getRank((Player) sender) >= 45) {
                            if(Bukkit.getWorld(args[1]) == null) {
                                player.sendMessage("§l"  + args[1] + "§c is not a valid world.");
                            }
                            else{
                                functions.WorldTp(player, args[1]);
                            }
                        }
                        break;

                    case "setrank":
                        if (userConfig.getRank((Player) sender) >= 75) {
                            switch (args[2].toLowerCase()) {
                                case "owner":
                                    userConfig.setRank(Bukkit.getPlayer(args[1]), 100);
                                    break;
                                case "dev":
                                    userConfig.setRank(Bukkit.getPlayer(args[1]), 90);
                                    break;
                                case "admin":
                                    userConfig.setRank(Bukkit.getPlayer(args[1]), 60);
                                    break;
                                case "builder":
                                    userConfig.setRank(Bukkit.getPlayer(args[1]), 45);
                                    break;
                                case "mod":
                                    userConfig.setRank(Bukkit.getPlayer(args[1]), 40);
                                    break;
                                case "helper":
                                    userConfig.setRank(Bukkit.getPlayer(args[1]), 10);
                                    break;
                                case "tester":
                                    userConfig.setRank(Bukkit.getPlayer(args[1]), 5);
                                    break;
                                case "farmer":
                                    userConfig.setRank(Bukkit.getPlayer(args[1]), 0);
                                    break;
                            }
                        }
                        break;

                    case "placecrops":
                        if (args.length == 3) {
                            if (userConfig.getRank((Player) sender) >= 45) {
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
                            }
                        } else {
                            player.sendMessage("/e radius, material");
                        }
                        break;

                    case "setspawn":
                        if (userConfig.getRank((Player) sender) >= 75) {

                            plugin.getConfig().set("Spawn", player.getLocation());
                            plugin.saveConfig();
                        }
                        break;

                    case "setvoidtp":
                        if (userConfig.getRank((Player) sender) >= 75) {
                            if (args.length == 2) {
                                plugin.getConfig().set("VoidTp", Integer.parseInt(args[1]));
                                plugin.saveConfig();
                            } else {
                                player.sendMessage("/e voidtp int");

                            }
                        }
                        break;

                    case "setcash":
                        if (userConfig.getRank((Player) sender) >= 75) {
                            if (args.length == 3) {
                                userConfig.setCash(Bukkit.getPlayer(args[1]), Double.parseDouble(args[2]));
                            } else if (args.length <= 2) {
                                player.sendMessage("/e SetCash Player, Amount");
                            }
                        }
                        break;

                    case "set2xsell":
                        if (userConfig.getRank((Player) sender) >= 40) {
                            if (args.length == 3) {
                                userConfig.set2XSell(Bukkit.getOfflinePlayer(args[0]), Boolean.parseBoolean(args[2]));
                            } else if (args.length <= 2) {
                                player.sendMessage("/e Set2XSell Player, Amount");
                            }
                        }
                        break;

                    case "hologram":
                        if (args.length >= 2) {
                            if(userConfig.getRank((Player) sender) >= 45) {
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
                        }
                        break;


                    case "disable":
                        if (args.length == 2 && plugin != null) {
                            if (userConfig.getRank((Player) sender) >= 75) {
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
                        }
                        break;

                    case "invsee":
                        if (args.length == 2 && Bukkit.getPlayer(args[1]) != null) {
                            if (userConfig.getRank((Player) sender) >= 40) {
                                player.openInventory(Objects.requireNonNull(Bukkit.getPlayer(args[1])).getInventory());
                            } else {
                                player.sendMessage("/invsee playerName");
                            }
                        }
                        break;

                    case "echest":
                        if (userConfig.getRank((Player) sender) >= 40) {

                            if (args.length == 2 && Bukkit.getPlayer(args[1]) != null) {
                                player.openInventory(Objects.requireNonNull(Bukkit.getPlayer(args[1])).getEnderChest());
                            } else {
                                player.sendMessage("/echest playerName");
                            }
                        }
                        break;

                    case "help":
                        if(userConfig.getRank(player) >= 40){
                            player.sendMessage("WIP aka im to lazy to do it rn");
                        }


                    case "reload":
                        if(userConfig.getRank(player) >= 75){
                            for(Player people : Bukkit.getOnlinePlayers()){
                                people.sendMessage("§fServer is reloading, Sending you to spawn sorry for the inconvenience!");
                                people.teleport(plugin.getConfig().getLocation("Spawn"));
                            }

                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    Bukkit.getServer().reload();

                                    for(Player people : Bukkit.getOnlinePlayers()){
                                        people.sendMessage("§lServer Reloaded!");
                                    }
                                }
                            }.runTaskLater(plugin, 40);
                        }
                        break;
                    default:
                        player.sendMessage("§cInvalid command");
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

                //mod
                if (userConfig.getRank((Player) sender) >= 40) {
                    cmd.add("Help");
                    cmd.add("Vanish");
                    cmd.add("InvSee");
                    cmd.add("EChest");
                }

                //builder
                if (userConfig.getRank((Player) sender) >= 45) {
                    cmd.add("WorldTp");
                    cmd.add("PlaceCrops");
                    cmd.add("Hologram");
                }

                //admin
                if (userConfig.getRank((Player) sender) >= 60) {

                }

                //manager
                if (userConfig.getRank((Player) sender) >= 75) {
                    cmd.add("Reload");
                    cmd.add("Area");
                    cmd.add("SetRank");
                    cmd.add("SetSpawn");
                    cmd.add("SetCash");
                    cmd.add("SetVoidTp");
                    cmd.add("Set2XSell");
                    cmd.add("Disable");
                }


                return cmd;

            }
            if(args.length == 2 && args[0].equalsIgnoreCase("area")){
                List<String> cmd2 = new ArrayList<>();
                cmd2.add("Sell");
                cmd2.add("Shop");

                return cmd2;
            }

            if(args.length == 2 && args[0].equalsIgnoreCase("worldtp")){
                List<String> cmd2 = new ArrayList<>();
                cmd2.add("world");
                cmd2.add("world_nether");
                cmd2.add("world_the_end");
                cmd2.add("Worlds.Area1");

                return cmd2;
            }

        }

        return null;
    }
}