/*
 * Copyright (c) 2018 RSBuddy Ltd. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *    * Neither the name of RSBuddy Ltd. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.rsbuddy.osrs.game.world;

import java.util.Objects;

/**
 * Represents an area within the RuneScape game.
 *
 * @author Matt
 */
public final class Area {

    public final int x;
    public final int y;
    public final int width;
    public final int height;

    // caching
    private Tile tile;
    private Tile min;
    private Tile max;

    public Area(final Tile t1, final Tile t2) {
        int x1 = Math.min(t1.x(), t2.x());
        int y1 = Math.min(t1.y(), t2.y());
        int x2 = Math.max(t1.x(), t2.x());
        int y2 = Math.max(t1.y(), t2.y());
        this.x = x1;
        this.y = y1;
        this.width = x2 - x1;
        this.height = y2 - y1;
    }

    public Area(int x1, int y1, int width, int height) {
        x = x1;
        y = y1;
        min = new Tile(x, y);
        this.width = width;
        this.height = height;
    }

    public boolean contains(final Locatable t, boolean inclusive) {
        int x = t.location().x();
        int y = t.location().y();
        int maxX = this.x + this.width;
        int maxY = this.y + this.height;

        if (inclusive) {
            maxX++;
            maxY++;
        }

        return x >= this.x && x < maxX && y >= this.y && y < maxY;
    }

    public boolean contains(final Locatable t) {
        return contains(t, false);
    }

    public Tile min() {
        if (min == null) {
            min = new Tile(x, y);
        }
        return min;
    }

    public Tile max() {
        if (max == null) {
            max = new Tile(x + width, y + width);
        }
        return max;
    }

    public Tile center() {
        if (tile == null) {
            tile = new Tile((int) (x + (double) (width / 2)), (int) (y + (double) (height / 2)));
        }
        return tile;
    }

    public String toString() {
        return x + " " + y + " " + width + " " + height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return x == area.x &&
                y == area.y &&
                width == area.width &&
                height == area.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, width, height);
    }
}
