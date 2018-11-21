package com.rsbuddy.osrs.game;

import com.rsbuddy.osrs.event.AttackStyleUpdated;
import com.rsbuddy.osrs.event.MessageEvent;
import com.rsbuddy.osrs.event.SendChatMessage;
import com.rsbuddy.osrs.game.world.Npc;
//import com.rsbuddy.osrs.event.world.*;

/**
 * A list of game events along with the type of object that is able to be passed to {@link com.rsbuddy.osrs.annotation.OnGameEvent}-annotated methods.
 * */

public enum GameEvent {
    // uncommented as they are implemented
    // world
//    ANIMATION_CHANGED(AnimationChanged.class),
//    GROUND_ITEM_SPAWNED(GroundItemSpawned.class),
//    GROUND_ITEM_UPDATED(GroundItemUpdated.class),
//    GROUND_ITEM_REMOVED(GroundItemRemoved.class),
//    LOC_ADDED(LocAdded.class),
//    LOC_UPDATED(LocUpdated.class),
//    MAP_BUILD_END(MapBuildEnd.class),
    NPC_SPAWNED(Npc.class),
    NPC_DESPAWNED(Npc.class),
    // ~world
    ATTACK_STYLE_UPDATED(AttackStyleUpdated.class),
    CONTENT_TICK,
    CHAT_MESSAGE(MessageEvent.class),
    SEND_CHAT_MESSAGE(SendChatMessage.class),
    DRAW_LAYER(Integer.class),
    WIDGET_DRAW_END;

    // only here for verbosity
    private Class<?> clazz;

    GameEvent(Class<?> clazz) {
        this.clazz = clazz;
    }

    GameEvent() {
    }
}
