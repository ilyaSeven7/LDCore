package me.litedeforged.ldcore.practicepvp;

import me.litedeforged.ldcore.LDCore;
import me.litedeforged.ldcore.message.Components;

import org.bukkit.Bukkit;
import org.bukkit.Sound;

public class FFaArenaRollbackTimer {





    StrikePracticeMethods spMethods = new StrikePracticeMethods();

    Components mini = new Components();



    public void resetFFAPerTick() {
        final int[] TIMER = {spMethods.getConfigSec("PracticePvPSystem").getInt("FFaResetTimerMessage")};

         Bukkit.getScheduler().runTaskTimer(LDCore.getInstance(), main -> {

            if (TIMER[0] == 60 || TIMER[0] == 45 || TIMER[0] == 30 || TIMER[0] == 15) {
                spMethods.getPlayersInArena("crystalffa").forEach(playerList -> playerList.sendMessage(mini.components("<aqua>ᴀʀᴇɴᴀ ʀᴇsᴛᴀʀᴛ ᴀғᴛᴇʀ <light_purple>" + TIMER[0] + " <aqua>sᴇᴄᴏɴᴅs.")));
                spMethods.getPlayersInArena("crystalffa").forEach(playerList -> playerList.playSound(playerList.getLocation(), Sound.BLOCK_WOODEN_BUTTON_CLICK_ON, 1, 1));
            }
            if (TIMER[0] < 6 && TIMER[0] != 0) {
                spMethods.getPlayersInArena("crystalffa").forEach(playerList -> playerList.sendMessage(mini.components("<aqua>ᴀʀᴇɴᴀ ʀᴇsᴛᴀʀᴛ ᴀғᴛᴇʀ <light_purple>" + TIMER[0] + " <aqua>sᴇᴄᴏɴᴅs.")));
                spMethods.getPlayersInArena("crystalffa").forEach(playerList -> playerList.playSound(playerList.getLocation(), Sound.BLOCK_WOODEN_BUTTON_CLICK_ON, 1, 1));
            }


            if (TIMER[0] == 0) {

                spMethods.getPlayersInArena("crystalffa").forEach(playerList -> playerList.teleport(spMethods.getArena("crystalffa").getCenter()));
                spMethods.getPlayersInArena("crystalffa").forEach(playerList -> playerList.getInventory().clear());
                spMethods.getPlayersInArena("crystalffa").forEach(playerList -> playerList.playSound(playerList.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 0));
                spMethods.getPlayersInArena("crystalffa").forEach(playerList -> playerList.sendMessage(mini.components("<green>ʀᴇsᴇᴛ ᴀʀᴇɴᴀ sᴜᴄᴄᴇssғᴜʟʟʏ!")));



                spMethods.getPlayersInArena("crystalffa").forEach(playerList -> spMethods.getPlayerLastEditedKit(playerList));
                spMethods.getArena("crystalffa").quickRollback();


                 main.cancel();
                 resetFFAPerTick();
            }

             TIMER[0]--;

        },20L * spMethods.getConfigSec("PracticePvPSystem").getInt("FFaResetSpeed"), 20);


    }


}
