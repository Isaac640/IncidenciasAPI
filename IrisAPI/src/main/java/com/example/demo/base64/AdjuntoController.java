package com.example.demo.base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdjuntoController {

    @Autowired
    private final Servicio servicio;

    public AdjuntoController(Servicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/guardarIncidenciaConAdjunto")
    public void guardarIncidenciaConAdjunto(@RequestBody IncidenciasDTO incidenciasDTO) {
        servicio.guardarIncidenciaConAdjunto(incidenciasDTO);
    }

    @PostMapping("/guardarComentarioConAdjunto")
    public void guardarComentariosConAdjunto(@RequestBody ComentariosDTO comentariosDTO) {
        servicio.guardarComentarioConAdjunto(comentariosDTO);
    }

    /*
    @GetMapping("/mostrarComentarioConAdjunto/{id}")
    public ComentariosDTO mostrarComentarioConAdjunto(@PathVariable Long id) {
        return servicio.mostrarComentarioConAdjunto(id);
    }

    @GetMapping("/mostrarIncidenciaConAdjunto/{id}")
    public ComentariosDTO mostrarIncidenciaConAdjunto(@PathVariable Long id) {
        return servicio.mostrarIncidenciaConAdjunto(id);
    }
    */
}
