package me.ethan.farmvill.Commands.ShopStuff;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopUtils {

    public static void openShopMain(Player player){
        Inventory shop = Bukkit.createInventory(null, 27, "§aShop");

        ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.setDisplayName(" ");
        glass.setItemMeta(glassMeta);

        ItemStack FarmingTools = new ItemStack(Material.GOLDEN_HOE);
        ItemMeta FarmingToolsMeta = FarmingTools.getItemMeta();
        FarmingToolsMeta.setDisplayName("§f§lFarming Tools!");
        FarmingTools.setItemMeta(FarmingToolsMeta);

        ItemStack Sacks = new ItemStack(Material.BUNDLE);
        ItemMeta SacksMeta = Sacks.getItemMeta();
        SacksMeta.setDisplayName("§f§lSacks!");
        Sacks.setItemMeta(SacksMeta);

        ItemStack Food = new ItemStack(Material.BREAD);
        ItemMeta FoodMeta = Food.getItemMeta();
        FoodMeta.setDisplayName("§f§lFood!");
        Food.setItemMeta(FoodMeta);

        ItemStack Pvp = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta PvpMeta = Pvp.getItemMeta();
        PvpMeta.setDisplayName("§f§lPvp!");
        Pvp.setItemMeta(PvpMeta);

        for (int i = 0; i < shop.getSize(); i++) {
            shop.setItem(i, glass);
        }


        shop.setItem(10, new ItemStack(FarmingTools));
        shop.setItem(12, new ItemStack(Sacks));
        shop.setItem(14, new ItemStack(Food));
        shop.setItem(16, new ItemStack(Pvp));

        player.openInventory(shop);
    }
}
