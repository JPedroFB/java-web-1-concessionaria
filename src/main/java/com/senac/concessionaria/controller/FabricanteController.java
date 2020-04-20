package com.senac.concessionaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.concessionaria.model.Fabricante;
import com.senac.concessionaria.service.FabricanteService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("fabricante")
public class FabricanteController {

	@Autowired
	FabricanteService fabricanteService;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("fabricante/listaFabricantes");
		mv.addObject("fabricantes", fabricanteService.listar());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("fabricante/cadastroFabricante");
		mv.addObject("fabricante", new Fabricante());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Fabricante fabricante) {
		fabricanteService.salvar(fabricante);
		return listar();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("fabricante/alterarFabricante");
		mv.addObject("fabricante", fabricanteService.buscaPorID(id));	
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Fabricante fabricante) throws ObjectNotFoundException {
		fabricanteService.alterar(fabricante);
		return listar();
	}
	
	
	@SuppressWarnings("finally")
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		try{
			fabricanteService.excluir(id);
		}finally {
			return listar();			
		}
	}
	
	
}
