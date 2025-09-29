package fistEffect.fistEffect.commands;

//Command Imports
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

//enchantment addition logic
import org.bukkit.entity.Player;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.enchantments.Enchantment;


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
        if (item.getType() == Material.DIAMOND_SWORD || item.getType() == Material.NETHERITE_SWORD) {
            item.addEnchantment(Enchantment.SMITE, 5);
            item.addEnchantment(Enchantment.SWEEPING_EDGE, 3);
            item.addEnchantment(Enchantment.LOOTING, 3);
            item.addEnchantment(Enchantment.FIRE_ASPECT, 2);
            item.addEnchantment(Enchantment.UNBREAKING, 3);
            item.addEnchantment(Enchantment.MENDING, 1);
            player.sendMessage("Now we're talking!");

            return true;
        }

        player.sendMessage("You are not strong enough.");
        return true;
    }
}
