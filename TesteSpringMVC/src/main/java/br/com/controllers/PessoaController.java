package br.com.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.entity.Pessoa;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	
	@RequestMapping(method = RequestMethod.GET)
	public String init(ModelMap map) {
		Pessoa pessoa = new Pessoa();
		map.addAttribute("pessoa", pessoa);
		return "pessoa";
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String cadastro(@Valid Pessoa pessoa, BindingResult result,
			ModelMap model) {
		
		if (result.hasErrors()) {
			model.addAttribute("erro","cadastro invalido!");
		} else {
			model.addAttribute("sucesso","cadastro realizado com sucesso!");
		}
		return "pessoa";
	}

}
