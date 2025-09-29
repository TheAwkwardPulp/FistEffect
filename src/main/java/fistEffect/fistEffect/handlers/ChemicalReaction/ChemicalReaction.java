package fistEffect.fistEffect.handlers.ChemicalReaction;

//Stick Detection
import fistEffect.fistEffect.FistEffect;
import org.bukkit.entity.Player;
import org.bukkit.Material;

//Projectile Logic
import org.bukkit.entity.Arrow;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

//Effect Logic
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

//Stick Use Listener
import org.bukkit.event.EventHandler; //for Listeners
import org.bukkit.event.Listener; //create listeners
import org.bukkit.event.player.PlayerInteractEvent; //detect if player is punching
import org.bukkit.event.block.Action; //event being listened to

public class ChemicalReaction implements Listener{
    private final NamespacedKey arrowKey;

    public ChemicalReaction(FistEffect plugin){
        this.arrowKey = new NamespacedKey(plugin, "stickArrow");
    }

    // Shoot arrow with stick
    @EventHandler
    public void onStickShoot(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (!(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (event.getItem() == null || event.getItem().getType() != Material.STICK) return;

        Arrow arrow = player.launchProjectile(Arrow.class);

        // Tag arrow as special
        arrow.getPersistentDataContainer().set(arrowKey, PersistentDataType.BYTE, (byte) 1);
    }

    @EventHandler
    public void onArrowHit(ProjectileHitEvent event) {
        if (!(event.getEntity() instanceof Arrow arrow)) return;

        if (!arrow.getPersistentDataContainer().has(arrowKey, PersistentDataType.BYTE)) return;

        if (event.getHitEntity() instanceof LivingEntity target) {
            target.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
            target.setFireTicks(20*5);
        }
    }
}
