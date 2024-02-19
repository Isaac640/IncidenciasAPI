package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Incidencias;
import com.example.demo.model.IncidenciasSin;
import com.example.demo.model.Personal;

public interface IncidenciaSinRepository extends JpaRepository<IncidenciasSin, Long>{


}
