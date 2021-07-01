package com.odealva.pocket;

import com.odealva.pocket.core.service.AppService;
import com.odealva.pocket.core.service.PocketService;
import com.odealva.pocket.configuration.GlobalConfig;
import com.odealva.pocket.configuration.AppConfiguration;
import com.odealva.pocket.core.model.pocket.PocketArticle;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.codeset.pocket.read.PocketItem;

@SpringBootApplication
public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		final GlobalConfig config = ctx.getBean(GlobalConfig.class);
		logger.debug("Loaded the following config: ");
		logger.debug(config.toString());
		final PocketService pocket = ctx.getBean(PocketService.class);
		Try<List<PocketItem>> articles = pocket.getArticles(config.msgsConf().getAmountToRequest());
		logger.debug(articles.toString());
		final AppService appService = ctx.getBean(AppService.class);
		Try<List<PocketArticle>> domain = articles.map(appService::transformToDomain);
		Try<List<PocketArticle>> randomized = domain.map(arts -> appService.getRandomArticles(arts, config.msgsConf().getAmountToSend()));
		logger.debug("Initial count of articles: " + articles.map(a -> a.size()));
		logger.debug("Randomized count: " + randomized.map(a -> a.size()));
	}

}
