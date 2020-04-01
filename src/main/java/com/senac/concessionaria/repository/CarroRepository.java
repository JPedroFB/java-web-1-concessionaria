package com.senac.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.concessionaria.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{

}
