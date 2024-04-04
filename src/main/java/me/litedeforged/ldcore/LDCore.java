package me.litedeforged.ldcore;

import ga.strikepractice.StrikePractice;
import ga.strikepractice.api.StrikePracticeAPI;
import me.litedeforged.ldcore.deathMessage.fileManager.ConfigManager;
import me.litedeforged.ldcore.deathMessage.listeners.PlayerDeath;
import me.litedeforged.ldcore.message.Components;
import me.litedeforged.ldcore.nicknamechanger.NickNameCheck;
import me.litedeforged.ldcore.practicepvp.commands.ArenaRollback;
import me.litedeforged.ldcore.practicepvp.commands.FFALastDeathLocation;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

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
            getCommand("lastdeathlocation").setExecutor(new FFALastDeathLocation());
        }

        getCommand("changerollbackspeed").setExecutor(new ArenaRollback());
        getCommand("partylimit").setExecutor(new PartyLimit());
        Bukkit.getServer().getConsoleSender().sendMessage(getter.components("<green>Plugin Has Been Enabled!"));
        Bukkit.getPluginManager().registerEvents(new NickNameCheck(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeath(), this);
        ConfigManager.setup();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getServer().getConsoleSender().sendMessage(getter.components("<red>Plugin Has Been Disabled"));
    }



}
