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

import com.example.demo.model.Aulas;
import com.example.demo.repository.AulasRepository;

@RestController
@RequestMapping("/api/aulas")
public class AulasController {
	
	@Autowired
	private AulasRepository aulasRepository;
	
	@GetMapping
	public List<Aulas> getAllAulas() {
		return aulasRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Aulas getAulaById(@PathVariable Long id) {
        return aulasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula no encontrada con id: " + id));
    }
	
	@PostMapping
	public Aulas createAula(@RequestBody Aulas aulas) {
		return aulasRepository.save(aulas);
	}
	
	@PutMapping("/{id}")
	public Aulas updateAula(@PathVariable Long id, @RequestBody Aulas aulasDetails) {
        Aulas aulas = aulasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula no encontrada con id: " + id));

        // Actualizar los campos según los detalles proporcionados
        aulas.setCodigo(aulasDetails.getCodigo());
        aulas.setDescripcion(aulasDetails.getDescripcion());
        aulas.setPlanta(aulasDetails.getPlanta());

        return aulasRepository.save(aulas);
    }
	
	@DeleteMapping("/{id}")
	public void deleteAula(@PathVariable Long id) {
        Aulas aulas = aulasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula no encontrada con id: " + id));

        aulasRepository.delete(aulas);
    }
	
}
