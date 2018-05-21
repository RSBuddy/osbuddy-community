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

package com.rsbuddy.osrs.game;

import com.rsbuddy.osrs.game.chat.*;
import com.rsbuddy.osrs.game.config.Configs;
import com.rsbuddy.osrs.game.ui.Interfaces;
import com.rsbuddy.osrs.game.world.*;

import javax.inject.Singleton;
import java.util.concurrent.Callable;

/**
 * The primary interface through which plugins can communicate with the game client.
 * It's possible to access the other game interfaces through the {@link Game} instance,
 * but they can also be injected directly by IoC.
 */
@Singleton
public interface Game {

    void once(Runnable task, String name);

    void loop(Callable<Boolean> task, long interval, String name);

    Configs configs();

    Camera camera();

    PlayerRegistry<Friend> friends();

    PlayerRegistry<Ignore> ignores();

    ClanChat clanChat();

    Locations locations();

    Interfaces interfaces();

    GroundItems items();

    MiniMenu miniMenu();

    Npcs npcs();

    Players players();

    Projectiles projectiles();

    Variables vars();

    Skills skills();

    Viewport viewport();

    Inventories inventories();

    GameState state();

    boolean inGame();

    int currentWorld();

    boolean membersWorld();

    boolean resizable();

    boolean welcomeScreen();

    int time();

    int energy();

    int baseX();

    int baseY();

    int floor();

    int[][][] groundHeights();

    byte[][][] groundSettings();

    ChatLine[] chatLines();

    int localPlayerIndex();

    void setFov(int fov);

    int fov();

    int compassAngle();

    String loginName();

    int adminLevel();

    void doCommand(String s);

    boolean worldSelectShown();

    void setWorldSelectShown(boolean show);

    int fps();

    void setChatboxMessage(final String text);

    String chatboxMessage();

    void addChatMessage(final int type, final String sender, final String message);

    void addChatMessage(final int type, final String sender, final String message, final String prefix);

    void addSystemMessage(final String message);

    Tile flag();

    void setLoginMessage1(String message);

    void setLoginMessage2(String message);

    void setLoginMessage3(String message);

    String loginMessage1();

    String loginMessage2();

    String loginMessage3();

    void setCompassAngle(int angle);

    int topFloorToRender();

}
