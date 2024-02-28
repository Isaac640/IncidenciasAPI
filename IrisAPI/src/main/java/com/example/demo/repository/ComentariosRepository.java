package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Comentarios;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ComentariosRepository extends JpaRepository<Comentarios, Long>{
	@Query("SELECT c FROM Comentarios c WHERE c.incidencia_num = :incidenciaNum")
	List<Comentarios> findByIncidenciaNum(@Param("incidenciaNum") Long incidenciaNum);
}
