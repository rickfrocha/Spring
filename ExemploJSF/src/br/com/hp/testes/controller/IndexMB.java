package br.com.hp.testes.controller;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.hp.testes.service.IndexService;

@Controller
@Scope("request")
@ManagedBean(name = "indexMB")
public class IndexMB extends AbstractMB{

	private static final long serialVersionUID = 1L;
	
	private String mensagemBoasVindas;
	
	@Autowired
	private IndexService service;
	
	public IndexMB() {
		System.out.println(">>> Criando managed bean index.");
	}

	public String getMensagemBoasVindas() {
		if(mensagemBoasVindas == null){
			mensagemBoasVindas = service.obterMensagemBoasVindas();
		}
		return mensagemBoasVindas;
	}

	public void setMensagemBoasVindas(String mensagemBoasVindas) {
		this.mensagemBoasVindas = mensagemBoasVindas;
	}
	
	

}
