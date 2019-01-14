package com.rsbuddy.osrs.game;

import com.rsbuddy.osrs.event.*;
import com.rsbuddy.osrs.event.world.GroundItemRemoved;
import com.rsbuddy.osrs.event.world.GroundItemUpdated;
import com.rsbuddy.osrs.game.world.GroundItem;
import com.rsbuddy.osrs.game.world.Loot;
import com.rsbuddy.osrs.game.world.Npc;
//import com.rsbuddy.osrs.event.world.*;

/**
 * A list of game events along with the type of object that is able to be passed to {@link com.rsbuddy.osrs.annotation.OnGameEvent}-annotated methods.
 * */

public enum GameEvent {
    // uncommented as they are implemented
    // world
//    ANIMATION_CHANGED(AnimationChanged.class),
    GROUND_ITEM_SPAWNED(GroundItem.class),
    GROUND_ITEM_UPDATED(GroundItemUpdated.class),
    GROUND_ITEM_REMOVED(GroundItemRemoved.class),
//    LOC_ADDED(LocAdded.class),
//    LOC_UPDATED(LocUpdated.class),
//    MAP_BUILD_END(MapBuildEnd.class),
    NPC_SPAWNED(Npc.class),
    NPC_DESPAWNED(Npc.class),
    LOOT_RECEIVED(Loot.class),
    // ~world
    ATTACK_STYLE_UPDATED(AttackStyleUpdated.class),
    CONTENT_TICK,
    CHAT_MESSAGE(MessageEvent.class),
    SEND_CHAT_MESSAGE(SendChatMessage.class),
    CHAT_SHORTCUT(ChatShortcut.class),
    DRAW_LAYER(Integer.class),
    WIDGET_DRAW_END;

    private Class<?> clazz;

    GameEvent(Class<?> clazz) {
        this.clazz = clazz;
    }

    GameEvent() {
    }
}
