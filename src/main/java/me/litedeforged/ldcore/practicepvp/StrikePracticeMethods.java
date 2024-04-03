package me.litedeforged.ldcore.practicepvp;

import ga.strikepractice.StrikePractice;
import ga.strikepractice.api.StrikePracticeAPI;
import ga.strikepractice.fights.Fight;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StrikePracticeMethods {

    private static final Map<UUID, Location> locaitonsList = new HashMap<>();

    private static final StrikePracticeAPI spAPI = StrikePractice.getAPI();

    public void saveDeathLocation(Player player) {
        locaitonsList.put(player.getUniqueId(), player.getLocation());
    }

    public Location getDeathLocation(Player player) {
        return locaitonsList.get(player.getUniqueId());
    }

    public void removeDeathLocation(Player player) {
        locaitonsList.remove(player.getUniqueId());
    }

    public Fight getFight(Player player) {
        return spAPI.getFight(player);
    }

    public void getArena(Player player, String arenaName, int tick) {
        if (spAPI.getArena(arenaName) == null) {
                player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Arena Not Exist!"));
                return;
        }
        spAPI.getArena(arenaName).setCustomMaxChangesPerTick(tick);
    }
}
