package dev.andrewd1.spitsmp;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpitSMP implements ModInitializer {
    public static final String MOD_ID = "spit_smp";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Spit SMP mod...");



        LOGGER.info("Spit SMP mod loaded");
    }
}
