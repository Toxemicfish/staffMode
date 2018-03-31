package com.toxemicfish.staffmode.events;

import com.toxemicfish.staffmode.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class modEvents implements Listener{

    Main PLUGIN = Main.getInstance();

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (PLUGIN.ISmod.contains(player.getUniqueId())) {
            switch (event.getSlotType()) {
                case CRAFTING:
                case ARMOR:
                case FUEL:
                    event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = (Player) event.getPlayer();
        if (PLUGIN.ISmod.contains(player.getUniqueId())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = (Player) event.getPlayer();
        if (PLUGIN.ISmod.contains(player.getUniqueId())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = (Player) event.getPlayer();
        if (PLUGIN.ISmod.contains(player.getUniqueId())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onStarve(FoodLevelChangeEvent event) {
        Player player = (Player) event.getEntity();
        if (PLUGIN.ISmod.contains(player.getUniqueId())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onTrample(PlayerInteractEvent event) {
        Player player = (Player) event.getPlayer();
        if (PLUGIN.ISmod.contains(player.getUniqueId())) {
            if (event.getClickedBlock() == null) {
                return;
            }

            if (event.getAction() == Action.PHYSICAL) {
                Block block = event.getClickedBlock();

                Material material = block.getType();

                if (material == Material.CROPS || material == Material.SOIL) {
                    event.setUseInteractedBlock(PlayerInteractEvent.Result.DENY);
                    event.setCancelled(true);

                    block.setType(material);
                    block.setData(block.getData());
                }
            }
        }
    }
}
