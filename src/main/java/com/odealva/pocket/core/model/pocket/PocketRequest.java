package com.odealva.pocket.core.model.pocket;

import lombok.Data;

@Data
public class PocketRequest {
  private final String consumerKey;
  private final String accessToken;
  private final int count;
  private final String detailType = "simple";
  private final String sort = "oldest";
}
