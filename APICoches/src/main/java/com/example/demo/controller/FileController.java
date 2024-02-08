package com.example.demo.controller;

import java.util.Base64;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class FileController {
	@PostMapping("/upload")
    public String uploadFile(@RequestBody String base64EncodedFile) {
        // Decodificar el archivo desde Base64
        byte[] decodedBytes = Base64.getDecoder().decode(base64EncodedFile);
        // Aquí podrías guardar los bytes en un archivo o procesarlos según tus necesidades
        return "Archivo recibido y decodificado correctamente.";
    }

    @GetMapping("/download")
    public String downloadFile() {
        // Aquí simulo obtener el archivo codificado en Base64 (podría ser desde una base de datos o un servicio)
        String encodedFile = obtenerArchivoCodificado();
        // Devolver el archivo codificado en Base64
        return encodedFile;
    }

    // Método de ejemplo para simular la obtención de un archivo codificado en Base64
    private String obtenerArchivoCodificado() {
        // Aquí podrías obtener el archivo codificado desde alguna fuente
        String entradaOriginal = "Texto de prueba.";
        return Base64.getEncoder().encodeToString(entradaOriginal.getBytes());
    }
}
