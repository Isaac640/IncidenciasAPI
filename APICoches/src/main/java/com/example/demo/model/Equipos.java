package com.example.demo.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipos")
public class Equipos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(value =EnumType.STRING)
    private TipoEquipo tipoEquipo;
    private Date fechaAdquisicion;
    private String etiqueta;
    private String marca;
    private String modelo;
    private String descripcion;
    private int baja;
    private Long aulaNum;
    private Long puesto;
    
    @OneToMany
    @JoinColumn(name = "equipo_id")
    private List<Incidencias> incidencias;
    
	public Equipos() {
		super();
	}

	public Equipos(Long id, TipoEquipo tipoEquipo, Date fechaAdquisicion, String etiqueta, String marca, String modelo,
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

	public TipoEquipo getTipoEquipo() {
		return tipoEquipo;
	}

	public void setTipoEquipo(TipoEquipo tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}

	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	public void setFechaAdquisicion(Date fechaAdquisicion) {
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
