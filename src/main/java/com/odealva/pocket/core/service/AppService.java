package com.odealva.pocket.core.service;

import com.odealva.pocket.core.model.pocket.PocketArticle;
import com.odealva.pocket.core.model.telegram.MarkdownFormat;
import io.vavr.collection.List;
import org.springframework.stereotype.Component;
import pl.codeset.pocket.read.PocketItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class AppService {

    public List<PocketArticle> transformToDomain(List<PocketItem> items) {
        return items.map(PocketArticle::itemToArticle);
    }

    public List<PocketArticle> getRandomArticles(List<PocketArticle> articles, int max) {
        Set<Integer> used = new HashSet<>();
        ArrayList<PocketArticle> toReturn = new ArrayList<>();
        Random random = new Random();
        int size = articles.size();
        int counter = 0;
        while (counter < max) {
            int i = random.nextInt(size);
            if(!used.contains(i)) {
                used.add(i);
                toReturn.add(articles.get(i));
                counter++;
            }
        }
        return List.ofAll(toReturn);
    }

    private MarkdownFormat transformToMarkdown(PocketArticle article) {
        return new MarkdownFormat.MarkdownBuilder()
                .setTitle(article.getTitle())
                .setUrl(article.getPocket_url())
                .setTimeAdded(article.getTime_added())
                .setWordCount(article.getWord_count())
                .build();
    }

    public List<String> generateTelegramBody(List<PocketArticle> articles) {
        return articles.map(this::transformToMarkdown).map(MarkdownFormat::compile);
    }


}
