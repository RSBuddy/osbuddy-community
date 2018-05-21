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

package com.rsbuddy.osrs.util;

import com.rsbuddy.osrs.game.Game;
import com.rsbuddy.osrs.game.GameState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

public class GameTimer {

    private static final Logger log = LoggerFactory.getLogger("GameTimer");

    private final Timer timer;

    private Game game;

    private boolean running = true;

    public GameTimer(String name, Game game) {
        timer = new Timer(name + " Scheduler", true);
        this.game = game;
    }

    /**
     * Executes a task periodically.
     *
     * @param timing       The rate to execute the task
     * @param requireLogin Whether or not to skip executions when the player isn't logged in
     * @param callable     The task to execute
     */
    public void schedule(final int timing, final boolean requireLogin, final Callable<Boolean> callable) {
        if (running) {
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    try {
                        if (game.state() == GameState.LOGGED_IN || !requireLogin) {
                            if (!callable.call() && running){
                                cancel();
                            }
                        }
                    } catch (Exception e) {
                        log.error("Failed to perform scheduled task: {}", e.getMessage());
                    }
                }
            }, 0, timing);
        }
    }

    public void schedule(final int timing, final Callable<Boolean> callable) {
        schedule(timing, true, callable);
    }

    /**
     * Executes a task periodically.
     *
     * @param timing       The rate to execute the task
     * @param requireLogin Whether or not to skip executions when the player isn't logged in
     * @param runnable     The task to execute
     */
    public void schedule(final int timing, final boolean requireLogin, final Runnable runnable) {
        schedule(timing, requireLogin, () -> {
            try {
                if (game.state() == GameState.LOGGED_IN || !requireLogin) {
                    runnable.run();
                }
            } catch (Exception e) {
                log.error("Failed to perform scheduled task: {}", e.getMessage());
            }
            return true;
        });
    }

    /**
     * Executes a task periodically.
     *
     * @param timing   The rate to execute the task
     * @param runnable The task to execute
     */
    public void schedule(final int timing, final Runnable runnable) {
        schedule(timing, true, runnable);
    }

    /**
     * Executes a Runnable once after a specified delay. Ignores it if not logged in at the time!
     *
     * @param runnable     The task to (maybe) execute.
     * @param requireLogin Whether or not to skip executions when the player isn't logged in
     * @param delay        The amount of time in milliseconds to wait until the task is executed
     */
    public void submit(final Runnable runnable, final boolean requireLogin, long delay) {
        if (running) {
            timer.schedule(new TimerTask() {
                public void run() {
                    if (!requireLogin || game.state() == GameState.LOGGED_IN) {
                        runnable.run();
                    }
                }
            }, delay);
        }
    }

    /**
     * Forces any currently executing task to cease
     */
    public void shutdownActiveTasks() {
        running = false;
        timer.cancel();
    }
}