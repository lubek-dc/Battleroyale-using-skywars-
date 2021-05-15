package me.lubek.battleroyalesky;

import org.bukkit.plugin.java.JavaPlugin;

public final class Battleroyalesky extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new events(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
