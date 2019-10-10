package com.rsbuddy.osrs.gui.component;

import com.rsbuddy.osrs.gui.BoxEntry;
import com.rsbuddy.osrs.gui.GraphicsEx;

import java.awt.*;

public abstract class BoxComponent implements BoxEntry {

    private boolean active = true;

    private final Rectangle bounds = new Rectangle();

    @Override
    public Rectangle bounds() {
        return bounds;
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        bounds.x = x;
        bounds.y = y;
        bounds.width = width;
        bounds.height = height;
    }

    @Override
    public final int paint(int width, GraphicsEx g) {
        return active() ? paintComponent(width, g) : 0;
    }

    public final void setActive(boolean active) {
        this.active = active;
    }

    public final boolean active() {
        return active = componentActive();
    }

    public final boolean lastActive() {
        return active;
    }

    protected boolean componentActive() {
        return active;
    }

    public abstract int paintComponent(int width, GraphicsEx g);

}
