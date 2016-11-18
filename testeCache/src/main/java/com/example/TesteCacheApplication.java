package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Date;


@SpringBootApplication
@EnableCaching
public class TesteCacheApplication implements CommandLineRunner {

	@Autowired
	MyService myService;

	@RestController
	@RequestMapping("api")
	public static class Controller{

		@Cacheable(cacheNames = "get")
		@RequestMapping("/get/{id}")
		public String include(@PathVariable("id") String id){
			System.out.println("solicitando cache " + id + " data " + new Date());
			return "valor solicitado " + id;
		}

		@CacheEvict(cacheNames = "get")
		@RequestMapping("/remove/{id}")
		public void remove(@PathVariable("id") String id){
			System.out.println("removendo o cache " + id + " data " + new Date());
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(TesteCacheApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Chamando servico "+ new Date());
		myService.execSlowMethod();
		System.out.println("Finalizando " + new Date());

		System.out.println("Chamando servico "+ new Date());
		myService.execSlowMethod();
		System.out.println("Finalizando " + new Date());

	}
}
