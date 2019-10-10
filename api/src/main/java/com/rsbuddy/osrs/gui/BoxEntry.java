package com.rsbuddy.osrs.gui;

import java.awt.*;

public interface BoxEntry {

    default Rectangle bounds() { return null; }

    default void setBounds(int x, int y, int width, int height) {}

    int paint(int width, GraphicsEx g);

}
