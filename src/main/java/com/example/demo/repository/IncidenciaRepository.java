package com.example.demo.repository;

import java.util.List;
import java.util.Map;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Incidencias;
import com.example.demo.model.Personal;

public interface IncidenciaRepository extends JpaRepository<Incidencias, Long>{
    List<Incidencias> findByTipo(String tipo);
    List<Incidencias> findByCreadorId(Personal creador_id);
}
