package me.ethan.farmvill;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;

public class functions {


    public static void VoidWorld(String WorldName) {
        WorldCreator wc = new WorldCreator(WorldName);
        wc.generator(new EmptyChunkGenerator());
        wc.createWorld();
    }

    public static void WorldTp(Player player, String WorldName) {
        player.teleport(Bukkit.getWorld(WorldName).getSpawnLocation());
    }
}
