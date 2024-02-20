package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.IncidenciasSubtipos;
import com.example.demo.model.Perfiles;

public interface IncidenciasSubtiposRepository extends JpaRepository<IncidenciasSubtipos, Long>{
	
}
