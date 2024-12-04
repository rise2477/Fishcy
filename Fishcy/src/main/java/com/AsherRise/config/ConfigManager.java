package com.AsherRise.config;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.AsherRise.Main;

import net.md_5.bungee.api.ChatColor;

public class ConfigManager {
    private static final File configPath = new File(Main.getInstance().getDataFolder() + File.separator + "message.yml");
    private static FileConfiguration config;

    public static String PREFIX;
    public static String NOTCONSOLE;
    public static String RELOAD_CONFIG;

    public static void load() {
        if (!configPath.exists()) {
            Main.getInstance().saveResource("message.yml", false);
        }
        config = YamlConfiguration.loadConfiguration(configPath);

        PREFIX = ChatColor.translateAlternateColorCodes('&', config.getString("PREFIX", "&7[&bFishcy&7] "));
        NOTCONSOLE = ChatColor.translateAlternateColorCodes('&', config.getString("THIS_COMMAND_ONLY_FOR_PLAYER", "&cThis Command is only for player"));
        RELOAD_CONFIG = ChatColor.translateAlternateColorCodes('&', config.getString("RELOAD_CONFIG", "&6Reloaded Config"));
    }
}
