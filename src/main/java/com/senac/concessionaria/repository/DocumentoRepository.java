package com.senac.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.concessionaria.model.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long>{

}
