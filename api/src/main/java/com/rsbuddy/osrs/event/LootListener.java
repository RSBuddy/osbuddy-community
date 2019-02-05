package com.rsbuddy.osrs.event;

import com.rsbuddy.osrs.game.world.Loot;

import java.util.List;

public interface LootListener {

    void addLoot(Loot event);

    default void addLoot(List<Loot> events) {}

}
