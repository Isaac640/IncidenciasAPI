package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Departamentos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String cod;
    private String nombre;
    private int activo;
    private Long jefedepId;
    
	public Departamentos() {
		super();
	}

	public Departamentos(Long id, String cod, String nombre, int activo, Long jefedepId) {
		super();
		this.id = id;
		this.cod = cod;
		this.nombre = nombre;
		this.activo = activo;
		this.jefedepId = jefedepId;
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
		return jefedepId;
	}

	public void setJefedepId(Long jefedepId) {
		this.jefedepId = jefedepId;
	}
    
    
	
}
