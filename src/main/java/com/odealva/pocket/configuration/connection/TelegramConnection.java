package com.odealva.pocket.configuration.connection;

import com.odealva.pocket.configuration.credentials.TelegramCredentials;
import com.pengrad.telegrambot.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TelegramConnection {

    @Autowired
    @Qualifier("telegramConf")
    private TelegramCredentials config;

    @Bean
    public TelegramBot telegramBot() {
        return new TelegramBot(config.getAccessToken());
    }


}
