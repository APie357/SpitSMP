package dev.andrewd1.spitsmp.client;

import dev.andrewd1.spitsmp.client.event.KeyInputHandler;
import dev.andrewd1.spitsmp.network.ModPackets;
import net.fabricmc.api.ClientModInitializer;

public class SpitSMPClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();

        ModPackets.registerS2CPackets();
    }
}
