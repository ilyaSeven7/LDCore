package me.litedeforged.ldcore.commands;

import ga.strikepractice.StrikePractice;
import ga.strikepractice.api.StrikePracticeAPI;
import me.litedeforged.ldcore.message.Components;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LeaveMatch implements CommandExecutor {

    StrikePracticeAPI spAPI = StrikePractice.getAPI();

    Components mini = new Components();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (spAPI.getFight(player) == null) {
                player.sendMessage(mini.components("<red>You Can't Use This Command Right Now!"));

                return false;
            }


            player.sendMessage(mini.components("<red>You Have Been Leaved From Fight!"));
            spAPI.getFight(player).forceEndDelayed(null);


            for (Player playerList : spAPI.getFight(player).getPlayersInFight()) {
                if (player != playerList) {
                    playerList.sendMessage(mini.components(playerList.getName() + "<red> Have Been Quit From The Fight!"));
                    playerList.playSound(playerList.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1, 1);

                    return true;
                }
            }
        }
        return false;
    }
}