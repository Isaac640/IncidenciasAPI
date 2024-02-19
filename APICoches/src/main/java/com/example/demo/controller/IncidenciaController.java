package com.example.demo.controller;

import com.example.demo.model.*;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Incidencias;
import com.example.demo.repository.IncidenciaRepository;
import com.example.demo.repository.PersonalRepository;

@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaController {

	@Autowired
    private IncidenciaRepository incidenciaRepository;

    @GetMapping
    public List<Incidencias> getAllIncidencias() {
        return incidenciaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Incidencias getIncidenciaById(@PathVariable Long id) {
        return incidenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incidencia no encontrada con id: " + id));
    }


   
   
    @GetMapping("/tipo={tipo}")
   	public List<Incidencias> findByTipo(@PathVariable String Tipo){
   		return incidenciaRepository.findByTipo(Tipo);
   	}
       
  
    
    
   
     
	
}
