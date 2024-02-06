package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Aulas;

public interface AulasRepository extends JpaRepository<Aulas, Long> {
	// Metodos de consulta personalizados
}
