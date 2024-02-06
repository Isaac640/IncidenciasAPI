package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Incidencias;

public interface IncidenciaRepository extends JpaRepository<Incidencias, Long>{

}
