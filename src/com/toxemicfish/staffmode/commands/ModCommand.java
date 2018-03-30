package com.toxemicfish.staffmode.commands;

import com.toxemicfish.staffmode.Main;
import com.toxemicfish.staffmode.utils.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class ModCommand implements CommandExecutor {

    Main PLUGIN = Main.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            UUID uuid = player.getUniqueId();

            if (!PLUGIN.ISmod.contains(uuid)) {
                PLUGIN.ISmod.add(uuid);

                PLUGIN.inventoryContents.put(player.getName(), player.getInventory().getContents());
                PLUGIN.inventoryArmorContents.put(player.getName(), player.getInventory().getArmorContents());

                player.getInventory().clear();
                player.getInventory().setArmorContents(null);

                //Give items here
                ItemStack im = new ItemStackBuilder(Material.COMPASS).withName("&3Player finder").build();

                player.getInventory().addItem(im);
                //---------------
            } else {
                PLUGIN.ISmod.remove(uuid);
                player.getInventory().clear();

                player.getInventory().setContents(PLUGIN.inventoryContents.get(player.getName()));

                player.getInventory().setArmorContents(null);
                player.getInventory().setArmorContents(PLUGIN.inventoryArmorContents.get(player.getName()));
            }

        } else {

        }
        return true;
    }
}
