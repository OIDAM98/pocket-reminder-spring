package com.odealva.pocket.core.controllers.connection;

import com.odealva.pocket.core.model.credentials.PocketCredentials;
import com.odealva.pocket.core.model.pocket.PocketRequest;
import io.vavr.CheckedFunction1;
import io.vavr.Function1;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.codeset.pocket.Pocket;
import pl.codeset.pocket.PocketAuth;
import pl.codeset.pocket.PocketAuthFactory;
import pl.codeset.pocket.read.*;

import javax.annotation.PostConstruct;


@Component
public class PocketConnection {

    private static final Logger logger = LoggerFactory.getLogger(PocketConnection.class);

    @Qualifier("pocketConf")
    @Autowired
    private PocketCredentials credentials;

    private Try<PocketAuth> authRes;
    private Try<Pocket> pocketRes;

    @PostConstruct
    private void createConnection() {
        authRes = makeAuth();
        pocketRes = authRes.flatMap(this::generateAccess);
        logger.debug("Connection to Pocket with Credentials");
        logger.debug(credentials.toString());
        logger.debug("Resulted in");
        logger.debug(pocketRes.toString());
    }


    public Try<List<PocketItem>> getArticles(int count) {
        Try<GetItemsCmd> query = buildQuery(count);
        return query
                .flatMap(cmd -> pocketRes.flatMap(pocket -> getItemsResults(pocket).apply(cmd)))
                .map(getRes -> List.ofAll(getRes.getList()));
    }

    private Try<GetItemsCmd> buildQuery(int count) {
        final PocketRequest req = credentials.toRequest(count);
        return Try.of(() -> new GetItemsCmd.Builder()
                .count(req.getCount())
                .sort(Sort.valueOf(req.getSort()))
                .detailType(DetailType.valueOf(req.getDetailType()))
                .build());
    }

    private Try<PocketAuth> makeAuth() {
        return Try.of(() -> PocketAuthFactory.createForAccessToken(credentials.getConsumerKey(), credentials.getAccessToken()));
    }

    private Try<Pocket> generateAccess(PocketAuth auth) {
        return Try.of(() -> new Pocket(auth));
    }

    private Function1<GetItemsCmd, Try<GetItemsResult>> getItemsResults(Pocket pocket) {
        return CheckedFunction1.liftTry(pocket::getItems);
    }

}
