package me.litedeforged.ldcore.deathMessage.Listeners;

import me.litedeforged.ldcore.deathMessage.FileManager.ConfigManager;
import me.litedeforged.ldcore.message.Components;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.time.LocalTime;

public class PlayerDeath implements Listener {

    Components getter = new Components();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {


        Player player = event.getPlayer();
//        String getWorld = player.getWorld().getName();
//        String getX = String.valueOf(player.getPlayer().getLastDeathLocation().getBlockX());
//        String getY = String.valueOf(player.getPlayer().getLastDeathLocation().getBlockY());
//        String getZ = String.valueOf(player.getPlayer().getLastDeathLocation().getBlockZ());
//        player.sendMessage(getter.components( "<aqua>You Die In = " + "<white>" + getWorld + " <white>" + getX + " <white>" + getY + " <white>" + getZ));

        ConfigManager.setup();

        if (player.getKiller() == null) {

            ConfigManager.writer("[" +LocalTime.now().withNano(0) + "] " +
                    player.getName() + "Died, Death Reason: " +  player.getLastDamageCause().getCause() +
                    ". World: " + player.getLocation().getWorld().getName() +
                    " , Location: " + coord(player)); // end of line

        } else {
            ConfigManager.writer("[" +LocalTime.now().withNano(0) + "] " +
                    player.getName() + " Has Slayed by : " + player.getKiller().getName() +
                    ". World: " + player.getLocation().getWorld().getName() +
                    " , Location: " + coord(player)); // end of line
        }


    }

    public String coord(Player player) {

        String getX = String.valueOf(player.getLocation().getBlockX());
        String getY = String.valueOf(player.getLocation().getBlockY());
        String getZ = String.valueOf(player.getLocation().getBlockZ());


        return "X: " + getX + ", Y: " + getY + ", Z:" + getZ;
    }


}
