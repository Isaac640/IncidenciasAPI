package com.example.demo.base64;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

@RestController
public class base64 {
    @PostMapping("/descargar")
    public String descargarArchivo(@RequestBody String urlCodificadoBase64) {
        String nombreArchivoSalida = "archivo_descargado.bin";

        try {
            // Decodificar el URL
            String urlDecodificado = new String(Base64.getDecoder().decode(urlCodificadoBase64));

            // Crear conexión HTTP
            URL url = new URL(urlDecodificado);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Verificar la respuesta del servidor
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Leer el contenido de la respuesta
                InputStream inputStream = connection.getInputStream();

                // Escribir el contenido en un archivo binario
                FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivoSalida);
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                // Cerrar streams
                inputStream.close();
                fileOutputStream.close();

                return "Descarga y guardado exitosos.";
            } else {
                return "Error al descargar el archivo. Código de respuesta: " + responseCode;
            }
        } catch (IOException e) {
            return "Ocurrió un error: " + e.getMessage();
        }
    }
}
