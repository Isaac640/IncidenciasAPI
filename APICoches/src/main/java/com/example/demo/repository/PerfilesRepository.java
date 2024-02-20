package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Perfiles;

@Repository
public interface PerfilesRepository extends JpaRepository<Perfiles, Long>{
	
	Perfiles findByEducantabriaAndPassword( String educantabria,  String Password);
	Perfiles findByDominio(String dominio);
	
}
