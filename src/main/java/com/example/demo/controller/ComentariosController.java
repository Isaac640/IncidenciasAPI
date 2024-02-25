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

import com.example.demo.model.Comentarios;
import com.example.demo.repository.ComentariosRepository;


@RestController
@RequestMapping("/api/comentarios")
public class ComentariosController {
	
	@Autowired
	private ComentariosRepository comentariosRepository;
	
	@GetMapping
	public List<Comentarios> getAllComentarios() {
        return comentariosRepository.findAll();
    }
	
	@GetMapping("/{id}")
	public Comentarios getComentarioById(@PathVariable Long id) {
        return comentariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado con id: " + id));
    }
	
	@PostMapping
	public Comentarios createComentario(@RequestBody Comentarios comentario) {
        return comentariosRepository.save(comentario);
    }
	
	@PutMapping("/{id}")
	public Comentarios updateComentario(@PathVariable Long id, @RequestBody Comentarios comentarioDetails) {
        Comentarios comentario = comentariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado con id: " + id));

        // Actualizar los campos según los detalles proporcionados
        comentario.setTexto(comentarioDetails.getTexto());
        comentario.setFechahora(comentarioDetails.getFechahora());
        comentario.setIncidenciaNum(comentarioDetails.getIncidenciaNum());
        comentario.setPersonal(comentarioDetails.getPersonal());
        //comentarios.setAdjuntoUrl(comentarioDetails.getAdjuntoUrl());

        return comentariosRepository.save(comentario);
    }
	
	@DeleteMapping("/{id}")
	public void deleteComentario(@PathVariable Long id) {
        Comentarios comentario = comentariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado con id: " + id));

        comentariosRepository.delete(comentario);
    }
	
}
