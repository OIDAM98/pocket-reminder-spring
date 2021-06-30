package com.odealva.pocket.core.model.configuration;

public class AppConfig {
    private String toSend;
    private int amountToSend;
    private int amountToRequest;

    public AppConfig(String toSend, int amountToSend, int amountToRequest) {
        this.toSend = toSend;
        this.amountToSend = amountToSend;
        this.amountToRequest = amountToRequest;
    }

    public String getToSend() {
        return toSend;
    }

    public int getAmountToSend() {
        return amountToSend;
    }

    public int getAmountToRequest() {
        return amountToRequest;
    }

}
