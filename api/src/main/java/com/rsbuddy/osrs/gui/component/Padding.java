package com.rsbuddy.osrs.gui.component;

import com.rsbuddy.osrs.gui.GraphicsEx;

public class Padding extends BoxComponent {
    private int size;

    public Padding(int size) {
        this.size = size;
    }

    public int size() {
        return size;
    }

    @Override
    public int paintComponent(int width, GraphicsEx g) {
        return size();
    }
}
