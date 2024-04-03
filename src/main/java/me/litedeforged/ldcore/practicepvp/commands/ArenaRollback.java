package me.litedeforged.ldcore.practicepvp.commands;

import me.litedeforged.ldcore.practicepvp.StrikePracticeMethods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ArenaRollback implements CommandExecutor {

    StrikePracticeMethods spMethods = new StrikePracticeMethods();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (args.length <= 2) {
                if (Integer.parseInt(args[1]) <= 10000 ) {
                    spMethods.getArena(player, args[0], Integer.parseInt(args[1]));
                }
                return false;
            }
            return false;
        }

        return false;
    }
}
