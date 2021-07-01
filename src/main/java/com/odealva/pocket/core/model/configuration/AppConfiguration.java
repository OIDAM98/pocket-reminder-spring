package com.odealva.pocket.core.model.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = "com.odealva.pocket")
@Configuration
@Import({GlobalConfig.class})
@EnableConfigurationProperties
public class AppConfiguration {
}
