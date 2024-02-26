package com.example.demo.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.Mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="incidencias")
@NamedQuery(name="Incidencias.findAll", query="SELECT i FROM Incidencias i")
public class Incidencias implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long num;

    private String tipo;
    private String descripcion;
    private String estado;
	private String adjunto_url;
    private Date fecha_creacion;
    private Date fecha_cierre;
    @OneToOne
    @JoinColumn(name="equipo_id")
    private Equipos equipoId;

    @OneToOne
    @JoinColumn(name="creador_id")
    private Personal creadorId;

    @OneToOne
    @JoinColumn(name="responsable_id")
    private Personal responsable_id;

    @OneToOne
    @JoinColumn(name="subtipo_id")
    private IncidenciasSubtipos subtipo_id;

    @Column(name="tiempo")
    private Time tiempo;
    
	public Incidencias() {
		super();
	}

	public Incidencias(Long num, String tipo, String descripcion, String estado, Date fecha_creacion, Date fecha_cierre,
			Equipos equipoId, Personal creadorId, Personal responsable_id, IncidenciasSubtipos subtipo_id,
			Time tiempo, String adjuntoURL, ) {
		super();
		this.num = num;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fecha_creacion = fecha_creacion;
		this.fecha_cierre = fecha_cierre;
		this.equipoId = equipoId;
		this.creadorId = creadorId;
		this.responsable_id = responsable_id;
		this.subtipo_id = subtipo_id;
		this.adjunto_url = adjuntoURL;
		this.tiempo = tiempo;
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

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_cierre() {
		return fecha_cierre;
	}

	public void setFecha_cierre(Date fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
	}

	public Equipos getEquipoId() {
		return equipoId;
	}

	public void setEquipoId(Equipos equipoId) {
		this.equipoId = equipoId;
	}

	public Personal getCreadorId() {
		return creadorId;
	}

	public void setCreadorId(Personal creadorId) {
		this.creadorId = creadorId;
	}

	public Personal getResponsable_id() {
		return responsable_id;
	}

	public void setResponsable_id(Personal responsable_id) {
		this.responsable_id = responsable_id;
	}

	public IncidenciasSubtipos getSubtipo_id() {
		return subtipo_id;
	}

	public void setSubtipo_id(IncidenciasSubtipos subtipo_id) {
		this.subtipo_id = subtipo_id;
	}

	public Time getTiempo() {
		return tiempo;
	}

	public void setTiempo(Time tiempo) {
		this.tiempo = tiempo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setAdjuntoURL(String adjuntoURL) {
		this.adjunto_url = adjuntoURL;
	}
}