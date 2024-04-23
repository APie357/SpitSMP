package dev.andrewd1.spitsmp.network;

import dev.andrewd1.spitsmp.SpitSMP;
import dev.andrewd1.spitsmp.network.packet.SpitAltAbilityC2SPacket;
import dev.andrewd1.spitsmp.network.packet.SpitMainAbilityC2SPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModPackets {
    public static final Identifier SPIT_MAIN_ABILITY = new Identifier(SpitSMP.MOD_ID, "spit_main_ability");
    public static final Identifier SPIT_ALT_ABILITY = new Identifier(SpitSMP.MOD_ID, "spit_alt_ability");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(SPIT_MAIN_ABILITY, SpitMainAbilityC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(SPIT_ALT_ABILITY, SpitAltAbilityC2SPacket::receive);
    }

    public static void registerS2CPackets() {

    }
}
