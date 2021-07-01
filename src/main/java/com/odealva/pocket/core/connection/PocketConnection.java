package com.odealva.pocket.core.connection;

import com.odealva.pocket.core.model.credentials.PocketCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.codeset.pocket.Pocket;
import pl.codeset.pocket.PocketAuth;
import pl.codeset.pocket.PocketAuthFactory;

@Component
public class PocketConnection {

    @Autowired
    @Qualifier("pocketConf")
    private PocketCredentials credentials;

    @Bean
    public PocketAuth pocketAuth() {
        return PocketAuthFactory.createForAccessToken(credentials.getConsumerKey(), credentials.getAccessToken());
    }

    @Bean
    public Pocket pocket(PocketAuth auth) {
        return new Pocket(auth);
    }
}
