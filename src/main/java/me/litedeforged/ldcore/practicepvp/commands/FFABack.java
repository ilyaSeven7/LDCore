package me.litedeforged.ldcore.practicepvp.commands;

import me.litedeforged.ldcore.LDCore;
import me.litedeforged.ldcore.deathMessage.listeners.PlayerDeath;
import me.litedeforged.ldcore.message.Components;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FFABack implements CommandExecutor {

    Components getter = new Components();
    PlayerDeath deathlocationgetter = new PlayerDeath();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

            if (sender instanceof Player) {
                Player player = ((Player) sender).getPlayer();
                if (args.length == 0) {
                    assert player != null;
                    if (LDCore.strikePracticeAPI.getFight(player) == null) {
                        player.sendMessage(getter.components("<red>You Can Only Use This Command On FFa Crystal Mode"));
                        return true;
                    }
                    if (LDCore.strikePracticeAPI.getFight(player).getArena().getName().equalsIgnoreCase("crystalffa")) {


                        if (LDCore.uuids.contains(player.getUniqueId()) || deathlocationgetter.getdeathlocation(player) == null) {
                            player.sendMessage(getter.components("<red>You Can't Use /Back For Now!"));
                            return true;
                        }
                        getter.components("<green>You Teleported Back!");
                        player.teleport(deathlocationgetter.getdeathlocation(player));
                        deathlocationgetter.resetdeathlocation(player);
                        LDCore.uuids.add(player.getUniqueId());

                    }
                }
            }

        return false;
    }
}
