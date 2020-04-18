package com.senac.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.concessionaria.model.Chave;

@Repository
public interface ChaveRepository extends JpaRepository<Chave, Long>{

}
