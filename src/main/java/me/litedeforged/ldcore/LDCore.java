package me.litedeforged.ldcore;

import me.litedeforged.ldcore.DeathMessage.Listeners;
import me.litedeforged.ldcore.message.Components;
import me.litedeforged.ldcore.NickNameChanger.NickNameCheck;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LDCore extends JavaPlugin {

    Components getter = new Components();
    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getConsoleSender().sendMessage(getter.components("<green>Plugin Has Been Enabled!"));
        getServer().getPluginManager().registerEvents(new NickNameCheck(), this);
        getServer().getPluginManager().registerEvents(new Listeners(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getServer().getConsoleSender().sendMessage(getter.components("<red>Plugin Has Been Disabled"));
    }
}
