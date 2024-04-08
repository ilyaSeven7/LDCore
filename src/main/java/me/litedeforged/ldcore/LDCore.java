package me.litedeforged.ldcore;

import me.litedeforged.ldcore.deathMessage.fileManager.ConfigManager;
import me.litedeforged.ldcore.deathMessage.listeners.PlayerDeath;
import me.litedeforged.ldcore.message.Components;
import me.litedeforged.ldcore.nicknamechanger.NickNameCheck;
import me.litedeforged.ldcore.practicepvp.commands.ArenaRollbackTick;
import me.litedeforged.ldcore.practicepvp.commands.FFALastDeathLocation;
import me.litedeforged.ldcore.practicepvp.commands.ForceArenaRollback;
import me.litedeforged.ldcore.practicepvp.commands.PartyLimit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class LDCore extends JavaPlugin {

    private static LDCore instance;

    public static LDCore getInstance() {return instance;}

    public static List<UUID> uuids = new ArrayList<>();

    FFaArenaRollbackTimer spRollBackPerTick = new FFaArenaRollbackTimer();

    Components getter = new Components();
    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        saveDefaultConfig();

        spRollBackPerTick.resetFFAPerTick();

        if (getConfig().getConfigurationSection("PracticeBackCommand").getBoolean("enable")) {
            getCommand("lastdeathlocation").setExecutor(new FFALastDeathLocation());
        }

        getCommand("changerollbackspeed").setExecutor(new ArenaRollbackTick());
        getCommand("partylimit").setExecutor(new PartyLimit());
        getCommand("forcearenarollback").setExecutor(new ForceArenaRollback());


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
