package me.litedeforged.ldcore.deathMessage.FileManager;

import me.litedeforged.ldcore.LDCore;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.configuration.file.YamlConfiguration;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class ConfigManager {

    private static File file;

    public static void setup() {
        file = new File(LDCore.getInstance().getDataFolder() + "/DeathLogs", LocalDate.now() + ".txt");

        try {
            if (!file.exists()) {
                new File(LDCore.getInstance().getDataFolder() + "/DeathLogs").mkdirs();
                file.createNewFile();
            }
        } catch (IOException e) {
            LDCore.getInstance().getServer().getConsoleSender().sendMessage(mini("<red>File Cannot Created!"));
        }
    }

    public static void writer(String text) {

        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(text + "\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            LDCore.getInstance().getServer().getConsoleSender().sendMessage(mini("<red>File Cannot Write!"));
        }

    }

    public static Component mini(String text) {
        return MiniMessage.miniMessage().deserialize(text);
    }

}
