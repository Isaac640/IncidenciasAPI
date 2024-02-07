package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQuery(name="Incidencias.findAll", query="SELECT i FROM Incidencias i")
public class Incidencias implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int num;

    private String tipo;
    private String descripcion;
    private String estado;
   
    @Column(name="equipo_id")
    private Long equipoId;
    @OneToMany
    @JoinColumn(name="incidencia_id")
    private List<Comentarios> comentarios;

    @ManyToOne
    @JoinColumn(name="creador_id")
    private Personal creador;

    @ManyToOne
    @JoinColumn(name="responsable_id")
    private Personal responsable;

    @ManyToOne
    @JoinColumn(name="subtipo_id")
    private IncidenciasSubtipos subtipo;

	public Incidencias() {
		super();
	}

	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Incidencias(int num, String tipo, String descripcion, String estado, Long equipoId,
			List<Comentarios> comentarios, Personal creador, Personal responsable, IncidenciasSubtipos subtipo) {
		super();
		this.num = num;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.equipoId = equipoId;
		this.comentarios = comentarios;
		this.creador = creador;
		this.responsable = responsable;
		this.subtipo = subtipo;
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

	public Long getEquipoId() {
		return equipoId;
	}

	public void setEquipoId(Long equipoId) {
		this.equipoId = equipoId;
	}

	



	public List<Comentarios> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}

	public Personal getCreador() {
		return creador;
	}

	public void setCreador(Personal creador) {
		this.creador = creador;
	}

	public Personal getResponsable() {
		return responsable;
	}

	public void setResponsable(Personal responsable) {
		this.responsable = responsable;
	}

	public IncidenciasSubtipos getSubtipo() {
		return subtipo;
	}

	public void setSubtipo(IncidenciasSubtipos subtipo) {
		this.subtipo = subtipo;
	}

	
    
	
}
