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
import jakarta.persistence.Table;

@Entity
@Table(name = "aulas")
@NamedQuery(name="Aulas.findAll", query="SELECT a FROM Aulas a")
public class Aulas implements Serializable{
	private static final long serialVersionUID = 1L;
			
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	private String codigo;
	private String descripcion;
	private int planta;
	
	@OneToMany
	@JoinColumn(name = "aula_id")
	private List<Equipos> equipos;
	
	public Aulas() {
		super();
		//nacho es bobo
	}
	
	public Aulas(Long num, String codigo, String descripcion, int planta) {
		super();
		this.num = num;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.planta = planta;
	}
	
	public Long getNum() {
		return num;
	}
	
	public void setNum(Long num) {
		this.num = num;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getPlanta() {
		return planta;
	}
	
	public void setPlanta(int planta) {
		this.planta = planta;
	}
	
	
}
