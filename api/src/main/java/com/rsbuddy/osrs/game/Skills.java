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

import com.rsbuddy.osrs.content.config.Skill;

import javax.inject.Singleton;

@Singleton
public interface Skills {

    /**
     * Get the overall experience of the current player.
     *
     * @return All of the user's experiences added up.
     * */

    long overallExp();

    /**
     * Get the total level of the current player.
     *
     * @return All of the user's levels added up.
     * */

    int totalLevel();

    /**
     * Get the current experience of a skill.
     *
     * @param index The index of a skill to get the experience in.
     *
     * @return The current experience of a particular skill.
     * */

    int exp(final int index);

    /**
     * Get the current experience of a skill.
     *
     * @param skill The skill to get the experience in.
     *
     * @return The current experience of a particular skill.
     * */

    int exp(final Skill skill);

    /**
     * Get the current (boosted or drained) level of a skill by the index.
     *
     * @param index The index of a skill to get the level of.
     *
     * @return The current level of a particular skill.
     * */

    int currentLevel(final int index);

    /**
     * Get the current (boosted or drained) level of a skill.
     *
     * @param skill The skill to get the level of.
     *
     * @return The current level of a particular skill.
     * */

    int currentLevel(final Skill skill);

    /**
     * Get the base (non-boosted and non-drained) level of a skill by the index.
     *
     * @param index The index of the skill to get the level of.
     *
     * @return The base level of the skill.
     * */

    int level(final int index);

    /**
     * Get the base (non-boosted and non-drained) level of a skill.
     *
     * @param skill The skill to get the level of.
     *
     * @return The base level of the skill.
     * */

    int level(final Skill skill);

    /**
     * Get all of the current (boosted or drained) levels for the current player.
     *
     * @return All of the current levels.
     * */

    int[] currentLevels();

    /**
     * Get all of the experiences for the current player.
     *
     * @return All of the current experiences.
     * */

    int[] exps();

    /**
     * Get all of the base (non-boosted and non-drained) levels for the current player.
     *
     * @return All of the base levels.
     * */

    int[] levels();

    int expAt(final int level);

    int levelAt(final long expCap);

    double expBetween(final int start, final int end);

    double percentUntilNext(final Skill skill);

    double percentUntil(final Skill skill, int end);

    double rawPercentUntil(final Skill skill, int end);

    double rawPercentUntilNext(final int exp);

    double rawPercentBetween(final int curExp, final int startLevel, final int endLevel);

    /**
     * @param xp The xp to calculate the percentage from.
     *
     * @return The percent you're at for the next level if your xp is at xp.
     * */

    double percentUntilNext(final int xp);

    int expRemaining(final Skill skill, final int level);

    int expRemaining(final int exp);

    /**
     * Get the experience until the next level.
     *
     * @param skill The skill to find the exp remaining from.
     *
     * @return The exp until the next level in the specified skill.
     * */

    int expUntilNext(final Skill skill);

    /**
     * @param exp The xp to calculate the percentage from.
     *
     * @return The xp until the next level if your xp is at xp.
     * */

    int expUntilNext(final int exp);

    double combat();
}
