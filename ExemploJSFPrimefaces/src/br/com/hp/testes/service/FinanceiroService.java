package br.com.hp.testes.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class FinanceiroService {
	
	public Map<String,Double> obterPosicaoFinanceiraUltimosMeses(){
		Map<String,Double> retorno = new HashMap<String,Double>();
		retorno.put("Junho",1000.00);
		retorno.put("Julho",5000.00);
		retorno.put("Ago",5000.00);
		retorno.put("Set",3000.00);
		retorno.put("Out",5000.00);
		retorno.put("Nov",20000.00);
		
		return retorno;
	}

}
