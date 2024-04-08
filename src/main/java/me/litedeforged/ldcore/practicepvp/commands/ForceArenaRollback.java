package me.litedeforged.ldcore.practicepvp.commands;

import me.litedeforged.ldcore.message.Components;
import me.litedeforged.ldcore.practicepvp.StrikePracticeMethods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ForceArenaRollback implements CommandExecutor {

    Components mini = new Components();

    StrikePracticeMethods spMethods = new StrikePracticeMethods();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (args.length == 0) {
                player.sendMessage(mini.components("<red>Command Usage<dark_gray>: <gray>/<white>ForceArenaRollback <dark_gray>(<white>ArenaName<dark_gray>)"));
                return false;
            }
            if (spMethods.getArena(args[0]) == null) {
                player.sendMessage(mini.components("<red>Arena Not Exist!"));
                return false;
            }
            if (args.length < 2) {
                player.sendMessage(mini.components("<aqua>Rollback SuccessFully, All Player SuccessFully Teleported Into The Spawn."));
                spMethods.getArena(args[0]).quickRollback();
                spMethods.getPlayersInArena(args[0]).forEach(playerList -> playerList.teleport(spMethods.getArena(args[0]).getCenter()));
            }

        }
        return false;
    }
}
