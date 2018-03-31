package com.toxemicfish.staffmode.utils;

import org.bukkit.ChatColor;

public class MessageManger {

    private static String prefix = ChatColor.translateAlternateColorCodes('&', "&7[&estaffMode&7] &f");

    public static String getPrefix() {
        return prefix;
    }

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
