package com.rsbuddy.osrs.event;

import com.rsbuddy.osrs.game.world.Player;

public class AnimatePlayer {
    private final Player player;
    private final int animationId;
    private final int delay;
    private final int end;

    public AnimatePlayer(Player player, int animationId, int delay, int end) {
        this.player = player;
        this.animationId = animationId;
        this.delay = delay;
        this.end = end;
    }

    public Player player() {
        return player;
    }

    public int animationId() {
        return animationId;
    }

    public int delay() {
        return delay;
    }

    public int end() {
        return end;
    }

    @Override
    public String toString() {
        return "AnimatePlayer{" +
                "player=" + player +
                ", animationId=" + animationId +
                ", delay=" + delay +
                ", end=" + end +
                '}';
    }
}
