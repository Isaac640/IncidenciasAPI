package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@NamedQuery(name="Departamentos.findAll", query="SELECT d FROM Departamentos d")
public class Departamentos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    private String cod;
    private String nombre;
    private int activo;
    private Long jefedepId;


    @OneToMany(mappedBy="departamento")
    private List<Personal> personals;

	public Departamentos() {
		super();
	}

	public Departamentos(int id, String cod, String nombre, int activo, Long jefedepId) {
		super();
		this.id = id;
		this.cod = cod;
		this.nombre = nombre;
		this.activo = activo;
		this.jefedepId = jefedepId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
