package fistEffect.fistEffect;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import fistEffect.fistEffect.handlers.PunchHandler.PunchHandler;
import fistEffect.fistEffect.commands.MaximEnchant;
import fistEffect.fistEffect.handlers.ChemicalReaction.ChemicalReaction;
import org.bukkit.event.Listener;

public final class FistEffect extends JavaPlugin implements Listener{

    private static FistEffect instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PunchHandler(), this);
        getServer().getPluginManager().registerEvents(new ChemicalReaction(this), this);
        instance = this; // assign the instance when the plugin is enabled

        getCommand("maximenchant").setExecutor(new MaximEnchant());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Shutting Down");
    }
}
