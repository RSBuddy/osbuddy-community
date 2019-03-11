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
 * An event to be sent when an item is added to the inventory.
 */
public class ItemAdded extends ItemChanged {
    /**
     * The amount added to the item's stack.
     */
    private final int increaseAmount;
    /**
     * Whether or not the previous stack size in this slot was 0.
     */
    private final boolean newAddition;

    /**
     * Creates an event to indicate that an item was added.
     *
     * @param currentItem  the current item in this slot.
     * @param previousItem the previous item in this slot.
     */
    public ItemAdded(InventoryItem currentItem, InventoryItem previousItem) {
        super(currentItem.slot(), currentItem, previousItem, Type.ADDED);
        this.increaseAmount = currentItem.stackSize() - previousItem.stackSize();
        this.newAddition = previousItem.stackSize() == 0;
    }

    /**
     * @return the amount added to the item's stack.
     */
    public int increaseAmount() {
        return increaseAmount;
    }

    /**
     * @return true if the previous item had a stack size of 0.
     */
    public boolean newAddition() {
        return newAddition;
    }

    @Override
    public String toString() {
        return "ItemAdded{" +
                "increaseAmount=" + increaseAmount +
                ", newAddition=" + newAddition +
                '}';
    }
}
