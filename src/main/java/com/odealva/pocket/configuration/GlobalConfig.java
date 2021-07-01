package com.odealva.pocket.configuration;


import com.odealva.pocket.configuration.yaml.YamlPropertySourceFactory;
import com.odealva.pocket.configuration.credentials.PocketCredentials;
import com.odealva.pocket.configuration.credentials.TelegramCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:app-config.yaml", factory = YamlPropertySourceFactory.class)
public class GlobalConfig {

    @Bean("msgsConfig")
    public MessagesConfig msgsConf() {
        return new MessagesConfig();
    }

    @Bean("schedules")
    public CronConfig schedules() {
        return new CronConfig();
    }

    @Bean("pocketConf")
    public PocketCredentials pocket() {
        return new PocketCredentials();
    }

    @Bean("telegramConf")
    public TelegramCredentials telegram() {
        return new TelegramCredentials();
    }

    @Override
    public String toString() {
        return "GlobalConfig{" +
                "\n" + "msgs: " + msgsConf() +
                "\n" + "pocket: " + pocket() +
                "\n" + "telegram: " + telegram() +
                "\n" + "schedules" + schedules() +
                "\n" +
                "}";
    }
}
