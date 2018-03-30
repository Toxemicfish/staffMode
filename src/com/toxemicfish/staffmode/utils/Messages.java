package com.toxemicfish.staffmode.utils;

import com.toxemicfish.staffmode.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum Messages {

    BAD_INPUT("&c%s is not a number.");

    private String message;

    Main PLUGIN = Main.getInstance();

    private String prefix = MessageManger.getPrefix();

    Messages(String message) {
        this.message = MessageManger.color(message);
    }

    public String toString() {
        return message;
    }

    public String toString(Object... parts) {
        return String.format(message, parts);
    }

    public void send(Player player) {
        player.sendMessage(prefix + message);
    }

    public void send(CommandSender sender) {
        sender.sendMessage(prefix + message);
    }

    public void send(Player player, String replacement) {
        player.sendMessage(prefix + message.replace("%s", replacement));
    }

    public void send(Player player, Object... replacements) {
        player.sendMessage(String.format(prefix + message, replacements));
    }

    public void broadcast() {
        Bukkit.broadcastMessage(prefix + message);
    }

    public void broadcast(String replacement) {
        Bukkit.broadcastMessage(prefix + message.replace("%s", replacement));
    }

    public void broadcast(Object... replacements) {
        Bukkit.broadcastMessage(String.format(prefix + message, replacements));
    }

}
