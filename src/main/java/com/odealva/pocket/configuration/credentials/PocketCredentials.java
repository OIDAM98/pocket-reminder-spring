package com.odealva.pocket.configuration.credentials;

import com.odealva.pocket.core.model.pocket.PocketRequest;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "pocket")
public class PocketCredentials {
    private String consumerKey;
    private String accessToken;

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public PocketRequest toRequest(int count) {
        return new PocketRequest(this.consumerKey, this.accessToken, count);
    }

    @Override
    public String toString() {
        return "PocketConfig{" +
                "consumerKey='" + consumerKey + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
