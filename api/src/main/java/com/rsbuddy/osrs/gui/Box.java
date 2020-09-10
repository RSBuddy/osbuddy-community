package com.rsbuddy.osrs.gui;

public interface Box {
    /**
     * Determine whether or not there are any active boxes in this box.
     * */

    boolean active();

    void add(BoxEntry component);

    void remove(BoxEntry component);

    void paint(GraphicsEx g);

    void setX(int x);

    void setY(int y);

    void setWidth(int width);

    int width();

    void setHeight(int height);

    int height();
}
