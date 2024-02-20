package com.example.demo.security;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import com.example.demo.security.util.JksProperties;

@Configuration
public class JwtConfig {
	private static final Logger log = LoggerFactory.getLogger(JwtConfig.class);	
	private JksProperties jksProperties;

	public JwtConfig(JksProperties jksProperties) {
		this.jksProperties = jksProperties;
	}


    @Bean
    KeyStore keyStore() {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream resourceAsStream = JwtConfig.class.getResourceAsStream("/keystoreApi");
            if (resourceAsStream == null) {
                throw new IllegalArgumentException("El archivo keystore no se encontró en el classpath");
            }
            char[] password = "Na373cho".toCharArray();
            keyStore.load(resourceAsStream, password);
            return keyStore;
        } catch (IOException e) {
            log.error("Error al cargar keystore: " + e.toString());
            throw new IllegalArgumentException("Error al cargar keystore: " + e.toString());
        } catch (CertificateException | NoSuchAlgorithmException | KeyStoreException e) {
            log.error("Error al cargar keystore: " + e.toString());
            throw new IllegalArgumentException("Error al cargar keystore: " + e.toString());
        }
    }


    @Bean
    RSAPublicKey jwtValidationKey(KeyStore keyStore) {
		try {
			Certificate certificate = keyStore.getCertificate(this.jksProperties.getKeystoreKeyAlias());
			if (certificate != null) {
				PublicKey publicKey = certificate.getPublicKey();
				if (publicKey instanceof RSAPublicKey) {
					return (RSAPublicKey) publicKey;
				} else {
					throw new IllegalArgumentException("La clave no es de tipo RSAPublicKey");
				}
			} else {
				throw new IllegalArgumentException("No se encontró el certificado en el keystore");
			}	
			
		} catch (KeyStoreException e) {
			log.error("No se pudo recuperar la clave privada del keystore");
		}
		
		throw new IllegalArgumentException("No se pudo cargar la clave publica");
	}


    @Bean
    RSAPrivateKey jwtSigningKey(KeyStore keyStore) {
		try {
			Key key = keyStore.getKey(this.jksProperties.getKeystoreKeyAlias(), this.jksProperties.getKeystorePrivateKeyPassphrase().toCharArray());
			
			if (key instanceof RSAPrivateKey) {
				return (RSAPrivateKey) key;
			} else {
				throw new IllegalArgumentException("No se encontró el certificado en el keystore");
			}
		} catch (UnrecoverableKeyException e) {
			log.error("No se pudo recuperar la clave privada del keystore: " + e.toString());
		} catch (NoSuchAlgorithmException e) {
			log.error("No se pudo recuperar la clave privada del keystore: " + e.toString());
		} catch (KeyStoreException e) {
			log.error("No se pudo recuperar la clave privada del keystore: " + e.toString());
		}
		
		throw new IllegalArgumentException("No se pudo cargar la clave privada");
	}


    @Bean
    JwtDecoder jwtDecoder(RSAPublicKey rsaPublicKey) {
		return NimbusJwtDecoder.withPublicKey(rsaPublicKey).build();
	}
}
