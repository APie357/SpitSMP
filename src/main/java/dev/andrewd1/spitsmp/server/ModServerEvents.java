package dev.andrewd1.spitsmp.server;

import dev.andrewd1.spitsmp.server.event.EndWorldTick;

public class ModServerEvents {
    public static void register() {
        EndWorldTick.register();
    }
}
