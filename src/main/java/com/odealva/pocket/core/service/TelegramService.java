package com.odealva.pocket.core.service;

import com.odealva.pocket.configuration.credentials.TelegramCredentials;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import io.vavr.CheckedFunction1;
import io.vavr.Function1;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TelegramService {

    @Autowired
    @Qualifier("telegramConf")
    private TelegramCredentials config;

    @Autowired
    private TelegramBot bot;

    public Try<Tuple2<Boolean, Message>> sendArticles(String articles) {
        SendMessage msg = new SendMessage(config.getChatId(), articles).parseMode(ParseMode.Markdown);
        Function1<SendMessage, Try<SendResponse>> sendMsg = CheckedFunction1.liftTry(bot::execute);

        return sendMsg
                .apply(msg)
                .map(res -> Tuple.of(res.isOk(), res.message()));
    }
}
