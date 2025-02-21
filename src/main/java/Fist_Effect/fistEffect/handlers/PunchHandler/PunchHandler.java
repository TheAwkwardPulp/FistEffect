package Fist_Effect.fistEffect.handlers.PunchHandler;

import org.bukkit.Bukkit;

//For applying potion effect
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

//Listeners and Punch Detection
import Fist_Effect.fistEffect.FistEffect; //create plugin
import org.bukkit.event.EventHandler; //for Listeners
import org.bukkit.event.EventPriority; //listener priority
import org.bukkit.event.Listener; //create listeners
import org.bukkit.event.block.Action; //detect if player is punching
import org.bukkit.event.player.PlayerInteractEvent; //event being listened to


public class PunchHandler implements Listener{
    public PunchHandler(FistEffect plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    //Apply Potion Effect on Punch
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerPunch_low(PlayerInteractEvent event){
        if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK){
            LivingEntity entity = event.getPlayer();
            PotionEffectType effectType = PotionEffectType.STRENGTH; // Choose the effect type
            int duration = 2000; // Duration in ticks
            int amplifier = 10; // Amplifier level
            boolean ambient = false; // Whether the effect is ambient
            boolean particles = true; // Whether particles are visible
            boolean icon = true; // Whether the effect is shown as an icon

            PotionEffect effect = new PotionEffect(effectType, duration, amplifier, ambient, particles, icon);
            entity.addPotionEffect(effect);
        }
    }

    //Listen to Punch
    @EventHandler
    public void onPlayerPunch_normal(PlayerInteractEvent event){
        Action hand = event.getAction();

        if (hand == Action.LEFT_CLICK_AIR || hand == Action.LEFT_CLICK_BLOCK){
            Bukkit.getLogger().info("Player is punching");
        }
    }
}
