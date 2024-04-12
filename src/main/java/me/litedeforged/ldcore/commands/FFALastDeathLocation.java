package me.litedeforged.ldcore.commands;

import me.litedeforged.ldcore.LDCore;
import me.litedeforged.ldcore.message.Components;
import me.litedeforged.ldcore.practicepvp.StrikePracticeMethods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class FFALastDeathLocation implements CommandExecutor {


    Components getter = new Components();

    StrikePracticeMethods spMethods = new StrikePracticeMethods();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

            if (sender instanceof Player) {
                Player player = ((Player) sender).getPlayer();
                if (args.length == 0) {
                    assert player != null;
                    if (!spMethods.getFight(player).getArena().getName().equalsIgnoreCase("crystalffa")) {
                        player.sendMessage(getter.components("<red>You Can Only Use This Command On FFa Crystal Mode!"));
                        return true;
                    }

                    if (spMethods.getFight(player).getArena().getName().equalsIgnoreCase("crystalffa")) {

                        if (LDCore.uuids.contains(player.getUniqueId()) && spMethods.getDeathLocation(player) == null) {
                            player.sendMessage(getter.components("<red>You Can't Use Back For Now!"));
                            return true;
                        }
                        player.sendMessage(getter.components("<green>You Teleported Back!"));
                        player.teleport(spMethods.getDeathLocation(player));
                        spMethods.removeDeathLocation(player);
                        LDCore.uuids.add(player.getUniqueId());

                    }
                }
            }

        return false;
    }

}
