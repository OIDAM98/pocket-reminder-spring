package com.odealva.pocket.core.schedule;

import com.odealva.pocket.configuration.CronConfig;
import com.odealva.pocket.core.service.MainService;
import io.vavr.collection.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
public class AppScheduler {

    @Autowired
    private TaskScheduler scheduler;

    @Autowired
    private PocketTask task;

    @Autowired
    @Qualifier("cronConfig")
    private CronConfig config;

    private static final Logger log = LoggerFactory.getLogger(AppScheduler.class);

    public void scheduleCrons() {
        log.info("Scheduling taks with the following Crons:\n" + List.ofAll(config.getTimers()).mkString("\n"));
        config.getTimers().forEach(cron -> scheduler.schedule(task, new CronTrigger(cron)));
    }

}
