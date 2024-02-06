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

import com.example.demo.model.Personal;
import com.example.demo.repository.PersonalRepository;

@RestController
@RequestMapping("/api/personal")
public class PersonalController {

	@Autowired
    private PersonalRepository personalRepository;

    @GetMapping
    public List<Personal> getAllPersonal() {
        return personalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Personal getPersonalById(@PathVariable Long id) {
        return personalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personal no encontrado con id: " + id));
    }

    @PostMapping
    public Personal createPersonal(@RequestBody Personal personal) {
        return personalRepository.save(personal);
    }

    @PutMapping("/{id}")
    public Personal updatePersonal(@PathVariable Long id, @RequestBody Personal personalDetails) {
        Personal personal = personalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personal no encontrado con id: " + id));

        // Actualizar los campos según los detalles proporcionados
        personal.setDni(personalDetails.getDni());
        personal.setNombre(personalDetails.getNombre());
        personal.setApellido1(personalDetails.getApellido1());
        personal.setApellido2(personalDetails.getApellido2());
        personal.setDireccion(personalDetails.getDireccion());
        personal.setLocalidad(personalDetails.getLocalidad());
        personal.setCp(personalDetails.getCp());
        personal.setTlf(personalDetails.getTlf());
        personal.setActivo(personalDetails.getActivo());
        personal.setDepartamentoId(personalDetails.getDepartamentoId());

        return personalRepository.save(personal);
    }

    @DeleteMapping("/{id}")
    public void deletePersonal(@PathVariable Long id) {
        Personal personal = personalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personal no encontrado con id: " + id));

        personalRepository.delete(personal);
    }
	
}
