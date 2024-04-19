package me.litedeforged.ldcore.commands;

import me.litedeforged.ldcore.listeners.PlayerDeath;
import me.litedeforged.ldcore.message.Components;
import me.litedeforged.ldcore.practicepvp.StrikePracticeMethods;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;


public class FFALastDeathLocation implements CommandExecutor {

    Components mini = new Components();
    static StrikePracticeMethods spMethods = new StrikePracticeMethods();

    private static PlayerDeathEvent playerDeathEvent() {return PlayerDeath.getInstance();}

    final static HashMap<UUID, Location> deathLocationStore = new HashMap<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

            if (sender instanceof Player player) {
                if (args.length == 0) {
                    if (!spMethods.getFight(player).getArena().getName().equalsIgnoreCase("crystalffa")) {
                        player.sendMessage(mini.components("<red><bold>ʏᴏᴜ ᴄᴀɴ'ᴛ ᴜsᴇ ʙᴀᴄᴋ ғᴏʀ ɴᴏᴡ!"));
                        return true;
                    }
                    if (deathLocationStore.get(player.getUniqueId()) != null) {
                        player.sendMessage(mini.components("<light_purple>ʏᴏᴜ ᴛᴇʟᴇᴘᴏʀᴛᴇᴅ ʙᴀᴄᴋ!"));
                        player.teleport(deathLocationStore.get(player.getUniqueId()));
                        deathLocationStore.remove(player.getUniqueId());
                        return true;
                    }

                    player.sendMessage(mini.components("<red><bold>ʏᴏᴜ ᴄᴀɴ ᴜsᴇ ᴛʜɪs ᴄᴏᴍᴍᴀɴᴅ ᴏɴᴇ ᴛɪᴍᴇ ᴀғᴛᴇʀ ʏᴏᴜ ᴅɪᴇᴅ!"));
                    return true;
                }
            }
        return false;
    }

    public static void addPlayerToHashMp() {
        Player player = playerDeathEvent().getPlayer();
        if (spMethods.getFight(player) == null) return;
        if (player.getLastDamageCause().getCause().name().equalsIgnoreCase("SUFFOCATION")) {
            deathLocationStore.remove(playerDeathEvent().getPlayer().getUniqueId());
            return;
        }
        if (spMethods.getFight(player).getArena().getName().equalsIgnoreCase("crystalffa") && deathLocationStore.get(player.getUniqueId()) == null) {
            deathLocationStore.put(player.getUniqueId(), player.getLocation());
        }
    }

}
