package com.example.demo.security.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
@ConfigurationProperties(prefix = "p12")
public class JksProperties {
    private String keystorePath;
    private String keystorePassword;
    private String keystoreKeyAlias;
    private String keystorePrivateKeyPassphrase;

    // Constructor vacío necesario para la inicialización por Spring
    public JksProperties() {}

    // Getters y setters para cada propiedad

    public String getKeystorePath() {
        return keystorePath;
    }

    public void setKeystorePath(String keystorePath) {
        this.keystorePath = keystorePath;
    }

    public String getKeystorePassword() {
        return keystorePassword;
    }

    public void setKeystorePassword(String keystorePassword) {
        this.keystorePassword = keystorePassword;
    }

    public String getKeystoreKeyAlias() {
        return keystoreKeyAlias;
    }

    public void setKeystoreKeyAlias(String keystoreKeyAlias) {
        this.keystoreKeyAlias = keystoreKeyAlias;
    }

    public String getKeystorePrivateKeyPassphrase() {
        return keystorePrivateKeyPassphrase;
    }

    public void setKeystorePrivateKeyPassphrase(String keystorePrivateKeyPassphrase) {
        this.keystorePrivateKeyPassphrase = keystorePrivateKeyPassphrase;
    }
}

