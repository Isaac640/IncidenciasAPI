package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Perfiles;

public interface PerfilesRepository extends JpaRepository<Perfiles, Long>{
	Perfiles findByEducantabriaAndPassword( String educantabria,  String Password);
	Perfiles findByDominio(String dominio);

}
