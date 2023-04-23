package me.ethan.farmvill.Commands.ShopStuff;

import me.ethan.farmvill.Commands.ShopStuff.ShopUtils;
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
    ShopUtils shopUtils;
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
                                ItemMeta backMeta = backButton.getItemMeta();
                                backMeta.setDisplayName("§f§lBack");
                                backButton.setItemMeta(backMeta);

                                ItemStack Hoe1 = new ItemStack(Material.WOODEN_HOE);
                                ItemMeta Hoe1Meta = Hoe1.getItemMeta();
                                Hoe1Meta.setDisplayName("§f§lHoe1 350$");
                                Hoe1Meta.setLore(Collections.singletonList("2x Crops!"));
                                Hoe1.setItemMeta(Hoe1Meta);

                                ItemStack Hoe2 = new ItemStack(Material.WOODEN_HOE);
                                ItemMeta Hoe2Meta = Hoe2.getItemMeta();
                                Hoe2Meta.setDisplayName("§f§lHoe2 1000$");
                                Hoe2Meta.setLore(Collections.singletonList("3x Crops!"));
                                Hoe2.setItemMeta(Hoe2Meta);

                                ItemStack Hoe3 = new ItemStack(Material.WOODEN_HOE);
                                ItemMeta Hoe3Meta = Hoe3.getItemMeta();
                                Hoe3Meta.setDisplayName("§f§lHoe3 2250$");
                                Hoe3Meta.setLore(Collections.singletonList("4x Crops!"));
                                Hoe3.setItemMeta(Hoe3Meta);

                                ItemStack Hoe4 = new ItemStack(Material.WOODEN_HOE);
                                ItemMeta Hoe4Meta = Hoe4.getItemMeta();
                                Hoe4Meta.setDisplayName("§f§lHoe4 4000$");
                                Hoe4Meta.setLore(Collections.singletonList("5x Crops!"));
                                Hoe4.setItemMeta(Hoe4Meta);

                                toolInventory.setItem(26, backButton);
                                toolInventory.setItem(0, Hoe1);
                                toolInventory.setItem(1, Hoe2);
                                toolInventory.setItem(2, Hoe3);
                                toolInventory.setItem(3, Hoe4);

                                player.openInventory(toolInventory);


                                break;

                            case BUNDLE:
                                player.closeInventory();
                                Inventory SackInventory = Bukkit.createInventory(null, 36, "§fSacks!");

                                backButton = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                                backMeta = backButton.getItemMeta();
                                backMeta.setDisplayName("§f§lBack");
                                backButton.setItemMeta(backMeta);

                                ItemStack Sack1 = new ItemStack(Material.BUNDLE);
                                ItemMeta Sack1Meta = Sack1.getItemMeta();
                                Sack1Meta.setDisplayName("§fSack1 §a100$");
                                Sack1Meta.setLore(Collections.singletonList("Upgrade sack size to 50"));
                                Sack1.setItemMeta(Sack1Meta);

                                ItemStack Sack2 = new ItemStack(Material.BUNDLE);
                                ItemMeta Sack2Meta = Sack2.getItemMeta();
                                Sack2Meta.setDisplayName("§fSack2 §a200$");
                                Sack2Meta.setLore(Collections.singletonList("Upgrade sack size to 100"));
                                Sack2.setItemMeta(Sack2Meta);

                                ItemStack Sack3 = new ItemStack(Material.BUNDLE);
                                ItemMeta Sack3Meta = Sack3.getItemMeta();
                                Sack3Meta.setDisplayName("§fSack3 §a400$");
                                Sack3Meta.setLore(Collections.singletonList("Upgrade sack size to 250"));
                                Sack3.setItemMeta(Sack3Meta);

                                ItemStack Sack4 = new ItemStack(Material.BUNDLE);
                                ItemMeta Sack4Meta = Sack4.getItemMeta();
                                Sack4Meta.setDisplayName("§fSack4 §a1000$");
                                Sack4Meta.setLore(Collections.singletonList("Upgrade sack size to 500"));
                                Sack4.setItemMeta(Sack4Meta);

                                ItemStack Sack5 = new ItemStack(Material.BUNDLE);
                                ItemMeta Sack5Meta = Sack5.getItemMeta();
                                Sack5Meta.setDisplayName("§fSack5 §a2000$");
                                Sack5Meta.setLore(Collections.singletonList("Upgrade sack size to 1000"));
                                Sack5.setItemMeta(Sack5Meta);

                                ItemStack Sack6 = new ItemStack(Material.BUNDLE);
                                ItemMeta Sack6Meta = Sack6.getItemMeta();
                                Sack6Meta.setDisplayName("§fSack6 §a3500$");
                                Sack6Meta.setLore(Collections.singletonList("Upgrade sack size to 2500"));
                                Sack6.setItemMeta(Sack6Meta);

                                ItemStack Sack7 = new ItemStack(Material.BUNDLE);
                                ItemMeta Sack7Meta = Sack7.getItemMeta();
                                Sack7Meta.setDisplayName("§fSack7 §a10000$");
                                Sack7Meta.setLore(Collections.singletonList("Upgrade sack size to 5000"));
                                Sack7.setItemMeta(Sack7Meta);

                                ItemStack Sack8 = new ItemStack(Material.BUNDLE);
                                ItemMeta Sack8Meta = Sack8.getItemMeta();
                                Sack8Meta.setDisplayName("§fSack8 §a25000$");
                                Sack8Meta.setLore(Collections.singletonList("Upgrade sack size to 10000"));
                                Sack8.setItemMeta(Sack8Meta);




                                SackInventory.setItem(35, backButton);
                                SackInventory.setItem(0, Sack1);
                                SackInventory.setItem(1, Sack2);
                                SackInventory.setItem(2, Sack3);
                                SackInventory.setItem(3, Sack4);
                                SackInventory.setItem(4, Sack5);
                                SackInventory.setItem(5, Sack6);
                                SackInventory.setItem(6, Sack7);
                                SackInventory.setItem(7, Sack8);

                                player.openInventory(SackInventory);
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
                                Food1Meta.setDisplayName("§f§l16x Bread 75$");
                                Food1.setItemMeta(Food1Meta);

                                ItemStack Food2 = new ItemStack(Material.GOLDEN_CARROT);
                                ItemMeta Food2Meta = Food2.getItemMeta();
                                Food2Meta.setDisplayName("§f§l16x Golden_Carrot 1000$");
                                Food2.setItemMeta(Food2Meta);

                                FoodInventory.setItem(8, backButton);
                                FoodInventory.setItem(0, Food1);
                                FoodInventory.setItem(1, Food2);


                                player.openInventory(FoodInventory);
                                break;

                            case DIAMOND_SWORD:
                                player.closeInventory();
                                Inventory PvpInventory = Bukkit.createInventory(null, 9, "§fPvp!");

                                backButton = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                                backMeta = backButton.getItemMeta();
                                backMeta.setDisplayName("§f§lBack");
                                backButton.setItemMeta(backMeta);

                                PvpInventory.setItem(8, backButton);

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

        ItemStack Hoe3 = new ItemStack(Material.WOODEN_HOE);
        ItemMeta Hoe3Meta = Hoe3.getItemMeta();
        Hoe3Meta.setDisplayName("§f§lHoe3");
        Hoe3Meta.setUnbreakable(true);
        Hoe3.setItemMeta(Hoe3Meta);

        ItemStack Hoe4 = new ItemStack(Material.WOODEN_HOE);
        ItemMeta Hoe4Meta = Hoe4.getItemMeta();
        Hoe4Meta.setDisplayName("§f§lHoe4");
        Hoe4Meta.setUnbreakable(true);
        Hoe4.setItemMeta(Hoe4Meta);

        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (event.getClickedInventory() != null) {
                if (event.getView().getTitle().equals("§fFarming tools!")) {
                    event.setCancelled(true);
                    ItemStack ClickedItem = event.getCurrentItem();
                    if (ClickedItem != null) {
                        switch (ClickedItem.getItemMeta().getDisplayName()) {
                            case "§f§lHoe1 350$":
                                if (userConfig.getCash(player) >= 350) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 350);
                                    player.getInventory().addItem(Hoe1);
                                }
                                break;
                            case "§f§lHoe2 1000$":
                                if (userConfig.getCash(player) >= 1000) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 1000);
                                    player.getInventory().addItem(Hoe2);
                                }
                                break;

                            case "§f§lHoe3 2250$":
                                if (userConfig.getCash(player) >= 2250) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 2250);
                                    player.getInventory().addItem(Hoe3);
                                }
                                break;
                            case "§f§lHoe4 4000$":
                                if (userConfig.getCash(player) >= 4000) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 4000);
                                    player.getInventory().addItem(Hoe4);
                                }
                                break;

                            case "§f§lBack":
                                player.closeInventory();
                                shopUtils.openShopMain(player);
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
                            case "§f§l16x Bread 75$":
                                if (userConfig.getCash(player) >= 75) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 75);
                                    player.getInventory().addItem(Food1);
                                }
                            case "§f§l16x Golden_Carrot 1000$":
                                if (userConfig.getCash(player) >= 1000) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 1000);
                                    player.getInventory().addItem(Food2);
                                }
                                break;
                            case "§f§lBack":
                                player.closeInventory();
                                shopUtils.openShopMain(player);
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
                            shopUtils.openShopMain(player);
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
                            shopUtils.openShopMain(player);
                            break;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onSackShopClickEven(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getClickedInventory() != null) {
            if (e.getView().getTitle().equals("§fSacks!")) {
                e.setCancelled(true);
                ItemStack ClickedItem = e.getCurrentItem();
                if (ClickedItem != null) {
                    switch (ClickedItem.getItemMeta().getDisplayName()) {

                        case "§fSack1 §a100$":
                            if (userConfig.getCash(player) >= 100) {
                                if (userConfig.getSackSize(player) < 50) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 100);
                                    userConfig.setSackSize(player, 50);
                                }
                            }
                            break;

                        case "§fSack2 §a200$":
                            if (userConfig.getCash(player) >= 200) {
                                if (userConfig.getSackSize(player) < 100) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 200);
                                    userConfig.setSackSize(player, 100);
                                }
                            }
                            break;

                        case "§fSack3 §a400$":
                            if (userConfig.getCash(player) >= 400) {
                                if (userConfig.getSackSize(player) < 250) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 400);
                                    userConfig.setSackSize(player, 250);
                                }
                            }
                            break;

                        case "§fSack4 §a1000$":
                            if (userConfig.getCash(player) >= 1000) {
                                if (userConfig.getSackSize(player) < 500) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 1000);
                                    userConfig.setSackSize(player, 500);
                                }
                            }
                            break;

                        case "§fSack5 §a2000$":
                            if (userConfig.getCash(player) >= 2000) {
                                if (userConfig.getSackSize(player) < 1000) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 2000);
                                    userConfig.setSackSize(player, 1000);
                                }
                            }
                            break;

                        case "§fSack6 §a3500$":
                            if (userConfig.getCash(player) >= 3500) {
                                if (userConfig.getSackSize(player) < 2500) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 3500);
                                    userConfig.setSackSize(player, 2500);
                                }
                            }
                            break;

                        case "§fSack7 §a10000$":
                            if (userConfig.getCash(player) >= 10000) {
                                if (userConfig.getSackSize(player) < 5000) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 10000);
                                    userConfig.setSackSize(player, 5000);
                                }
                            }
                            break;

                        case "§fSack8 §a25000$":
                            if (userConfig.getCash(player) >= 25000) {
                                if (userConfig.getSackSize(player) < 10000) {
                                    userConfig.setCash(player, userConfig.getCash(player) - 25000);
                                    userConfig.setSackSize(player, 10000);
                                }
                            }
                            break;

                        case "§f§lBack":
                            player.closeInventory();
                            shopUtils.openShopMain(player);
                            break;
                    }
                }
            }
        }
    }
}
