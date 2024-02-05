package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Coche;
import com.example.demo.repository.CocheRepository;

@RestController
@RequestMapping("/api")
public class CocheController {
	@Autowired
	private CocheRepository cocheRepository;

//	public CocheController(CocheRepository cocheRepository) {
//		this.cocheRepository = cocheRepository;
//	}
	@GetMapping("/coches")
	public List<Coche> obtenerCoches() {
		return cocheRepository.findAll();
	}
	@GetMapping("/coches/{id}")
	public Coche obtenerUno(@PathVariable Integer id) {
		
		return cocheRepository.findById(id).orElse(null);
	}
	@PostMapping("/coches")
	public Coche nuevoCoche(@RequestBody Coche nuevo) {
		return cocheRepository.save(nuevo);
	}
	@PutMapping("/coches/{id}")
	public Coche editarCoche(@RequestBody Coche cocheEdit, @PathVariable Integer id) {
		if(cocheRepository.existsById(id)) {
			cocheEdit.setId(id);
			return cocheRepository.save(cocheEdit);
		}else {
			return null;
		}
	}
	//Eliminar un coche
	@DeleteMapping("/coches/{id}")
	public Coche borrarCoche(@PathVariable Integer id) {
		if(cocheRepository.existsById(id)) {
			Coche coche = cocheRepository.findById(id).get();
			cocheRepository.delete(coche);
			return coche;
		}else {
			return null;
		}
	}
}
