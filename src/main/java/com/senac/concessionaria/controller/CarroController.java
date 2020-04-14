package com.senac.concessionaria.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.concessionaria.model.Carro;
import com.senac.concessionaria.service.CarroService;
import com.senac.concessionaria.service.ChaveService;
import com.senac.concessionaria.service.DocumentoService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("carro")
public class CarroController {

	@Autowired
	CarroService carroService;
	
	@Autowired
	ChaveService chaveService;
	
	@Autowired
	DocumentoService documentoService;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("carro/listaCarros");
		mv.addObject("carros", carroService.listar());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("carro/cadastroCarro");
		mv.addObject("documentos", documentoService.listar());
		mv.addObject("chaves", chaveService.listar());
		mv.addObject("carro", new Carro());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Carro carro) {
		carroService.salvar(carro);
		return listar();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("carro/alterarCarro");
		mv.addObject("documentos", documentoService.listar());
		mv.addObject("chaves", chaveService.listar());
		mv.addObject("carro", carroService.buscaPorID(id));	
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Carro carro) throws ObjectNotFoundException {
		carroService.alterar(carro);
		return listar();
	}
	
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		try{
			carroService.excluir(id);
		}finally {
			return listar();
		}
	}
	
	
}
