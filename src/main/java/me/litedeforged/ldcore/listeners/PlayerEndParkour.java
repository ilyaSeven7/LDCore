package me.litedeforged.ldcore.listeners;

import ga.strikepractice.StrikePractice;
import ga.strikepractice.api.StrikePracticeAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import us.ajg0702.parkour.api.events.PlayerEndParkourEvent;

public class PlayerEndParkour implements Listener {

    StrikePracticeAPI spAPI = StrikePractice.getAPI();


    @EventHandler
    public void onPlayerEndParkour(PlayerEndParkourEvent event) {
        Player player = event.getPlayer();

        if (!spAPI.isInQueue(player)) {
            System.out.println("test");
            spAPI.joinQueue(player, PlayerStartParkour.storePlayerKit.get(player.getUniqueId()));
            PlayerStartParkour.storePlayerKit.remove(player.getUniqueId());
        }

    }
}
