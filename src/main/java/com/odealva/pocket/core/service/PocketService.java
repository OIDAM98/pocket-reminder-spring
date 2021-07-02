package com.odealva.pocket.core.service;

import com.odealva.pocket.configuration.credentials.PocketCredentials;
import com.odealva.pocket.core.model.pocket.PocketRequest;
import io.vavr.CheckedFunction1;
import io.vavr.Function1;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.codeset.pocket.Pocket;
import pl.codeset.pocket.PocketAuth;
import pl.codeset.pocket.read.*;

import javax.annotation.PostConstruct;


@Service
public class PocketService {

    private static final Logger logger = LoggerFactory.getLogger(PocketService.class);

    @Qualifier("pocketConf")
    @Autowired
    private PocketCredentials credentials;

    @Autowired
    private PocketAuth authRes;

    @Autowired
    private Pocket pocketRes;

    @PostConstruct
    private void createConnection() {
        logger.debug("Connection to Pocket with Credentials");
        logger.debug(credentials.toString());
        logger.debug("Resulted in");
        logger.debug(pocketRes.toString());
    }


    public Try<List<PocketItem>> getArticles(int count) {
        Function1<GetItemsCmd, Try<GetItemsResult>> getItems = CheckedFunction1.liftTry(pocketRes::getItems);
        return buildQuery(count)
                .flatMap(getItems)
                .map(items -> List.ofAll(items.getList()));
    }

    private Try<GetItemsCmd> buildQuery(int count) {
        final PocketRequest req = credentials.toRequest(count);
        return Try.of(() -> new GetItemsCmd.Builder()
                .count(req.getCount())
                .sort(Sort.valueOf(req.getSort()))
                .detailType(DetailType.valueOf(req.getDetailType()))
                .build());
    }

}
