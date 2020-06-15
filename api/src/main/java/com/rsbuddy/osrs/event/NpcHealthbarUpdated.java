package com.rsbuddy.osrs.event;

import com.rsbuddy.osrs.game.world.Npc;

public class NpcHealthbarUpdated {

    private final Npc npc;
    private final int maxWidth;
    private final int currentWidth;

    public NpcHealthbarUpdated(Npc npc, int maxWidth, int currentWidth) {
        this.npc = npc;
        this.maxWidth = maxWidth;
        this.currentWidth = currentWidth;
    }

    public Npc getNpc() {
        return npc;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public int getCurrentWidth() {
        return currentWidth;
    }
}
