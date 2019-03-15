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

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Tile implements Locatable {

    @SerializedName("bx")
    private final int baseX;

    @SerializedName("by")
    private final int baseY;

    @SerializedName("x")
    private final int localX;

    @SerializedName("y")
    private final int localY;

    @SerializedName("floor")
    private final int floor;
    private Tile lastApplied = null;

    public Tile(int baseX, int baseY, int localX, int localY, int floor) {
        this.baseX = baseX;
        this.baseY = baseY;
        this.localX = localX;
        this.localY = localY;
        this.floor = floor;
    }

    public Tile(int localX, int localY, int floor) {
        this(0, 0, localX, localY, floor);
    }

    public Tile(int x, int y) {
        this(x, y, 0);
    }

    public int baseX() {
        return baseX;
    }

    public int baseY() {
        return baseY;
    }

    public int localX() {
        return localX;
    }

    public int localY() {
        return localY;
    }

    public int x() {
        return baseX + localX;
    }

    public int y() {
        return baseY + localY;
    }

    public int floor() {
        return floor;
    }

    public Tile location() {
        return this;
    }

    public Tile apply(int angle) {
        /*
      Apply an orientation to this tile and return it's result.
      Also cache it in case someone decides they're not going to be efficient.
      */
        if (lastApplied == null) {
            // 0 is 0x -1y
            // 2048 is the total rotation
            // want to make it 8 possible directions
            Tile resolvedTile = this;
            int bx = resolvedTile.baseX, by = resolvedTile.baseY;
            int lx = resolvedTile.localX, ly = resolvedTile.localY;
            int realAngle = Math.round(angle / 256f);
            switch (realAngle) {
                case 0: {
                    resolvedTile = new Tile(bx, by, lx, ly - 1, resolvedTile.floor);
                    break;
                }
                case 1: {
                    resolvedTile = new Tile(bx, by, lx - 1, ly - 1, resolvedTile.floor);
                    break;
                }
                case 2: {
                    resolvedTile = new Tile(bx, by, lx - 1, ly, resolvedTile.floor);
                    break;
                }
                case 3: {
                    resolvedTile = new Tile(bx, by, lx - 1, ly + 1, resolvedTile.floor);
                    break;
                }
                case 4: {
                    resolvedTile = new Tile(bx, by, lx, ly + 1, resolvedTile.floor);
                    break;
                }
                case 5: {
                    resolvedTile = new Tile(bx, by, lx + 1, ly + 1, resolvedTile.floor);
                    break;
                }
                case 6: {
                    resolvedTile = new Tile(bx, by, lx + 1, ly, resolvedTile.floor);
                    break;
                }
                case 7: {
                    resolvedTile = new Tile(bx, by, lx + 1, ly - 1, resolvedTile.floor);
                    break;
                }
                case 8: {
                    resolvedTile = new Tile(bx, by, lx, ly - 1, resolvedTile.floor);
                    break;
                }
            }
            lastApplied = resolvedTile;
        }

        return lastApplied;
    }

    public int distanceTo(int x, int y) {
        return (int) Math.sqrt(Math.pow(x - this.x(), 2) + Math.pow(y - this.y(), 2));
    }

    public int distanceTo(Tile tile) {
        return distanceTo(tile.x(), tile.y());
    }

    public int distanceTo(Locatable locatable) {
        return distanceTo(locatable.location());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return baseX == tile.baseX &&
                baseY == tile.baseY &&
                localX == tile.localX &&
                localY == tile.localY &&
                floor == tile.floor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseX, baseY, localX, localY, floor);
    }

    public String toString() {
        return "(" + x() + ", " + y() + ", " + floor + ")";
    }
}
