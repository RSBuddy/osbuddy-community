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

package com.rsbuddy.osrs.game.ui;

import java.awt.*;
import java.util.List;

public interface Component {
    boolean containsAction(String... phrases);

    void setWidth(int width);

    void setHeight(int height);

    /**
     * Checks the text of this component for a given substring
     *
     * @param phrase The phrase to check for
     * @return <tt>true</tt> if the text contained the phrase
     * @see #text()
     */
    boolean containsText(final String phrase);

    /**
     * Gets the text of this component
     *
     * @return the text or "" if null
     */
    String text();

    void setText(String text);

    /**
     * Gets the content width of this component
     *
     * @return the content width of the component or -1 if null
     */
    int width();

    /**
     * Gets the content height of this component
     *
     * @return the content height of this component or -1 if null
     */
    int height();

    /**
     * Gets the border thickness of this component
     *
     * @return the thickness of the border on this component
     */
    int borderThickness();

    /**
     * Gets the absolute x position of the child, calculated from
     * the beginning of the game screen
     *
     * @return the absolute x or -1 if null
     */
    int absoluteX();

    /**
     * Gets the absolute y position of the child, calculated from
     * the beginning of the game screen
     *
     * @return the absolute y position or -1 if null
     */
    int absoluteY();

    /**
     * Sets the relative x position of the child
     *
     */
    void setX(int x);

    /**
     * Sets the relative y position of the child
     *
     */
    void setY(int y);

    /**
     * Sets the absolute x position of the child.
     * Parent(s) will be moved also if position relative to parent is negative
     *
     */
    void setAbsoluteX(int x);

    /**
     * Sets the absolute y position of the child
     * Parent(s) will be moved also if position relative to parent is negative
     *
     */
    void setAbsoluteY(int y);

    int color();

    void setColor(int color);

    int shadowColor();

    void setShadowColor(int color);

    /**
     * Gets the absolute screen location of this component.
     *
     * @return the absolute position or new Point(-1, -1) if null
     */
    Point absoluteLocation();

    /**
     * Gets a random absolute point on the location of this component.
     *
     * @return the absolute position or new Point(-1, -1) if null
     */

    Point randomPoint();

    /**
     * Gets the position of the child in its parent
     *
     * @return the relative position or new Point(-1, -1) if null
     */
    Point relativeLocation();

    int relativeX();

    int relativeY();

    /**
     * Gets the offset applied to the locations of each of the
     * children of this viewport component.
     *
     * @return The scroll offset; Point(-1, -1) if null.
     */
    Point scrollOffset();

    int scrollX();

    int scrollY();

    void setScrollY(int scrollY);

    int scrollHeight();

    void setScrollHeight(int scrollHeight);

    /**
     * Returns the center point of this interface
     *
     * @return The center point of this interface
     */
    Point center();

    /**
     * Gets the index in the bounds array of this component.
     *
     * @return The bounds index
     */
    int boundsArrayIndex();

    /**
     * Gets the bounding box of this component in screen space.
     *
     * @return the area or new Rectangle(-1, -1, -1, -1) if null
     */
    Rectangle bounds();

    /**
     * Gets the rectangle in which interaction with the component is
     * possible. By default it is just the bounds with a 1 pixel margin
     * in all directions.
     *
     * @return the interacting bounds.
     */
    Rectangle interactingArea();

    /**
     * Determines if the provided point is contained within the interacting
     * region of this component.
     *
     * @param point the point to check
     * @return <tt>true</tt> if the point is contained by the
     * component.
     */
    boolean contains(final Point point);

    /**
     * Gets the actions of this component.
     *
     * @return the actions or an empty array if null
     */
    String[] actions();

    String option();

    void setOption(String option);

    /**
     * Gets the texture id of this component.
     *
     * @return the texture id; -1 if null
     */
    int sprite();

    void sprite(int id);

    /**
     * Gets the sprite2 of this component.
     *
     * @return the sprite2; -1 if null
     */

    int sprite2();

    /**
     * Gets the child of this component with the provided id
     *
     * @param id the id to look for
     * @return the child component
     */
    Component child(int id);

    /**
     * The child components of this component.
     *
     * @return The children or Component[0]
     */
    List<Component> children();

    int childrenCount();

    /**
     * Gets the parent of this component, the right way.
     *
     * @return the parent component, or null
     */
    Component parent();

    void setItemId(int itemId);

    /**
     * Gets the id of the item in this component.
     *
     * @return The id of this component, or -1 if no item present.
     */
    int itemId();

    /**
     * Gets the stack of the item in this component.
     *
     * @return The stack of this component, or -1 if no item present.
     */
    int itemStack();

    void setItemStack(int stackSize);

    /**
     * Gets the array of ids for all items in the inventory of the
     * component.
     *
     * @return The array of ids for the component inventory,
     * or new int[0] if no inventory present.
     */
    int[] inventoryIds();

    /**
     * Gets the array of stacks for all items in the inventory of the
     * component.
     *
     * @return The array of stacks for the component inventory,
     * or new int[0] if no inventory present.
     */
    int[] inventoryStacks();

    /**
     * Gets the parent id of this component.
     *
     * @return the parent id of the component, -1 if the
     * component is null.
     */
    int parentId();

    /**
     * Gets the id of this component.
     *
     * @return the  id of the component, -1 if the
     * component is null.
     */
    int id();

    int group();

    int index();

    /**
     * Gets the child id of this component.
     *
     * @return the child id of the component, -1 if the
     * component is null.
     */
    int childId();

    /**
     * Determines whether or not this component is loaded for display.
     *
     * @return whether or not the component is valid
     */
    boolean valid();

    /**
     * Determines whether or not this component is visible.
     *
     * @return whether or not the component is visible
     */
    boolean visible();

    /**
     * Draws the bounds of the component.
     *
     * @param g the graphics object to use when drawing
     */
    void outline(Graphics g);

    /**
     * Fills the entire bounds of the component.
     *
     * @param g the graphics object to use
     */
    void fill(Graphics g);

    void setHidden(boolean hidden);

}
