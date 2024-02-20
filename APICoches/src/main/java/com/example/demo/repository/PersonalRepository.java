package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Long>{
	List<Personal> findByNombreAndApellido1(String nombre, String apellido);
	List<Personal> findByDni(String dni);
}
