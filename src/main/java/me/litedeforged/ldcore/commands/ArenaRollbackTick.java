package me.litedeforged.ldcore.commands;

import me.litedeforged.ldcore.LDCore;
import me.litedeforged.ldcore.message.Components;
import me.litedeforged.ldcore.practicepvp.FFaArenaRollbackTimer;
import me.litedeforged.ldcore.practicepvp.StrikePracticeMethods;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ArenaRollbackTick implements CommandExecutor {

    StrikePracticeMethods spMethods = new StrikePracticeMethods();

    Components mini = new Components();

    FFaArenaRollbackTimer spRollBackPerTick = new FFaArenaRollbackTimer();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (args.length == 0) {
                player.sendMessage(mini.components("<red>Command Usage<dark_gray>: <gray>/<white>ChangeRollbackSpeed <dark_gray>(<white>ResetTick<dark_gray>)"));
                return false;
            }
            if (args.length < 2) {

                if (spMethods.getFight(player) == null) {
                    player.sendMessage(mini.components("<red>Arena Not Found!"));
                    return false;
                }

                if (spMethods.isInt(args[0]) == null) {
                    player.sendMessage(mini.components("<red>You Need Import a Integer Value!"));
                    return false;

                }else {
                    Bukkit.getScheduler().cancelTasks(LDCore.getInstance());
                    player.sendMessage(mini.components( spMethods.getFight(player).getArena().getName() + "<aqua> ᴀʀᴇɴᴀ ʀᴏʟʟʙᴀᴄᴋ sᴘᴇᴇᴅ ᴄʜᴀɴɢᴇᴅ<dark_gray>: <red>" + spMethods.getConfigSec("PracticePvPSystem").getInt("FFaResetSpeed") / 60 + "<dark_gray> » <green>" + Integer.parseInt(args[0])));
                    player.sendMessage(mini.components(spMethods.getFight(player).getArena().getName() + "<red> ᴀʀᴇɴᴀ ʀᴇsᴛᴀʀᴛ ᴇᴠᴇʀʏ <white>" + Integer.parseInt(args[0]) + "<red> ᴍɪɴᴜᴛᴇ!"));
                    spMethods.getConfigSec("PracticePvPSystem").set("FFaResetSpeed", Integer.parseInt(args[0]) * 60);
                    LDCore.getInstance().saveConfig();
                    LDCore.getInstance().reloadConfig();
                    spRollBackPerTick.resetFFAPerTick();


                    return true;
                }
            }
            return false;
        }

        return false;
    }
}
