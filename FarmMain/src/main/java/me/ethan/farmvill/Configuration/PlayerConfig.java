package me.ethan.farmvill.Configuration;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerConfig {
    public void playerConfig(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Integer Owner = 100;
        Integer Developer = 90;
        Integer Manager = 75;
        Integer Admin = 60;
        Integer Builder = 45;
        Integer Moderator = 40;
        Integer Helper = 10;
        Integer Tester = 5;
        Integer Farmer = 0;



        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.addDefault("Name", player.getName());
        yml.addDefault("Rank", Tester);
        yml.addDefault("Cash", 0);
        yml.addDefault("Raining", false);
        yml.addDefault("SackSize", 25);
        yml.addDefault("HideSell", false);
        //Sellable
        yml.addDefault("Wheat", 0);
        yml.addDefault("Carrot", 0);
        yml.addDefault("Egg", 0);



        yml.addDefault("FarmCoins", 0);
        yml.addDefault("Vanish", false);
        yml.addDefault("2XSell", false);
        yml.addDefault("InfiniteSackSize", false);
        yml.options().copyDefaults(true);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int getRank(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getInt("Rank");
    }

    public void setRank(Player player, double rank) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("Rank", rank);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getFarmCoins(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getDouble("FarmCoins");
    }

    public void setFarmCoins(Player player, double farmCoins) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("FarmCoins", farmCoins);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void savePlayerData(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadPlayerData(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
    }

    public double getCash(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getDouble("Cash");
    }

    public void setCash(Player player, double cash) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("Cash", cash);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getRaining(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getBoolean("Raining");
    }

    public void setRaining(Player player, Boolean raining) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("Raining", raining);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setVanish(Player player, Boolean Vanish) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("Vanish", Vanish);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getVanish(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getBoolean("Vanish");
    }


    public void set2XSell(OfflinePlayer player, Boolean Multi) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("2XSell", Multi);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean get2XSell(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getBoolean("2XSell");
    }
    public void setAutoSellSack(Player player, Boolean SackSize) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("AutoSellSack", SackSize);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getAutoSellSack(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getBoolean("AutoSellSack");
    }

    public void setSackSize(Player player, Integer Size) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("SackSize", Size);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getSackSpaceLeft(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return getWheatAmount(player) + getCarrotAmount(player) + getEggAmount(player) - getSackSize(player) * -1 - getSackSize(player);
    }

    public int getSackSize(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getInt("SackSize");
    }

    public void setWheatAmount(Player player, Integer Amount) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("Wheat", Amount);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getWheatAmount(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getInt("Wheat");
    }

    public void setCarrotAmount(Player player, Integer Amount) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("Carrot", Amount);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getCarrotAmount(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getInt("Carrot");
    }


    public void setEggAmount(Player player, Integer Amount) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("Egg", Amount);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getEggAmount(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getInt("Egg");
    }

    public void setHideSell(Player player, Boolean HideSell) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("HideSell", HideSell);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getHideSell(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getBoolean("HideSell");
    }
}