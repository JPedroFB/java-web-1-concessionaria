package com.senac.concessionaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.concessionaria.model.Documento;
import com.senac.concessionaria.repository.DocumentoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class DocumentoService {

	@Autowired
	DocumentoRepository documentoRepo;

	public List<Documento> listar() {
		return documentoRepo.findAll();
	}

	public Documento salvar(Documento documento) {
		return documentoRepo.save(documento);		
	}

	public void excluir(Long id) {
		documentoRepo.deleteById(id);;	
	}
	
	public Documento buscaPorID(Long id) throws ObjectNotFoundException {
		Optional<Documento> documento = documentoRepo.findById(id);
		return documento.orElseThrow(() -> new ObjectNotFoundException("Documento não encontrado. id:" + id));
	}

	public Documento alterar(Documento documentoAlterado) throws ObjectNotFoundException {
		Documento documento = buscaPorID(documentoAlterado.getId());
		documento.setDescricao(documentoAlterado.getDescricao());
		return salvar(documento);
	}
}
