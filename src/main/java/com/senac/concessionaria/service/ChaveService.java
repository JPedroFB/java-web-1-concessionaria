package com.senac.concessionaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.concessionaria.model.Chave;
import com.senac.concessionaria.repository.ChaveRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ChaveService {

	@Autowired
	ChaveRepository chaveRepo;
	
	public List<Chave> listar() {
		return chaveRepo.findAll();
	}

	public Chave salvar(Chave chave) {
		return chaveRepo.save(chave);
	}

	public Chave alterar(Chave chaveAlterado) throws ObjectNotFoundException {
		Chave chave = buscaPorID(chaveAlterado.getId());
		chave.setDescricao(chaveAlterado.getDescricao());
		return salvar(chave);
	}

	public void excluir(Long id) {
		chaveRepo.deleteById(id);
	}

	public Chave buscaPorID(Long id) throws ObjectNotFoundException {
		Optional<Chave> chave = chaveRepo.findById(id);
		return chave.orElseThrow(() -> new ObjectNotFoundException("Chave não encontrado. id:" + id));
	}

}
