package com.AsherRise.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import com.AsherRise.Main;
import com.AsherRise.config.ConfigManager;

import net.md_5.bungee.api.ChatColor;

public class MainCommands implements CommandExecutor, TabCompleter {

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

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        
        if (command.getName().equalsIgnoreCase("fishcy")) {
            if (args.length == 1) {
                if (sender.hasPermission("fishcy.reload")) {
                    completions.add("reload");
                }
            }
        }
        Collections.sort(completions);
        return completions;
    }
}
