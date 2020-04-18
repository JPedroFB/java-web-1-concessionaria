package com.senac.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.concessionaria.model.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long>{

}
