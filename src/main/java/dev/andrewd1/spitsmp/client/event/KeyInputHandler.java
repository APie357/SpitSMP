package dev.andrewd1.spitsmp.client.event;

import dev.andrewd1.spitsmp.network.ModPackets;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY = "key.category.spit_smp.spit";
    public static final String KEY_MAIN_ABILITY = "key.spit_smp.spit_main";
    public static final String KEY_ALT_ABILITY = "key.spit_smp.spit_alt";

    public static KeyBinding mainAbility;
    public static KeyBinding altAbility;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (mainAbility.wasPressed()) {
                ClientPlayNetworking.send(ModPackets.SPIT_MAIN_ABILITY, PacketByteBufs.create());
            }

            if (altAbility.wasPressed()) {
                ClientPlayNetworking.send(ModPackets.SPIT_ALT_ABILITY, PacketByteBufs.create());
            }
        });
    }

    public static void register() {
        mainAbility = KeyBindingHelper.registerKeyBinding(new KeyBinding(KEY_MAIN_ABILITY, GLFW.GLFW_KEY_R, KEY_CATEGORY));
        altAbility = KeyBindingHelper.registerKeyBinding(new KeyBinding(KEY_ALT_ABILITY, GLFW.GLFW_KEY_V, KEY_CATEGORY));

        registerKeyInputs();
    }
}
