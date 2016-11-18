package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(Config.class)
public class TesteInitializationSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteInitializationSpringApplication.class, args);
	}
}
