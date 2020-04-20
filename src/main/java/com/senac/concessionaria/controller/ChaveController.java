package com.senac.concessionaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.concessionaria.model.Chave;
import com.senac.concessionaria.service.ChaveService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("chave")
public class ChaveController {
	
		@Autowired
		ChaveService chaveService;
		
		@GetMapping("")
		public ModelAndView listar() {
			ModelAndView mv = new ModelAndView("chave/listaChaves");
			mv.addObject("chaves", chaveService.listar());
			return mv;
		}
		
		@GetMapping("/cadastrar")
		public ModelAndView cadastrar() {
			ModelAndView mv = new ModelAndView("chave/cadastroChave");
			mv.addObject("chave", new Chave());
			return mv;
		}
		
		@PostMapping("/salvar")
		public ModelAndView salvar(Chave chave) {
			chaveService.salvar(chave);
			return listar();
		}
		
		@GetMapping("/alterar/{id}")
		public ModelAndView editar(@PathVariable("id") Long id) throws ObjectNotFoundException {
			ModelAndView mv = new ModelAndView("chave/alterarChave");
			mv.addObject("chave", chaveService.buscaPorID(id));	
			return mv;
		}
		
		@PostMapping("/alterar")
		public ModelAndView alterar(Chave chave) throws ObjectNotFoundException {
			chaveService.alterar(chave);
			return listar();
		}
		
		
		@SuppressWarnings("finally")
		@GetMapping("/excluir/{id}")
		public ModelAndView excluir(@PathVariable("id") Long id) {
			try{
				chaveService.excluir(id);
			}finally {
				return listar();
			}
		}
		
	
}
