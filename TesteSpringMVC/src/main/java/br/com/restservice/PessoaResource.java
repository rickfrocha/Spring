package br.com.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.entity.Pessoa;
import br.com.services.PessoaServiceInterface;

@RestController
@RequestMapping("/services/rest/pessoa")
public class PessoaResource {
	
	@Autowired
	PessoaServiceInterface service;
	
	@RequestMapping("/{id}")
	public @ResponseBody Pessoa obterPessoa(@PathVariable("id") final Integer codigo){
		Pessoa retorno = service.getPessoas().stream().filter(p -> p.getCodigo() == codigo).findFirst().get();
		if(retorno == null){
			retorno = new Pessoa();
		}
		return retorno;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Pessoa> getPessoas(){
		List<Pessoa> retorno = service.getPessoas();
		retorno.forEach(p -> System.out.println(p) );
		retorno.stream().filter(p -> p.getCodigo() > 3).forEach(p -> System.out.println("Pessoa filtrada: " + p) );

		return retorno;
	}

}
