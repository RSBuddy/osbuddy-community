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

public interface Actor extends Renderable, Locatable, ModelProvider {
    int LOCATION_SHIFT = 7;
    int MAX_HEALTH = 255;

    String name();

    String text();

    void setText(String text);

    int animation();

    Actor interacting();

    Object interactingRaw();

    int[] hitTimes();

    int[] hitDamages();

    int maxHealth();

    // the scale itself
    int healthBarScale();

    // the "raw" health bar amount that is out of healthBarScale
    int healthBarAmount();

    int damageTaken();

    boolean healthBarActive();

    /**
     * Whether or not the actor is at full health.
     * At present it is whether or not the health bar amount is == 255, but it can change in the future.
     *
     * @return true if they are at full health, false if they aren't.
     */
    boolean fullHealth();

    int health();

    int absHealth();

    int interactingIndex();

    boolean isInteracting();

    int localX();

    int localY();

    int angle();

    int x();

    int y();

    int floor();

    Tile location();

    int[] pathX();

    int[] pathY();

    Tile[] walkingQueue();

    Tile queuedTile();

    boolean fighting();

    int lastCombatTick();

    int hashCode();

    Model model();

    Object obj();

    int graphic();

    int pose();
}
