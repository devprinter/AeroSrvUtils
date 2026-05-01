package fr.blueflower.nekk.aerosrvutils.events;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerLoginEvent {
    private static final Logger log = LoggerFactory.getLogger(PlayerLoginEvent.class);
    private final Item currencyToGive = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("numismatics", "cog"));

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event){
        Player player = event.getEntity();
        CompoundTag playerData = player.getPersistentData();
        if (!playerData.getBoolean("receivedCurrency")){
            log.info(String.format("%s (%s) has not received any currency yet!", player.getName().getString(), player.getStringUUID()));
            player.getInventory().add(new ItemStack(currencyToGive,8));
            playerData.putBoolean("receivedCurrency", true);
        }
    }
}
