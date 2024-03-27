package me.litedeforged.ldcore.deathMessage.listeners;

import me.litedeforged.ldcore.LDCore;
import me.litedeforged.ldcore.deathMessage.fileManager.ConfigManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.time.LocalTime;

public class PlayerDeath implements Listener {


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {


        Player player = event.getPlayer();

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


//      #When A Player Die Send Dead Location For Them.
        if (LDCore.getInstance().getConfig().getConfigurationSection("deathMessage").getBoolean("toggle")) {
            player.sendMessage(coordcolored(player));
        }

    }

    public String coord(Player player) {

        String getX = String.valueOf(player.getLocation().getBlockX());
        String getY = String.valueOf(player.getLocation().getBlockY());
        String getZ = String.valueOf(player.getLocation().getBlockZ());


        return "X: " + getX + " Y: " + getY + " Z: " + getZ;
    }
    public Component coordcolored(Player player) {

        String getX = String.valueOf(MiniMessage.miniMessage().deserialize("<aqua>" + player.getLocation().getBlockX() + "<white>-X"));
        String getY = String.valueOf(MiniMessage.miniMessage().deserialize(" <aqua>" + player.getLocation().getBlockY() + "<white>-Y"));
        String getZ = String.valueOf(MiniMessage.miniMessage().deserialize(" <aqua>" + player.getLocation().getBlockZ() + "<white>-Z"));

        return MiniMessage.miniMessage().deserialize(getX + getY + getZ);
    }


}
