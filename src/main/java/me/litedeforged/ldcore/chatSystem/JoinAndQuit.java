package me.litedeforged.ldcore.chatSystem;

import me.litedeforged.ldcore.LDCore;
import me.litedeforged.ldcore.listeners.PlayerJoin;
import me.litedeforged.ldcore.listeners.PlayerQuit;
import me.litedeforged.ldcore.message.Components;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JoinAndQuit {

    static Components mini = new Components();

    private static PlayerJoinEvent playerJoinEvent() {
        return PlayerJoin.getInstance();
    }

    private static PlayerQuitEvent playerQuitEvent() {
        return PlayerQuit.getInstance();
    }

    public static boolean groupCheck(Player player, String group) {
        return player.hasPermission("group." + group);
    }

    public static List<UUID> joinedList = new ArrayList<>();


    public static void onPlayerJoined() {
        Player player = playerJoinEvent().getPlayer();
        assert player == null;
        Server getServer = Bukkit.getServer();


        if (groupCheck(player, "default") && !groupCheck(player, "elf")) {
            playerJoinEvent().joinMessage(mini.components("<dark_gray>[<green>+<dark_gray>]<gray> " + player.getName() + " <dark_gray>[<green>+<dark_gray>]"));
            return;
        }


        if (groupCheck(player, "litedeforged")) {
            playerJoinEvent().joinMessage(mini.components("<white>" + player.getName() + " <light_purple><bold>ʜᴀs ʙᴇᴇɴ ᴊᴏɪɴᴇᴅ!"));
            getServer.sendActionBar(mini.components("<white>" + player.getName() + " <light_purple>ʜᴀs ʙᴇᴇɴ ᴊᴏɪɴᴇᴅ!"));
            if (!joinedList.contains(player.getUniqueId())) {
                joinedList.add(player.getUniqueId());
                Bukkit.getServer().getOnlinePlayers().forEach(playerList -> playerList.playSound(playerList.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1, 1));
                Bukkit.getScheduler().runTaskLater(LDCore.getInstance(), removePlayer -> {
                    joinedList.remove(player.getUniqueId());
                },(120 * 60) * 20);
                return;
            }
            return;
        }
        if (groupCheck(player, "demon")) {
            playerJoinEvent().joinMessage(mini.components("<white>" + player.getName() + " <red><bold>ʜᴀs ʙᴇᴇɴ ᴊᴏɪɴᴇᴅ!"));
            getServer.sendActionBar(mini.components("<white>" + player.getName() + " <red>ʜᴀs ʙᴇᴇɴ ᴊᴏɪɴᴇᴅ!"));
            if (!joinedList.contains(player.getUniqueId())) {
                joinedList.add(player.getUniqueId());
                Bukkit.getServer().getOnlinePlayers().forEach(playerList -> playerList.playSound(playerList.getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1, 1));
                Bukkit.getScheduler().runTaskLater(LDCore.getInstance(), removePlayer -> {
                    joinedList.remove(player.getUniqueId());
                },(120 * 60) * 20);
                return;
            }
            return;
        }
        if (groupCheck(player, "angel")) {
            playerJoinEvent().joinMessage(mini.components("<white>" + player.getName() + " <white><bold>ʜᴀs ʙᴇᴇɴ ᴊᴏɪɴᴇᴅ!"));
            getServer.sendActionBar(mini.components("<white>" + player.getName() + " <white>ʜᴀs ʙᴇᴇɴ ᴊᴏɪɴᴇᴅ!"));
            if (!joinedList.contains(player.getUniqueId())) {
                joinedList.add(player.getUniqueId());
                Bukkit.getServer().getOnlinePlayers().forEach(playerList -> playerList.playSound(playerList.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_HIT, 1, 1));
                Bukkit.getScheduler().runTaskLater(LDCore.getInstance(), removePlayer -> {
                    joinedList.remove(player.getUniqueId());
                },(120 * 60) * 20);
                return;
            }
            return;
        }
        if (groupCheck(player, "darkelf")) {
            playerJoinEvent().joinMessage(mini.components("<white>" + player.getName() + " <dark_purple><bold>ʜᴀs ʙᴇᴇɴ ᴊᴏɪɴᴇᴅ!"));
            getServer.sendActionBar(mini.components("<white>" + player.getName() + " <dark_purple>ʜᴀs ʙᴇᴇɴ ᴊᴏɪɴᴇᴅ!"));
            return;
        }
        if (groupCheck(player, "elf")) {
            playerJoinEvent().joinMessage(mini.components("<white>" + player.getName() + " <yellow><bold>ʜᴀs ʙᴇᴇɴ ᴊᴏɪɴᴇᴅ!"));
            getServer.sendActionBar(mini.components("<white>" + player.getName() + " <yellow>ʜᴀs ʙᴇᴇɴ ᴊᴏɪɴᴇᴅ!"));
        }

    }

    public static void onPlayerQuit() {
        Player player = playerQuitEvent().getPlayer();
        assert player == null;
        playerQuitEvent().quitMessage(mini.components("<dark_gray>[<red>-<dark_gray>]<gray> " + player.getName() + " <dark_gray>[<red>-<dark_gray>]"));


    }
}