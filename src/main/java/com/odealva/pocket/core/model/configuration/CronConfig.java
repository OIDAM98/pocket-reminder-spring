package com.odealva.pocket.core.model.configuration;

import java.util.List;

public class CronConfig {
    private List<String> schedules;

    public CronConfig(List<String> schedules) {
        this.schedules = schedules;
    }

    public List<String> getSchedules() {
        return schedules;
    }
}
