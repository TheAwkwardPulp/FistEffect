package fistEffect.fistEffect.handlers.PunchHandler;

import org.bukkit.Bukkit;

//For applying potion effect
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.Player;
import org.bukkit.Material;

//Listeners and Punch Detection
import org.bukkit.event.EventHandler; //for Listeners
import org.bukkit.event.EventPriority; //listener priority
import org.bukkit.event.Listener; //create listeners
import org.bukkit.event.block.Action; //detect if player is punching
import org.bukkit.event.player.PlayerInteractEvent; //event being listened to

public class PunchHandler implements Listener{
    //Apply Potion Effect on Punch
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerPunch(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        // Only trigger on left click
        if (!(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK)) {
            return;
        }

        // Item Check
        if (event.getItem() != null && event.getItem().getType() != Material.AIR) {
            return;
        }

        // Apply Potion Effect
        PotionEffectType effectType = PotionEffectType.STRENGTH;
        int duration = 2000; // 1 second (20 ticks)
        int amplifier = 1; // Strength I

        PotionEffect effect = new PotionEffect(effectType, duration, amplifier, false, true, true);
        player.addPotionEffect(effect);
    }

    //Listen to Punch
    @EventHandler
    public void onPlayerPunch_normal(PlayerInteractEvent event) {
        Action hand = event.getAction();

        if (hand == Action.LEFT_CLICK_AIR || hand == Action.LEFT_CLICK_BLOCK) {
            // Item Check
            if (event.getItem() != null && event.getItem().getType() != Material.AIR) {
                return; // Player is holding something; exit
            }

            // Player is not holding anything
            Bukkit.getLogger().info("Player is punching with empty hand");
        }
    }
}
