package me.ethan.farmvill.Commands.Players;

import me.ethan.farmvill.Commands.ShopStuff.ShopUtils;
import me.ethan.farmvill.FarmVill;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Shop implements CommandExecutor {

    FarmVill plugin;
    ShopUtils shopUtils;

    public Shop(FarmVill plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ShopUtils.openShopMain(player);

        }
        return false;
    }
}
