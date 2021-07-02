package com.odealva.pocket.configuration;


import com.odealva.pocket.Main;
import com.odealva.pocket.configuration.yaml.YamlPropertySourceFactory;
import com.odealva.pocket.configuration.credentials.PocketCredentials;
import com.odealva.pocket.configuration.credentials.TelegramCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource(value = "classpath:app-config.yaml", factory = YamlPropertySourceFactory.class)
public class GlobalConfig {

    private static final Logger logger = LoggerFactory.getLogger(GlobalConfig.class);

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

    @PostConstruct
    private void configRead() {
        logger.debug("Loaded the following config: ");
        logger.debug(this.toString());
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
