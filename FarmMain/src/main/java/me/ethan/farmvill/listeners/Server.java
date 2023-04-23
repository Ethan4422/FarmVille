package me.ethan.farmvill.listeners;

import me.ethan.farmvill.FarmVill;
import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityUnleashEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;


public class Server implements Listener {

    FarmVill plugin;

    public Server(FarmVill plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.teleport(plugin.getConfig().getLocation("Spawn"));
    }

    @EventHandler
    public void join(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if (player.getLocation().getBlockY() <= plugin.getConfig().getInt("VoidTp")) {
            player.teleport(plugin.getConfig().getLocation("Spawn"));
        }
    }

    @EventHandler
    public void anvilInteract(PlayerInteractEvent e){
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(e.getClickedBlock() != null && e.getClickedBlock().getType() == Material.ANVIL){
                if(!e.getPlayer().isOp()) {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void leaves(LeavesDecayEvent e){
        e.setCancelled(true);
    }
}
