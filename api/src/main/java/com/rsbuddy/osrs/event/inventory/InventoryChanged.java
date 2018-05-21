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

import java.util.List;

/**
 * An event that stores all of the changes to the inventory.
 */
public final class InventoryChanged {
    /**
     * A list of events for items added to the inventory.
     */
    private final List<ItemAdded> addedEvents;
    /**
     * A list of events for items removed from the inventory.
     */
    private final List<ItemRemoved> removedEvents;
    /**
     * A list of events for items moved within the inventory.
     */
    private final List<ItemMoved> movedEvents;

    private final List<ItemChanged> replacedEvents;

    /**
     * Creates a new InventoryChanged event.
     *
     * @param addedEvents   the events for items added to the inventory.
     * @param removedEvents the events for items removed from the inventory.
     * @param movedEvents   the events for items moved within the inventory.
     */
    public InventoryChanged(List<ItemAdded> addedEvents, List<ItemRemoved> removedEvents,
                            List<ItemMoved> movedEvents, List<ItemChanged> replacedEvents) {
        this.addedEvents = addedEvents;
        this.removedEvents = removedEvents;
        this.movedEvents = movedEvents;
        this.replacedEvents = replacedEvents;
    }

    /**
     * @return the events for items added to the inventory.
     */
    public List<ItemAdded> addedEvents() {
        return addedEvents;
    }

    /**
     * @return the events for items removed from the inventory.
     */
    public List<ItemRemoved> removedEvents() {
        return removedEvents;
    }

    /**
     * @return the events for items moved within the inventory.
     */
    public List<ItemMoved> movedEvents() {
        return movedEvents;
    }

    public List<ItemChanged> replacedEvents() {
        return replacedEvents;
    }

}
