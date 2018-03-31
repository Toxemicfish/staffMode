package com.toxemicfish.staffmode;

import com.toxemicfish.staffmode.commands.ModCommand;
import com.toxemicfish.staffmode.events.modEvents;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Main extends JavaPlugin {

    private static Main instance;

    public ArrayList<UUID> ISmod = new ArrayList<>();

    public HashMap<String, ItemStack[]> inventoryContents = new HashMap<String, ItemStack[]>();
    public HashMap<String, ItemStack[]> inventoryArmorContents = new HashMap<String, ItemStack[]>();


    @Override
    public void onEnable() {
        instance = this;

        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {
        getCommand("mod").setExecutor(new ModCommand());
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new modEvents(), this);
    }

    public static Main getInstance() {
        return instance;
    }

}
