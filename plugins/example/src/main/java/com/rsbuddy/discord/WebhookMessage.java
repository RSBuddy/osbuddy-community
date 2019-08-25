package com.rsbuddy.discord;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WebhookMessage {

    @SerializedName("content")
    private final String content;
    @SerializedName("username")
    private final String username;
    @SerializedName("avatar_url")
    private final String avatarUrl;
    @SerializedName("tts")
    private final Boolean tts;
    @SerializedName("embeds")
    private final ArrayList<RichEmbed> embeds;

    public static class Builder {

        private static final int CONTENT_LIMIT = 2000; // 2000 characters
        private static final int USERNAME_MIN = 2; // 2 characters
        private static final int USERNAME_MAX = 32; // 32 characters
        private static final int EMBEDS_LIMIT = 10; // Up to 10 embed objects

        private String content = null;
        private String username = null;
        private String avatarUrl = null;
        private Boolean tts = null;
        private ArrayList<RichEmbed> embeds = new ArrayList<>();

        public WebhookMessage build() {
            if (embeds.isEmpty()) embeds = null;
            return new WebhookMessage(this);
        }

        public Builder setContent(String content) {
            if (content.length() <= CONTENT_LIMIT) this.content = content;
            return this;
        }

        public Builder setUsername(String username) {
            if (username.length() >= USERNAME_MIN && username.length() <= USERNAME_MAX) this.username = username;
            return this;
        }

        public Builder setAvatarURL(String avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }

        public Builder setTts(Boolean tts) {
            this.tts = tts;
            return this;
        }

        public Builder addEmbed(RichEmbed embed) {
            if (embeds.size() < EMBEDS_LIMIT) this.embeds.add(embed);
            return this;
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    public String toJson() {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(this);
    }

    private WebhookMessage(Builder builder) {
        this.content = builder.content;
        this.username = builder.username;
        this.avatarUrl = builder.avatarUrl;
        this.tts = builder.tts;
        this.embeds = builder.embeds;
    }
}