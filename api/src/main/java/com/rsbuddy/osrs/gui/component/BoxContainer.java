package com.rsbuddy.osrs.gui.component;

import com.rsbuddy.osrs.gui.BoxEntry;
import com.rsbuddy.osrs.gui.DefaultColors;
import com.rsbuddy.osrs.gui.GraphicsEx;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.List;
import java.util.*;
import java.util.concurrent.Semaphore;

public class BoxContainer extends BoxComponent {
    // we want to use a semaphore because we don't want to block on the game thread and just skip execution if it's locked
    private final Semaphore lock = new Semaphore(1);

    protected List<BoxEntryContainer> components = new ArrayList<>(20);
    protected Collection<BoxEntry> cachedComponents = null;

    private int lastHeight = 0;

    private Color backgroundColor = DefaultColors.RS_BROWN_TRANSPARENT; // Default background

    private Color borderColor = DefaultColors.RS_BROWN_BORDER;

    public final void setBackground(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public final void setBorder(Color borderColor) {
        this.borderColor = borderColor;
    }

    public Collection<BoxEntry> components() {
        ArrayList<BoxEntry> components = new ArrayList<>();
        for (BoxEntryContainer component : this.components) {
            if (component != null) {
                components.add(component.entry);
            }
        }
        return Collections.unmodifiableList(components);
    }

    private final Map<Class<?>, Integer> metrics = new HashMap<>();
    private int currentMetric = 0;

    public void add(BoxEntry entry) {
        try {
            lock.acquire();
            try {
                // it fails because it doesn't work with prefabbed classes like Padding
                Integer metric = metrics.get(entry.getClass());
                if (metric == null) {
                    metric = ++currentMetric;
                    metrics.put(entry.getClass(), metric);
                }
                components.add(new BoxEntryContainer(entry, metric));
                cachedComponents = components();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            lock.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void remove(BoxEntry component) {
        try {
            lock.acquire();
            try {
                BoxEntryContainer foundContainer = null;

                for (BoxEntryContainer container : this.components) {
                    if (container.entry == component) {
                        foundContainer = container;
                        break;
                    }
                }

                // if we found the container, remove it otherwise it's not there
                if (foundContainer != null) {
                    components.remove(foundContainer);
                    // rebuild this
                    cachedComponents = components();
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
            lock.release();
        } catch (InterruptedException e) {
            // if this happens we have bigger problems on our hands
            e.printStackTrace();
        }
    }

    @Override
    public int paintComponent(int width, GraphicsEx g) {
        int height = 0;
        // also allow overriding of components so padding can be added by things interested in doing so automatically etc

        // try to acquire the lock in a non-blocking fashion so if it can't lock it just skips painting
        // realistically it shouldn't happen but you never know
        if (lock.tryAcquire()) {
            try {
                if (active()) {
                    // prevent plugin code from messing up the whole container
                    if (!(this instanceof MouseEntry)) {
                        if (backgroundColor != null) {
                            g.setColor(backgroundColor);
                            g.fillRect(0, 0, width + 1, lastHeight);
                        }
                        if (borderColor != null) {
                            g.setColor(borderColor);
                            g.drawRect(0, 0, width, lastHeight);
                        }
                    }

                    if (cachedComponents == null) {
                        cachedComponents = components();
                    }
                    AffineTransform transform = g.getTransform();
                    int baseX = 0, baseY = 0;
                    if (transform != null) {
                        baseX = (int) transform.getTranslateX();
                        baseY = (int) transform.getTranslateY();
                    }

                    for (BoxEntry component : cachedComponents) {
                        Color color = g.getColor();
                        Font font = g.getFont();
                        Composite composite = g.getComposite();
                        int componentHeight = component.paint(width, g);
                        int x = 0, y = 0;
                        if (transform != null) {
                            x = (int) transform.getTranslateX();
                            y = (int) transform.getTranslateY();
                        }
                        component.setBounds(x, y, width, componentHeight);
                        height += componentHeight;
                        g.translate(0, componentHeight);
                        if (g.getComposite() != composite) {
                            g.setComposite(composite);
                        }
                        g.setFont(font); // return font to as it was
                        g.setColor(color);
                    }
                    setBounds(baseX, baseY, width, height);
                    g.translate(0, -height);
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
            lock.release();
        }
        this.lastHeight = height;
        return height;
    }

    public static class BoxEntryContainer {
        public final BoxEntry entry;
        public final int metric;

        public BoxEntryContainer(final BoxEntry entry, final int metric) {
            this.entry = entry;
            this.metric = metric;
        }
    }
}
