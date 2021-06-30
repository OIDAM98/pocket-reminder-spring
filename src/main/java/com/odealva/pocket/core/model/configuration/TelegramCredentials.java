package com.odealva.pocket.core.model.configuration;

public class TelegramCredentials implements NotificationCredentials {
    private String accessToken;
    private long chatId;

    public TelegramCredentials(String accessToken, long chatId) {
        this.accessToken = accessToken;
        this.chatId = chatId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public long getChatId() {
        return chatId;
    }
}
