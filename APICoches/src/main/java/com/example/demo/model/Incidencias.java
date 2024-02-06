package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Incidencias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
    private String tipo;
    private Long subtipoId;
    private String descripcion;
    private String estado;
    private Long creadorId;
    private Long responsableId;
    private Long equipoId;
    
	public Incidencias() {
		super();
	}

	public Incidencias(Long num, String tipo, Long subtipoId, String descripcion, String estado, Long creadorId,
			Long responsableId, Long equipoId) {
		super();
		this.num = num;
		this.tipo = tipo;
		this.subtipoId = subtipoId;
		this.descripcion = descripcion;
		this.estado = estado;
		this.creadorId = creadorId;
		this.responsableId = responsableId;
		this.equipoId = equipoId;
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

	public Long getSubtipoId() {
		return subtipoId;
	}

	public void setSubtipoId(Long subtipoId) {
		this.subtipoId = subtipoId;
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

	public Long getCreadorId() {
		return creadorId;
	}

	public void setCreadorId(Long creadorId) {
		this.creadorId = creadorId;
	}

	public Long getResponsableId() {
		return responsableId;
	}

	public void setResponsableId(Long responsableId) {
		this.responsableId = responsableId;
	}

	public Long getEquipoId() {
		return equipoId;
	}

	public void setEquipoId(Long equipoId) {
		this.equipoId = equipoId;
	}
    
    
	
}
