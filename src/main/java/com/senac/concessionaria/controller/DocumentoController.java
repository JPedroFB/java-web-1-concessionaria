package com.senac.concessionaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.concessionaria.model.Documento;
import com.senac.concessionaria.service.DocumentoService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("documento")
public class DocumentoController {

	@Autowired
	DocumentoService documentoService;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("documento/listaDocumentos");
		mv.addObject("documentos", documentoService.listar());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("documento/cadastroDocumento");
		mv.addObject("documento", new Documento());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Documento documento) {
		documentoService.salvar(documento);
		return listar();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("documento/alterarDocumento");
		mv.addObject("documento", documentoService.buscaPorID(id));	
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Documento documento) throws ObjectNotFoundException {
		documentoService.alterar(documento);
		return listar();
	}
	
	
	@SuppressWarnings("finally")
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		try{
			documentoService.excluir(id);
		}finally {
			return listar();			
		}
	}
	
	
}
