package me.litedeforged.ldcore.DeathMessage.Listeners;

import me.litedeforged.ldcore.message.Components;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    Components getter = new Components();
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        Player player = event.getPlayer();
        String getWorld = player.getWorld().getName();
        String getX = String.valueOf(player.getPlayer().getLastDeathLocation().getBlockX());
        String getY = String.valueOf(player.getPlayer().getLastDeathLocation().getBlockY());
        String getZ = String.valueOf(player.getPlayer().getLastDeathLocation().getBlockZ());
        player.sendMessage(getter.components( "<aqua>You Die In = " + "<white>" + getWorld + " <white>" + getX + " <white>" + getY + " <white>" + getZ));
        // test

    }
}
