package me.litedeforged.ldcore.commands;

import me.litedeforged.ldcore.message.Components;
import me.litedeforged.ldcore.practicepvp.StrikePracticeMethods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PartyLimit implements CommandExecutor {

    Components mini = new Components();

    StrikePracticeMethods spMethods = new StrikePracticeMethods();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (sender instanceof Player player) {
            if (args.length == 0) {
                player.sendMessage(mini.components("<red>Command Usage<dark_gray>: <gray>/<white>PartyLimit <dark_gray>(<white>Number<dark_gray>)"));
                return false;
            }
            if (args.length == 1 && spMethods.isInt(args[0]) <= 15) {
                if (spMethods.partyExist(player) == null) {
                    player.sendMessage(mini.components("<red>You Must Have a Party To Do This!"));
                    return false;
                }else {
                    String text = "<aqua>Party Limit Changed Into <light_purple>" + args[0] + "<aqua> Members";
                    player.sendMessage(mini.components(text));
                    spMethods.partyExist(player).getSettings().setMaxPlayerLimit(spMethods.isInt(args[0]));
                    return true;
                }
            }
            return false;
        }



        return false;
    }
}
