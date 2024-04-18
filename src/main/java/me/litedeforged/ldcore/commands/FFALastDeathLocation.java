package me.litedeforged.ldcore.commands;

import me.litedeforged.ldcore.message.Components;
import me.litedeforged.ldcore.practicepvp.StrikePracticeMethods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class FFALastDeathLocation implements CommandExecutor {

    Components mini = new Components();
    StrikePracticeMethods spMethods = new StrikePracticeMethods();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

            if (sender instanceof Player player) {
                if (args.length == 0) {
                    if (!spMethods.getFight(player).getArena().getName().equalsIgnoreCase("crystalffa")) {
                        player.sendMessage(mini.components("<red>You Can't Use Back For Now!"));
                        return true;
                    }
                    if (StrikePracticeMethods.deathLocationStore.get(player.getUniqueId()) != null) {
                        StrikePracticeMethods.deathLocationStore.remove(player.getUniqueId());
                        player.sendMessage(mini.components("<green>You Teleported Back!"));
                        player.teleport(StrikePracticeMethods.deathLocationStore.get(player.getUniqueId()));
                        return true;
                    }

                    player.sendMessage(mini.components("<red>You Can Use This Command One Time After You Died!"));
                    return true;
                }
            }
        return false;
    }

}
