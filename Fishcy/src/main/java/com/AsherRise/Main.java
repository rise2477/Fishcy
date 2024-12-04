package com.AsherRise;

import org.bukkit.plugin.java.JavaPlugin;

import com.AsherRise.commands.MainCommands;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Fishy Enabled!");
        getCommand("fishcy").setExecutor(new MainCommands());
    }

    @Override
    public void onDisable() {
        getLogger().info("Fishcy Disabled!");
    }

}
