package com.rsbuddy.discord;

import java.io.DataOutputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

import static java.net.HttpURLConnection.HTTP_NO_CONTENT;

public class PostWebhook {

    public static boolean postWebhook(WebhookMessage message, URL url) throws Exception {

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "DiscordBot (https://github.com/RSBuddy/osbuddy-community, 1.0)");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
        writer.writeBytes(message.toJson());
        writer.flush();
        writer.close();
        return connection.getResponseCode() == HTTP_NO_CONTENT;
    }
}
