package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



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
    @Column(name="jefedep_id")
    private int jefedep_Id;

    

	public Departamentos() {
		super();
	}

	public Departamentos(int id, String cod, String nombre, int activo, int jefedep_Id) {
		super();
		this.id = id;
		this.cod = cod;
		this.nombre = nombre;
		this.activo = activo;
		this.jefedep_Id = jefedep_Id;
		
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

	public int getJefedep_Id() {
		return jefedep_Id;
	}

	public void setJefedep_Id(int jefedep_Id) {
		this.jefedep_Id = jefedep_Id;
	}

    
	
}
