package com.odealva.pocket.core.model.credentials;

import com.odealva.pocket.core.model.requests.PocketRequest;

public class PocketCredentials {
    private String consumerKey;
    private String accessToken;

    public PocketCredentials(String consumerKey, String accessToken) {
        this.consumerKey = consumerKey;
        this.accessToken = accessToken;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public PocketRequest toRequest(int count) {
        return new PocketRequest(this.consumerKey, this.accessToken, count);
    }
}
