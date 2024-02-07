package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Aulas;
import java.util.List;


public interface AulasRepository extends JpaRepository<Aulas, Long> {
	List<Aulas> findByCodigo(String codigo);
}
