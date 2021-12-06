package com.odealva.pocket.core.model.pocket;

import pl.codeset.pocket.read.PocketItem;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PocketArticle {

  private final String item_id;
  private final String original_url;
  private final String title;
  private final LocalDateTime time_added;
  private final int word_count;
  private final String pocket_url;

  private static String generatePocketURL(String id) {
    return String.format("https://app.getpocket.com/read/%s", id);
  }

  private static String generateURL(PocketItem item) {
    if (item.isArticle()) {
      if (item.hasImage() || item.hasVideo())
        return generatePocketURL(item.getResolvedId());
      else
        return item.getGivenUrl();
    } else
      return item.getGivenUrl();
  }

  public static PocketArticle itemToArticle(PocketItem item) {
    return new PocketArticle(
        item.getItemId(),
        item.getGivenUrl(),
        item.getGivenTitle(),
        item.getTimeAdded(),
        item.getWordCount(),
        generateURL(item));
  }

}
