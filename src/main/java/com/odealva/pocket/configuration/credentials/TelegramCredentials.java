package com.odealva.pocket.configuration.credentials;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "telegram")
@Data
public class TelegramCredentials {
  private String accessToken;
  private long chatId;
}
