package com.rsbuddy.osrs.event;

import com.google.common.base.Preconditions;
import com.rsbuddy.osrs.game.world.Item;
import com.rsbuddy.osrs.game.world.Tile;

import java.util.Set;

public class LootReceived {
    private final Source source;
    private final int npcId;
    private final String playerName;
    private final String bossName;
    private final Tile location;
    private final Set<Item> items;

    public LootReceived(Source source, int npcId, String playerName, String bossName, Tile location, Set<Item> items) {
        this.source = source;
        this.npcId = npcId;
        this.playerName = playerName;
        this.bossName = bossName;
        this.location = location;
        this.items = items;
    }

    public Source source() {
        return source;
    }

    public int npcId() {
        Preconditions.checkState(source == Source.BOSS || source == Source.NPC);
        return npcId;
    }

    public String playerName() {
        Preconditions.checkState(source == Source.PLAYER);
        return playerName;
    }

    public String bossName() {
        Preconditions.checkState(source == Source.BOSS);
        return bossName;
    }

    public Tile location() {
        return location;
    }

    public Set<Item> items() {
        return items;
    }

    public enum Source {
        NPC,
        BOSS,
        BOSS_PET,
        PLAYER,
        DUEL_WON
    }
}
