package me.litedeforged.ldcore.listeners;

import me.litedeforged.ldcore.LDCore;
import me.litedeforged.ldcore.message.Components;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;



public class EntityDamagedByEntity implements Listener {

        Components mini = new Components();


    @EventHandler
    public void onEntityDamagedByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player player) || !(event.getDamager() instanceof Player damager)) {
            return;
        }

        if (LDCore.getInstance().getConfig().getConfigurationSection("PracticePvPSystem").get("ShieldDamagerBreakSound")  == null) {
            LDCore.getInstance().getServer().getConsoleSender().sendMessage(mini.components("<red>Sound Not Valid! Replacing With Default!"));
            LDCore.getInstance().getConfig().getConfigurationSection("PracticePvPSystem").set("ShieldDamagerBreakSound", "ITEM_SHIELD_BREAK");
            return;
        }

        if (damager.getEquipment().getItemInMainHand().getType().toString().toLowerCase().contains("axe") && player.isBlocking() && (int) event.getFinalDamage() == 0) {

            damager.playSound(damager.getLocation(), Sound.ITEM_SHIELD_BREAK, 1, 0);
        }
    }

}
