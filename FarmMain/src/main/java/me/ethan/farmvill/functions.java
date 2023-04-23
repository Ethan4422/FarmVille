package me.ethan.farmvill;

import me.ethan.farmvill.Configuration.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class functions {

    public static void VoidWorld(String WorldName) {
        WorldCreator wc = new WorldCreator(WorldName);
        wc.generator(new EmptyChunkGenerator());
        wc.createWorld();
    }

    public static void WorldTp(Player player, String WorldName) {
        player.teleport(Bukkit.getWorld(WorldName).getSpawnLocation());
    }

    public static void Sell(Player player){
        PlayerConfig userConfig = new PlayerConfig();
        double WheatPrice = 0.25;
        double CarrotPrice = 0.75;
        double EggPrice = 100;

        double wheatSell = userConfig.getWheatAmount(player) * WheatPrice;
        double carrotSell = userConfig.getCarrotAmount(player) * CarrotPrice;
        double eggSell = userConfig.getEggAmount(player) * EggPrice;

        if(userConfig.get2XSell(player)) {
            double SellPrice = wheatSell * 2 + carrotSell * 2 + eggSell * 2;
            userConfig.setCash(player, userConfig.getCash(player) + SellPrice);
            if(userConfig.getHideSell(player)) {
                player.sendMessage("you sold " + userConfig.getSackSpaceLeft(player) + " items in your sack for " + "§a" + SellPrice + "$");
            }
            userConfig.setWheatAmount(player, 0);
            userConfig.setCarrotAmount(player, 0);
            userConfig.setEggAmount(player, 0);
        }
        else {
            double SellPrice = wheatSell + carrotSell + eggSell;
            userConfig.setCash(player, userConfig.getCash(player) + SellPrice);
            if(userConfig.getHideSell(player)) {
                player.sendMessage("you sold " + userConfig.getSackSpaceLeft(player) + " items in your sack for " + "§a" + SellPrice + "$");
            }
            userConfig.setWheatAmount(player, 0);
            userConfig.setCarrotAmount(player, 0);
            userConfig.setEggAmount(player, 0);
        }
    }


    public static String getRank(Player player){
        PlayerConfig userConfig = new PlayerConfig();
        switch (userConfig.getRank(player)){
            case 100:
                return "§5§lOwner";

            case 90:
                return "§9§lDev";

            case 75:
                return "§4§lManager";

            case 60:
                return "§4§lAdmin";

            case 45:
                return "§a§lBuilder";

            case 40:
                return "§d§lMod";

            case 10:
                return "§a§lHelper";

            case 5:
                return "§f§lTester";

            case 0:
                return "§7Farmer";
        }
        return "§7Farmer";
    }

    public static void createArmorStand(Location loc, String name){
        ArmorStand armorStand = (ArmorStand) Bukkit.getWorld(loc.getWorld().getName()).spawnEntity(loc, EntityType.ARMOR_STAND);
        armorStand.setCustomName(name);
        armorStand.setCustomNameVisible(true);
        armorStand.setInvisible(true);
    }


    public static void ObtainPet(Player player, String name){

    }
}
