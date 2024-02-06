package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aulas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	private String codigo;
	private String descripcion;
	private int planta;
	
	public Aulas() {
		super();
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
