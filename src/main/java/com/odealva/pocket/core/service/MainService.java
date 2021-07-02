package com.odealva.pocket.core.service;

import com.odealva.pocket.configuration.GlobalConfig;
import com.odealva.pocket.core.model.pocket.PocketArticle;
import com.pengrad.telegrambot.model.Chat;

import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.collection.Traversable;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codeset.pocket.read.PocketItem;

@Service
public class MainService {

    private static final Logger logger = LoggerFactory.getLogger(MainService.class);

    @Autowired
    private GlobalConfig config;

    @Autowired
    private PocketService pocket;

    @Autowired
    private AppService appService;

    @Autowired
    private TelegramService telegram;

    public Try<Tuple2<Integer, Chat>> fetchPocketSendTelegram() {
        logger.info("Fetching articles from Pocket...");
        Try<List<PocketItem>> articles = pocket.getArticles(config.msgsConf().getAmountToRequest());
        logger.debug("Fetched the following articles from Pocket:\n" + articles.toString());

        logger.info("Preparing articles to send by Telegram...");
        Try<List<PocketArticle>> domain = articles.map(appService::transformToDomain);
        Try<List<PocketArticle>> randomized = domain.map(appService::getRandomArticles);
        logger.debug("Initial count of articles: " + articles.map(Traversable::size));
        logger.debug("Randomized count: " + randomized.map(Traversable::size));
        logger.debug("Messages to send:/n" + randomized.map(lst -> lst.mkString("\n")).toString());

        Try<List<String>> payload = randomized.map(appService::generateTelegramBody);
        logger.debug("Payload for Telegram"+ payload.toString());

        logger.info("Sending articles to Telegram...");
        Try<Tuple2<Integer, Chat>> response = payload.flatMap(p -> telegram.sendArticles(p.mkString("\n")));
        logger.info("Articles sent!");
        logger.info("Result from sending articles to Telegram:\n" + response.map(t -> String.format("MessageId:%d\t|\tTo: %s", t._1, t._2)));

        return response;
    }
}
