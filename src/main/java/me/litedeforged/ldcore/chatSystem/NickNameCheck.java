package me.litedeforged.ldcore.chatSystem;

import com.earth2me.essentials.Essentials;
import me.litedeforged.ldcore.LDCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class NickNameCheck implements Listener {

//When A Player Joining The Server Check Their Rank If They Have It Skip And If Not Reset Their Name Into The Default.
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Essentials ess = (Essentials) Bukkit.getPluginManager().getPlugin("Essentials");
        Player player = event.getPlayer();
        assert ess != null;
        if (!ess.getUser(player).getNick().equalsIgnoreCase(player.getName()) && !player.hasPermission("nickpermission.keepnickname") && LDCore.getInstance().getConfig().getConfigurationSection("NickName").getBoolean("toggle")) {
            ess.getUser(player).setNickname(player.getName());
        }

    }
}
