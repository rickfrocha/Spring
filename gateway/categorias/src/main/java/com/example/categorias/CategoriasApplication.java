package com.example.categorias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
@RestController
public class CategoriasApplication {

	@GetMapping("/categories")
	public Collection<String> list(){
		return Arrays.asList("Limpeza","Alimento","Cosmetico");
	}

	public static void main(String[] args) {
		SpringApplication.run(CategoriasApplication.class, args);
	}
}
