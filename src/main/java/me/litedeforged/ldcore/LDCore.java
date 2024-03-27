package me.litedeforged.ldcore;

import me.litedeforged.ldcore.deathMessage.FileManager.ConfigManager;
import me.litedeforged.ldcore.deathMessage.FileManager.Listeners.PlayerDeath;
import me.litedeforged.ldcore.message.Components;
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
        Bukkit.getServer().getConsoleSender().sendMessage(getter.components("<green>Plugin Has Been Enabled!"));
        //getServer().getPluginManager().registerEvents(new NickNameCheck(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);

        ConfigManager.setup();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getServer().getConsoleSender().sendMessage(getter.components("<red>Plugin Has Been Disabled"));
    }
}
