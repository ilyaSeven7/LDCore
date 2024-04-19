package me.litedeforged.ldcore.practicepvp;

import me.litedeforged.ldcore.LDCore;
import me.litedeforged.ldcore.commands.FFALastDeathLocation;
import me.litedeforged.ldcore.message.Components;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import java.util.List;

public class FFaArenaRollbackTimer {

    StrikePracticeMethods spMethods = new StrikePracticeMethods();

    Components mini = new Components();



    public void resetFFAPerTick() {
            final int[] TIMER = {spMethods.getConfigSec("PracticePvPSystem").getInt("FFaResetTimerMessage")};


//            List<Arena> arenas = spAPI.getArenas();
//
//            for (Arena arenaList : arenas) {
//                if (arenaList.getName().equalsIgnoreCase("crystalffa") &&arenaList.isFFA()) {
//                    System.out.println(arenaList.getName());
//                }
//            }

            Bukkit.getScheduler().runTaskTimer(LDCore.getInstance(), main -> {


                List<Player> players = spMethods.getPlayersInArena("crystalffa");


                if (TIMER[0] == 60 || TIMER[0] == 45 || TIMER[0] == 30 || TIMER[0] == 15) {
                    players.forEach(playerList -> playerList.sendMessage(mini.components("<aqua>ᴀʀᴇɴᴀ ʀᴇsᴛᴀʀᴛ ᴀғᴛᴇʀ <light_purple>" + TIMER[0] + " <aqua>sᴇᴄᴏɴᴅs.")));
                    players.forEach(playerList -> playerList.playSound(playerList.getLocation(), Sound.BLOCK_WOODEN_BUTTON_CLICK_ON, 1, 1));
                }
                if (TIMER[0] < 6 && TIMER[0] != 0) {
                    players.forEach(playerList -> playerList.sendMessage(mini.components("<aqua>ᴀʀᴇɴᴀ ʀᴇsᴛᴀʀᴛ ᴀғᴛᴇʀ <light_purple>" + TIMER[0] + " <aqua>sᴇᴄᴏɴᴅs.")));
                    players.forEach(playerList -> playerList.playSound(playerList.getLocation(), Sound.BLOCK_WOODEN_BUTTON_CLICK_ON, 1, 1));
                }


                if (TIMER[0] == 0) {


                    players.forEach(playerList -> playerList.teleport(spMethods.getArena("crystalffa").getCenter()));
                    players.forEach(playerList -> playerList.getInventory().clear());
                    players.forEach(playerList -> playerList.playSound(playerList.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 0));
                    players.forEach(playerList -> playerList.sendMessage(mini.components("<green>ʀᴇsᴇᴛ ᴀʀᴇɴᴀ sᴜᴄᴄᴇssғᴜʟʟʏ!")));


                    players.forEach(playerList -> spMethods.getPlayerLastEditedKit(playerList));
                    spMethods.getArena("crystalffa").setCustomMaxChangesPerTick(1000);
                    spMethods.getArena("crystalffa").quickRollback();
                    FFALastDeathLocation.removeAllPlayersFromHashMp();


                    main.cancel();
                    resetFFAPerTick();
                }

                TIMER[0]--;
            },20L * spMethods.getConfigSec("PracticePvPSystem").getInt("FFaResetSpeed"), 20);

    }
}
