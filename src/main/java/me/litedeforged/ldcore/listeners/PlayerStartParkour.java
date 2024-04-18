package me.litedeforged.ldcore.listeners;

import ga.strikepractice.StrikePractice;
import ga.strikepractice.api.StrikePracticeAPI;
import ga.strikepractice.battlekit.BattleKit;
import me.litedeforged.ldcore.message.Components;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import us.ajg0702.parkour.api.events.PlayerStartParkourEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerStartParkour implements Listener {

    StrikePracticeAPI spAPI = StrikePractice.getAPI();

    public static final HashMap<UUID, BattleKit> storePlayerKit = new HashMap<>();

    Components mini = new Components();


    @EventHandler
    public void onPlayerStartParkour(PlayerStartParkourEvent event) {
        Player player = event.getPlayer();

        if (spAPI.isInQueue(player) && spAPI.getQueuedKit(player) != null) {
            storePlayerKit.put(player.getUniqueId(), spAPI.getQueuedKit(player));
            player.performCommand("queue leave");

        }
        if (spAPI.getParty(player) != null) {

            player.sendMessage(mini.components("<red>sʜᴏᴍᴀ ɴᴇᴍɪᴛᴀᴠᴀɴɪᴅ ᴢᴀᴍᴀɴɪ ᴋᴇ ᴅᴀʀ ᴘᴀʀᴛʏ ʜᴀsᴛɪᴅ, ɪɴ ᴋᴀʀ ʀᴀ ᴀɴᴊᴀᴍ ᴅᴀʜɪᴅ!"));
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 2, 1);
            event.getParkourPlayer().end();
        }

    }
}

