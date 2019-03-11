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
 * An event to be sent when an item is removed from the inventory.
 */
public class ItemRemoved extends ItemChanged {
    /**
     * The amount removed from the item's stack.
     */
    private final int decreaseAmount;
    /**
     * Whether or not the item was fully removed from the inventory.
     */
    private final boolean fullyRemoved;

    /**
     * Creates an event to indicate that an item was removed.
     *
     * @param currentItem  the current item in this slot.
     * @param previousItem the previous item in this slot.
     */
    public ItemRemoved(InventoryItem currentItem, InventoryItem previousItem) {
        super(currentItem.slot(), currentItem, previousItem, Type.REMOVED);
        this.decreaseAmount = previousItem.stackSize() - currentItem.stackSize();
        this.fullyRemoved = currentItem.stackSize() == 0;
    }

    /**
     * @return the amount removed from the item's stack.
     */
    public int decreaseAmount() {
        return decreaseAmount;
    }

    /**
     * @return true if the current item has a stack size of 0.
     */
    public boolean fullyRemoved() {
        return fullyRemoved;
    }

    @Override
    public String toString() {
        return "ItemRemoved{" +
                "decreaseAmount=" + decreaseAmount +
                ", fullyRemoved=" + fullyRemoved +
                '}';
    }
}
