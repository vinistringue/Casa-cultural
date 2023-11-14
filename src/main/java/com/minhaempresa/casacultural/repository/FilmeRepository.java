package com.minhaempresa.casacultural.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhaempresa.casacultural.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
}