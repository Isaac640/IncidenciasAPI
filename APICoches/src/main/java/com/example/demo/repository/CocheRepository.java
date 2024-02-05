package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Coche;

public interface CocheRepository extends JpaRepository<Coche, Integer>{
	//List<Coche> listAllByMarca(String marca);
}
