package fr.blueflower.nekk.aerosrvutils.events;

import net.neoforged.neoforge.common.NeoForge;

public class EventBus {
    public static void registerEvents(){
        NeoForge.EVENT_BUS.register(new PlayerLoginEvent());
    }
}
