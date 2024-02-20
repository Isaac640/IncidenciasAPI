package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Aulas;

public interface AulasRepository extends JpaRepository<Aulas, Long> {
	List<Aulas> findByCodigo(String codigo);
}
