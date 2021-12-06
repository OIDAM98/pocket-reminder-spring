package com.odealva.pocket.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "msgs")
@Data
public class MessagesConfig {
  private String toSend;
  private int amountToSend;
  private int amountToRequest;
}
