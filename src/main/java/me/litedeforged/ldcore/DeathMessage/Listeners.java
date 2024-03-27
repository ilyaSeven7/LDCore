package me.litedeforged.ldcore.DeathMessage;

import me.litedeforged.ldcore.message.Components;
import net.kyori.adventure.text.Component;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Listeners implements Listener {
    Components getter = new Components();
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        String getWorld = player.getWorld().getName();
        String getX = String.valueOf(player.getPlayer().getLastDeathLocation().getBlockX());
        String getY = String.valueOf(player.getPlayer().getLastDeathLocation().getBlockY());
        String getZ = String.valueOf(player.getPlayer().getLastDeathLocation().getBlockZ());
        player.sendMessage(getter.components( "<aqua>You Die In = " + "<white>" + getWorld + " <white>" + getX + " <white>" + getY + " <white>" + getZ));
    }
}
