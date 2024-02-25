package com.example.demo;

import lombok.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.core.token.Token;
import org.springframework.stereotype.Component;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.UUID;


@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = DispatcherServletAutoConfiguration.class))
public class ApiApplication {

    public static void main(String[] args) {

        // Nombre del archivo donde deseas guardar la salida
        // Se sobreescribe sobre el cada vez para buscar la contraseña
        // El usuario es user
        String nombreArchivo = "output.txt";

        String password = null;
        try {
            // Crear un objeto FileOutputStream para escribir en el archivo
            FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo);

            // Crear un objeto PrintStream para escribir datos en el FileOutputStream
            PrintStream printStream = new PrintStream(fileOutputStream);

            // Guardar la referencia original de System.out
            PrintStream originalOut = System.out;

            // Redirigir la salida estándar (System.out) al PrintStream
            System.setOut(printStream);

            // Aquí puedes colocar tu código para ejecutar la API
            // Por ejemplo:
            System.out.println("Iniciando ejecución de la API...");
            // Llama a tu método para ejecutar la API aquí
            SpringApplication.run(ApiApplication.class, args);

            // Restaurar la salida estándar original
            System.setOut(originalOut);

            // Cerrar el PrintStream y FileOutputStream
            printStream.close();
            fileOutputStream.close();

            // Leer el archivo de salida para encontrar la línea deseada
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            password = null;
            while ((linea = br.readLine()) != null) {
                if (linea.contains("Using generated security password:")) {
                    // Si se encuentra la línea, extraer el password
                    password = linea.split(": ")[1];
                    break;
                }
            }
            br.close();

            // Mostrar el password si se encontró
            if (password != null) {
                System.out.println("Password generado: " + password);
            } else {
                System.out.println("No se encontró la línea con el password.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}




