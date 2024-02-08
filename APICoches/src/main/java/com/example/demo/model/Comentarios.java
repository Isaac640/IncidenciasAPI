package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "comentarios")
public class Comentarios {
	
	@Id
	private Long id;
	
    private String texto;
    
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechahora;
    
    private Long incidenciaNum;
    
    private String adjuntoUrl;
    
    @ManyToOne
    @JoinColumn(name="personal_id")
    private Personal personal;
    
    
    
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Comentarios() {
		super();
	}

	
	public Comentarios(Long id, String texto, LocalDateTime fechahora, Long incidenciaNum, String adjuntoUrl,
			Personal personal) {
		super();
		this.id = id;
		this.texto = texto;
		this.fechahora = fechahora;
		this.incidenciaNum = incidenciaNum;
		this.adjuntoUrl = adjuntoUrl;
		this.personal = personal;
	}

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
	
	public Long getIncidenciaNum() {
		return incidenciaNum;
	}
	
	public void setIncidenciaNum(Long incidenciaNum) {
		this.incidenciaNum = incidenciaNum;
	}
	
	
	
	public Personal getPersonal() {
		return personal;
	}

	public String getAdjuntoUrl() {
		return adjuntoUrl;
	}
	
	public void setAdjuntoUrl(String adjuntoUrl) {
		this.adjuntoUrl = adjuntoUrl;
	}
    
    
}
