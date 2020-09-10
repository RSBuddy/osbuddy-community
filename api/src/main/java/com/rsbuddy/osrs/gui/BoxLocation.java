package com.rsbuddy.osrs.gui;

import java.awt.*;

public enum BoxLocation {
    LEFT("left", new Rectangle(5, 23, 126, 1000)),
    RIGHT("right", new Rectangle(389, 23, 126, 1000)),
    TOP("top", new Rectangle(23, 0, 382, 50));

    public final String name;
    public final Rectangle area;

    BoxLocation(String name, Rectangle area) {
        this.name = name;
        this.area = area;
    }

    public Rectangle area() {
        return area;
    }

    public static BoxLocation forString(String string) {
        if (string != null) {
            string = string.toLowerCase();
            for (BoxLocation value : BoxLocation.values()) {
                if (value.name.equals(string)) {
                    return value;
                }
            }
        }
        return BoxLocation.LEFT;
    }
}
