package com.rsbuddy.osrs.game.world;

import com.google.common.base.Preconditions;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;

public class Loot {
    private final Source source;
    private final Tile location;
    private final Set<Item> items;
    private final Instant time;

    // metadata
    // some of the below fields are only relevant with certain sources
    private final int npcId;
    private final String npcName;
    private final String playerName;
    private final Duration killTime;

    // barrows
    private final int killCount;
    private final int rewardPotential;

    public Loot(Source source, Tile location, Set<Item> items, Instant time, int npcId, String npcName, String playerName, Duration killTime, int killCount, int rewardPotential) {
        this.source = source;
        this.location = location;
        this.items = items;
        this.time = time;
        this.npcId = npcId;
        this.npcName = npcName;
        this.playerName = playerName;
        this.killTime = killTime;
        this.killCount = killCount;
        this.rewardPotential = rewardPotential;
    }

    public Source source() {
        return source;
    }

    public Tile location() {
        return location;
    }

    public Set<Item> items() {
        return items;
    }

    public Instant time() {
        return time;
    }

    public int npcId() {
        Preconditions.checkState(source == Source.BOSS || source == Source.NPC);
        return npcId;
    }

    public String playerName() {
        Preconditions.checkState(source == Source.PLAYER);
        return playerName;
    }

    public String npcName() {
        Preconditions.checkState(source == Source.BOSS || source == Source.NPC);
        return npcName;
    }

    public Duration killTime() {
        return killTime;
    }

    public int killTimeSeconds() {
        return (int) killTime.getSeconds();
    }

    public int killCount() {
        return killCount;
    }

    public int rewardPotential() {
        return rewardPotential;
    }

    public enum Source {
        NPC,
        BOSS,
        BOSS_PET,
        PLAYER,
        DUEL_WON,
        BARROWS
    }
}
