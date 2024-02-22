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

import com.example.demo.model.Equipos;
import com.example.demo.repository.EquiposRepository;

@RestController
@RequestMapping("/api/equipos")
public class EquiposController {
	
	@Autowired
    private EquiposRepository equiposRepository;

    @GetMapping
    public List<Equipos> getAllEquipos() {
        return equiposRepository.findAll();
    }

    @GetMapping("/{id}")
    public Equipos getEquipoById(@PathVariable Long id) {
        return equiposRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con id: " + id));
    }

    @PostMapping
    public Equipos createEquipo(@RequestBody Equipos equipo) {
        return equiposRepository.save(equipo);
    }

    @PutMapping("/{id}")
    public Equipos updateEquipo(@PathVariable Long id, @RequestBody Equipos equipoDetails) {
        Equipos equipo = equiposRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con id: " + id));

        // Actualizar los campos según los detalles proporcionados
        equipo.setTipoEquipo(equipoDetails.getTipoEquipo());
        equipo.setFechaAdquisicion(equipoDetails.getFechaAdquisicion());
        equipo.setEtiqueta(equipoDetails.getEtiqueta());
        equipo.setMarca(equipoDetails.getMarca());
        equipo.setModelo(equipoDetails.getModelo());
        equipo.setDescripcion(equipoDetails.getDescripcion());
        equipo.setBaja(equipoDetails.getBaja());
        equipo.setAulaNum(equipoDetails.getAulaNum());
        equipo.setPuesto(equipoDetails.getPuesto());

        return equiposRepository.save(equipo);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipo(@PathVariable Long id) {
        Equipos equipo = equiposRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con id: " + id));

        equiposRepository.delete(equipo);
    }
	
}
