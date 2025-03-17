package com.example.TomAIto_BE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TomAItoBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TomAItoBeApplication.class, args);
	}

}
