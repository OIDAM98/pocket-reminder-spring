package com.odealva.pocket.core.model.pocket;

import pl.codeset.pocket.read.PocketItem;

import java.time.LocalDateTime;

public class PocketArticle {

    private String item_id;
    private String original_url;
    private String title;
    private LocalDateTime time_added;
    private int word_count;
    private String pocket_url;

    public PocketArticle(String item_id, String original_url, String title, LocalDateTime time_added, int word_count, String pocket_url) {
        this.item_id = item_id;
        this.original_url = original_url;
        this.title = title;
        this.time_added = time_added;
        this.word_count = word_count;
        this.pocket_url = pocket_url;
    }

    public String getItem_id() {
        return item_id;
    }

    public String getOriginal_url() {
        return original_url;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getTime_added() {
        return time_added;
    }

    public int getWord_count() {
        return word_count;
    }

    public String getPocket_url() {
        return pocket_url;
    }

    private static String generatePocketURL(String id) {
        return String.format("https://app.getpocket.com/read/%s", id);
    }

    private static String generateURL(PocketItem item) {
        if (item.isArticle()) {
            if(item.hasImage() || item.hasVideo()) return generatePocketURL(item.getResolvedId());
            else return item.getGivenUrl();
        }
        else
            return item.getGivenUrl();
    }

    public static PocketArticle itemToArticle(PocketItem item) {
        return new PocketArticle(
                item.getItemId(),
                item.getGivenUrl(),
                item.getGivenTitle(),
                item.getTimeAdded(),
                item.getWordCount(),
                generateURL(item)
        );
    }

    @Override
    public String toString() {
        return "PocketArticle{" +
                "item_id='" + item_id + '\'' +
                ", original_url='" + original_url + '\'' +
                ", title='" + title + '\'' +
                ", time_added=" + time_added +
                ", word_count=" + word_count +
                ", pocket_url='" + pocket_url + '\'' +
                '}';
    }
}
