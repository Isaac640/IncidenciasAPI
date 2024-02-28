package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.IncidenciasSubtipos;

import java.util.List;

public interface IncidenciasSubtiposRepository extends JpaRepository<IncidenciasSubtipos, Long>{
   List<IncidenciasSubtipos> findByTipo(String Tipo);
}
