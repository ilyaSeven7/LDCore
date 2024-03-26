package me.litedeforged.ldcore;

import me.litedeforged.ldcore.message.Components;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LDCore extends JavaPlugin {

    Components getter = new Components();
    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getConsoleSender().sendMessage(getter.components("<red>Plugin Has Been Enabled!"));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
