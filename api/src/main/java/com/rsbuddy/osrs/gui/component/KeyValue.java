package com.rsbuddy.osrs.gui.component;

import com.google.common.base.Preconditions;
import com.rsbuddy.osrs.gui.GraphicsEx;
import com.rsbuddy.osrs.gui.TextAlign;

import java.awt.*;

public class KeyValue extends BoxComponent {
    private static final int DEFAULT_PADDING = 7;

    protected Color accentedColor = Color.GREEN;
    protected Color labelColor = Color.WHITE;
    protected Font font;
    protected TextAlign valueAlignment = TextAlign.RIGHT;
    protected Point offset = new Point(DEFAULT_PADDING, 0);
    private String key;
    private String value;

    public KeyValue() {}

    public KeyValue(Font font) {
        this.font = font;
    }

    public KeyValue(Font font, String key, String value) {
        this.font = font;
        this.key = key;
        this.value = value;
    }

    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int paintComponent(int width, GraphicsEx g) {
        int rowHeight = g.fontHeight() + 1;
        int baseOff = rowHeight - 1;
        if (font != null) {
            g.setFont(font);
        }
        g.setColor(labelColor);
        String key = key();
        g.drawStringEx(key, offset.x, baseOff);
        g.setColor(accentedColor);
        Preconditions.checkState(valueAlignment != TextAlign.CENTER);
        if (valueAlignment == TextAlign.RIGHT) {
            g.drawStringEx(value(), width - offset.x, baseOff, -1, valueAlignment);
        } else if (valueAlignment == TextAlign.LEFT) {
            int keyWidth = g.stringWidth(key);
            g.drawStringEx(value(), offset.x + keyWidth, baseOff);
        }
        return rowHeight;
    }

    public String key() {
        return key;
    }

    public String value() {
        return value;
    }

    public KeyValue setLabelColor(Color labelColor) {
        this.labelColor = labelColor;
        return this;
    }

    public KeyValue setAccentedColor(Color accentedColor) {
        this.accentedColor = accentedColor;
        return this;
    }

    public KeyValue setKey(String key) {
        this.key = key;
        return this;
    }

    public KeyValue setValue(String value) {
        this.value = value;
        return this;
    }

    public KeyValue setFont(Font font) {
        this.font = font;
        return this;
    }

    @Deprecated
    public KeyValue setAlignment(int alignment) {
        this.valueAlignment = TextAlign.values()[alignment];
        return this;
    }

    public KeyValue setAlignment(TextAlign alignment) {
        this.valueAlignment = alignment;
        return this;
    }

    public KeyValue setOffsetX(int offsetX) {
        this.offset.x = offsetX;
        return this;
    }

    public KeyValue setOffsetY(int offsetY) {
        this.offset.y = offsetY;
        return this;
    }

    public KeyValue setOffset(int offsetX, int offsetY) {
        setOffsetX(offsetX);
        setOffsetY(offsetY);
        return this;
    }

}
