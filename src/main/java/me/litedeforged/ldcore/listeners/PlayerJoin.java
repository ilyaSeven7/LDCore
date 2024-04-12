package me.litedeforged.ldcore.listeners;

import me.litedeforged.ldcore.chatSystem.JoinAndQuit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {


    private static PlayerJoinEvent instance;

    public static PlayerJoinEvent getInstance() {return instance;}

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        instance = event;
        JoinAndQuit.onPlayerJoined();
    }

}
