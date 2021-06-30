package com.odealva.pocket.core.model.configuration;

import com.odealva.pocket.core.model.credentials.PocketCredentials;

public class GlobalConfig {
    private AppConfig appConfig;
    private NotificationCredentials notifConfig;
    private PocketCredentials pocketConfig;
    private CronConfig crons;

    public GlobalConfig(AppConfig appConfig, NotificationCredentials notifConfig, PocketCredentials pocketConfig, CronConfig crons) {
        this.appConfig = appConfig;
        this.notifConfig = notifConfig;
        this.pocketConfig = pocketConfig;
        this.crons = crons;
    }

    public AppConfig getAppConfig() {
        return appConfig;
    }

    public NotificationCredentials getNotifConfig() {
        return notifConfig;
    }

    public PocketCredentials getPocketConfig() {
        return pocketConfig;
    }

    public CronConfig getCrons() {
        return crons;
    }
}
