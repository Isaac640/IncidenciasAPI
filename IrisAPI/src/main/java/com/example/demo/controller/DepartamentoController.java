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

import com.example.demo.model.Departamentos;
import com.example.demo.repository.DepartamentosRepository;

@RestController
@RequestMapping("/api/Departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentosRepository departamentosRepository;
	
	@GetMapping
	public List<Departamentos> getAllDepartamentos() {
        return departamentosRepository.findAll();
    }
	
	@GetMapping("/{id}")
	public Departamentos getDepartamentoById(@PathVariable Long id) {
        return departamentosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado con id: " + id));
    }
	
	@PostMapping
	public Departamentos createDepartamento(@RequestBody Departamentos departamento) {
        return departamentosRepository.save(departamento);
    }
	
	@PutMapping("/{id}")
	public Departamentos updateDepartamento(@PathVariable Long id, @RequestBody Departamentos departamentoDetails) {
        Departamentos departamento = departamentosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado con id: " + id));

        // Actualizar los campos según los detalles proporcionados
        departamento.setCod(departamentoDetails.getCod());
        departamento.setNombre(departamentoDetails.getNombre());
        departamento.setActivo(departamentoDetails.getActivo());
        departamento.setJefedep_Id(departamentoDetails.getJefedep_Id());

        return departamentosRepository.save(departamento);
    }
	
	@DeleteMapping("/{id}")
	public void deleteDepartamento(@PathVariable Long id) {
        Departamentos departamento = departamentosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado con id: " + id));

        departamentosRepository.delete(departamento);
    }
}
