package dev.offhandutility;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class OffhandUtility implements ModInitializer {
    public static final String MOD_ID = "offhand_utility";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Offhand Utility initialized.");
    }
}
