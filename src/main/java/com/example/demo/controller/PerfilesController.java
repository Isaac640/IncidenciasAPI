package com.example.demo.controller;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Perfiles;
import com.example.demo.repository.PerfilesRepository;



@RestController
@RequestMapping("/api/perfiles")
public class PerfilesController {
	
	@Autowired
    private PerfilesRepository perfilesRepository;

    @GetMapping
    public List<Perfiles> getAllPerfiles() {
        return perfilesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Perfiles getPerfilById(@PathVariable Long id) {
        return perfilesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado con id: " + id));
    }

    @PostMapping
    public Perfiles createPerfil(@RequestBody Perfiles perfil) {
        return perfilesRepository.save(perfil);
    }

    @PutMapping("/{id}")
    public Perfiles updatePerfil(@PathVariable Long id, @RequestBody Perfiles perfilDetails) {
        Perfiles perfil = perfilesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado con id: " + id));

        // Actualizar los campos según los detalles proporcionados
        perfil.setPersonal_id(perfilDetails.getPersonal_id());
        perfil.setDominio(perfilDetails.getDominio());
        perfil.setEducantabria(perfilDetails.getEducantabria());
        perfil.setPassword(perfilDetails.getPassword());
        perfil.setPerfil(perfilDetails.getPerfil());
        return perfilesRepository.save(perfil);
    }

    @DeleteMapping("/{id}")
    public void deletePerfil(@PathVariable Long id) {
        Perfiles perfil = perfilesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado con id: " + id));

        perfilesRepository.delete(perfil);
    }
    @GetMapping("/validacion")
    public Perfiles findbyEducantabriaAndPassword(@RequestParam String educantabria, @RequestParam String password){
Perfiles p= 	perfilesRepository.findByEducantabriaAndPassword(educantabria, password);
return p;
    }
    
    @GetMapping("/dominio")
    public Perfiles findByDominio(@RequestParam String dominio)
    {	
    	return perfilesRepository.findByDominio(dominio);
    }
    @PostMapping("/dominio")
    public Perfiles findDominio(@RequestParam String dominio) {
    	return perfilesRepository.findByDominio(dominio);
    }
    
}
