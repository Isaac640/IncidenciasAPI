package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Incidencias;
import com.example.demo.model.Personal;

public interface IncidenciaRepository extends JpaRepository<Incidencias, Long>{
	static List<Incidencias> findByTipo(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}
	List<Incidencias> findByCreadorId(Personal creador_id);
}
