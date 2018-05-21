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

package com.rsbuddy.osrs.event.inventory;

import com.rsbuddy.osrs.game.ui.InventoryItem;

/**
 * An event to show a change of an item in the inventory.
 */
public class ItemChanged {
    /**
     * The slot that the change affected.
     */
    private final InventoryItem.Slot slot;
    /**
     * The current item in this slot.
     */
    private final InventoryItem currentItem;
    /**
     * The previous item in this slot.
     */
    private final InventoryItem previousItem;
    /**
     * The type of change event.
     */
    private final Type type;

    /**
     * @param slot         the slot that the change affected.
     * @param currentItem  the current item in this slot.
     * @param previousItem the previous item in this slot.
     * @param type         the type of change event.
     */
    public ItemChanged(InventoryItem.Slot slot, InventoryItem currentItem, InventoryItem previousItem, Type type) {
        this.previousItem = previousItem;
        this.currentItem = currentItem;
        this.slot = slot;
        this.type = type;
    }

    /**
     * @return the slot that the event occurred in.
     */
    public InventoryItem.Slot slot() {
        return slot;
    }

    /**
     * @return the previous item in this slot.
     */
    public InventoryItem previousItem() {
        return previousItem;
    }

    /**
     * @return the current item in this slot.
     */
    public InventoryItem currentItem() {
        return currentItem;
    }

    /**
     * @return the type of change event.
     */
    public Type type() {
        return type;
    }

    /**
     * The types of events.
     * ADDED is for items added into the inventory.
     * REMOVED is for items taken out of the inventory.
     * MOVED is for moving items within the inventory.
     */
    public enum Type {
        ADDED, REMOVED, MOVED
    }
}
