package com.senac.concessionaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.concessionaria.model.Carro;
import com.senac.concessionaria.repository.CarroRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CarroService {

	@Autowired
	CarroRepository carroRepo;

	public List<Carro> listar() {
		return carroRepo.findAll();
	}

	public Carro salvar(Carro carro) {
		return carroRepo.save(carro);		
	}

	public void excluir(Long id) {
		carroRepo.deleteById(id);;	
	}
	
	public Carro buscaPorID(Long id) throws ObjectNotFoundException {
		Optional<Carro> carro = carroRepo.findById(id);
		return carro.orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado. id:" + id));
	}

	public Carro alterar(Carro carroAlterado) throws ObjectNotFoundException {
		Carro carro = buscaPorID(carroAlterado.getId());
		carro.setModelo(carroAlterado.getModelo());
		carro.setDescricao(carroAlterado.getDescricao());
		carro.setId(carroAlterado.getId());
		carro.setDocumento(carroAlterado.getDocumento());
		return salvar(carro);
	}
	
}
