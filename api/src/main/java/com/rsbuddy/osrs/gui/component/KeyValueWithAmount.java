package com.rsbuddy.osrs.gui.component;

import com.rsbuddy.osrs.gui.GraphicsEx;
import com.rsbuddy.osrs.gui.TextAlign;

import java.awt.*;

public class KeyValueWithAmount extends KeyValue {

    private long primaryValue = -1;

    private long secondaryValue = -1;

    protected Color accentedColor2 = Color.GREEN;

    public void setSecondaryValue(int secondaryValue) {
        this.secondaryValue = secondaryValue;
    }

    public void setPrimaryValue(int primaryValue) {
        this.primaryValue = primaryValue;
    }

    public void accentedColor2(final Color color) {
        this.accentedColor2 = color;
    }

    public long primaryValue() {
        return primaryValue;
    }

    public long secondaryValue() {
        return secondaryValue;
    }

    @Override
    public int paintComponent(int width, GraphicsEx g) {
        if (font != null) {
            g.setFont(font);
        }

        int rowHeight = g.fontHeight() + 1;

        g.setColor(labelColor);
        g.drawStringEx(key(), 7, rowHeight - 1);

        String currentText = Long.toString(primaryValue());
        String baseText = "";
        if(secondaryValue() > 0) {
            baseText = "/" + secondaryValue();
        }

        g.setColor(accentedColor);
        g.drawStringEx(currentText, width - 7 - g.stringWidth(baseText), rowHeight - 1, -1, TextAlign.RIGHT);
        g.setColor(accentedColor2);
        g.drawStringEx(baseText, width - 7, rowHeight - 1, -1, TextAlign.RIGHT);

        return rowHeight;
    }
}
