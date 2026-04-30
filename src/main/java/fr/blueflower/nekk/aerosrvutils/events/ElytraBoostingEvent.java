package fr.blueflower.nekk.aerosrvutils.events;

import fr.blueflower.nekk.aerosrvutils.AeroSrvUtils;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class ElytraBoostingEvent {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ElytraBoostingEvent.class);

    @SubscribeEvent
    public void playerRightClickItem(PlayerInteractEvent.RightClickItem event){
        // is the player flying with elytra
        if (!event.getEntity().isFallFlying()) return;

        // are they holding firework?
        if (!event.getEntity().isHolding(Items.FIREWORK_ROCKET)) return;

        event.setCanceled(true);
    }

}
