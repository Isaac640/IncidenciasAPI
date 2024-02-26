package com.example.demo.base64;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;


public class ComentariosDTO {

    // atributos
    private String texto;
    private LocalDateTime fechahora;
    private Long incidencia_num;
    private Long personalId;
    private String adjuntoURL;
    private String cuerpoBase64;
    private String extension;

    public ComentariosDTO(String texto, LocalDateTime fechahora, Long incidenciaNum, Long personalId, String cuerpoBase64, String extension) {
        this.texto = texto;
        this.fechahora = fechahora;
        this.incidencia_num = incidenciaNum;
        this.personalId = personalId;
        this.cuerpoBase64 = cuerpoBase64;
        this.extension = extension;
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

    public long getIncidencia_Num() {
        return incidencia_num;
    }

    public void setIncidenciaNum(Long incidenciaNum) {
        this.incidencia_num = incidenciaNum;
    }

    public Long getPersonalId() {
        return personalId;
    }

    public void setPersonalId(Long personalId) {
        this.personalId = personalId;
    }

    public String getAdjuntoURL() {
        return adjuntoURL;
    }

    public void setAdjuntoURL(String adjuntoURL) {
        this.adjuntoURL = adjuntoURL;
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
