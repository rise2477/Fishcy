package com.AsherRise.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.AsherRise.Main;
import com.AsherRise.config.ConfigManager;

import net.md_5.bungee.api.ChatColor;
public class MainCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.PREFIX + ConfigManager.NOTCONSOLE));
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("fishcy")) {
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (player.hasPermission("fishcy.reload")) {
                        Main.getInstance().reloadConfig();
                        ConfigManager.load();
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.PREFIX + ConfigManager.RELOAD_CONFIG));
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou don't have permission"));
                    }
                }
            } else {
                player.sendMessage("IDK THIS IS JUST A CMD");
            }
            return true;
        }

        return false;
    }
}
