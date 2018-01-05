package com.example.produtos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.example.produtos.ProductVO.voList;

@SpringBootApplication
@RestController
public class ProdutosApplication {

	@GetMapping("/products")
	public List<ProductVO> getProducts(){
		return voList;
	}

	@GetMapping("/products/{name}")
	public ProductVO byName(@PathVariable("name") final String name){
		if(!voList.contains(new ProductVO(name))){
			return null;
		}
		return voList.get(voList.indexOf(new ProductVO(name)));
	}

	public static void main(String[] args) {
		SpringApplication.run(ProdutosApplication.class, args);
	}
}
