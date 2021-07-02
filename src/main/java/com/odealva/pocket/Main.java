package com.odealva.pocket;

import com.odealva.pocket.core.service.MainService;
import com.odealva.pocket.configuration.AppConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		final MainService service = ctx.getBean(MainService.class);
		service.fetchPocketSendTelegram();
	}

}
