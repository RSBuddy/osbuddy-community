package com.rsbuddy.discord;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.awt.*;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public class RichEmbed {

    @SerializedName("title")
    private final String title;
    @SerializedName("description")
    private final String description;
    @SerializedName("url")
    private final String url;
    @SerializedName("timestamp")
    private final String timestamp;
    @SerializedName("color")
    private final Integer color;
    @SerializedName("footer")
    private final Footer footer;
    @SerializedName("image")
    private final Image image;
    @SerializedName("thumbnail")
    private final Thumbnail thumbnail;
    @SerializedName("author")
    private final Author author;
    @SerializedName("fields")
    private final ArrayList<EmbedField> fields;


    public static class Builder {

        private static final int TITLE_LIMIT = 256; // 256 characters
        private static final int DESCRIPTION_LIMIT = 2048; // 2048 characters
        private static final int FIELDS_LIMIT = 25; // Up to 25 field objects
        private static final int FIELD_NAME_LIMIT = 256; // 256 characters
        private static final int FIELD_VALUE_LIMIT = 1024; // 1024 characters
        private static final int FOOTER_TEXT_LIMIT = 2048; // 2048 characters
        private static final int AUTHOR_NAME_LIMIT = 256; // 256 characters
        private static final int STRUCTURE_LIMIT = 6000; // 6000 characters

        private String title = null;
        private String description = null;
        private String url = null;
        private String timestamp = null;
        private Integer color = null;
        private Footer footer = null;
        private Image image = null;
        private Thumbnail thumbnail = null;
        private Author author = null;
        private ArrayList<EmbedField> fields = new ArrayList<>();

        private int contentLength = 0;

        public RichEmbed build() {
            if (fields.isEmpty()) fields = null;
            return new RichEmbed(this);
        }

        public Builder setTitle(String title) {
            int length = title.length();
            if (length <= TITLE_LIMIT && length + contentLength <= STRUCTURE_LIMIT) {
                contentLength += length;
                this.title = title;
            }
            return this;
        }

        public Builder setDescription(String description) {
            int length = description.length();
            if (length <= DESCRIPTION_LIMIT && length + contentLength <= STRUCTURE_LIMIT) {
                contentLength += length;
                this.description = description;
            }
            return this;
        }

        public Builder setURL(String url) {
            this.url = url;
            return this;
        }

        public Builder setTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setTimestamp() {
            return this.setTimestamp(OffsetDateTime.now(ZoneId.of("Z")).toString());
        }

        public Builder setColor(int color) {
            this.color = color;
            return this;
        }

        public Builder setColor(Color color) {
            return this.setColor(color.getRGB() & 0x00FFFFFF);
        }

        public Builder setColor(String color) {
            try {
                return this.setColor(Color.decode(color).getRGB() & 0x00FFFFFF);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return this;
        }

        public Builder setFooter(String text, String iconUrl) {
            int length = text.length();
            if (length <= FOOTER_TEXT_LIMIT && length + contentLength <= STRUCTURE_LIMIT) {
                contentLength += length;
                this.footer = new Footer(text, iconUrl);
            }
            return this;
        }

        public Builder setFooter(String text) {
            return this.setFooter(text, null);
        }

        public Builder setImage(String url) {
            this.image = new Image(url);
            return this;
        }

        public Builder setThumbnail(String url) {
            this.thumbnail = new Thumbnail(url);
            return this;
        }

        public Builder setAuthor(String name, String iconUrl, String url) {
            int length = name.length();
            if (length <= AUTHOR_NAME_LIMIT && length + contentLength <= STRUCTURE_LIMIT) {
                contentLength += length;
                this.author = new Author(name, iconUrl, url);
            }
            return this;
        }

        public Builder setAuthor(String name, String iconUrl) {
            return this.setAuthor(name, iconUrl, null);
        }

        public Builder setAuthor(String name) {
            return this.setAuthor(name, null, null);
        }

        public Builder addField(String name, String value,  Boolean inline) {
            int length = name.length() + value.length();
            if (fields.size() < FIELDS_LIMIT && name.length() <= FIELD_NAME_LIMIT && value.length() <= FIELD_VALUE_LIMIT
                                             && length + contentLength <= STRUCTURE_LIMIT) {
                contentLength += length;
                this.fields.add(new EmbedField(name, value, inline));
            }
            return this;
        }

        public Builder addField(String name, String value) {
            return this.addField(name, value, null);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    public String toJson() {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(this);
    }

    private RichEmbed(Builder builder) {
        title = builder.title;
        description = builder.description;
        url = builder.url;
        timestamp = builder.timestamp;
        color = builder.color;
        footer = builder.footer;
        image = builder.image;
        thumbnail = builder.thumbnail;
        author = builder.author;
        fields = builder.fields;
    }

    private static class Footer {
        @SerializedName("text")
        private final String text;
        @SerializedName("icon_url")
        private final String iconUrl;

        private Footer(String text, String iconUrl) {
            this.text = text;
            this.iconUrl = iconUrl;
        }
    }

    private static class Image {
        @SerializedName("url")
        private final String url;

        private Image(String url) {
            this.url = url;
        }
    }

    private static class Thumbnail {
        @SerializedName("url")
        private final String url;

        private Thumbnail(String url) {
            this.url = url;
        }
    }

    private static class Author {
        @SerializedName("name")
        private final String name;
        @SerializedName("icon_url")
        private final String iconUrl;
        @SerializedName("url")
        private final String url;

        private Author(String name, String iconUrl, String url) {
            this.name = name;
            this.iconUrl = iconUrl;
            this.url = url;
        }
    }

    private static class EmbedField {
        @SerializedName("name")
        private final String name;
        @SerializedName("value")
        private final String value;
        @SerializedName("inline")
        private final Boolean inline;

        private EmbedField(String name, String value, Boolean inline) {
            this.name = name;
            this.value = value;
            this.inline = inline;
        }
    }
}