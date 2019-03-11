package com.rsbuddy.osrs.event.inventory;

import com.rsbuddy.osrs.game.ui.InventoryItem;


public class ItemHovered {
    private final int index;
    private final InventoryItem item;

    public ItemHovered(int index, InventoryItem item) {
        this.index = index;
        this.item = item;
    }

    public int index() {
        return index;
    }

    public boolean isItemPresent() {
        return item != null;
    }

    public InventoryItem item() {
        return item;
    }
}
