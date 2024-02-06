package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Equipos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String tipoEquipo;
    private String fechaAdquisicion;
    private String etiqueta;
    private String marca;
    private String modelo;
    private String descripcion;
    private int baja;
    private Long aulaNum;
    private Long puesto;
    
	public Equipos() {
		super();
	}

	public Equipos(Long id, String tipoEquipo, String fechaAdquisicion, String etiqueta, String marca, String modelo,
			String descripcion, int baja, Long aulaNum, Long puesto) {
		super();
		this.id = id;
		this.tipoEquipo = tipoEquipo;
		this.fechaAdquisicion = fechaAdquisicion;
		this.etiqueta = etiqueta;
		this.marca = marca;
		this.modelo = modelo;
		this.descripcion = descripcion;
		this.baja = baja;
		this.aulaNum = aulaNum;
		this.puesto = puesto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoEquipo() {
		return tipoEquipo;
	}

	public void setTipoEquipo(String tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}

	public String getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	public void setFechaAdquisicion(String fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getBaja() {
		return baja;
	}

	public void setBaja(int baja) {
		this.baja = baja;
	}

	public Long getAulaNum() {
		return aulaNum;
	}

	public void setAulaNum(Long aulaNum) {
		this.aulaNum = aulaNum;
	}

	public Long getPuesto() {
		return puesto;
	}

	public void setPuesto(Long puesto) {
		this.puesto = puesto;
	}
    
    
	
}
