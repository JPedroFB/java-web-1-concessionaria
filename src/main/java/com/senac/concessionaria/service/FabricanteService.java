package com.senac.concessionaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.concessionaria.model.Fabricante;
import com.senac.concessionaria.repository.FabricanteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class FabricanteService {

	@Autowired
	FabricanteRepository fabricanteRepo;

	public List<Fabricante> listar() {
		return fabricanteRepo.findAll();
	}

	public Fabricante salvar(Fabricante fabricante) {
		return fabricanteRepo.save(fabricante);		
	}

	public void excluir(Long id) {
		fabricanteRepo.deleteById(id);;	
	}
	
	public Fabricante buscaPorID(Long id) throws ObjectNotFoundException {
		Optional<Fabricante> fabricante = fabricanteRepo.findById(id);
		return fabricante.orElseThrow(() -> new ObjectNotFoundException("Fabricante não encontrado. id:" + id));
	}

	public Fabricante alterar(Fabricante fabricanteAlterado) throws ObjectNotFoundException {
		Fabricante fabricante = buscaPorID(fabricanteAlterado.getId());
		fabricante.setNome(fabricanteAlterado.getNome());
		return salvar(fabricante);
	}
}
