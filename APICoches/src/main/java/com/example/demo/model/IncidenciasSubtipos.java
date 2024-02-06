package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IncidenciasSubtipos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String tipo;
    private String subtipoNombre;
    private String subSubtipo;
    
	public IncidenciasSubtipos() {
		super();
	}

	public IncidenciasSubtipos(Long id, String tipo, String subtipoNombre, String subSubtipo) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.subtipoNombre = subtipoNombre;
		this.subSubtipo = subSubtipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSubtipoNombre() {
		return subtipoNombre;
	}

	public void setSubtipoNombre(String subtipoNombre) {
		this.subtipoNombre = subtipoNombre;
	}

	public String getSubSubtipo() {
		return subSubtipo;
	}

	public void setSubSubtipo(String subSubtipo) {
		this.subSubtipo = subSubtipo;
	}
    
    
	
}
