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

package com.rsbuddy.osrs.content.config;

public enum Prayer {

    THICK_SKIN(1, 83, 0, 1d / 12d),
    BURST_OF_STRENGTH(4, 83, 1, 1d / 12d),
    CLARITY_OF_THOUGHT(7, 83, 2, 1d / 12d),
    SHARP_EYE(8, 83, 18, 1d / 12d),
    MYSTIC_WILL(9, 83, 19, 1d / 12d),

    ROCK_SKIN(10, 83, 3, 1d / 6d),
    SUPERHUMAN_STRENGTH(13, 83, 4, 1d / 6d),
    IMPROVED_REFLEXES(16, 83, 5, 1d / 6d),

    RAPID_RESTORE(19, 83, 6, 1d / 26d),
    RAPID_HEAL(22, 83, 7, 1d / 18d),

    PROTECT_ITEMS(25, 83, 8, 1d / 18d),

    HAWK_EYE(26, 83, 20, 1d / 6d),
    MYSTIC_LORE(27, 83, 21, 1d / 6d),

    STEEL_SKIN(28, 83, 9, 1d / 3d),
    ULTIMATE_STRENGTH(31, 83, 10, 1d / 3d),
    INCREDIBLE_REFLEXES(34, 83, 11, 1d / 3d),
    PROTECT_FROM_MAGIC(37, 83, 12, 1d / 3d),
    PROTECT_FROM_MISSILES(40, 83, 13, 1d / 3d),
    PROTECT_FROM_MELEE(43, 83, 14, 1d / 3d),
    EAGLE_EYE(44, 83, 22, 1d / 3d),
    MYSTIC_MIGHT(45, 83, 23, 1d / 3d),

    RETRIBUTION(46, 83, 15, 1d / 12d),
    REDEMPTION(49, 83, 16, 1d / 6d),
    SMITE(52, 83, 17, 1d / 1.8d),

    CHIVALRY(60, 83, 25, 1d / 1.8d),
    PIETY(70, 83, 26, 1d / 1.5d),

    PRESERVE(55, 83, 28, 1 / 12d),
    RIGOUR(74, 83, 24, 1 / 1.5d),
    AUGURY(77, 83, 27, 1 / 1.5d);

    private final int level;
    private final int varId;
    private final int bitId;
    private final double drainRate;

    Prayer(final int level, final int varId, final int bitId, final double drainRate) {
        this.level = level;
        this.varId = varId;
        this.bitId = bitId;
        this.drainRate = drainRate;
    }

    public int level() {
        return level;
    }

    public int varId() {
        return varId;
    }

    public int bitId() {
        return bitId;
    }

    public double drainRate() {
        return drainRate;
    }

}

