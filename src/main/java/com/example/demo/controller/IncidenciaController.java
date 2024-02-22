package com.example.demo.controller;

import com.example.demo.model.Incidencias;
import com.example.demo.repository.IncidenciaRepository;
import com.example.demo.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaController {

	@Autowired
    private IncidenciaRepository incidenciaRepository;

    private IncidenciaService incidenciaService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
