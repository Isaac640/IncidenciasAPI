package com.example.demo.base64;

import com.example.demo.model.Equipos;
import com.example.demo.model.IncidenciasSubtipos;
import com.example.demo.model.Personal;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

public class IncidenciasDTO {

    // atributos
    private Long num;
    private String tipo;
    private IncidenciasSubtipos subtipoId;
    private Date fechaCreacion;
    private Date fechaCierre;
    private String descripcion;
    private String estado;
    private String adjuntoURL;
    private Personal creadorId;
    private Personal responsableId;
    private Equipos equipoId;
    private Time tiempo;
    private String cuerpoBase64;
    private String extension;

    public IncidenciasDTO(Long num, String tipo, IncidenciasSubtipos subtipoId, Date fechaCreacion,
                          Date fechaCierre, String descripcion, String estado, String adjuntoURL,
                          Personal creadorId, Personal responsableId, Equipos equipoId, Time tiempo,
                          String cuerpoBase64, String extension) {
        this.num = num;
        this.tipo = tipo;
        this.subtipoId = subtipoId;
        this.fechaCreacion = fechaCreacion;
        this.fechaCierre = fechaCierre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.adjuntoURL = adjuntoURL;
        this.creadorId = creadorId;
        this.responsableId = responsableId;
        this.equipoId = equipoId;
        this.tiempo = tiempo;
        this.cuerpoBase64 = cuerpoBase64;
        this.extension = extension;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public IncidenciasSubtipos getSubtipoId() {
        return subtipoId;
    }

    public void setSubtipoId(IncidenciasSubtipos subtipoId) {
        this.subtipoId = subtipoId;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAdjuntoURL() {
        return adjuntoURL;
    }

    public void setAdjuntoURL(String adjuntoURL) {
        this.adjuntoURL = adjuntoURL;
    }

    public Personal getCreadorId() {
        return creadorId;
    }

    public void setCreadorId(Personal creadorId) {
        this.creadorId = creadorId;
    }

    public Personal getResponsableId() {
        return responsableId;
    }

    public void setResponsableId(Personal responsableId) {
        this.responsableId = responsableId;
    }

    public Equipos getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(Equipos equipoId) {
        this.equipoId = equipoId;
    }

    public Time getTiempo() {
        return tiempo;
    }

    public void setTiempo(Time tiempo) {
        this.tiempo = tiempo;
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
