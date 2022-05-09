package com.kafka.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaAPIApplication.class, args);
	}
	
	@Bean
	CommandLineRunner clr(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			for (int i = 0; i < 100; i++) {
				kafkaTemplate.send("topic", "hello Kafka!" + i);
			}
		};
	}

}
