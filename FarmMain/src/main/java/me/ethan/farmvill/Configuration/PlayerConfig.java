package me.ethan.farmvill.Configuration;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerConfig {
    public void playerConfig(Player player) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName()+ "-" + player.getUniqueId() + ".yml");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.addDefault("Name", player.getName());
        yml.addDefault("Cash", 0);
        yml.addDefault("Raining", false);
        yml.addDefault("Vanish", false);
        yml.addDefault("2XSell", false);
        yml.options().copyDefaults(true);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void savePlayerData(Player player){
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName()+ "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadPlayerData(Player player){
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName()+ "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
    }
    public double getCash(Player player){
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName()+ "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getDouble("Cash");
    }

    public void setCash(Player player,double cash) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("Cash", cash);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getRaining(Player player){
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName()+ "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getBoolean("Raining");
    }

    public void setRaining(Player player,Boolean raining) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("Raining", raining);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setVanish(Player player,Boolean Vanish) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("Vanish", Vanish);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean getVanish(Player player){
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName()+ "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getBoolean("Vanish");
    }


    public void set2XSell(Player player,Boolean Multi) {
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName() + "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.set("2XSell", Multi);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean get2XSell(Player player){
        File f = new File("plugins/FarmVille/PlayerData/" + player.getName()+ "-" + player.getUniqueId() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getBoolean("2XSell");
    }

}
