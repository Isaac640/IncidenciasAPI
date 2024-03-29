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

import com.example.demo.repository.IncidenciaRepository;
import com.example.demo.repository.IncidenciaSinRepository;
import com.example.demo.repository.PersonalRepository;

@RestController
@RequestMapping("/api/")
public class IncidenciaSinController {

	@Autowired
    private IncidenciaSinRepository incidenciaSinRepository;

   
   
	
    @PostMapping("incidencias")
    public IncidenciasSin createIncidencia(@RequestBody IncidenciasSin incidencia) {
        return incidenciaSinRepository.save(incidencia);
    }

    @PutMapping("incidencias/{id}")
    public IncidenciasSin updateIncidencia(@PathVariable Long id, @RequestBody IncidenciasSin incidenciaDetails) {
        IncidenciasSin incidencia = incidenciaSinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incidencia no encontrada con id: " + id));

        // Actualizar los campos según los detalles proporcionados
        incidencia.setTipo(incidenciaDetails.getTipo());
        incidencia.setSubtipo_id(incidenciaDetails.getSubtipo_id());
        incidencia.setDescripcion(incidenciaDetails.getDescripcion());
        incidencia.setCreador_id(incidenciaDetails.getCreador_id());
        incidencia.setFecha_creacion(incidenciaDetails.getFecha_creacion());
        incidencia.setFecha_cierre(incidenciaDetails.getFecha_cierre());
        incidencia.setResponsable_id(incidenciaDetails.getResponsable_id());
        incidencia.setEstado(incidenciaDetails.getEstado());
        incidencia.setTiempo(incidenciaDetails.getTiempo());
        // Actualizar otros campos según sea necesario

        return incidenciaSinRepository.save(incidencia);
    }

    @DeleteMapping("incidencias/{id}")
    public void deleteIncidencia(@PathVariable Long id) {
        IncidenciasSin incidencia = incidenciaSinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incidencia no encontrada con id: " + id));

        incidenciaSinRepository.delete(incidencia);
    }
}
