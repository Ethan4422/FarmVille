package me.ethan.farmvill.Commands.ShopStuff;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class FCShopUtils {

    public static void openShopMain(Player player) {
        Inventory shop = Bukkit.createInventory(null, 27, "§aFcShop");

        ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.setDisplayName(" ");
        glass.setItemMeta(glassMeta);

        ItemStack X2Coin = new ItemStack(Material.DIAMOND, 2);
        ItemMeta X2CoinMeta = X2Coin.getItemMeta();
        X2CoinMeta.setDisplayName("§f2xSell 250FC");
        X2CoinMeta.setLore(Collections.singletonList("Sell Crops for 2x the value!"));
        X2Coin.setItemMeta(X2CoinMeta);

        ItemStack AutoSell = new ItemStack(Material.SHULKER_BOX);
        ItemMeta AutoSellMeta = AutoSell.getItemMeta();
        AutoSellMeta.setDisplayName("§fAutoSellSack 650FC");
        AutoSellMeta.setLore(Collections.singletonList("Max sack size autosells crops, type /setsellprompt false"));
        AutoSell.setItemMeta(AutoSellMeta);





        for (int i = 0; i < shop.getSize(); i++) {
            shop.setItem(i, glass);
        }

        shop.setItem(0, X2Coin);
        shop.setItem(1, AutoSell);

        player.openInventory(shop);
    }
}
