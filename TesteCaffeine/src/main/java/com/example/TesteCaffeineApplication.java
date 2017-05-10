package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Import(AppConfig.class)
public class TesteCaffeineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteCaffeineApplication.class, args);
	}
	
	
	@Service
	public static class MyService{
		
		@Cacheable("myCache")
		public String hello(){
			System.out.println("Passei aqui");
			return "ola";
		}
	}
	
	@Controller
	public static class WebApp{
		
		@Autowired
		private MyService service;
		
		@GetMapping("/ola")
		@ResponseBody
		public String hello(){
			return service.hello();
		}
	}
}
