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

package com.rsbuddy.osrs.content.ui;

import com.rsbuddy.osrs.content.config.InventoryId;
import com.rsbuddy.osrs.game.Inventories;
import com.rsbuddy.osrs.game.Inventory;
import com.rsbuddy.osrs.game.ui.Component;
import com.rsbuddy.osrs.game.ui.Interfaces;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Singleton
public class Bank {

    public static final int PLAYER_INVENTORY_IFID = 15;
    public static final int PLAYER_INVENTORY_COMPONENT = 3;

    public static final int PIN_IFID = 213;

    public static final int IFID = 12;
    public static final int TABS_COMPONENT = 10;
    public static final int MODAL_COMPONENT = 11;
    public static final int INVENTORY_COMPONENT = 12;
    public static final int SEARCH_BUTTON_COMPONENT = 39;
    public static final int ITEM_COUNT_COMPONENT = 5;
    public static final int TITLE_COMPONENT = 4;
    public static final int TAB_SEPARATOR_CHILD = 800;
    public static final int TAB_SEPARATOR_COUNT = 9;

    private final Interfaces interfaces;
    private final Inventories inventories;

    @Inject
    public Bank(Inventories inventories, Interfaces interfaces) {
        this.inventories = inventories;
        this.interfaces = interfaces;
    }

    public boolean open() {
        return inventory() != null;
    }

    public boolean pinScreenOpen() {
        Component component = interfaces.component(PIN_IFID, 0);
        return component != null && component.visible();
    }

    public Component component() {
        return interfaces.component(IFID, INVENTORY_COMPONENT);
    }

    public Collection<Component> slots() {
        final List<Component> items = new LinkedList<>();

        int max = itemCount();
        if (max == -1) {
            return items;
        }

        Component component = component();
        for (Component child : component.children()) {
            if (child.childId() > max) {
                break;
            }
            if (child.itemId() > 0 && child.visible()) {
                items.add(child);
            }
        }
        return items;
    }

    public int itemCount() {
        if (open()) {
            Component component = interfaces.component(IFID, ITEM_COUNT_COMPONENT);
            if (component != null && !component.text().isEmpty()) {
                return Integer.parseInt(component.text());
            }
        }
        return -1;
    }

    public Inventory inventory() {
        return inventories.get(InventoryId.BANK);
    }

    public int[] itemIds() {
        final Inventory inventory = inventory();
        if (inventory != null) {
            return inventory.items();
        }
        return new int[0];
    }

    public int[] itemStacks() {
        final Inventory inventory = inventory();
        if (inventory != null) {
            return inventory.stacks();
        }
        return new int[0];
    }

    public void setItemStack(int position, int size) {
        if (position < 0 || position > 27) {
            return;
        }
        if (open()) {
            Component inventory = interfaces.component(PLAYER_INVENTORY_IFID, PLAYER_INVENTORY_COMPONENT);

            Component child = inventory.child(position);

            if (child != null) {
                child.setItemStack(size);
            }
        }
    }
}