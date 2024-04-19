package me.litedeforged.ldcore;

import me.litedeforged.ldcore.commands.*;
import me.litedeforged.ldcore.deathMessage.fileManager.ConfigManager;
import me.litedeforged.ldcore.listeners.*;
import me.litedeforged.ldcore.message.Components;
import me.litedeforged.ldcore.chatSystem.NickNameCheck;
import me.litedeforged.ldcore.practicepvp.FFaArenaRollbackTimer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class LDCore extends JavaPlugin {
    public static LDCore getInstance() {return instance;}
    private static LDCore instance;

    FFaArenaRollbackTimer spRollBackPerTick = new FFaArenaRollbackTimer();

    Components getter = new Components();
    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        saveDefaultConfig();

        spRollBackPerTick.resetFFAPerTick();


        if (getConfig().getConfigurationSection("PracticePvPSystem").getBoolean("DeathLocationTracker")) {
            getCommand("lastdeathlocation").setExecutor(new FFALastDeathLocation());
        }

        getCommand("changerollbackspeed").setExecutor(new ArenaRollbackTick());
        getCommand("partylimit").setExecutor(new PartyLimit());
        getCommand("forcearenarollback").setExecutor(new ForceArenaRollback());
        getCommand("clientdetector").setExecutor(new ClientDetector());
        getCommand("ff").setExecutor(new LeaveMatch());



        Bukkit.getServer().getConsoleSender().sendMessage(getter.components("<green>Plugin Has Been Enabled!"));
        Bukkit.getPluginManager().registerEvents(new NickNameCheck(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeath(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuit(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamagedByEntity(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerStartParkour(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerEndParkour(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDamage(), this);
        ConfigManager.setup();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getServer().getConsoleSender().sendMessage(getter.components("<red>Plugin Has Been Disabled"));
    }



}
