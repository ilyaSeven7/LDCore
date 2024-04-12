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
            if (args.length <= 1) {
                player.sendMessage(mini.components("<red>Command Usage<dark_gray>: <gray>/<white>ChangeRollbackSpeed <dark_gray>(<white>ArenaName<dark_gray>) <dark_gray>(<white>ResetTick<dark_gray>)"));
                return false;
            }
            if (args.length < 3) {

                if (spMethods.getArena(args[0]) == null) {
                    player.sendMessage(mini.components("<red>Arena Not Exist!"));
                    return false;
                }

                if (spMethods.isInt(args[1]) == null) {
                    player.sendMessage(mini.components("<red>You Need Import a Integer Value!"));
                    return false;

                }else {
                    Bukkit.getScheduler().cancelTasks(LDCore.getInstance());
                    player.sendMessage(mini.components("<aqua>ᴀʀᴇɴᴀ ʀᴏʟʟʙᴀᴄᴋ sᴘᴇᴇᴅ ᴄʜᴀɴɢᴇᴅ<dark_gray>: <red>" + spMethods.getConfigSec("PracticePvPSystem").getInt("FFaResetSpeed") / 60 + "<dark_gray> >>> <green>" + Integer.parseInt(args[1])));
                    player.sendMessage(mini.components("<red>ᴀʀᴇɴᴀ ʀᴇsᴛᴀʀᴛ ᴇᴠᴇʀʏ <white>" + Integer.parseInt(args[1]) + "<red> ᴍɪɴᴜᴛᴇ!"));
                    spMethods.getConfigSec("PracticePvPSystem").set("FFaResetSpeed", Integer.parseInt(args[1]) * 60);
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
