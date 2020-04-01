package com.senac.concessionaria.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.concessionaria.model.Carro;
import com.senac.concessionaria.service.CarroService;

@Controller
@RequestMapping("carro")
public class CarroController {

	@Autowired
	CarroService carroService;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("carro/listaCarros");
		mv.addObject("carros", carroService.listar());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("carro/cadastroCarro");
		mv.addObject("carro", new Carro());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Carro carro) {
		carroService.salvar(carro);
		return listar();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		carroService.excluir(id);
		return listar();
	}
	
	
}
