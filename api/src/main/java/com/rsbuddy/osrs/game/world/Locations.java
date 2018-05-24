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

import java.util.Collection;
import java.util.EnumSet;
import java.util.function.Predicate;

public interface Locations {

    Predicate<Location> ALL = gameObject -> true;

    int MAP_RADIUS = 20;

    Location at(Tile tile, EnumSet<Location.Type> types, Predicate<Location> predicate);

    Location at(Tile tile, Predicate<Location> predicate);

    Location at(Tile tile);

    Collection<Location> loadedById(EnumSet<Location.Type> types, Predicate<Integer> predicate);

    Collection<Location> loadedById(Predicate<Integer> predicate);

    Collection<Location> loadedById(EnumSet<Location.Type> types, Predicate<Integer> predicate, int radius);

    /**
     * Get the loaded objects within a radius. We do this for efficiency's sake.
     *
     * @param types     The Location types
     * @param predicate The condition
     * @param radius    The radius to search
     */
    Collection<Location> loaded(EnumSet<Location.Type> types, Predicate<Location> predicate, int radius);

    Collection<Location> loaded(int id, EnumSet<Location.Type> types, Predicate<Location> predicate, int radius);

    /**
     * Get the loaded objects within the minimap region.
     *
     * @param types     The Location types
     * @param predicate The condition
     */

    Collection<Location> loaded(EnumSet<Location.Type> types, Predicate<Location> predicate);

    Collection<Location> loaded(int id, EnumSet<Location.Type> types, Predicate<Location> predicate);

    Collection<Location> loadedInRegion();

    /**
     * Get the loaded objects within the minimap region.
     *
     * @param predicate The condition
     */

    Collection<Location> loaded(Predicate<Location> predicate);

    Collection<Location> loaded(int id, Predicate<Location> predicate);

    /**
     * Get the loaded objects within the minimap region.
     *
     * @param types The Location types
     */

    Collection<Location> loaded(EnumSet<Location.Type> types);

    Collection<Location> loaded(int id, EnumSet<Location.Type> types);

    Collection<Location> loaded(int id);

    Location first(EnumSet<Location.Type> types, Predicate<Location> predicate, int radius);

    Location first(int id, EnumSet<Location.Type> types, Predicate<Location> predicate, int radius);

    Location first(EnumSet<Location.Type> types, Predicate<Location> predicate);

    Location first(int id, EnumSet<Location.Type> types, Predicate<Location> predicate);

    Location first(Predicate<Location> predicate);

    Location first(int id, Predicate<Location> predicate);

    Location first(EnumSet<Location.Type> types);

    Location first(int id, EnumSet<Location.Type> types);

    Location first(int id);

    /**
     * Get the loaded objects within the minimap region.
     */

    Collection<Location> loaded();
}
