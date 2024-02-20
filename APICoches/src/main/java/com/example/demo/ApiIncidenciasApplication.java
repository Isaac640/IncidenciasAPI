package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.ssl.JksSslBundleProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.security.ApiClient;
import com.example.demo.security.util.JksProperties;


@SpringBootApplication
@EnableConfigurationProperties(JksProperties.class)
public class ApiIncidenciasApplication {
	
	public static void main(String[] args) throws Exception {
		// Inicializar la aplicación Spring Boot
		ConfigurableApplicationContext context = SpringApplication.run(ApiIncidenciasApplication.class, args);
		
		// Obtener el bean de JksProperties
		JksProperties jksProperties = context.getBean(JksProperties.class);
		
		// Lógica para interactuar con la API utilizando las propiedades del archivo de almacén de claves (jksProperties)
		ApiClient apiClient = new ApiClient(jksProperties);
		
		// Ejecutar la lógica de la API
		apiClient.execute();
		
		// Cerrar el contexto de la aplicación Spring Boot
		context.close();
	}
	


	
}
