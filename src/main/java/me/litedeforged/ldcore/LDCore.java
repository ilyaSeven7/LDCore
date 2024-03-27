package me.litedeforged.ldcore;

import me.litedeforged.ldcore.deathMessage.listeners.PlayerDeath;
import me.litedeforged.ldcore.message.Components;
import me.litedeforged.ldcore.nicknamechanger.NickNameCheck;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LDCore extends JavaPlugin {

    private static LDCore instance;

    public static LDCore getInstance() {return instance;}


    Components getter = new Components();
    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        saveDefaultConfig();
        Bukkit.getServer().getConsoleSender().sendMessage(getter.components("<green>Plugin Has Been Enabled!"));
        Bukkit.getPluginManager().registerEvents(new NickNameCheck(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeath(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getServer().getConsoleSender().sendMessage(getter.components("<red>Plugin Has Been Disabled"));
    }
}
