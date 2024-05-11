package dev.andrewd1.spitsmp;

import dev.andrewd1.spitsmp.item.ModItemGroups;
import dev.andrewd1.spitsmp.item.ModItems;
import dev.andrewd1.spitsmp.network.ModPackets;
import dev.andrewd1.spitsmp.server.ModServerEvents;
import dev.andrewd1.spitsmp.util.CooldownManager;
import dev.andrewd1.spitsmp.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpitSMP implements ModInitializer {
    public static final String MOD_ID = "spit_smp";
    public static final String MOD_NAME = "Spit SMP";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static final CooldownManager mainCooldownManager = new CooldownManager();
    public static final CooldownManager altCooldownManager = new CooldownManager();

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Spit SMP mod...");

        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModLootTableModifiers.modifyLootTables();

        ModPackets.registerC2SPackets();

        ModServerEvents.register();

        LOGGER.info("Spit SMP mod loaded");
    }
}
