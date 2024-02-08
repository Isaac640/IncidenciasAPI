package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "incidencias_subtipos")
public class IncidenciasSubtipos {
	
	@Id
	private Long id;
	@Enumerated(EnumType.STRING)
    private TipoIncidencias tipo;
    private String subtipoNombre;
    private String subSubtipo;
    
    @OneToMany
    @JoinColumn(name="subtipo_id")
    private List<Incidencias> incidencias;
    
	public IncidenciasSubtipos() {
		super();
	}

	public IncidenciasSubtipos(Long id, TipoIncidencias tipo, String subtipoNombre, String subSubtipo) {
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

	public TipoIncidencias getTipo() {
		return tipo;
	}

	public void setTipo(TipoIncidencias tipo) {
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
