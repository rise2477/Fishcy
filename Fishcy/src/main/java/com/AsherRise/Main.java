package com.AsherRise;

import org.bukkit.plugin.java.JavaPlugin;

import com.AsherRise.commands.MainCommands;
import com.AsherRise.config.ConfigManager;
public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        ConfigManager.load();
        getLogger().info("Fishy Enabled!");
        getCommand("fishcy").setExecutor(new MainCommands());
    }

    @Override
    public void onDisable() {
        getLogger().info("Fishcy Disabled!");
    }
    public static Main getInstance() {
        return instance;
    }
}
