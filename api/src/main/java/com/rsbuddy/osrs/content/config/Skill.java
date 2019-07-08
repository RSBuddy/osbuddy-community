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

public enum Skill {

    ATTACK("Attack", 0, 1),
    DEFENCE("Defence", 1, 3),
    STRENGTH("Strength", 2, 2),
    HITPOINTS("Hitpoints", 3, 9),
    RANGED("Ranged", 4, 4),
    PRAYER("Prayer", 5, 5),
    MAGIC("Magic", 6, 6),
    COOKING("Cooking", 7, 20),
    WOODCUTTING("Woodcutting", 8, 22),
    FLETCHING("Fletching", 9, 14),
    FISHING("Fishing", 10, 19),
    FIREMAKING("Firemaking", 11, 21),
    CRAFTING("Crafting", 12, 13),
    SMITHING("Smithing", 13, 18),
    MINING("Mining", 14, 17),
    HERBLORE("Herblore", 15, 11),
    AGILITY("Agility", 16, 10),
    THIEVING("Thieving", 17, 12),
    SLAYER("Slayer", 18, 15),
    FARMING("Farming", 19, 23),
    RUNECRAFTING("Runecrafting", 20, 7),
    HUNTER("Hunter", 21, 16),
    CONSTRUCTION("Construction", 22, 8);

    private final String name;
    private final int index;
    private final int widgetId;

    Skill(String name, int index, int widgetId) {
        this.name = name;
        this.index = index;
        this.widgetId = widgetId;
    }

    public static Skill forName(String name) {
        for (Skill skill : values()) {
            if (skill.name.equalsIgnoreCase(name)) {
                return skill;
            }
        }
        return null;
    }

    public static Skill forIndex(int index) {
        for (Skill skill : values()) {
            if (skill.index == index) {
                return skill;
            }
        }
        return null;
    }

    public String skillName() {
        return name;
    }

    public int index() {
        return index;
    }

    public int widgetId() {
        return widgetId;
    }

}
