package com.odealva.pocket;

import com.odealva.pocket.core.schedule.AppScheduler;
import com.odealva.pocket.configuration.AppConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		AppScheduler scheduler = ctx.getBean(AppScheduler.class);
		scheduler.scheduleCrons();
	}

}
