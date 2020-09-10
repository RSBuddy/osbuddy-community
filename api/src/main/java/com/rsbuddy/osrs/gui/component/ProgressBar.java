package com.rsbuddy.osrs.gui.component;

import com.rsbuddy.osrs.gui.GraphicsEx;
import com.rsbuddy.osrs.gui.TextAlign;

import java.awt.*;

public class ProgressBar extends BoxComponent {
    public static final int DEFAULT_HEIGHT = 14;
    public static final int DEFAULT_OFFSET = 1;

    private static final int MAX_ANIMATION_TIME = 1000; // how long it takes to go from full hp to 0 hp

    private volatile long max;
    private volatile long current;

    private volatile long changeDetected = 0;
    private volatile long changedAmount = 0;
    private volatile int lastHash = 0;
    private volatile boolean positiveChange = false;

    private boolean showText = true;

    private int height;
    private int offset;

    protected Color backgroundColor = new Color(255, 0, 0, 80);
    protected Color foregroundColor = new Color(0, 255, 0, 80);
    protected Color gainColor = new Color(0, 255, 0, 80);
    protected Color loseColor = new Color(255, 255, 0, 80);
    protected Color textColor = Color.WHITE;

    /**
     * Initialise a new progress bar with a specified height and offset.
     *
     * @param height The height of the progress bar.
     * @param offset The offset (on both sides) the progress bar starts on.
     * */

    public ProgressBar(int height, int offset) {
        this.height = height;
        this.offset = offset;
    }

    public ProgressBar() {
        this(DEFAULT_HEIGHT, DEFAULT_OFFSET);
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public void setGainColor(Color gainColor) {
        this.gainColor = gainColor;
    }

    public void setLoseColor(Color loseColor) {
        this.loseColor = loseColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * Set whether or not text will be shown (i.e. current/max in the middle of the bar).
     *
     * @param showText The flag of whether or not to show the text.
     * */

    public void setShowText(boolean showText) {
        this.showText = showText;
    }

    /**
     * Reset the progress bar (i.e. set it's current and max without animating).
     *
     * @param current The current amount.
     * @param max The max of the progress bar.
     * */

    public void reset(long current, long max) {
        this.current = current;
        this.max = max;
    }

    /**
     * Set the max value and reset it if it is different.
     *
     * @param max The new (or existing) max.
     * */

    public final void setMax(long max) {
        if (this.max != max) {
            reset(current(), max);
        }
    }

    public long max() {
        return max;
    }

    /**
     * The default way of calculating the change amount. We want this to be overrideable in case something is happening where we don't want an animation.
     *
     * @param current The current value.
     * @return The delta.
     * */

    public long change(long current) {
        return current - this.current;
    }

    /**
     * Set the current value. If the value specified in the parameter differs from the stored current, it will animate.
     *
     * @param current The value to set.
     * */

    public final void setCurrent(long current) {
        if (this.current != current) {
            changeDetected = System.currentTimeMillis();
            changedAmount = change(current);
            positiveChange = changedAmount > 0;
            changedAmount = Math.abs(changedAmount);
        }
        this.current = current;
    }

    public String text() {
        return current + " / " + max;
    }

    public long current() {
        return current;
    }

    @Override
    public int paintComponent(int width, GraphicsEx g) {
        int height = 0;

        long max = max();

        if (max > 0) {
            setMax(max);

            long current = current();
            if (current != this.current) {
                setCurrent(current);
            }

            height = this.height;
            long now = System.currentTimeMillis();
            double percent = ((double) current) / ((double) max);

            if (percent > 1d) {
                percent = 1d;
            }

            final int totalRectWidth = (width - (offset * 2) + 1);
            final int startX = offset;
            final int barWidth = (int) (totalRectWidth * percent);

            g.setColor(backgroundColor);

            // pretend it's drawing along the top

            g.fillRect(startX + barWidth, 0, totalRectWidth - barWidth, height);

            int animationTime = (int) (((double) changedAmount) / ((double) max) * ((double) MAX_ANIMATION_TIME));
            if (now - changeDetected < animationTime && changedAmount <= max) {
                double progress = 1D - (double) (System.currentTimeMillis() - changeDetected) / (double) animationTime;
                double changePercent = (max <= 0 ? 0 : ((double) changedAmount / max));
                if (positiveChange) {
                    g.setColor(gainColor);
                    g.fillRect((barWidth + 1) - (int) (totalRectWidth * changePercent * progress), 0, (int) (totalRectWidth * changePercent * progress), height);
                } else if ((changedAmount + current) <= max) { // apply a special rule for subtraction
                    g.setColor(loseColor);
                    g.fillRect(barWidth + 1, 0, (int) (totalRectWidth * changePercent * progress), height);
                }
            }
            g.setColor(foregroundColor);
            g.fillRect(startX, 0, barWidth, height);
            if (showText) {
                g.setColor(textColor);
                g.drawStringEx(text(), 0, 11, width, TextAlign.CENTER);
            }
        }
        return height;
    }
}
