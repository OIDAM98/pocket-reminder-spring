package com.odealva.pocket.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "schedules")
public class CronConfig {
    private List<String> timers;

    public List<String> getTimers() {
        return timers;
    }

    public void setTimers(List<String> timers) {
        this.timers = timers;
    }

    @Override
    public String toString() {
        return "CronConfig{" +
                "timers=" + timers +
                '}';
    }
}
