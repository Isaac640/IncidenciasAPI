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
    private Long id;

	
    private String texto;
    
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechahora;
   
    @Column(name="incidencia_num")
    private Long incidenciaNum;
   private Long personal_id;
    
    private String adjuntoUrl;
    
    
    public Comentarios(Long id, String texto, LocalDateTime fechahora, Long incidenciaNum, Long personal,
			String adjuntoUrl) {
		super();
		this.id = id;
		this.texto = texto;
		this.fechahora = fechahora;
		this.incidenciaNum = incidenciaNum;
		this.personal_id = personal;
		this.adjuntoUrl = adjuntoUrl;
	}

	public Comentarios() {
		super();
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

	public Long getPersonal() {
		return personal_id;
	}

	public void setPersonal(Long personal) {
		this.personal_id = personal;
	}

	public String getAdjuntoUrl() {
		return adjuntoUrl;
	}

	public void setAdjuntoUrl(String adjuntoUrl) {
		this.adjuntoUrl = adjuntoUrl;
	}
}
