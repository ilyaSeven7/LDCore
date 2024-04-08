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
import java.util.Map;
import java.util.UUID;

public class StrikePracticeMethods {

    Components mini = new Components();

    private static final Map<UUID, Location> locaitonsList = new HashMap<>();

    private static final StrikePracticeAPI spAPI = StrikePractice.getAPI();

    public void saveDeathLocation(Player player) {
        locaitonsList.put(player.getUniqueId(), player.getLocation());
    }

    public Location getDeathLocation(Player player) {
        return locaitonsList.get(player.getUniqueId());
    }

    public void removeDeathLocation(Player player) {
        locaitonsList.remove(player.getUniqueId());
    }

    public Fight getFight(Player player) {
        if (spAPI.getFight(player) == null) {
            return null;
        }
        return spAPI.getFight(player);
    }
    

    public Player playerExist(Player player) {
        if (player == null) {
            return null;
        }
        return player;
    }

    public Player stringPlayerIntoPlayer(String player) {
        if (Bukkit.getPlayer(player) == null) {
            return null;
        }
        return Bukkit.getPlayer(player);
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
