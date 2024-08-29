package me.tisleo.autominecart.listeners;

import me.tisleo.autominecart.AutoMinecart;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.util.Vector;

public class BoatMoveHandler implements Listener {

    private final AutoMinecart plugin;
    private static final Vector multiplier = new Vector(1.3D, 1D, 1.3D);

    public BoatMoveHandler(AutoMinecart plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onVehicleUpdate(VehicleMoveEvent e) {
        if (e.getVehicle().getPassengers().isEmpty() || !(e.getVehicle() instanceof Boat)) {
            return;
        }

        for (Entity entity : e.getVehicle().getPassengers()) {
            if (!(entity instanceof Player && plugin.getMinecartUsers().contains(entity))) {
                return;
            }

            Boat boat = (Boat) e.getVehicle();
            boat.setVelocity(boat.getVelocity().multiply(multiplier));
        }
    }
}
