package com.odealva.pocket.core.schedule;

import com.odealva.pocket.core.service.MainService;
import com.pengrad.telegrambot.model.Chat;
import io.vavr.Tuple2;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PocketTask implements Runnable {
    @Autowired
    private MainService service;

    private static final Logger log = LoggerFactory.getLogger(PocketTask.class);


    @Override
    public void run() {
        Try<Tuple2<Integer, Chat>> response = service.fetchPocketSendTelegram();
        log.debug(String.format("Task #%d: Finished with result:\n%s", service.getTaskNumber(), response.toString()));
    }
}
