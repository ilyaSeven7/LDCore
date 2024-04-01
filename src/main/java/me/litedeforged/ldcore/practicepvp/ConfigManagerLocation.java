package me.litedeforged.ldcore.practicepvp;

import me.litedeforged.ldcore.LDCore;
import me.litedeforged.ldcore.message.Components;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManagerLocation {
    static Components getter = new Components();
    private static File file;

    private static YamlConfiguration yml;

    public static void setup() {
        file = new File(LDCore.getInstance().getDataFolder() + "/DeathLocation", "Locations.yml" );
        try {
            new File(LDCore.getInstance().getDataFolder() + "/DeathLocation").mkdirs();
            if (!file.exists()) {
                LDCore.getInstance().getServer().getConsoleSender().sendMessage(getter.components("<green>File Successfully Created!"));
                file.createNewFile();
            }
        }catch (IOException e) {
            LDCore.getInstance().getServer().getConsoleSender().sendMessage(getter.components("<red>File Can't Be Created!"));
        }
        yml = YamlConfiguration.loadConfiguration(file);
    }


    public static void relaod() {
        yml = YamlConfiguration.loadConfiguration(file);
    }
    public static FileConfiguration get() {
        return yml;
    }
    public static void save() {
        try {
            yml.save(file);
        } catch (IOException e) {
            LDCore.getInstance().getServer().getConsoleSender().sendMessage("WTFXD");
        }

    }
}
