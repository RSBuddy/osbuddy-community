package com.rsbuddy.osrs.event;

import com.rsbuddy.osrs.game.world.Player;

public class PlayerOverheadTextUpdated {
    private final Player player;
    private final String previousText;
    private String text;

    public PlayerOverheadTextUpdated(Player player, String previousText, String text) {
        this.player = player;
        this.previousText = previousText;
        this.text = text;
    }

    public Player player() {
        return player;
    }

    public String previousText() {
        return previousText;
    }

    public String text() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
