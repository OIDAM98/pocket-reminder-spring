package com.odealva.pocket.configuration.credentials;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "telegram")
public class TelegramCredentials {
    private String accessToken;
    private long chatId;

    public String getAccessToken() {
        return accessToken;
    }

    public long getChatId() {
        return chatId;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    @Override
    public String toString() {
        return "TelegramCredentials{" +
                "accessToken='" + accessToken + '\'' +
                ", chatId=" + chatId +
                '}';
    }
}
