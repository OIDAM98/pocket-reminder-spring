package com.odealva.pocket.configuration.credentials;

import com.odealva.pocket.core.model.pocket.PocketRequest;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "pocket")
@Data
public class PocketCredentials {
  private String consumerKey;
  private String accessToken;

  public PocketRequest toRequest(int count) {
    return new PocketRequest(this.consumerKey, this.accessToken, count);
  }

}
