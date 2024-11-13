package me.tisleo.autominecart.listeners;

import me.tisleo.autominecart.AutoMinecart;
import me.tisleo.autominecart.PlayerConfig;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.entity.boat.OakBoat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

public class WaterClickHandler implements Listener {

    private final AutoMinecart plugin;

    public WaterClickHandler(AutoMinecart plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (!isWater(e, p)) {
            return;
        }

        Location blockLocation = p.getLineOfSight(null, 5).get(0).getLocation();
        blockLocation.setYaw(p.getLocation().getYaw());
        blockLocation.setPitch(p.getLocation().getPitch());

        Boat boat = p.getWorld().spawn(blockLocation, OakBoat.class);
        plugin.addBoatUser(p);
        boat.addPassenger(p);
    }

    /**
     * Checks whether the player is valid to create and use a new AutoMinecart. To
     * be valid, the player must:
     * <ol>
     * <li>Be inside a world where the plugin is enabled</li>
     * <li>Have permission to use the plugin</li>
     * <li>Have the plugin toggled on for them (/togglecart command)</li>
     * <li>Not be inside a vehicle</li>
     * <li>Have right-clicked a valid rail with an empty main hand</li>
     * </ol>
     * 
     * @param p the player
     * @return whether the player is valid to create and use a new AutoMinecart.
     */
    private boolean isWater(PlayerInteractEvent e, Player p) {
        if ((e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)
                && !plugin.getConfig().getStringList("disabled_worlds").contains(p.getWorld().getName())
                && (p.isOp() || p.hasPermission("autominecart.use"))
                && (PlayerConfig.getPlayersFileConfig().getBoolean("players." + p.getUniqueId() + ".boat.toggled"))
                && !p.isInsideVehicle()
                && p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
            List<Block> los = e.getPlayer().getLineOfSight(null, 5);
            for (Block b : los) {
                if (b.getType() == Material.WATER) {
                    return true;
                }
            }
        }
        return false;
    }

}
