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

public enum Diary {

    ARDOUGNE(4458, 4459, 4460, 4461),
    DESERT(4483, 4484, 4485, 4486),
    FALADOR(4462, 4463, 4464, 4465),
    FREMENNIK(4491, 4492, 4493, 4494),
    KANDARIN(4475, 4476, 4477, 4478),
    KARAMJA(3578, 3599, 3611, 4566),
    LUMBRIDGE(4495, 4496, 4497, 4498),
    MORYTANIA(4487, 4488, 4489, 4490),
    VARROCK(4479, 4480, 4481, 4482),
    WESTERN(4471, 4472, 4473, 4474),
    WILDERNESS(4466, 4467, 4468, 4469);

    private final VarbitId[] varbits;

    Diary(int... varbits) {
        this.varbits = new VarbitId[varbits.length];
        for (int i = 0; i < varbits.length; ++i) {
            this.varbits[i] = new VarbitId(varbits[i]);
        }
    }

    public VarbitId easy() {
        return varbits[0];
    }

    public VarbitId medium() {
        return varbits[1];
    }

    public VarbitId hard() {
        return varbits[2];
    }

    public VarbitId elite() {
        return varbits[3];
    }

    public VarbitId[] varbits() {
        return varbits;
    }

}