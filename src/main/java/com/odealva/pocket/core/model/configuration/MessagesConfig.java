package com.odealva.pocket.core.model.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "msgs")
public class MessagesConfig {
    private String toSend;
    private int amountToSend;
    private int amountToRequest;

    public String getToSend() {
        return toSend;
    }

    public int getAmountToSend() {
        return amountToSend;
    }

    public int getAmountToRequest() {
        return amountToRequest;
    }

    public void setToSend(String toSend) {
        this.toSend = toSend;
    }

    public void setAmountToSend(int amountToSend) {
        this.amountToSend = amountToSend;
    }

    public void setAmountToRequest(int amountToRequest) {
        this.amountToRequest = amountToRequest;
    }

    @Override
    public String toString() {
        return "MessagesConfig{" +
                "toSend='" + toSend + '\'' +
                ", amountToSend=" + amountToSend +
                ", amountToRequest=" + amountToRequest +
                '}';
    }
}
