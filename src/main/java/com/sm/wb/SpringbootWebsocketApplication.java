package com.sm.wb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringbootWebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebsocketApplication.class, args);
	}

}
