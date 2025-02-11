package Fist_Effect.fistEffect;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import Fist_Effect.fistEffect.handlers.PunchHandler;
import Fist_Effect.fistEffect.commands.MaximEnchant;

public final class FistEffect extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new PunchHandler(this);
        getCommand("maxim").setExecutor(new MaximEnchant());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Shutting Down");
    }
}
