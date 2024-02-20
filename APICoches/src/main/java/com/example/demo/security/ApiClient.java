package com.example.demo.security;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.stereotype.Component;

import com.example.demo.security.util.JksProperties;

@Component
public class ApiClient {
	private final JksProperties jksProperties;

    public ApiClient(JksProperties jksProperties) {
        this.jksProperties = jksProperties;
    }

    public void execute() throws Exception {
        // Cargar el almacén de claves
        char[] keystorePassword = jksProperties.getKeystorePassword().toCharArray();
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        keystore.load(new FileInputStream(jksProperties.getKeystorePath()), keystorePassword);

        // Obtener la clave privada y el certificado del almacén de claves
        String alias = jksProperties.getKeystoreKeyAlias();
        char[] keyPassword = jksProperties.getKeystorePrivateKeyPassphrase().toCharArray();
        PrivateKey privateKey = (PrivateKey) keystore.getKey(alias, keyPassword);
        X509Certificate certificate = (X509Certificate) keystore.getCertificate(alias);

        // Configurar la conexión segura
        URL url = new URL("https://ejemplo.com/api/endpoint");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setSSLSocketFactory(createSSLSocketFactory(privateKey, certificate));

        // Establecer la autenticación del cliente
        connection.setDoOutput(true);
        connection.connect();

        // Leer la respuesta de la API
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    // Método para crear el SSLSocketFactory con la clave privada y el certificado
    private SSLSocketFactory createSSLSocketFactory(PrivateKey privateKey, X509Certificate certificate) throws Exception {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        keyStore.setKeyEntry("app", privateKey, "Na373cho".toCharArray(), new X509Certificate[]{certificate});
        keyManagerFactory.init(keyStore, "Na373cho".toCharArray());

        TrustManager[] trustManagers = {new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain, String authType) {}
            public void checkServerTrusted(X509Certificate[] chain, String authType) {}
            public X509Certificate[] getAcceptedIssuers() {return new X509Certificate[0];}
        }};

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagers, null);
        return sslContext.getSocketFactory();
    }
}
