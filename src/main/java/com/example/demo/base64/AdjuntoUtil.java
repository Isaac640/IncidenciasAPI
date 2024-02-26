package com.example.demo.base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class AdjuntoUtil {

    public static String codificarAdjunto(String rutaArchivo) throws IOException {
        // Leer archivo en bytes
        byte[] archivoBytes = leerArchivo(rutaArchivo);

        // Codificar los bytes a base64
        return Base64.getEncoder().encodeToString(archivoBytes);
    }

    public static void descodificarAdjunto(String adjuntoBase64, String extension, String rutaDestino) throws IOException {
        if(adjuntoBase64 != null) {
            // Descodificar el adjunto Base64 a bytes
            byte[] adjuntoBytes = Base64.getDecoder().decode(adjuntoBase64);

            // Guardar los bytes descodificados en un archivo
            guardarArchivo(adjuntoBytes, extension, rutaDestino);
        } else {
            System.out.println("AdjuntoBase64 es nulo");
        }

    }

    private static byte[] leerArchivo(String rutaArchivo) throws IOException {
        File archivo = new File(rutaArchivo);
        FileInputStream fis = new FileInputStream(archivo);

        byte[] buffer = new byte[(int) archivo.length()];
        fis.read(buffer);

        fis.close();

        return buffer;
    }

    public static void guardarArchivo(byte[] adjuntoBytes, String extension, String rutaDestino) throws IOException {
        FileOutputStream fos = new FileOutputStream(rutaDestino);
        fos.write(adjuntoBytes);
        fos.close();
    }

}
