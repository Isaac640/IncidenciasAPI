package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQuery(name="IncidenciasSubtipos.findAll", query="SELECT i FROM IncidenciasSubtipos i")
public class IncidenciasSubtipos implements Serializable {
   

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
