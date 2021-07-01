package com.odealva.pocket.core.model.configuration;


import com.odealva.pocket.core.model.configuration.yaml.YamlPropertySourceFactory;
import com.odealva.pocket.core.model.credentials.PocketCredentials;
import com.odealva.pocket.core.model.credentials.TelegramCredentials;
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

    @Bean("schedues")
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


}
