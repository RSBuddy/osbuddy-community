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

public class MessageEvent {

    public static final int SYSTEM = 0;
    public static final int PUBLIC_MOD = 1;
    public static final int PUBLIC = 2;
    public static final int PM_RECEIVE = 3;
    public static final int PRIVATE_LOGIN = 5;
    public static final int PM_SENT = 6;
    public static final int PM_RECEIVE_MOD = 7;
    public static final int CLAN = 9;
    public static final int EXAMINE = 27;
    public static final int AUTOCHAT = 90;

    //Trade + Duel offer are meant to be the same value
    public static final int TRADE_REQUEST_RECEIVED = 101;
    public static final int TRADE_REQUEST_SENT = 102;
    public static final int DUEL_REQUEST_RECEIVED = 103;
    public static final int DUEL_REQUEST_SENT = 102;

    public static final int FILTERABLE_CHAT = 105; // presumably

    private String sender;
    private String screenName;
    private String message;
    private String prefix;
    private int flags;
    private boolean consumed;
    private boolean modified = false;

    public MessageEvent(int flags, String prefix, String sender, String message) {
        this.flags = flags;
        this.prefix = prefix;
        this.sender = sender != null ? sender.replace('\u00A0', ' ') : null;
        this.message = message != null ? message.replace('\u00A0', ' ') : null;
    }

    public boolean privateMessage() {
        return (flags == PM_RECEIVE) || (flags == PRIVATE_LOGIN) ||
                (flags == PM_SENT) || (flags == PM_RECEIVE_MOD);
    }

    public boolean clan() {
        return flags == CLAN;
    }

    public String sender() {
        return sender;
    }

    /**
     * Generates a screenName similar to the one Jagex uses internally in the client (r162). Not every
     * message needs this, so only calculate the screen name once, and if it is needed.
     * <p>
     *
     * @return the user's screen name
     */
    public String screenName() {
        if (screenName != null) return screenName;
        return screenName = sender.toLowerCase().substring(sender.indexOf(">") + 1).replace(' ', '_');
    }

    public String message() {
        return message;
    }

    public String prefix() {
        return prefix;
    }

    public int flags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
        modified = true;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
        modified = true;
    }

    public void setSender(String sender) {
        this.sender = sender;
        modified = true;
    }

    public void setMessage(String message) {
        this.message = message;
        modified = true;
    }

    private void setModified(final boolean modified) {
        this.modified = modified;
    }

    public boolean modified() {
        return modified;
    }

    public String toString() {
        return String.format("[flags=%d, prefix=\"%s\", sender=\"%s\" message=\"%s\"]", flags, prefix, sender, message);
    }

    public boolean isPublic() {
        return (flags == PUBLIC || flags == PUBLIC_MOD);
    }

    public boolean isMod() {
        return (flags == PUBLIC_MOD || flags == PM_RECEIVE_MOD);
    }

    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final MessageEvent that = (MessageEvent) o;
        return !(message != null ? !message.equals(that.message) : that.message != null) && !(sender != null ? !sender
                .equals(that.sender) : that.sender != null);

    }

    public int hashCode() {
        int result = sender != null ? sender.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    public void consume() {
        consumed = true;
    }

    public boolean consumed() {
        return consumed;

    }
}
