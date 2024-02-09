package com.example.demo.controller;


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

    @PostMapping
    public Incidencias createIncidencia(@RequestBody Incidencias incidencia) {
        return incidenciaRepository.save(incidencia);
    }

    @PutMapping("/{id}")
    public Incidencias updateIncidencia(@PathVariable Long id, @RequestBody Incidencias incidenciaDetails) {
        Incidencias incidencia = incidenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incidencia no encontrada con id: " + id));

        // Actualizar los campos según los detalles proporcionados
        incidencia.setTipo(incidenciaDetails.getTipo());
        incidencia.setSubtipo_id(incidenciaDetails.getSubtipo_id());
        incidencia.setDescripcion(incidenciaDetails.getDescripcion());
        incidencia.setCreador_id(incidenciaDetails.getCreador_id());
        // Actualizar otros campos según sea necesario

        return incidenciaRepository.save(incidencia);
    }

    @DeleteMapping("/{id}")
    public void deleteIncidencia(@PathVariable Long id) {
        Incidencias incidencia = incidenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incidencia no encontrada con id: " + id));

        incidenciaRepository.delete(incidencia);
    }
    @GetMapping("/tipo={tipo}")
   	public List<Incidencias> findByTipo(@PathVariable String Tipo){
   		return incidenciaRepository.findByTipo(Tipo);
   	}
       
     
       
	
}
