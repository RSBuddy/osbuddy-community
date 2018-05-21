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

import com.rsbuddy.osrs.game.ui.Component;
import com.rsbuddy.osrs.game.ui.InventoryItem;
import com.rsbuddy.osrs.game.world.GroundItem;

import java.lang.ref.WeakReference;

public class MiniMenuEntry<T> {

    private final String verb;
    private final String noun;
    private final Type type;
    private final int opcode;

    private WeakReference<T> target;

    public MiniMenuEntry(String verb, String noun, Type type, T target) {
        this.verb = verb;
        this.noun = noun;
        this.type = type;
        this.opcode = type.virtualOpcode;
        this.target = new WeakReference<>(target);
    }

    public MiniMenuEntry(String verb, String noun, Type type, int opcode, T target) {
        this.verb = verb;
        this.noun = noun;
        this.type = type;
        this.opcode = opcode;
        this.target = new WeakReference<>(target);
    }

    public String verb() {
        return verb;
    }

    public String noun() {
        return noun;
    }

    public Type type() {
        return type;
    }

    public T target() {
        return target.get();
    }

    public int opcode() {
        return opcode;
    }

    /**
     * Get the item id if it's an item component or a ground item.
     *
     * @return The item id of the clicked target or whatever.
     */
    public int itemId() {
        switch (type) {
            case INVENTORY_ITEM: {
                InventoryItem item = (InventoryItem)target.get();
                if (item != null) return item.id();
            }
            case WIDGET: {
                Component component = (Component)target.get();
                if (component != null) return component.itemId();
            }
            case GROUND_ITEM: {
                GroundItem item = (GroundItem)target.get();
                if (item != null) return item.id();
            }
        }
        return -1;
    }

    public String toString() {
        return String.valueOf(target.get());
    }

    public enum Type {
        GAME_OBJECT(1940),
        GROUND_ITEM(1941),
        INVENTORY_ITEM(1942),
        NPC(1943),
        PLAYER(1944),
        WIDGET(1945),
        OTHER(1946)
        ;

        Type(int virtualOpcode) {
            this.virtualOpcode = virtualOpcode;
        }

        /**
         * The opcode to use when creating an entry with {@link MiniMenu#addEntry(MiniMenuEntry)}.
         * Will not be passed back into the game client.
         */
        public final int virtualOpcode;
    }
}
