package com.example.demo.model;


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
import jakarta.persistence.Table;

@Entity
@Table(name = "departamentos")
@NamedQuery(name="Departamentos.findAll", query="SELECT d FROM Departamentos d")
public class Departamentos {
	
	@Id
	@Column(name = "id")
	private Long id;
    private String cod;
    private String nombre;
    private int activo;
    private Long jefedep_id;
    
	public Departamentos() {
		super();
	}

	public Departamentos(Long id, String cod, String nombre, int activo, Long jefedepId) {
		super();
		this.id = id;
		this.cod = cod;
		this.nombre = nombre;
		this.activo = activo;
		this.jefedep_id = jefedepId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public Long getJefedepId() {
		return jefedep_id;
	}

	public void setJefedepId(Long jefedepId) {
		this.jefedep_id = jefedepId;
	}
    
    
	
}
