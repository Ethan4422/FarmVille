package me.ethan.farmvill.Commands.ShopStuff;

import me.ethan.farmvill.Configuration.PlayerConfig;
import me.ethan.farmvill.FarmVill;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;


public class ShopListener implements Listener {

    PlayerConfig userConfig = new PlayerConfig();
    FarmVill plugin;

    public ShopListener(FarmVill plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (event.getClickedInventory() != null) {
                if (event.getView().getTitle().equals("§aShop")) {
                    event.setCancelled(true);
                    ItemStack ClickedItem = event.getCurrentItem();
                    if (ClickedItem != null) {
                        switch (ClickedItem.getType()) {
                            case GOLDEN_HOE:
                                player.closeInventory();
                                Inventory toolInventory = Bukkit.createInventory(null, 27, "§fFarming tools!");

                                ItemStack backButton = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                                ItemMeta backMeta  = backButton.getItemMeta();
                                backMeta.setDisplayName("§f§lBack");
                                backButton.setItemMeta(backMeta);

                                ItemStack Hoe1 = new ItemStack(Material.WOODEN_HOE);
                                ItemMeta Hoe1Meta = Hoe1.getItemMeta();
                                Hoe1Meta.setDisplayName("§f§lHoe1 750$");
                                Hoe1Meta.setLore(Collections.singletonList("2x Crops!"));
                                Hoe1.setItemMeta(Hoe1Meta);

                                ItemStack Hoe2 = new ItemStack(Material.WOODEN_HOE);
                                ItemMeta Hoe2Meta = Hoe2.getItemMeta();
                                Hoe2Meta.setDisplayName("§f§lHoe2 1500$");
                                Hoe2Meta.setLore(Collections.singletonList("3x Crops!"));
                                Hoe2.setItemMeta(Hoe2Meta);

                                toolInventory.setItem(0, backButton);
                                toolInventory.setItem(1, Hoe1);
                                toolInventory.setItem(3, Hoe2);

                                player.openInventory(toolInventory);


                                break;

                            case MINECART:
                                player.closeInventory();
                                Inventory VehicleInventory = Bukkit.createInventory(null, 9, "§fFarming Vehicles!");

                                backButton = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                                backMeta = backButton.getItemMeta();
                                backMeta.setDisplayName("§f§lBack");
                                backButton.setItemMeta(backMeta);

                                 VehicleInventory.setItem(0, backButton);

                                player.openInventory(VehicleInventory);
                                break;


                            case BREAD:
                                player.closeInventory();
                                Inventory FoodInventory = Bukkit.createInventory(null, 9, "§fFood!");

                                backButton = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                                backMeta = backButton.getItemMeta();
                                backMeta.setDisplayName("§f§lBack");
                                backButton.setItemMeta(backMeta);

                                ItemStack Food1 = new ItemStack(Material.BREAD);
                                ItemMeta Food1Meta = Food1.getItemMeta();
                                Food1Meta.setDisplayName("§f§l16x Bread 250$");
                                Food1.setItemMeta(Food1Meta);

                                ItemStack Food2 = new ItemStack(Material.GOLDEN_CARROT);
                                ItemMeta Food2Meta = Food2.getItemMeta();
                                Food2Meta.setDisplayName("§f§l16x Golden_Carrot 5000$");
                                Food2.setItemMeta(Food2Meta);

                                FoodInventory.setItem(0, backButton);
                                FoodInventory.setItem(1, Food1);
                                FoodInventory.setItem(3, Food2);


                                player.openInventory(FoodInventory);
                                break;

                            case DIAMOND_SWORD:
                                player.closeInventory();
                                Inventory PvpInventory = Bukkit.createInventory(null, 9, "§fPvp!");

                                backButton = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                                backMeta = backButton.getItemMeta();
                                backMeta.setDisplayName("§f§lBack");
                                backButton.setItemMeta(backMeta);

                                PvpInventory.setItem(0, backButton);

                                player.openInventory(PvpInventory);

                                break;
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onToolShopClickEven(InventoryClickEvent event) {

        ItemStack Hoe1 = new ItemStack(Material.WOODEN_HOE);
        ItemMeta Hoe1Meta = Hoe1.getItemMeta();
        Hoe1Meta.setDisplayName("§f§lHoe1");
        Hoe1Meta.setUnbreakable(true);
        Hoe1.setItemMeta(Hoe1Meta);

        ItemStack Hoe2 = new ItemStack(Material.WOODEN_HOE);
        ItemMeta Hoe2Meta = Hoe2.getItemMeta();
        Hoe2Meta.setDisplayName("§f§lHoe2");
        Hoe2Meta.setUnbreakable(true);
        Hoe2.setItemMeta(Hoe2Meta);

        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (event.getClickedInventory() != null) {
                if (event.getView().getTitle().equals("§fFarming tools!")) {
                    event.setCancelled(true);
                    ItemStack ClickedItem = event.getCurrentItem();
                    if (ClickedItem != null) {
                        switch (ClickedItem.getItemMeta().getDisplayName()) {
                            case "§f§lHoe1 750$":
                                if (userConfig.getCash(player) >= 750) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 750);
                                    player.getInventory().addItem(Hoe1);
                                }
                            case "§f§lHoe2 1500$":
                                if (userConfig.getCash(player) >= 1500) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 1500);
                                    player.getInventory().addItem(Hoe2);
                                }
                                break;
                            case "§f§lBack":
                                player.closeInventory();
                                ShopUtils.openShopMain(player);
                                break;
                        }
                    }
                }
            }
        }
    }


    @EventHandler
    public void onFoodShopClickEven(InventoryClickEvent event) {

        ItemStack Food1 = new ItemStack(Material.BREAD, 16);
        ItemMeta Food1Meta = Food1.getItemMeta();
        Food1Meta.setDisplayName("§f§lBread");
        Food1.setItemMeta(Food1Meta);

        ItemStack Food2 = new ItemStack(Material.GOLDEN_CARROT, 16);
        ItemMeta Food2Meta = Food2.getItemMeta();
        Food2Meta.setDisplayName("§f§lGolden_Carrot");
        Food2.setItemMeta(Food2Meta);

        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (event.getClickedInventory() != null) {
                if (event.getView().getTitle().equals("§fFood!")) {
                    event.setCancelled(true);
                    ItemStack ClickedItem = event.getCurrentItem();
                    if (ClickedItem != null) {
                        switch (ClickedItem.getItemMeta().getDisplayName()) {
                            case "§f§l16x Bread 250$":
                                if (userConfig.getCash(player) >= 250) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 250);
                                    player.getInventory().addItem(Food1);
                                }
                            case "§f§l16x Golden_Carrot 5000$":
                                if (userConfig.getCash(player) >= 5000) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 5000);
                                    player.getInventory().addItem(Food2);
                                }
                                break;
                            case "§f§lBack":
                                player.closeInventory();
                                ShopUtils.openShopMain(player);
                                break;
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onVehicleShopClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory() != null) {
            if (event.getView().getTitle().equals("§fFarming Vehicles!")) {
                event.setCancelled(true);
                ItemStack ClickedItem = event.getCurrentItem();
                if (ClickedItem != null) {
                    switch (ClickedItem.getItemMeta().getDisplayName()) {
                        case "§f§lBack":
                            player.closeInventory();
                            ShopUtils.openShopMain(player);
                            break;

                    }
                }
            }
        }
    }

    @EventHandler
    public void onPvpShopClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory() != null) {
            if (event.getView().getTitle().equals("§fPvp!")) {
                event.setCancelled(true);
                ItemStack ClickedItem = event.getCurrentItem();
                if (ClickedItem != null) {
                    switch (ClickedItem.getItemMeta().getDisplayName()) {
                        case "§f§lBack":
                            player.closeInventory();
                            ShopUtils.openShopMain(player);
                            break;
                    }
                }
            }
        }
    }

}
