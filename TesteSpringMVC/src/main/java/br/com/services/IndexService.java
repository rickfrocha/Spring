package br.com.services;

import org.springframework.stereotype.Service;

@Service
public class IndexService implements IndexServiceInterface {

	@Override
	public String ola() {
		return "Seja bem vindo!!!!!";
	}

	@Override
	public String ola(String nome) {
		return "Seja bem vindo, usuario "+nome;
	}
	
	

}
