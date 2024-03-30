package me.litedeforged.ldcore.practiceapi.commands;

import ga.strikepractice.StrikePractice;
import ga.strikepractice.api.StrikePracticeAPI;
import me.litedeforged.ldcore.LDCore;
import me.litedeforged.ldcore.message.Components;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FFABack implements CommandExecutor {

    Components getter = new Components();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        StrikePracticeAPI strikePracticeAPI = StrikePractice.getAPI();

            if (sender instanceof Player) {
                Player player = ((Player) sender).getPlayer();
                if (args.length == 0) {
                    assert player != null;
                    if (strikePracticeAPI.getFight(player) == null) {
                        player.sendMessage(getter.components("<red>You Can Only Use This Command On FFa Crystal Mode"));
                        return true;
                    }
                    if (strikePracticeAPI.getFight(player).getArena().getName().equalsIgnoreCase("crystalffa")) {

                        if (player.getLastDeathLocation() == null) return true;

                        if (LDCore.uuids.contains(player.getUniqueId())) {
                            player.sendMessage(getter.components("<red>You Can't Use /Back For Now!"));
                            return true;
                        }


                        player.teleport(player.getLastDeathLocation());

                        LDCore.uuids.add(player.getUniqueId());

                    }
                }
            }
        return false;
    }
}
