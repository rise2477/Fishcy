package com.AsherRise.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command works only for players!");
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("fishcy")) {
            player.sendMessage("IDK THIS IS JUST A CMD");
            return true;
        }

        return false;
    }
}
