package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Comentarios;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ComentariosRepository extends JpaRepository<Comentarios, Long>{
    @Query("SELECT c FROM Comentarios c WHERE c.incidencia_num = :incidenciaNum")
    Optional<Comentarios> findByIncidenciaNum(@Param("incidenciaNum") Long incidenciaNum);
}
