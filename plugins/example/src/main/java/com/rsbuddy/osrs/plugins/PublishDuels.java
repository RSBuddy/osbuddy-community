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

package com.rsbuddy.osrs.plugins;

import com.google.common.eventbus.Subscribe;
import com.rsbuddy.discord.RichEmbed;
import com.rsbuddy.discord.WebhookMessage;
import com.rsbuddy.osrs.Plugin;
import com.rsbuddy.osrs.PluginContext;
import com.rsbuddy.osrs.annotation.OnContentTick;
import com.rsbuddy.osrs.annotation.OnGameEvent;
import com.rsbuddy.osrs.annotation.Setting;
import com.rsbuddy.osrs.event.MessageEvent;
import com.rsbuddy.osrs.event.SettingUpdated;
import com.rsbuddy.osrs.game.GameEvent;
import com.rsbuddy.osrs.game.ui.Component;
import com.rsbuddy.osrs.game.ui.Interfaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

import static com.rsbuddy.discord.PostWebhook.postWebhook;

public class PublishDuels implements Plugin  {

    private static final Logger log = LoggerFactory.getLogger(PublishDuels.class);

    private static final int DUEL_RESULT_IFID = 372;
    private static final int DUEL_WINNER_NAME = 7;
    private static final int DUEL_WINNER_LVL = 6;
    private static final int DUEL_DEFEATED_NAME = 3;
    private static final int DUEL_DEFEATED_LVL = 2;
    private static final int DUEL_STAKED_PLAT = 35;
    private static final int DUEL_STAKED_GOLD = 37;
    private static final int DUEL_STAKED_TOTAL = 32;
    private static final int DUEL_TAX_RATE = 38;
    private static final int DUEL_TAX_TOTAL = 39;
    private static final int DUEL_WINNINGS = 40;

    private URL webhookUrl = null;

    private int tick = 0;
    private int endTick = 0;
    private boolean captureDuel = false;
    private boolean wonDuel = false;

    @Setting("webhookUrlString")
    private String webhookUrlString;

    @Inject private PluginContext ctx;
    @Inject private Interfaces interfaces;

    @Override
    public void init(PluginContext ctx) {
        try {
            webhookUrl = new URL(webhookUrlString);
        } catch (MalformedURLException e) {
            log.error("Malformed URL", e);
        }
    }

    @Override
    public void dispose(PluginContext ctx) {

    }

    @OnContentTick
    public void tick() {
        if (captureDuel && tick > endTick) {
            captureDuel = false;

            Component winnerNameCmp = interfaces.component(DUEL_RESULT_IFID, DUEL_WINNER_NAME);
            Component winnerLvlCmp = interfaces.component(DUEL_RESULT_IFID, DUEL_WINNER_LVL);
            Component defeatedNameCmp = interfaces.component(DUEL_RESULT_IFID, DUEL_DEFEATED_NAME);
            Component defeatedLvlCmp = interfaces.component(DUEL_RESULT_IFID, DUEL_DEFEATED_LVL);
            Component stakedPlatCmp = interfaces.component(DUEL_RESULT_IFID, DUEL_STAKED_PLAT);
            Component stakedGoldCmp = interfaces.component(DUEL_RESULT_IFID, DUEL_STAKED_GOLD);
            Component stakedTotalCmp = interfaces.component(DUEL_RESULT_IFID, DUEL_STAKED_TOTAL);
            Component taxRateCmp = interfaces.component(DUEL_RESULT_IFID, DUEL_TAX_RATE);
            Component taxTotalCmp = interfaces.component(DUEL_RESULT_IFID, DUEL_TAX_TOTAL);
            Component winningsCmp = interfaces.component(DUEL_RESULT_IFID, DUEL_WINNINGS);

            if (notNull(winnerNameCmp, winnerLvlCmp, defeatedNameCmp, defeatedLvlCmp, stakedPlatCmp, stakedGoldCmp,
                    stakedTotalCmp, taxRateCmp, taxTotalCmp, winningsCmp)) {

                String winnerName = winnerNameCmp.text().replace('\u00A0', ' ');
                String winnerLvl = winnerLvlCmp.text();
                String defeatedName = defeatedNameCmp.text().replace('\u00A0', ' ');
                String defeatedLvl = defeatedLvlCmp.text();
                String stakedPlat = stakedPlatCmp.text();
                String stakedGold = stakedGoldCmp.text();
                String stakedTotal = stakedTotalCmp.text();
                String taxRate = taxRateCmp.text();
                String taxTotal = taxTotalCmp.text();
                String winnings = winningsCmp.text();

                ctx.io().execute(() -> {
                    RichEmbed embed = RichEmbed.builder()
                            .setColor(wonDuel ? Color.GREEN : Color.RED)
                            .setTitle("You have " + ( wonDuel ? "won!" : "lost!" ))
                            .addField("The Winner:",
                                      "Name: " + winnerName + "\n" +
                                            "Combat level: " + winnerLvl, true)
                            .addField("The Defeated:",
                                      "Name: " + defeatedName + "\n" +
                                            "Combat level: " + defeatedLvl, true)
                            .addField("The Stake:",
                                      "Platinum " + stakedPlat + "\n" +
                                            "Gold " + stakedGold + "\n" +
                                            "Total Staked " + stakedTotal, true)
                            .addField("The Winnings:",
                                    "Tax Rate " + taxRate + "\n" +
                                            "Tax total " + taxTotal + "\n" +
                                            "Winnings " + winnings, true)
                            .setThumbnail("https://rsbuddy.com/items/13204.png")
                            .setFooter("Powered by the OSBuddy Community API")
                            .setTimestamp()
                            .build();

                    WebhookMessage duelSubmission = WebhookMessage.builder()
                            .setUsername("Duel Arena")
                            .setAvatarURL("https://rsbuddy.com/items/995.png")
                            .addEmbed(embed)
                            .build();

                    try {
                        boolean posted = postWebhook(duelSubmission, webhookUrl);
                        if (!posted) log.error("Discord rejected webhook.");
                    } catch (Exception e) {
                        log.error("Failed to post to webhook.", e);
                    }
                });

            } else {
                log.error("Null component in duel results.");
            }
        }

        tick++;
    }

    @OnGameEvent(GameEvent.CHAT_MESSAGE)
    public void messageEvent(MessageEvent e) {
        if (e.flags() != MessageEvent.TRADE_REQUEST_SENT) return;
        boolean wonDuel = e.message().startsWith("You won! You have now won");
        if (wonDuel || e.message().startsWith("You were defeated! You have won")) {
            this.wonDuel = wonDuel;
            endTick = tick;
            captureDuel = true;
        }
    }

    @Subscribe
    public void settingUpdated(SettingUpdated event) {
        if ("webhookUrlString".equals(event.name)) {
            try {
                webhookUrl = new URL(event.value.toString());
            } catch (MalformedURLException e) {
                log.error("Malformed URL", e);
            }
        }
    }

    private static boolean notNull(final Object... values) {
        if (values == null) {
            return false;
        }
        for (Object value : values) {
            if (value == null) {
                return false;
            }
        }
        return true;
    }
}
