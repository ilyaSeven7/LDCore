package me.litedeforged.ldcore.commands;

import me.litedeforged.ldcore.message.Components;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClientDetector implements CommandExecutor {


    Components mini = new Components();


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player player) {

            if (args.length == 1) {
                Player targetPlayer =  Bukkit.getPlayer(args[0]);
                assert targetPlayer != null;


                player.sendMessage(mini.components("<dark_gray>-----------------------"));
                player.sendMessage(mini.components( "<aqua>Client Name<gray>: <light_purple>" + targetPlayer.getClientBrandName()));
                player.sendMessage(mini.components("<aqua>Client ID<gray>: <light_purple>" + targetPlayer.getProtocolVersion())) ;
                player.sendMessage(mini.components("<aqua>IP Address<gray>: <light_purple>" + targetPlayer.getAddress().getHostName()));
                player.sendMessage(mini.components("<aqua>View Distance<gray>: <light_purple>" + targetPlayer.getClientViewDistance()));
                player.sendMessage(mini.components("<dark_gray>-----------------------"));
            }else {
                player.sendMessage(mini.components("<red>Wrong Command Usage Or Player Not Exist!"));
            }
        }
        return false;
    }
}
