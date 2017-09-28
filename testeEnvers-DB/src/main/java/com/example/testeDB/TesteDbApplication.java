package com.example.testeDB;

import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableAutoConfiguration
public class TesteDbApplication implements CommandLineRunner {

	@RestController
	public static class myController{


        @Autowired
        private PessoaRepository repository;

        @Autowired
        private CarroRepository carroRepository;

        @GetMapping("/pessoa/add")
	    public String addPessoa(){
            Pessoa p = new Pessoa();
            p.setNome("Ricardo");
            p.setDtNascimento(new Date());
            repository.save(p);
	        return "OK";
        }

        @GetMapping("/carro/add")
        public String add(){
            Carro c = new Carro();
            c.setModelo(String.valueOf(new Random().nextInt()));
            carroRepository.save(c);
            return "OK";
        }

        @GetMapping("/pessoa/update/{id}")
        public String update(@PathVariable("id") Integer id){
            Pessoa one = repository.findOne(id);
            one.setNome(new Date().toString());
            one.setDtNascimento(new Date());
            repository.save(one);
            return "OK";
        }
    }

	public static void main(String[] args) {
		SpringApplication.run(TesteDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
