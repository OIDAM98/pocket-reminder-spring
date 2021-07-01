package com.odealva.pocket.core.model.requests;

public class PocketRequest {
    private String consumerKey;
    private String accessToken;
    private int count;
    private String detailType;
    private String sort;

    public PocketRequest(String consumerKey, String accessToken, int count) {
        this.consumerKey = consumerKey;
        this.accessToken = accessToken;
        this.count = count;
        this.detailType = "simple";
        this.sort = "oldest";
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public int getCount() {
        return count;
    }

    public String getDetailType() {
        return detailType;
    }

    public String getSort() {
        return sort;
    }

    @Override
    public String toString() {
        return "PocketRequest{" +
                "consumerKey='" + consumerKey + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", count=" + count +
                '}';
    }
}
