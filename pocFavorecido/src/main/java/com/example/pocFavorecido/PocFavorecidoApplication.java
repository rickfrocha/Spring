package com.example.pocFavorecido;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableAutoConfiguration
@EnableMongoRepositories
@RestController
@Validated
public class PocFavorecidoApplication {

	private static final String COLLECTION_NAME = "favorecido";

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private FavorecidoRepository favorecidoRepository;


	@GetMapping("/ping")
	public String ping(){
		return "pong";
	}

	@PostMapping(value = "/save", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public String save(@Valid @RequestBody Favorecido data) throws JsonProcessingException {
		System.out.println(data);

		ObjectMapper objectMapper = new ObjectMapper();
		String pureJson = objectMapper.writeValueAsString(data);

		mongoTemplate.save(pureJson, COLLECTION_NAME);

		return "OK";
	}

	@GetMapping("/find/user/{userId}")
	public List<Favorecido> findByUserId(@PathVariable String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("idtUser").is(userId));

		List<Favorecido> toReturn = mongoTemplate.find(query, Favorecido.class);

		return toReturn;
	}

	@GetMapping("/find/feature/{name}")
	public List<Favorecido> findByFeatureName(@PathVariable String name){
		List<Favorecido> toReturn = favorecidoRepository.findByFeatureName(name);
		return toReturn;
	}

	public static void main(String[] args) {
		SpringApplication.run(PocFavorecidoApplication.class, args);
	}
}
