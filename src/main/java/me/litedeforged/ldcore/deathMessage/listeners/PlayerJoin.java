package me.litedeforged.ldcore.deathMessage.listeners;

import me.litedeforged.ldcore.message.Components;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {


    Components mini = new Components();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

//        event.joinMessage(mini.components("<dark_gray>[<green>+<dark_gray>]<gray> ").append(mini.components(event.getPlayer().getName()).append(mini.components(" <dark_gray>[<green>+<dark_gray>]"))));


    }
}
