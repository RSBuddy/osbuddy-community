package com.rsbuddy.osrs.gui.component;

import com.rsbuddy.osrs.gui.GraphicsEx;
import com.rsbuddy.osrs.gui.TextAlign;

import java.awt.*;

public class Text extends BoxComponent {
    // either set it or constantly poll it

    private String text;

    protected Image image;
    protected Font font = null;
    protected Color color = null;
    protected TextAlign alignment = TextAlign.CENTER;
    protected Point offset = new Point(0, 0);
    protected int verticalPadding = 1;
    protected int imageWidth = 0;

    public Text(Font font) {
        this.font = font;
    }

    public Text(Font font, String text) {
        this.font = font;
        this.text = text;
    }

    public Text(String text) {
        this.text = text;
    }

    public Text() {
        this("");
    }

    @Override
    public int paintComponent(int width, GraphicsEx g) {
        paintIcon(g);
        g.setColor(color != null ? color : Color.WHITE);
        if (font != null) {
            g.setFont(font);
        }
        int fontHeight = g.fontHeight();
        g.drawStringEx(text(), offset.x + imageWidth, fontHeight + offset.y, width, alignment);
        return fontHeight + verticalPadding + offset.y;
    }

    public String text() {
        return text;
    }

    public Text setFont(Font font) {
        this.font = font;
        return this;
    }

    public Text setColor(Color color) {
        this.color = color;
        return this;
    }

    @Deprecated
    public Text setAlignment(int alignment) {
        this.alignment = TextAlign.values()[alignment];
        return this;
    }

    public Text setAlignment(TextAlign alignment) {
        this.alignment = alignment;
        return this;
    }

    public Text setOffsetX(int offsetX) {
        this.offset.x = offsetX;
        return this;
    }

    public Text setOffsetY(int offsetY) {
        this.offset.y = offsetY;
        return this;
    }

    public Text setOffset(int offsetX, int offsetY) {
        setOffsetX(offsetX);
        setOffsetY(offsetY);
        return this;
    }

    public Text setVerticalPadding(int verticalPadding) {
        this.verticalPadding = verticalPadding;
        return this;
    }

    public Text setImage(final Image image) {
        this.image = image;
        this.imageWidth = this.image.getWidth(null) + 4;
        return this;
    }

    protected void paintIcon(final Graphics2D g) {
        if (image != null) {
            g.drawImage(image, offset.x, offset.y, null);
        }
    }
}
