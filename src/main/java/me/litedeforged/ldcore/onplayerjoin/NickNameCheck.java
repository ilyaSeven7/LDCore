package me.litedeforged.ldcore.onplayerjoin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class NickNameCheck implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Essentials ess = (Essentials) Bukkit.getPluginManager().getPlugin("Essentials");
        Player player = event.getPlayer();
        assert ess != null;
        if (!ess.getUser(player).getNick().equalsIgnoreCase(player.getName()) && !player.hasPermission("nickpermission.keepnickname")) {
            ess.getUser(player).setNickname(player.getName());
        }

    }
}
