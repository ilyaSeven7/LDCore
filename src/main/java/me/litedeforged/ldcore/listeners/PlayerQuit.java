package me.litedeforged.ldcore.listeners;

import me.litedeforged.ldcore.chatSystem.JoinAndQuit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {


    private static PlayerQuitEvent instance;

    public static PlayerQuitEvent getInstance() {
        return instance;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        instance = event;
        JoinAndQuit.onPlayerQuit();
    }
}
