package me.litedeforged.ldcore;

import ga.strikepractice.StrikePractice;
import ga.strikepractice.api.StrikePracticeAPI;
import me.litedeforged.ldcore.deathMessage.fileManager.ConfigManager;
import me.litedeforged.ldcore.deathMessage.listeners.PlayerDeath;
import me.litedeforged.ldcore.message.Components;
import me.litedeforged.ldcore.nicknamechanger.NickNameCheck;
import me.litedeforged.ldcore.practicepvp.commands.FFABack;
import me.litedeforged.ldcore.practicepvp.SaveDeathLocation;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class LDCore extends JavaPlugin {

    private static LDCore instance;

    public static LDCore getInstance() {return instance;}

    public static List<UUID> uuids = new ArrayList<>();

    public static StrikePracticeAPI strikePracticeAPI = StrikePractice.getAPI();

    Components getter = new Components();
    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        saveDefaultConfig();
        if (getConfig().getConfigurationSection("PracticeBackCommand").getBoolean("enable")) {
            getCommand("back").setExecutor(new FFABack());
        }
        ConfigManager.setup();
        SaveDeathLocation.setup();
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
