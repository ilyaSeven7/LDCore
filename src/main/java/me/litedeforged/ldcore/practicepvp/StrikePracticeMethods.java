package me.litedeforged.ldcore.practicepvp;

import ga.strikepractice.StrikePractice;
import ga.strikepractice.api.StrikePracticeAPI;
import ga.strikepractice.arena.Arena;
import ga.strikepractice.battlekit.BattleKit;
import ga.strikepractice.fights.Fight;
import ga.strikepractice.party.Party;
import me.litedeforged.ldcore.LDCore;
import me.litedeforged.ldcore.message.Components;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class StrikePracticeMethods {

    Components mini = new Components();

    private static final StrikePracticeAPI spAPI = StrikePractice.getAPI();

    public final static HashMap<UUID, Location> deathLocationStore = new HashMap<>();

    public Fight getFight(Player player) {
        if (spAPI.getFight(player) == null) {
            return null;
        }
        return spAPI.getFight(player);
    }


    public Arena getArena(String arenaName) {
        if (spAPI.getArena(arenaName) == null) {
            return null;
        }
        return spAPI.getArena(arenaName);
    }

    public ConfigurationSection getConfigSec(String secName) {
        if (LDCore.getInstance().getConfig().getConfigurationSection(secName) == null) {
            Bukkit.getConsoleSender().sendMessage(mini.components("<red>There Is A Problem In Your Config File!"));
            return null;
        }
        return LDCore.getInstance().getConfig().getConfigurationSection(secName);
    }


    public List<Player> getPlayersInArena(String arenaName) {
        if (spAPI.getArena(arenaName) == null) {
            return null;
        }
        return spAPI.getArena(arenaName).getCurrentFight().getPlayersInFight();
    }

    public void getPlayerLastEditedKit(Player getPlayer) {
        BattleKit playerKit = spAPI.getFight(getPlayer).getKit();
        BattleKit getLastKit = spAPI.getLastSelectedEditedKit(getPlayer);
        if (getLastKit != null) {
            playerKit.giveKitStuff(getPlayer, getLastKit);

        }else {
            String kitName = playerKit.getName();
            BattleKit getKit = spAPI.getKit(kitName);
            playerKit.giveKitStuff(getPlayer, getKit);
        }
    }


    public Party partyExist(Player player) {
        if (spAPI.getParty(player) == null) {
            return null;
        }
        return spAPI.getParty(player);
    }

    public Integer isInt(String text) {
        try {
            return Integer.parseInt(text);
        }catch (NumberFormatException e){
            return null;
        }

    }

}
