package me.litedeforged.ldcore.deathMessage.listeners;

import me.litedeforged.ldcore.message.Components;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    Components mini = new Components();

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {

//        event.quitMessage(mini.components("<dark_gray>[<red>-<dark_gray>]<gray> ").append(mini.components(event.getPlayer().getName()).append(mini.components(" <dark_gray>[<red>-<dark_gray>]"))));

    }
}
