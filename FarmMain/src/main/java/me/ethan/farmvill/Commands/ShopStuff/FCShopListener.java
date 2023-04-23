package me.ethan.farmvill.Commands.ShopStuff;

import me.ethan.farmvill.Configuration.PlayerConfig;
import me.ethan.farmvill.FarmVill;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class FCShopListener implements Listener {
    PlayerConfig userConfig = new PlayerConfig();

    FarmVill plugin;

    public FCShopListener(FarmVill plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onToolShopClickEven(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (event.getClickedInventory() != null) {
                if (event.getView().getTitle().equals("§aFcShop")) {
                    event.setCancelled(true);
                    ItemStack ClickedItem = event.getCurrentItem();
                    if (ClickedItem != null) {
                        switch (ClickedItem.getItemMeta().getDisplayName()) {
                            case "§f2xSell 250FC":
                                if (userConfig.getFarmCoins(player) >= 250) {
                                    if (!userConfig.get2XSell(player)) {
                                        userConfig.setFarmCoins(player, userConfig.getFarmCoins(player) - 250);
                                        userConfig.set2XSell(player, true);
                                        player.sendMessage("§aYou Bought 2xSell for 250 FarmCoins");
                                    } else {
                                        player.sendMessage("§4You already own 2xSell!");
                                    }
                                } else {
                                    player.sendMessage("§4You cannot afford 2xSell for 250 FarmCoins");
                                }
                                break;

                            case "§fAutoSellSack 650FC":
                                if (userConfig.getFarmCoins(player) >= 650) {
                                    if (!userConfig.getAutoSellSack(player)) {
                                        userConfig.setFarmCoins(player, userConfig.getFarmCoins(player) - 650);
                                        userConfig.setAutoSellSack(player, true);
                                        userConfig.setSackSize(player, Integer.MAX_VALUE);
                                        player.sendMessage("§aYou Bought AutoSellSack for 650 FarmCoins, Type /setsellprompt false");
                                    } else {
                                        player.sendMessage("§4You already own AutoSellSack!");
                                    }
                                } else {
                                    player.sendMessage("§4You cannot afford AutoSellSack for 650 FarmCoins");
                                }
                                break;
                        }
                    }
                }
            }
        }
    }
}
