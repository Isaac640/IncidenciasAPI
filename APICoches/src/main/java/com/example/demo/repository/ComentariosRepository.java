package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Comentarios;

public interface ComentariosRepository extends JpaRepository<Comentarios, Long>{
public interface ComentariosRepository extends JpaRepository<Comentarios, Integer>{
	
}
