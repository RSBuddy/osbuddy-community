package com.rsbuddy.osrs.game;

import com.rsbuddy.osrs.event.*;
import com.rsbuddy.osrs.event.world.GroundItemRemoved;
import com.rsbuddy.osrs.event.world.GroundItemUpdated;
import com.rsbuddy.osrs.game.world.*;
//import com.rsbuddy.osrs.event.world.*;

/**
 * A list of game events along with the type of object that is able to be passed to {@link com.rsbuddy.osrs.annotation.OnGameEvent}-annotated methods.
 * */

public enum GameEvent {
    // world
    GROUND_ITEM_SPAWNED(GroundItem.class),
    GROUND_ITEM_UPDATED(GroundItemUpdated.class),
    GROUND_ITEM_REMOVED(GroundItemRemoved.class),
    NPC_SPAWNED(Npc.class),
    NPC_DESPAWNED(Npc.class),
    PLAYER_SPAWNED(Player.class),
    PLAYER_DESPAWNED(Player.class),
    LOOT_RECEIVED(Loot.class),
    LOCATION_CREATED(Location.class),
    LOCATION_REMOVED(Location.class),
    // ~world
    ATTACK_STYLE_UPDATED(AttackStyleUpdated.class),
    CONTENT_TICK,
    CHAT_MESSAGE(MessageEvent.class),
    SEND_CHAT_MESSAGE(SendChatMessage.class),
    CHAT_SHORTCUT(ChatShortcut.class),
    DRAW_LAYER(Integer.class),
    SKILL_UPDATED(SkillUpdated.class),
    WIDGET_UPDATED(Integer.class),
    WIDGET_DRAW_END;

    private Class<?> clazz;

    GameEvent(Class<?> clazz) {
        this.clazz = clazz;
    }

    GameEvent() {
    }
}
