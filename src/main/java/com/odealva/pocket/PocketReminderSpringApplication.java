package com.odealva.pocket;

import com.odealva.pocket.core.model.configuration.GlobalConfig;
import com.odealva.pocket.core.model.configuration.AppConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PocketReminderSpringApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		final GlobalConfig config = ctx.getBean(GlobalConfig.class);
		System.out.println(config.msgsConf());
		System.out.println(config.pocket().toRequest(50));
		System.out.println(config.telegram());
		System.out.println(config.schedules());
	}

}
