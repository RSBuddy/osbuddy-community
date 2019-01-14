package com.rsbuddy.osrs.game;

import com.rsbuddy.osrs.game.world.Loot;

import java.util.function.Consumer;

public interface LootManager {
    void addListener(Consumer<Loot> listener);

    void removeListener(Consumer<Loot> listener);

    void submitLoot(Loot loot);
}
