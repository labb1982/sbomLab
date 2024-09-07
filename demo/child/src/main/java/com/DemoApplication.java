package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@EnableAsync
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ThreadPoolTaskScheduler taskScheduler(@Value("${taskExecuter.corePoolSize:5}") int corePoolSize) {
		final ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setThreadNamePrefix("DemoThreadPoolTaskScheduler");
		scheduler.setPoolSize(corePoolSize);
		scheduler.setDaemon(true);
		scheduler.initialize();
		return scheduler;
	}

}
