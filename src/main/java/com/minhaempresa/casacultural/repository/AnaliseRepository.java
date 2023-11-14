package com.minhaempresa.casacultural.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhaempresa.casacultural.model.Analise;

@Repository
public interface AnaliseRepository extends JpaRepository<Analise, Long> {
}
