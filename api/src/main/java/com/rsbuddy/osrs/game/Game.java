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

import com.rsbuddy.osrs.content.config.AccountType;
import com.rsbuddy.osrs.game.chat.*;
import com.rsbuddy.osrs.game.config.Configs;
import com.rsbuddy.osrs.game.ui.Interfaces;
import com.rsbuddy.osrs.game.world.*;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.function.Function;

/**
 * The primary interface through which plugins can communicate with the game client.
 * It's possible to access the other game interfaces through the {@link Game} instance,
 * but they can also be injected directly by IoC.
 */
public interface Game extends Executor {

    /**
     * Runs a task on the game thread once.
     *
     * @param task The callback.
     * @param name A name for the task for profiling purposes.
     * @return The execution id of the submitted task which can be cancelled with {@link Game#cancel(int)}.
     */
    int once(Runnable task, String name);

    /**
     * Runs a task on the game thread each <tt>interval</tt>ms until it returns <tt>false</tt> or it is cancelled.
     * 
     * @param task The callback (which should return <tt>false</tt> to end execution).
     * @param interval The number of milliseconds between callbacks.
     * @param name A name for the task for profiling purposes.
     * @return The execution id of the submitted task which can be cancelled with {@link Game#cancel(int)}.
     */
    int loop(Callable<Boolean> task, long interval, String name);

    /**
     * Executes a task after each content tick until it returns <tt>false</tt> or it is cancelled.
     *
     * @param task The callback (which should return <tt>false</tt> to end execution).
     * @param name A name for the task for profiling purposes.
     * @return The execution id of the submitted task which can be cancelled with {@link Game#cancel(int)}.
     */
    int onContentTick(Callable<Boolean> task, String name);


    /**
     * Adds a listener for a particular type of task.
     *
     * @param task The callback which accepts T should return <tt>false</tt> to end execution.
     * @param name A name for the task for profiling purposes.
     * @return The execution id of the submitted task which can be cancelled with {@link Game#cancel(int)}.
     *
     * Note: It's important to only use whichever class is specified in the type parameter's {@link GameEvent#clazz}, or Object if one is not specified as the parameter will simply be null.
     */
    <T> int onGameEvent(GameEvent type, Function<T, Boolean> task, String name);

    /**
     * Cancels a task
     *
     * @param taskId The task execution id to cancel. See {@link Game#once(Runnable, String)} and {@link Game#loop(Callable, long, String)}.
     * @return Whether or not the task was cancelled successfully. This will return <tt>false</tt> if it was already cancelled or is an invalid task id.
     */
    boolean cancel(int taskId);

    /**
     * An object to access game configs (such as NPC and item metadata).
     * 
     * @return The singleton Configs interface.
     */
    Configs configs();

    /**
     * The local player's friends list.
     * 
     * @return A {@link PlayerRegistry} containing the friends.
     */
    PlayerRegistry<Friend> friends();

    /**
     * The local player's ignore list.
     *
     * @return A {@link PlayerRegistry} containing the ignores.
     */
    PlayerRegistry<Ignore> ignores();

    /**
     * The local player's clan chat.
     *
     * @return An object to access the clan chat.
     */
    ClanChat clanChat();

    /**
     * An object to access the game locations that are currently loaded.
     * 
     * @return An object to access game locations.
     */
    Locations locations();

    /**
     * An object to access the game's UI.
     * 
     * @return An object to access game UI.
     */
    Interfaces interfaces();

    /**
     * An object to access items that are currently on the ground.
     * 
     * @return An object to access ground items.
     */
    GroundItems items();

    /**
     * An object to interact with loot events.
     *
     * @return An object to interact with loot events.
     * */

    LootManager loot();

    /**
     * An object to access the context-sensitive right click menu ("mini-menu").
     * 
     * @return An object to access the minimenu.
     */
    MiniMenu miniMenu();

    /**
     * An object to access the loaded NPCs.
     * 
     * @return An object to access NPCs.
     */
    Npcs npcs();

    /**
     * An object to access the loaded players.
     * 
     * @return An object to access players.
     */
    Players players();

    /**
     * An object to access the loaded projectiles.
     *
     * @return An object to access projectiles.
     */
    Projectiles projectiles();

    /**
     * An object to access the variables that make up certain player settings
     * the player's state in various game content.
     * 
     * @return An object to access variables.
     */
    Variables vars();

    /**
     * An object to access the local player's skill levels and experience.
     * 
     * @return An object to access skills and experience.
     */
    Skills skills();

    /**
     * An object to access properties of the game's 3d rendering viewport
     * and compute various projections.
     * 
     * @return An object to access the viewport.
     */
    Viewport viewport();

    /**
     * An object to access the various inventories that are cached by the game client.
     *
     * @return An object to access the game inventories.
     */
    Inventories inventories();

    /**
     * An object to access map animations that are cached by the game client.
     *
     * @return  An object to access map animations.
     */
    MapAnims mapAnims();

    GameState state();

    boolean inGame();

    int currentWorld();

    boolean membersWorld();

    boolean resizable();

    boolean welcomeScreen();

    // 1/50th of a second
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

    int addChatMessage(final int type, final String sender, final String message);

    int addChatMessage(final int type, final String sender, final String message, final String prefix);

    int addSystemMessage(final String message);

    Tile flag();

    void setLoginMessage1(String message);

    void setLoginMessage2(String message);

    void setLoginMessage3(String message);

    String loginMessage1();

    String loginMessage2();

    String loginMessage3();

    void setCompassAngle(int angle);

    int topFloorToRender();

    int canvasWidth();

    int canvasHeight();

    void addMenuEntry(int actionParam0, int actionParam1, int typeId, int targetId, String action, String option);

    void swapMenuEntries(int index0, int index1);

    void duplicateMenuEntry(int index);

    void removeMenuEntry(int index);

    /**
     * Gets the {@link AccountType} for the currently logged in player.
     *
     * @return The player's {@code AccountType}
     */
    AccountType accountType();

    default Tile mapBase() {
        return new Tile(baseX(), baseY(), floor());
    }

}
