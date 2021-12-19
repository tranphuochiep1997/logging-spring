package com.example.logging;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class LoggingApplication implements ApplicationRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(LoggingApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				log.info("Logging INFO");
				log.warn("Logging WARN");
				log.error("Logging ERROR");
			}
			
		}, 0, 1000);
		
	}

}
