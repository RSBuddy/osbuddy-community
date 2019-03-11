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
 * An event to be sent when an item is moved within the inventory.
 */
public class ItemMoved extends ItemChanged {
    /**
     * The slot that the item was moved from.
     */
    private final InventoryItem.Slot previousSlot;

    /**
     * Creates an event to indicate that an item was moved.
     *
     * @param currentItem  the current item in this slot.
     * @param previousItem the previous item in this slot.
     * @param previousSlot the slot that the item was moved from.
     */
    public ItemMoved(InventoryItem currentItem, InventoryItem previousItem, InventoryItem.Slot previousSlot) {
        super(currentItem.slot(), currentItem, previousItem, Type.MOVED);
        this.previousSlot = previousSlot;
    }

    /**
     * @return the slot that the item came from.
     */
    public InventoryItem.Slot previousSlot() {
        return previousSlot;
    }

    @Override
    public String toString() {
        return "ItemMoved{" +
                "previousSlot=" + previousSlot +
                '}';
    }
}
