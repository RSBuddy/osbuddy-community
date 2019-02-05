package com.rsbuddy.osrs.game;

import com.rsbuddy.osrs.event.LootListener;
import com.rsbuddy.osrs.game.world.Loot;

public interface LootManager {

    boolean initialized();

    void addListener(LootListener listener);

    void removeListener(LootListener listener);

    void submitLoot(Loot loot);

}
