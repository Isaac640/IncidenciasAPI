package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@NamedQuery(name="Comentarios.findAll", query="SELECT c FROM Comentarios c")
public class Comentarios implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

	
    private String texto;
    
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechahora;
    
    private Long incidenciaNum;
    @ManyToOne
    @JoinColumn(name="personal_id")
    private Personal personal;

    
    private String adjuntoUrl;
    
	public Comentarios() {
		super();
	}


	public Comentarios(int id, String texto, LocalDateTime fechahora, Long incidenciaNum, Personal personal,
			String adjuntoUrl) {
		super();
		this.id = id;
		this.texto = texto;
		this.fechahora = fechahora;
		this.incidenciaNum = incidenciaNum;
		this.personal = personal;
		this.adjuntoUrl = adjuntoUrl;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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
	
	
	public String getAdjuntoUrl() {
		return adjuntoUrl;
	}
	
	public void setAdjuntoUrl(String adjuntoUrl) {
		this.adjuntoUrl = adjuntoUrl;
	}


	public Personal getPersonal() {
		return personal;
	}


	public void setPersonal(Personal personal) {
		this.personal = personal;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
