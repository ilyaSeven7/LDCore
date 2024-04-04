package me.litedeforged.ldcore.deathMessage.listeners;

import me.litedeforged.ldcore.LDCore;
import me.litedeforged.ldcore.deathMessage.fileManager.ConfigManager;
import me.litedeforged.ldcore.practicepvp.StrikePracticeMethods;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.time.LocalTime;
public class PlayerDeath implements Listener {

    StrikePracticeMethods spMethods = new StrikePracticeMethods();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        Player player = event.getPlayer();

        if (spMethods.getFight(player) == null) return;


        if (spMethods.getFight(player).getArena().getName().equalsIgnoreCase("crystalffa")) {
            LDCore.uuids.remove(player.getUniqueId());
            spMethods.saveDeathLocation(player);
        }

//      #When A Player Die Send Dead Location For Them.
        if (LDCore.getInstance().getConfig().getConfigurationSection("DeathMessage").getBoolean("toggle")) {
            player.sendMessage(coordcolored(player));
        }

//      #When A Player Die Log Their Location, World, Date In TxT File.
        if (LDCore.getInstance().getConfig().getConfigurationSection("PlayerDeathLogger").getBoolean("toggle")) {

            ConfigManager.writer("[" +LocalTime.now().withNano(0) + "]" +
                    " (" + player.getName() + " Has Slayed by " + killer(player) + ")" + " (DeathReason » " + cause(player) + ")" +
                    " (WorldName » " + player.getLocation().getWorld().getName() + ")" +
                    " (CordLocation » " + coord(player) + ")"); // end of line

        }

    }

    public String coord(Player player) {

        String getX = String.valueOf(player.getLocation().getBlockX());
        String getY = String.valueOf(player.getLocation().getBlockY());
        String getZ = String.valueOf(player.getLocation().getBlockZ());


        return getX + "-X " + getY + "-Y " + getZ + "-Z";
    }
    public Component coordcolored(Player player) {

        String getworld = player.getWorld().getName();
        String getX = String.valueOf(player.getLocation().getBlockX());
        String getY = String.valueOf(player.getLocation().getBlockY());
        String getZ = String.valueOf(player.getLocation().getBlockZ());

        return MiniMessage.miniMessage().deserialize("<aqua>You Died In<dark_gray>: " + "<light_purple>" + getworld + " <white>" + getX + "<dark_gray>-<white>X" + " <white>" + getY  + "<dark_gray>-<white>Y" + " <white>" + getZ  + "<dark_gray>-<white>Z");
    }

    public String cause(Player player) {
        if (player.getLastDamageCause() == null) {
            return "Unknown Cause";
        }
        return player.getLastDamageCause().getCause().name();
    }

    public String killer(Player player) {
        if (player.getKiller() == null) {
            return "Unknown Killer";
        }
        return player.getKiller().getName();
    }


}
