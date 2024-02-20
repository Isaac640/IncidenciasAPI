package com.example.demo.security;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.security.util.JksProperties;

@Component
public class JwtUtil {
	
	@Autowired
	private RSAPrivateKey privateKey;
	@Autowired
	private RSAPublicKey publicKey;

	public JwtUtil() {
		cargarClaves();
	}
	
	private void cargarClaves() {
		 try {
	            // Cargar el almacén de claves desde el archivo
	            ClassPathResource resource = new ClassPathResource("keystoreApi");
	            InputStream inputStream = resource.getInputStream();
	            KeyStore keystore = KeyStore.getInstance("PKCS12");
	            String keystorePassword = "Na373cho";
	            keystore.load(inputStream, keystorePassword.toCharArray());

	            // Extraer la clave privada RSA
	            String privateKeyAlias = "app";
	            String privateKeyPassword = "Na373cho";
	            privateKey = (RSAPrivateKey) keystore.getKey(privateKeyAlias, privateKeyPassword.toCharArray());

	            // Extraer la clave pública RSA
	            String publicKeyAlias = "app";
	            publicKey = (RSAPublicKey) keystore.getCertificate(publicKeyAlias).getPublicKey();

	            inputStream.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}


	public String encode(String subject) {
		
		if(publicKey == null || privateKey == null) {
			throw new IllegalArgumentException("La clave RSA no se ha inicializado correctamente");
		}
		
		return JWT.create()
				.withSubject(subject)
				.withExpiresAt(null)
				.sign(Algorithm.RSA256(publicKey, privateKey) );
	}
}
