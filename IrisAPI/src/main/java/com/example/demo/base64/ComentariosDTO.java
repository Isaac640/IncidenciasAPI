package com.example.demo.base64;

import java.time.LocalDateTime;


public class ComentariosDTO {

    // atributos
    private Long id;
    private String texto;
    private LocalDateTime fechahora;
    private Long incidencia_num;
    private Long personal_Id;
    private String adjunto_URL;
    private String cuerpoBase64;
    private String extension;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getFechahora() {
        return fechahora;
    }

    public void setFechahora(LocalDateTime fechahora) {
        this.fechahora = fechahora;
    }

    public long getIncidenciaNum() {
        return incidencia_num;
    }

    public void setIncidenciaNum(Long incidenciaNum) {
        this.incidencia_num = incidenciaNum;
    }

    public Long getPersonalId() {
        return personal_Id;
    }

    public void setPersonalId(Long personalId) {
        this.personal_Id = personalId;
    }

    public String getAdjuntoURL() {
        return adjunto_URL;
    }

    public void setAdjuntoURL(String adjuntoURL) {
        this.adjunto_URL = adjuntoURL;
    }

    public String getCuerpoBase64() {
        return cuerpoBase64;
    }

    public void setCuerpoBase64(String cuerpoBase64) {
        this.cuerpoBase64 = cuerpoBase64;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
