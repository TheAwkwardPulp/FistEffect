package Fist_Effect.fistEffect.commands;

//Command Imports
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

//enchantment addition logic
import org.bukkit.entity.Player;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;


public class MaximEnchant implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (!(sender instanceof Player player)){
            sender.sendMessage("Only players can use this command");
            return true;
        }

        ItemStack item = player.getInventory().getItemInMainHand();

        //Item Check
        if (item.getType() == Material.AIR) {
            player.sendMessage("You must hold an item in your hand.");
            return true;
        }

        //Sword Check
        if (item.getType() != Material.DIAMOND_SWORD || item.getType() != Material.NETHERITE_SWORD) {
            player.sendMessage("You are not strong enough.");
        }

        /*player.getItemInUse().addEnchantment(Enchantment.SWEEPING_EDGE, 5);
        player.getItemInUse().addEnchantment(Enchantment.LOOTING, 5);
        player.getItemInUse().addEnchantment(Enchantment.FIRE_ASPECT, 4);
        player.getItemInUse().addEnchantment(Enchantment.UNBREAKING, 5);
        player.getItemInUse().addEnchantment(Enchantment.MENDING, 3);*/

        player.sendMessage("Now we're talking!");

        return true;
    }
}
