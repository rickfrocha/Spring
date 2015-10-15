package br.com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.entity.Pessoa;

@Service
public class PessoaService implements PessoaServiceInterface {
	
	List<Pessoa> pessoas;
	
	public PessoaService() {
		pessoas = new ArrayList<Pessoa>();
		pessoas.add( new Pessoa(1,"Ricardo",33,"rocha.ricardo@gmail.com"));
		pessoas.add( new Pessoa(2,"Pedro",1,"rocha.ricardo@gmail.com"));
		pessoas.add( new Pessoa(3,"Leandro",25,"rocha.ricardo@gmail.com"));
		pessoas.add( new Pessoa(4,"Gustavo",18,"rocha.ricardo@gmail.com"));
		pessoas.add( new Pessoa(5,"Marcelo",33,"rocha.ricardo@gmail.com"));
	}

	@Override
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

}
