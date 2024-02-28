package com.example.demo.controller;

import java.util.List;

import com.example.demo.base64.IncidenciasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.IncidenciasSubtipos;
import com.example.demo.repository.IncidenciasSubtiposRepository;
@RestController
@RequestMapping("/api/incidenciasSubtipos")
public class IncidenciasSubtiposController {
	
	@Autowired
    private IncidenciasSubtiposRepository incidenciasSubtiposRepository;

    @GetMapping
    public List<IncidenciasSubtipos> getAllIncidenciasSubtipos() {
        return incidenciasSubtiposRepository.findAll();
    }

    @GetMapping("/{id}")
    public IncidenciasSubtipos getIncidenciaSubtipoById(@PathVariable Long id) {
        return incidenciasSubtiposRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subtipo de incidencia no encontrado con id: " + id));
    }

    @PostMapping
    public IncidenciasSubtipos createIncidenciaSubtipo(@RequestBody IncidenciasSubtipos subtipo) {
        return incidenciasSubtiposRepository.save(subtipo);
    }

    @PutMapping("/{id}")
    public IncidenciasSubtipos updateIncidenciaSubtipo(@PathVariable Long id, @RequestBody IncidenciasSubtipos subtipoDetails) {
        IncidenciasSubtipos subtipo = incidenciasSubtiposRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subtipo de incidencia no encontrado con id: " + id));

        // Actualizar los campos según los detalles proporcionados
        subtipo.setTipo(subtipoDetails.getTipo());
        subtipo.setSubtipoNombre(subtipoDetails.getSubtipoNombre());
        subtipo.setSubSubtipo(subtipoDetails.getSubSubtipo());

        return incidenciasSubtiposRepository.save(subtipo);
    }

    @DeleteMapping("/{id}")
    public void deleteIncidenciaSubtipo(@PathVariable Long id) {
        IncidenciasSubtipos subtipo = incidenciasSubtiposRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subtipo de incidencia no encontrado con id: " + id));

        incidenciasSubtiposRepository.delete(subtipo);
    }
    @GetMapping("/tipo")
    public List<IncidenciasSubtipos> findByTipo(@RequestParam(name = "tipo") String tipo){
        final String tip=tipo;
        List<IncidenciasSubtipos> list=incidenciasSubtiposRepository.findByTipo(tip);
        list.removeIf(c->
                !c.getTipo().equals(tip));
return list;
    }
	
}
