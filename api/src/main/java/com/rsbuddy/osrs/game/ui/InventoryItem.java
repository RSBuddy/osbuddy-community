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

package com.rsbuddy.osrs.game.ui;

import com.rsbuddy.osrs.game.Game;

import java.awt.*;

/**
 * A wrapper class for an item in the inventory.
 */
public final class InventoryItem {
    /**
     * An instance of the Game class.
     */
    private final Game game;
    /**
     * The item id.
     */
    private final int id;
    /**
     * The quantity of the item.
     */
    private final int stackSize;
    /**
     * The slot that contains the item in the inventory.
     */
    private final Slot slot;

    /**
     * Creates a wrapper for an item in the inventory.
     *
     * @param game      an instance of the game class.
     * @param id        the id of the item.
     * @param stackSize the quantity of the item.
     * @param slot      the slot that contains the item in the inventory.
     */
    public InventoryItem(Game game, int id, int stackSize, Slot slot) {
        this.game = game;
        this.id = id;
        this.stackSize = stackSize;
        this.slot = slot;
    }

    /**
     * @return the id of the item.
     */
    public int id() {
        return id;
    }

    /**
     * @return the name of the item.
     */
    public String name() {
        return game.itemCache().name(id);
    }

    /**
     * @return the size of the item's stack.
     */
    public int stackSize() {
        return stackSize;
    }

    /**
     * @return the slot that contains the item in the inventory.
     */
    public Slot slot() {
        return slot;
    }

    /**
     * @param object the object to compare with.
     * @return true if the Object is an instance of InventoryItem and the id, stackSize and slot are equal.
     */
    public boolean equals(Object object) {
        if (object instanceof InventoryItem) {
            InventoryItem item = (InventoryItem) object;
            return item.id == id && item.stackSize == stackSize && item.slot.equals(slot);
        } else {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        int result = id;
        result = 31 * result + stackSize;
        result = 31 * result + slot.hashCode();
        return result;
    }

    public String toString() {
        return id + " " + stackSize + " " + slot.area + " " + slot.position;
    }

    /**
     * A wrapper to represent a slot in the inventory.
     */
    public static class Slot {
        /**
         * The position of the slot in the inventory.
         */
        private final int position;
        /**
         * The area of the slot on the in-game screen.
         */
        private final Rectangle area;

        /**
         * Creates a wrapper for a slot in the inventory.
         *
         * @param position the position of the slot in the inventory.
         * @param area     the area of the slot in the inventory.
         */
        public Slot(int position, Rectangle area) {
            this.position = position;
            this.area = area;
        }

        /**
         * @return the position of the slot in the inventory.
         */
        public int position() {
            return position;
        }

        /**
         * @return the area of the slot on the in-game screen.
         */
        public Rectangle area() {
            return area;
        }

        /**
         * @param object the object to compare with.
         * @return true if the Object is an instance of Slot and the position is equal.
         */
        public boolean equals(Object object) {
            if (object instanceof Slot) {
                Slot slot = (Slot) object;
                return slot.position == position;
            } else {
                return false;
            }
        }

        /**
         * {@inheritDoc}
         */
        public int hashCode() {
            return position;
        }
    }
}
