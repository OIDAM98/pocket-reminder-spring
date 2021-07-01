package com.odealva.pocket;

import com.odealva.pocket.core.controllers.connection.PocketConnection;
import com.odealva.pocket.core.model.configuration.GlobalConfig;
import com.odealva.pocket.core.model.configuration.AppConfiguration;
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
		final PocketConnection pocket = ctx.getBean(PocketConnection.class);
		Try<List<PocketItem>> articles = pocket.getArticles(config.msgsConf().getAmountToRequest());
		logger.debug(articles.toString());
	}

}
