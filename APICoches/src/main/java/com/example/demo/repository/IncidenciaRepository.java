package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Incidencias;

public interface IncidenciaRepository extends JpaRepository<Incidencias, Long>{
List<Incidencias> findByTipo(String tipo);
List<Incidencias> findByCreadorId(Long creadorId);

}
