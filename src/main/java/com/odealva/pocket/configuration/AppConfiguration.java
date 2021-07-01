package com.odealva.pocket.configuration;

import com.odealva.pocket.core.model.credentials.PocketCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.codeset.pocket.Pocket;
import pl.codeset.pocket.PocketAuth;
import pl.codeset.pocket.PocketAuthFactory;

@ComponentScan(basePackages = "com.odealva.pocket")
@Configuration
@Import({GlobalConfig.class})
@EnableConfigurationProperties
public class AppConfiguration {
}
