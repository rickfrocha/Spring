package br.com.hp.testes.service;

import org.springframework.stereotype.Service;

@Service
public class IndexService {
	
	private static final String MSG_BOAS_VINDAS = "Seja bem vindo PRIMEFACES.....!";
	
	
	public String obterMensagemBoasVindas(){
		return MSG_BOAS_VINDAS;
	}

}
