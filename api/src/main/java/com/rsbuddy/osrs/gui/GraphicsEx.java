package com.rsbuddy.osrs.gui;

import java.awt.*;

public abstract class GraphicsEx extends Graphics2D {

    public abstract int stringWidth(String text);

    public abstract int fontHeight();

    public abstract int drawStringEx(String text, int x, int y, int width, TextAlign align, boolean shadow);

    public abstract int drawStringEx(String text, int x, int y, int width, TextAlign align);

    public abstract int drawStringEx(String text, int x, int y);

    public abstract int drawStringEx(String text, int x, int y, TextAlign align);

    public abstract String formatSeconds(int seconds);

    public abstract String formatTime(long time);

}
