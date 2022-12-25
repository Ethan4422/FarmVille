package me.ethan.farmvill;

import me.ethan.farmvill.Commands.*;
import me.ethan.farmvill.Configuration.DiscordWebhook;
import me.ethan.farmvill.Runnables.playerparticles;
import me.ethan.farmvill.Commands.ShopStuff.ShopListener;
import me.ethan.farmvill.listeners.User;
import me.ethan.farmvill.listeners.Server;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.io.IOException;

public final class FarmVill extends JavaPlugin {

    public static FarmVill plugin;
    String StatiswebhookURL = "https://discord.com/api/webhooks/1056270758692802610/SsXtPHzXQ6gIsjNqyOG9k0j8aufOWvxl5ZlvRIUcWJ2Wy7Ae5F96Ak4SMKg6z4s79Oii";
    @Override
    public void onEnable() {

        DiscordWebhook discordWebhook = new DiscordWebhook(StatiswebhookURL);
        discordWebhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setImage("https://cdn.discordapp.com/attachments/1024478965643100161/1054185851288039545/image.png")
                .setTitle("Server is Starting!"));
        try {
            discordWebhook.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        functions.VoidWorld("Worlds.Area1");


        getConfig().options().copyDefaults();
        saveDefaultConfig();


        Bukkit.getPluginCommand("e").setExecutor((CommandExecutor) new essentials(this));
        Bukkit.getPluginCommand("Sell").setExecutor((CommandExecutor) new Sell(this));
        Bukkit.getPluginCommand("Shop").setExecutor((CommandExecutor) new Shop(this));
        Bukkit.getPluginCommand("Bal").setExecutor((CommandExecutor) new Bal(this));
        Bukkit.getPluginCommand("Spawn").setExecutor((CommandExecutor) new SpawnTeleport(this));
        Bukkit.getPluginCommand("Weather").setExecutor((CommandExecutor) new ClientWeather(this));
        getCommand("Set2XSell").setExecutor(new set2xsell());
        getCommand("Gmc").setExecutor(new Gmc());
        getCommand("Gms").setExecutor(new Gms());
        getCommand("Gma").setExecutor(new Gma());
        getCommand("Gmsp").setExecutor(new Gmsp());
        getCommand("Activate").setExecutor(new PortalActivate());
        getCommand("Set2XSell").setExecutor(new set2xsell());
        getCommand("Weather").setTabCompleter(new ClientWeather(this));
        getCommand("e").setTabCompleter(new essentials(this));
        getServer().getPluginManager().registerEvents((Listener) new ShopListener(this),this);
        getServer().getPluginManager().registerEvents((Listener) new Server(this),this);
        getServer().getPluginManager().registerEvents((Listener) new User(this),this);
        BukkitTask runnable = new playerparticles(this).runTaskTimerAsynchronously(this, 0, 10);


    }

    @Override
    public void onDisable() {
        DiscordWebhook discordWebhook = new DiscordWebhook(StatiswebhookURL);
        discordWebhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setImage("https://cdn.discordapp.com/attachments/1024478965643100161/1054185851288039545/image.png")
                .setTitle("Farmer Bill")
                .setDescription("Server is Closed!"));
        try {
            discordWebhook.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Plugin shutdown logic
    }
    public static FarmVill getPlugin(){
        return plugin;
    }
}
