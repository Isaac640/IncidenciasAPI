package com.example.demo.controller;

import com.example.demo.model.Incidencias;
import com.example.demo.repository.IncidenciaRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaController {

	@Autowired
    private IncidenciaRepository incidenciaRepository;

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



    @PostMapping("/guardarAdjunto")
    public ResponseEntity<String> guardarAdjunto(
            @RequestParam String extension,
            @RequestParam Long id,
            @RequestParam String cuerpoBase64,
            @RequestParam String directorioDirectorio) {

        // Decodificar el cuerpo Base64
        byte[] decodeBytes = Base64.decodeBase64(cuerpoBase64);

        // Crear un archivo con la extension especificada

        String nombreArchivo = UUID.randomUUID().toString() + "." + extension;
        String directorio = "C://Users//Nacho//OneDrive//Documentos//GitHub//IncidenciasAPI";

        // Ruta completa del archivo
        String rutaArchivo = directorio + nombreArchivo;

        try {
            // Guardar los bytes del archivo en el disco
            FileOutputStream fileOutputStream = new FileOutputStream(rutaArchivo);
            fileOutputStream.write(decodeBytes);
            fileOutputStream.close();

            // Obtener la incidencia existente de la base de datos
            Incidencias incidencias = incidenciaRepository.findById(id).orElse(null);
            if(incidencias == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La incidencia no existe");
            }

            // Actualizar la URL del adjunto incidencia
            incidencias.setAdjuntoURL(rutaArchivo);
            incidenciaRepository.save(incidencias);

            return ResponseEntity.ok("URL del adjunto actualizada correctamente para la incidencia con ID: " + id);

        } catch (IOException exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el archivo adjunto");
        }
    }
   
     
	
}
