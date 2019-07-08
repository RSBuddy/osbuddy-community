/*
 * Copyright (c) 2018 RSBuddy Ltd. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *    * Neither the name of RSBuddy Ltd. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.rsbuddy.osrs.game;

import com.rsbuddy.osrs.event.*;
import com.rsbuddy.osrs.event.inventory.BackpackChanged;
import com.rsbuddy.osrs.event.inventory.InventoryUpdated;
import com.rsbuddy.osrs.event.inventory.ItemHovered;
import com.rsbuddy.osrs.event.world.GroundItemRemoved;
import com.rsbuddy.osrs.event.world.GroundItemUpdated;
import com.rsbuddy.osrs.game.chat.ClanChatUser;
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
    PLAYER_ANIMATED(AnimatePlayer.class),
    PLAYER_OVERHEAD_TEXT_UPDATED(PlayerOverheadTextUpdated.class),
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
    RENDER_TILE(Tile.class),
    SKILL_UPDATED(SkillUpdated.class),
    XP_DROP_CREATED(Integer.class),
    WIDGET_UPDATED(Integer.class),
    WIDGET_DRAW_END,
    GAME_STATE_CHANGED(false, GameStateChanged.class),
    MAP_REGIONS_CHANGED(MapRegionsChanged.class),
    INVENTORY_UPDATED(InventoryUpdated.class),
    BACKPACK_CHANGED(BackpackChanged.class),
    ITEM_HOVERED(ItemHovered.class),
    CLAN_CHAT_USER_CONNECTED(ClanChatUser.class),
    CLAN_CHAT_USER_DISCONNECTED(ClanChatUser.class),
    DEATH(DeathEvent.class)
    ;

    private final boolean loginCheck;
    private final Class<?> clazz;

    GameEvent(boolean loginCheck, Class<?> clazz) {
        this.loginCheck = loginCheck;
        this.clazz = clazz;
    }

    GameEvent(Class<?> clazz) {
        this(true, clazz);
    }

    GameEvent() {
        this(true, null);
    }

    public boolean loginCheck() {
        return loginCheck;
    }
}
