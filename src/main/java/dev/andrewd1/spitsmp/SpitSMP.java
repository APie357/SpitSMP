package dev.andrewd1.spitsmp;

import dev.andrewd1.spitsmp.item.ModItemGroups;
import dev.andrewd1.spitsmp.item.ModItems;
import dev.andrewd1.spitsmp.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpitSMP implements ModInitializer {
    public static final String MOD_ID = "spit_smp";
    public static final String MOD_NAME = "Spit SMP";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Spit SMP mod...");

        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModLootTableModifiers.modifyLootTables();

        LOGGER.info("Spit SMP mod loaded");
    }
}
