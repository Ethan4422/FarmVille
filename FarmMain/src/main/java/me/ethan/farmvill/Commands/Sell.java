package me.ethan.farmvill.Commands;

import me.ethan.farmvill.Configuration.PlayerConfig;
import me.ethan.farmvill.FarmVill;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Sell implements CommandExecutor {

    PlayerConfig userConfig = new PlayerConfig();

    FarmVill plugin;

    public Sell(FarmVill plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            double SellPrice = 0;
            double WheatPrice = 0.25;
            double CarrotPrice = 0.75;
            double EggPrice = 100;
            for (ItemStack item : player.getInventory().getContents()) {
                if (item != null) {
                    switch (item.getType()) {
                        case WHEAT:
                            player.getInventory().remove(item);
                            if(userConfig.get2XSell(player)) {
                                userConfig.setCash(player, userConfig.getCash(player) + item.getAmount() * WheatPrice * 2);
                                SellPrice+= item.getAmount() * WheatPrice * 2;
                            } else {
                                userConfig.setCash(player, userConfig.getCash(player) + item.getAmount() * WheatPrice);
                                SellPrice+= item.getAmount() * WheatPrice;
                            }
                            continue;

                        case CARROT:
                            player.getInventory().remove(item);
                            if(userConfig.get2XSell(player)) {
                                userConfig.setCash(player, userConfig.getCash(player) + item.getAmount() * CarrotPrice * 2);
                                SellPrice+= item.getAmount() * CarrotPrice * 2;
                            }
                            else {
                                userConfig.setCash(player, userConfig.getCash(player) + item.getAmount() * CarrotPrice);
                                SellPrice+= item.getAmount() * CarrotPrice;
                            }
                            break;


                        case EGG:
                            player.getInventory().remove(item);
                            if(userConfig.get2XSell(player)) {
                                userConfig.setCash(player, userConfig.getCash(player) + item.getAmount() * EggPrice * 2);
                                SellPrice+= item.getAmount() * EggPrice * 2;
                            }else {
                                userConfig.setCash(player, userConfig.getCash(player) + item.getAmount() * EggPrice);
                                SellPrice+= item.getAmount() * EggPrice;
                            }
                            break;

                    }
                }
            }
            player.sendMessage("You sold your inventory for " + "§a" + SellPrice + "$");
        }

        return false;
    }
}
