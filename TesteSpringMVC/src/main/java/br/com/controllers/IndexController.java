package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.services.IndexServiceInterface;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private IndexServiceInterface service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String hello(ModelMap model){
		model.addAttribute("msg", service.ola() );
		return "index";
	}
	
	@RequestMapping(path="/ola/{nome}", method=RequestMethod.GET)
	public ModelAndView cumprimentos(ModelMap model, @PathVariable("nome") String nome){
		ModelAndView view = new ModelAndView("index");
		view.addObject("msg", service.ola(nome) );
		return view;
	}
	

}
