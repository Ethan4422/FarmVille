package me.ethan.farmvill;

import me.ethan.farmvill.Commands.*;
import me.ethan.farmvill.Commands.Players.*;
import me.ethan.farmvill.Commands.ShopStuff.FCShopListener;
import me.ethan.farmvill.Commands.ShopStuff.ShopListener;
import me.ethan.farmvill.Runnables.AutoSellSack;
import me.ethan.farmvill.Runnables.SellArea;
import me.ethan.farmvill.Runnables.SideScoreboard;
import me.ethan.farmvill.Runnables.Tablist;
import me.ethan.farmvill.listeners.Server;
import me.ethan.farmvill.listeners.User;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;

public final class FarmVill extends JavaPlugin {


    public static FarmVill plugin;
    String StatiswebhookURL = "https://discord.com/api/webhooks/1056270758692802610/SsXtPHzXQ6gIsjNqyOG9k0j8aufOWvxl5ZlvRIUcWJ2Wy7Ae5F96Ak4SMKg6z4s79Oii";

    @Override
    public void onEnable() {
        functions.VoidWorld("Worlds.Area1");

        getConfig().options().copyDefaults();
        saveDefaultConfig();


        Bukkit.getPluginCommand("e").setExecutor((CommandExecutor) new essentials(this));
        Bukkit.getPluginCommand("Sell").setExecutor((CommandExecutor) new Sell(this));
        Bukkit.getPluginCommand("Shop").setExecutor((CommandExecutor) new Shop(this));
        Bukkit.getPluginCommand("FCShop").setExecutor((CommandExecutor) new fcCommand(this));
        Bukkit.getPluginCommand("Bal").setExecutor((CommandExecutor) new Bal(this));
        Bukkit.getPluginCommand("Spawn").setExecutor((CommandExecutor) new SpawnTeleport(this));
        Bukkit.getPluginCommand("Weather").setExecutor((CommandExecutor) new ClientWeather(this));
        getCommand("Set2XSell").setExecutor(new set2xsell());
        getCommand("SetSellPrompt").setExecutor(new HideSellPrompt());
        getCommand("Discord").setExecutor(new Discord());
        getCommand("Gmc").setExecutor(new Gmc());
        getCommand("Gms").setExecutor(new Gms());
        getCommand("Gma").setExecutor(new Gma());
        getCommand("Gmsp").setExecutor(new Gmsp());
        getCommand("Activate").setExecutor(new PortalActivate());
        getCommand("SetAutoSellSack").setExecutor(new setAutoSellSack());
        getCommand("AddFarmCoins").setExecutor(new addFarmCoins());
        getCommand("Weather").setTabCompleter(new ClientWeather(this));
        getCommand("line").setExecutor(new Line(this));
        getCommand("e").setTabCompleter(new essentials(this));
        getServer().getPluginManager().registerEvents((Listener) new ShopListener(this), this);
        getServer().getPluginManager().registerEvents((Listener) new FCShopListener(this), this);
        getServer().getPluginManager().registerEvents((Listener) new Server(this), this);
        getServer().getPluginManager().registerEvents((Listener) new User(this), this);
        BukkitTask scoreboard = new SideScoreboard(this).runTaskTimer(this, 0, 20 * 3);
        BukkitTask Sell = new SellArea(this).runTaskTimer(this, 0, 10);
        BukkitTask tablist = new Tablist(this).runTaskTimer(this, 0, 20 * 2);
        BukkitTask autoSell = new AutoSellSack(this).runTaskTimer(this, 0, 10);

    }

    @Override
    public void onDisable() {

    }

    public static FarmVill getPlugin() {
        return plugin;
    }
}
