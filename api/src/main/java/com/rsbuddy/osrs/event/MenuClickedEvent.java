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

package com.rsbuddy.osrs.event;

import com.rsbuddy.osrs.game.MiniMenuEntry;

public class MenuClickedEvent {
    private final MiniMenuEntry target;

    private final int actionParam0;
    private final int actionParam1;
    private final int targetId;
    private final int x;
    private final int y;
    private final String action;
    private int typeId;
    private String option;

    private boolean consumed = false;

    public MenuClickedEvent(MiniMenuEntry target, int actionParam0, int actionParam1, int typeId, int targetId, int x, int y, String action, String option) {
        this.target = target;
        this.actionParam0 = actionParam0;
        this.actionParam1 = actionParam1;
        this.typeId = typeId;
        this.targetId = targetId;
        this.x = x;
        this.y = y;
        this.action = action;
        this.option = option;
    }

    public MiniMenuEntry target() {
        return target;
    }

    public String action() {
        return action;
    }

    public String option() {
        return option;
    }

    public MenuClickedEvent setOption(String option) {
        this.option = option;
        return this;
    }

    public void consume() {
        consumed = true;
    }

    public boolean consumed() {
        return consumed;
    }

    public boolean fake() {
        return typeId == 1951;
    }

    public int typeId() {
        return typeId;
    }

    public MenuClickedEvent setTypeId(int typeId) {
        this.typeId = typeId;
        return this;
    }

    public int actionParam0() {
        return actionParam0;
    }

    public int actionParam1() {
        return actionParam1;
    }

    public String toString() {
        return "MenuClickedEvent{" +
                "target=" + target +
                ", actionParam0=" + actionParam0 +
                ", actionParam1=" + actionParam1 +
                ", typeId=" + typeId +
                ", targetId=" + targetId +
                ", x=" + x +
                ", y=" + y +
                ", action='" + action + '\'' +
                ", option='" + option + '\'' +
                ", consumed=" + consumed +
                '}';
    }
}
