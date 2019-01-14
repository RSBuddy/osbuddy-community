package com.rsbuddy.osrs.event;

import com.google.common.base.Preconditions;
import com.rsbuddy.osrs.game.world.Item;
import com.rsbuddy.osrs.game.world.Tile;

import java.time.Duration;
import java.util.Set;

public class LootReceived {
    private final Source source;
    private final Tile location;
    private final Set<Item> items;

    // metadata
    // some of the below fields are only relevant with certain sources
    private final int npcId;
    private final String playerName;
    private final String bossName;
    private final Duration killTime;

    public LootReceived(Source source, Tile location, Set<Item> items, int npcId, String playerName, String bossName, Duration killTime) {
        this.source = source;
        this.location = location;
        this.items = items;
        this.npcId = npcId;
        this.playerName = playerName;
        this.bossName = bossName;
        this.killTime = killTime;
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

    public Duration killTime() {
        return killTime;
    }

    public int killTimeSeconds() {
        return (int) killTime.getSeconds();
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
