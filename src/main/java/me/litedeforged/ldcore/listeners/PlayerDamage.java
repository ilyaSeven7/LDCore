package me.litedeforged.ldcore.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamage implements Listener {

    @EventHandler
    public void onPlayerDamaged(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player player && event.getCause().name().equalsIgnoreCase("SUFFOCATION")) {
            if (player.getLocation().getWorld().getBlockAt(player.getLocation()).getType() == Material.BARRIER) {
                event.setDamage(10);
            }
        }
    }
}
