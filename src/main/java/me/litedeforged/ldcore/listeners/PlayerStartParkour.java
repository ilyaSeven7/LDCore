package me.litedeforged.ldcore.listeners;

import ga.strikepractice.StrikePractice;
import ga.strikepractice.api.StrikePracticeAPI;
import ga.strikepractice.battlekit.BattleKit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import us.ajg0702.parkour.api.events.PrePlayerStartParkourEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerStartParkour implements Listener {

    StrikePracticeAPI spAPI = StrikePractice.getAPI();

    public static final HashMap<UUID, BattleKit> storePlayerKit = new HashMap<>();

    @EventHandler
    public void onPlayerStartParkour(PrePlayerStartParkourEvent event) {
        Player player = event.getPlayer();

        if (spAPI.isInQueue(player)) {
            storePlayerKit.put(player.getUniqueId(), spAPI.getQueuedKit(player));
            player.performCommand("queue leave");
        }

    }
}

